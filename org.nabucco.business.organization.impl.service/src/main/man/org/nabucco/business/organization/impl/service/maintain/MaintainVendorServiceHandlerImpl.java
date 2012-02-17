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
package org.nabucco.business.organization.impl.service.maintain;

import org.nabucco.business.organization.facade.datatype.OrganizationMaster;
import org.nabucco.business.organization.facade.datatype.OrganizationRelation;
import org.nabucco.business.organization.facade.datatype.Vendor;
import org.nabucco.business.organization.facade.message.VendorMsg;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.MaintainException;

/**
 * MaintainVendorServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class MaintainVendorServiceHandlerImpl extends MaintainVendorServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected VendorMsg maintainVendor(VendorMsg msg) throws MaintainException {

        Vendor vendor = msg.getVendor();

        try {
            if (vendor.getMaster() != null) {
                OrganizationMaster master = this.maintainMaster(vendor.getMaster());
                vendor.setMaster(master);
            }

            for (OrganizationRelation relation : vendor.getRelationList()) {
                relation = this.maintainRelation(relation);
            }

            vendor = this.maintainVendor(vendor);
            vendor.getRelationList().size();
            vendor.getSectorList().size();

        } catch (Exception e) {
            throw new MaintainException("Error maintaining Organization Vendor with id '" + vendor.getId() + "'.",
                    e);
        }

        VendorMsg rs = new VendorMsg();
        rs.setVendor(vendor);

        return rs;
    }

    /**
     * Maintains the Organization characteristic master when it does not already exist.
     * 
     * @param master
     *            the master to maintain
     * 
     * @return the maintained master
     * 
     * @throws PersistenceException
     *             when the master cannot be persisted
     */
    private OrganizationMaster maintainMaster(OrganizationMaster master) throws PersistenceException {
        return super.getPersistenceManager().persist(master);
    }

    /**
     * Maintains the Organization characteristic when it does not already exist.
     * 
     * @param characteristic
     *            the characteristic to maintain
     * 
     * @return the maintained characteristic
     * 
     * @throws PersistenceException
     *             when the characteristic cannot be persisted
     */
    private Vendor maintainVendor(Vendor characteristic) throws PersistenceException {
        return super.getPersistenceManager().persist(characteristic);
    }

    /**
     * Maintains the Organization relation.
     * 
     * @param relation
     *            the relation to maintain
     * 
     * @return the maintained relation
     * 
     * @throws PersistenceException
     *             when the relation cannot be persisted
     */
    private OrganizationRelation maintainRelation(OrganizationRelation relation) throws PersistenceException {
        return super.getPersistenceManager().persist(relation);
    }

}
