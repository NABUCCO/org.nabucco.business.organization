/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.business.organization.impl.service.maintain.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nabucco.business.organization.facade.datatype.BusinessVolume;
import org.nabucco.business.organization.facade.datatype.Corporation;
import org.nabucco.business.organization.facade.datatype.Customer;
import org.nabucco.business.organization.facade.datatype.Department;
import org.nabucco.business.organization.facade.datatype.EUCorporation;
import org.nabucco.business.organization.facade.datatype.OrganizationCharacteristic;
import org.nabucco.business.organization.facade.datatype.OrganizationMaster;
import org.nabucco.business.organization.facade.datatype.OrganizationRelation;
import org.nabucco.business.organization.facade.datatype.Sector;
import org.nabucco.business.organization.facade.datatype.Subsidiary;
import org.nabucco.business.organization.facade.datatype.Vendor;
import org.nabucco.framework.base.facade.datatype.DatatypeAccessor;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.DatatypeSupport;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelationContainer;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLogger;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLoggingFactory;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;

/**
 * MaintainOrganizationCharacteristicServiceSupport
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class MaintainOrganizationCharacteristicServiceSupport {

    private static NabuccoLogger logger = NabuccoLoggingFactory.getInstance().getLogger(
            MaintainOrganizationCharacteristicServiceSupport.class);

    private PersistenceManager persistenceManager;

    private HashMap<OrganizationMaster, OrganizationMaster> masterMap;

    private DatatypeState workingTimeState;

    /**
     * Creates a new {@link MaintainOrganizationCharacteristicServiceSupport} instance.
     * 
     * @param persistenceManager
     *            the persistence manager
     */
    public MaintainOrganizationCharacteristicServiceSupport(PersistenceManager persistenceManager) {
        this.persistenceManager = persistenceManager;
    }

    /**
     * Maintains an {@link OrganizationMaster}.
     * 
     * @param organizationMaster
     * @return
     * @throws MaintainException
     */
    public OrganizationMaster maintain(OrganizationMaster organizationMaster) throws MaintainException {
        return maintainOrganizationMaster(organizationMaster);
    }

    /**
     * Maintains an {@link OrganizationCharacteristic}.
     * 
     * @param rootElement
     * @return
     * @throws MaintainException
     */
    public OrganizationCharacteristic maintain(OrganizationCharacteristic rootElement) throws MaintainException {

        Map<OrganizationCharacteristic, OrganizationCharacteristic> characteristicMap = new HashMap<OrganizationCharacteristic, OrganizationCharacteristic>();
        Map<OrganizationRelation, OrganizationRelation> relationMap = new HashMap<OrganizationRelation, OrganizationRelation>();

        // linearize
        OrganizationCharacteristicNetworkLinearized linearizedNetwork = new OrganizationCharacteristicNetworkLinearizer()
                .linearizeNetwork(rootElement);

        List<OrganizationCharacteristic> characteristics = linearizedNetwork.getCharacteristics();
        List<OrganizationRelation> relations = linearizedNetwork.getRelations();

        // delete deleted relations
        for (OrganizationRelation relation : relations) {

            if (relation.getDatatypeState() != DatatypeState.DELETED) {
                continue;
            }

            // clone (shallow)
            // because clone clones deeply the target datatype must temporary be removed else a
            // StackOverFlow could occur
            OrganizationCharacteristic tmp = relation.getCharacteristic();
            relation.setCharacteristic(null);
            OrganizationRelation clone = clone(relation);
            // OrganizationRelation clone = relation.cloneObject();
            relation.setCharacteristic(tmp);

            // set maintained target datatype
            clone.setCharacteristic(characteristicMap.get(relation.getCharacteristic()));

            // maintain relation
            logger.debug("Maintain relation:\t" + relation.getClass().getSimpleName());
            clone = maintainRelation(clone);

            // add to map
            relationMap.put(relation, null);
        }

        // maintain characteristics
        for (OrganizationCharacteristic characteristic : characteristics) {

            // clone (shallow)
            // because clone clones deeply the relation list must temporary be removed else a
            // StackOverFlow could occur
            List<OrganizationRelation> tmp = new ArrayList<OrganizationRelation>(characteristic.getRelationList());
            characteristic.getRelationList().clear();
            OrganizationCharacteristic clone = clone(characteristic);
            // OrganizationCharacteristic clone = characteristic.cloneObject();
            characteristic.getRelationList().addAll(tmp);

            // maintain
            if (logger.isDebugEnabled()) {
                logger.debug("Maintain datatype:\t", characteristic.getClass().getSimpleName());
            }

            clone = maintainCharacteristic(clone);

            clone.getSectorList().size();
            clone.getRelationList().size();

            // add to map
            characteristicMap.put(characteristic, clone);
        }

        // maintain relations
        for (OrganizationRelation relation : relations) {

            if (relation.getDatatypeState() == DatatypeState.DELETED) {
                continue;
            }

            // clone (shallow)
            // because clone clones deeply the target datatype must temporary be removed else a
            // StackOverFlow could occur
            OrganizationCharacteristic tmp = relation.getCharacteristic();
            relation.setCharacteristic(null);
            OrganizationRelation clone = clone(relation);
            // OrganizationRelation clone = relation.cloneObject();
            relation.setCharacteristic(tmp);

            // set maintained target datatype
            clone.setCharacteristic(characteristicMap.get(relation.getCharacteristic()));

            // maintain relation
            if (logger.isDebugEnabled()) {
                logger.debug("Maintain relation:\t" + relation.getClass().getSimpleName());
            }
            clone = maintainRelation(clone);

            // add to map
            relationMap.put(relation, clone);
        }

        // maintain characteristics again
        // no need to call maintain because source is already attached
        for (OrganizationCharacteristic characteristic : characteristics) {

            // get maintained source datatype
            OrganizationCharacteristic source = characteristicMap.get(characteristic);

            // skip if no relations are available
            if (characteristic.getRelationList().isEmpty()) {
                source.getRelationList().size();
                continue;
            }

            // add relations
            for (OrganizationRelation organizationRelation : characteristic.getRelationList()) {
                OrganizationRelation relation = relationMap.get(organizationRelation);
                if (relation != null) {
                    source.getRelationList().add(relation);
                }
            }
        }

        for (OrganizationMaster organizationMaster : masterMap.values()) {
            maintainOrganizationMaster(organizationMaster);
        }

        return characteristicMap.get(rootElement);
    }

    private OrganizationRelation maintainRelation(OrganizationRelation relation) throws MaintainException {

        try {
            return persistenceManager.persist(relation);
        } catch (Exception pe) {
            throw new MaintainException("Error maintaining OrganizationRelation.", pe);
        }
    }

    private OrganizationCharacteristic maintainCharacteristic(OrganizationCharacteristic characteristic)
            throws MaintainException {

        if (characteristic.getDatatypeState() == DatatypeState.DELETED) {

            characteristic = internalMaintainCharacteristicDependenciesPre(characteristic);
            characteristic = internalMaintainCharacteristicDependenciesPast(characteristic);

            // master is temporary saved because it is reseted in
            // internalMaintainCharacteristic
            OrganizationMaster master = characteristic.getMaster();
            characteristic = internalMaintainCharacteristic(characteristic);
            characteristic.setMaster(master);

            characteristic = internalMaintainMaster(characteristic);

        } else {
            characteristic = internalMaintainMaster(characteristic);

            characteristic = internalMaintainCharacteristicDependenciesPre(characteristic);

            characteristic = internalMaintainCharacteristic(characteristic);

            characteristic = internalMaintainCharacteristicDependenciesPast(characteristic);
        }

        return characteristic;
    }

    private OrganizationCharacteristic internalMaintainMaster(OrganizationCharacteristic characteristic)
            throws MaintainException {

        if (masterMap == null) {
            masterMap = new HashMap<OrganizationMaster, OrganizationMaster>();
        }

        OrganizationMaster organizationMaster = characteristic.getMaster();
        if (organizationMaster.getDatatypeState() == DatatypeState.CONSTRUCTED) {
            if (organizationMaster.getId() != null) {
                organizationMaster.setDatatypeState(DatatypeState.PERSISTENT);
            }
        }

        if (masterMap.get(organizationMaster) != null) {
            organizationMaster = masterMap.get(organizationMaster);
        } else {

            if (organizationMaster.getDatatypeState() == DatatypeState.DELETED) {
                OrganizationMaster clone = clone(organizationMaster);
                masterMap.put(clone, organizationMaster);
            } else {
                OrganizationMaster clone = clone(organizationMaster);
                organizationMaster = maintainOrganizationMaster(organizationMaster);
                masterMap.put(clone, organizationMaster);
            }
        }

        characteristic.setMaster(organizationMaster);

        return characteristic;
    }

    private OrganizationCharacteristic internalMaintainCharacteristicDependenciesPre(
            OrganizationCharacteristic characteristic) throws MaintainException {

        try {
            // sectorList
            if (characteristic.getDatatypeState() == DatatypeState.DELETED) {
                if ((characteristic.getSectorList()).getState() == NabuccoCollectionState.LAZY) {
                    throw new MaintainException("Lazy loaded datatype can't be deleted!");
                }
                for (Sector organizationCustomer : characteristic.getSectorList()) {
                    organizationCustomer.setDatatypeState(DatatypeState.DELETED);
                }
            }
            persistenceManager.persist(characteristic.getSectorList());

            // workingTime
            if (characteristic.getWorkingTime() != null) {
                if (characteristic.getDatatypeState() == DatatypeState.DELETED) {
                    characteristic.getWorkingTime().setDatatypeState(DatatypeState.DELETED);
                }

                workingTimeState = characteristic.getWorkingTime().getDatatypeState();
                if (characteristic.getWorkingTime().getDatatypeState() != DatatypeState.DELETED) {
                    persistenceManager.persist(characteristic.getWorkingTime());
                }
            }

        } catch (Exception pe) {
            throw new MaintainException("Error maintaining " + characteristic.getClass().getSimpleName() + "!", pe);
        }

        return characteristic;
    }

    private OrganizationCharacteristic internalMaintainCharacteristicDependenciesPast(
            OrganizationCharacteristic characteristic) throws MaintainException {

        try {
            // relationList
            if (characteristic.getDatatypeState() == DatatypeState.DELETED) {
                if ((characteristic.getRelationList()).getState() == NabuccoCollectionState.LAZY) {
                    throw new MaintainException("Lazy loaded datatype can't be deleted!");
                }
                for (OrganizationRelation relation : characteristic.getRelationList()) {
                    relation.setDatatypeState(DatatypeState.DELETED);
                }
            }

            // workingTime
            if (characteristic.getWorkingTime() != null) {
                if (workingTimeState == DatatypeState.DELETED) {
                    characteristic.getWorkingTime().setDatatypeState(workingTimeState);
                    persistenceManager.persist(characteristic.getWorkingTime());
                    characteristic.setWorkingTime(null);
                }
            }

        } catch (Exception pe) {
            throw new MaintainException("Error maintaining " + characteristic.getClass().getSimpleName() + "!", pe);
        }

        return characteristic;
    }

    private OrganizationCharacteristic internalMaintainCharacteristic(OrganizationCharacteristic characteristic)
            throws MaintainException {

        if (characteristic instanceof Corporation) {
            return maintainCorporation((Corporation) characteristic);

        } else if (characteristic instanceof Customer) {
            return maintainCustomer((Customer) characteristic);

        } else if (characteristic instanceof Department) {
            return maintainDepartment((Department) characteristic);

        } else if (characteristic instanceof Vendor) {
            return maintainVendor((Vendor) characteristic);

        } else if (characteristic instanceof Subsidiary) {
            return maintainSubsidiary((Subsidiary) characteristic);

        } else if (characteristic instanceof EUCorporation) {
            return maintainEUCorporation((EUCorporation) characteristic);
        }

        throw new MaintainException("Maintain of '" + characteristic.getClass().getName() + "' is not supported!");
    }

    private OrganizationMaster maintainOrganizationMaster(OrganizationMaster organizationMaster)
            throws MaintainException {

        try {
            // master is maintained here to stay attached
            return persistenceManager.persist(organizationMaster);
        } catch (Exception pe) {
            throw new MaintainException("Error maintaining OrganizationMaster.", pe);
        }
    }

    private Corporation maintainCorporation(Corporation corporation) throws MaintainException {

        try {
            if (corporation.getDatatypeState() == DatatypeState.DELETED) {
                for (BusinessVolume businessVolume : corporation.getBusinessVolumeList()) {
                    businessVolume.setDatatypeState(DatatypeState.DELETED);
                }
            }

            persistenceManager.persist(corporation.getBusinessVolumeList());
            corporation = persistenceManager.persist(corporation);

            corporation.getBusinessVolumeList().size();

            return corporation;

        } catch (Exception pe) {
            throw new MaintainException("Error maintaining Customer.", pe);
        }
    }

    private Customer maintainCustomer(Customer customer) throws MaintainException {

        try {
            DatatypeState statisticState = null;
            if (customer.getStatistic() != null) {
                if (customer.getDatatypeState() == DatatypeState.DELETED) {
                    customer.getStatistic().setDatatypeState(DatatypeState.DELETED);
                }

                statisticState = customer.getStatistic().getDatatypeState();
                if (customer.getStatistic().getDatatypeState() != DatatypeState.DELETED) {
                    persistenceManager.persist(customer.getStatistic());
                }
            }

            DatatypeState creditState = null;
            if (customer.getCreditReport() != null) {
                if (customer.getDatatypeState() == DatatypeState.DELETED) {
                    customer.getCreditReport().setDatatypeState(DatatypeState.DELETED);
                }

                creditState = customer.getCreditReport().getDatatypeState();
                if (customer.getCreditReport().getDatatypeState() != DatatypeState.DELETED) {
                    persistenceManager.persist(customer.getCreditReport());
                }
            }

            Code functionalStatusType = customer.getFunctionalStatusType();
            customer = persistenceManager.persist(customer);
            customer.setFunctionalStatusType(functionalStatusType);

            if (customer.getStatistic() != null) {
                if (statisticState == DatatypeState.DELETED) {
                    customer.getStatistic().setDatatypeState(statisticState);
                    persistenceManager.persist(customer.getStatistic());
                    customer.setStatistic(null);
                }
            }

            if (customer.getCreditReport() != null) {
                if (creditState == DatatypeState.DELETED) {
                    customer.getCreditReport().setDatatypeState(creditState);
                    persistenceManager.persist(customer.getCreditReport());
                    customer.setCreditReport(null);
                }
            }

            return customer;

        } catch (Exception pe) {
            throw new MaintainException("Error maintaining Customer.", pe);
        }
    }

    private Department maintainDepartment(Department department) throws MaintainException {

        try {
            return persistenceManager.persist(department);
        } catch (Exception pe) {
            throw new MaintainException("Error maintaining Department.", pe);
        }
    }

    private Subsidiary maintainSubsidiary(Subsidiary subsidiary) throws MaintainException {

        try {
            return persistenceManager.persist(subsidiary);
        } catch (Exception pe) {
            throw new MaintainException("Error maintaining Subsidiary.", pe);
        }
    }

    private Vendor maintainVendor(Vendor vendor) throws MaintainException {

        try {
            return persistenceManager.persist(vendor);
        } catch (Exception pe) {
            throw new MaintainException("Error maintaining Vendor.", pe);
        }
    }

    private OrganizationCharacteristic maintainEUCorporation(EUCorporation characteristic) throws MaintainException {

        try {
            return persistenceManager.persist(characteristic);
        } catch (Exception pe) {
            throw new MaintainException("Error maintaining Vendor.", pe);
        }
    }

    private <T extends DatatypeSupport> T clone(T datatype) {
        @SuppressWarnings("unchecked")
        T cloneObject = (T) datatype.cloneObject();

        ComponentRelationContainer componentRelation = DatatypeAccessor.getInstance().getComponentRelation(datatype);
        DatatypeAccessor.getInstance().setComponentRelation(cloneObject, componentRelation);

        return cloneObject;
    }

}
