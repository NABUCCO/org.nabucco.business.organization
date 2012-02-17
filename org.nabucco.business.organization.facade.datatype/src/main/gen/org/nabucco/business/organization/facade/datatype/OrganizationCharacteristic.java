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
package org.nabucco.business.organization.facade.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.organization.facade.datatype.OrganizationCharacteristicType;
import org.nabucco.business.organization.facade.datatype.OrganizationMaster;
import org.nabucco.business.organization.facade.datatype.OrganizationRelation;
import org.nabucco.business.organization.facade.datatype.Sector;
import org.nabucco.business.organization.facade.datatype.WorkingTime;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * OrganizationCharacteristic
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-23
 */
public abstract class OrganizationCharacteristic extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;", "m0,n;", "m0,n;", "m0,1;" };

    public static final String CHARACTERISTICTYPE = "characteristicType";

    public static final String MASTER = "master";

    public static final String SECTORLIST = "sectorList";

    public static final String RELATIONLIST = "relationList";

    public static final String WORKINGTIME = "workingTime";

    protected OrganizationCharacteristicType characteristicType;

    private OrganizationMaster master;

    private NabuccoList<Sector> sectorList;

    private NabuccoList<OrganizationRelation> relationList;

    private WorkingTime workingTime;

    /** Constructs a new OrganizationCharacteristic instance. */
    public OrganizationCharacteristic() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the OrganizationCharacteristic.
     */
    protected void cloneObject(OrganizationCharacteristic clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        if ((this.getMaster() != null)) {
            clone.setMaster(this.getMaster().cloneObject());
        }
        if ((this.sectorList != null)) {
            clone.sectorList = this.sectorList.cloneCollection();
        }
        if ((this.relationList != null)) {
            clone.relationList = this.relationList.cloneCollection();
        }
        if ((this.getWorkingTime() != null)) {
            clone.setWorkingTime(this.getWorkingTime().cloneObject());
        }
    }

    /**
     * Getter for the SectorListJPA.
     *
     * @return the List<Sector>.
     */
    List<Sector> getSectorListJPA() {
        if ((this.sectorList == null)) {
            this.sectorList = new NabuccoListImpl<Sector>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<Sector>) this.sectorList).getDelegate();
    }

    /**
     * Setter for the SectorListJPA.
     *
     * @param sectorList the List<Sector>.
     */
    void setSectorListJPA(List<Sector> sectorList) {
        if ((this.sectorList == null)) {
            this.sectorList = new NabuccoListImpl<Sector>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<Sector>) this.sectorList).setDelegate(sectorList);
    }

    /**
     * Getter for the RelationListJPA.
     *
     * @return the List<OrganizationRelation>.
     */
    List<OrganizationRelation> getRelationListJPA() {
        if ((this.relationList == null)) {
            this.relationList = new NabuccoListImpl<OrganizationRelation>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<OrganizationRelation>) this.relationList).getDelegate();
    }

    /**
     * Setter for the RelationListJPA.
     *
     * @param relationList the List<OrganizationRelation>.
     */
    void setRelationListJPA(List<OrganizationRelation> relationList) {
        if ((this.relationList == null)) {
            this.relationList = new NabuccoListImpl<OrganizationRelation>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<OrganizationRelation>) this.relationList).setDelegate(relationList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class).getPropertyMap());
        propertyMap.put(CHARACTERISTICTYPE, PropertyDescriptorSupport.createEnumeration(CHARACTERISTICTYPE,
                OrganizationCharacteristicType.class, 3, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(MASTER, PropertyDescriptorSupport.createDatatype(MASTER, OrganizationMaster.class, 4,
                PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.AGGREGATION));
        propertyMap.put(SECTORLIST, PropertyDescriptorSupport.createCollection(SECTORLIST, Sector.class, 5,
                PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(RELATIONLIST, PropertyDescriptorSupport.createCollection(RELATIONLIST,
                OrganizationRelation.class, 6, PROPERTY_CONSTRAINTS[3], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(WORKINGTIME, PropertyDescriptorSupport.createDatatype(WORKINGTIME, WorkingTime.class, 7,
                PROPERTY_CONSTRAINTS[4], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(OrganizationCharacteristic.getPropertyDescriptor(CHARACTERISTICTYPE),
                this.getCharacteristicType(), null));
        properties.add(super.createProperty(OrganizationCharacteristic.getPropertyDescriptor(MASTER), this.getMaster(),
                null));
        properties.add(super.createProperty(OrganizationCharacteristic.getPropertyDescriptor(SECTORLIST),
                this.sectorList, null));
        properties.add(super.createProperty(OrganizationCharacteristic.getPropertyDescriptor(RELATIONLIST),
                this.relationList, null));
        properties.add(super.createProperty(OrganizationCharacteristic.getPropertyDescriptor(WORKINGTIME),
                this.getWorkingTime(), null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(CHARACTERISTICTYPE) && (property.getType() == OrganizationCharacteristicType.class))) {
            this.setCharacteristicType(((OrganizationCharacteristicType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(MASTER) && (property.getType() == OrganizationMaster.class))) {
            this.setMaster(((OrganizationMaster) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SECTORLIST) && (property.getType() == Sector.class))) {
            this.sectorList = ((NabuccoList<Sector>) property.getInstance());
            return true;
        } else if ((property.getName().equals(RELATIONLIST) && (property.getType() == OrganizationRelation.class))) {
            this.relationList = ((NabuccoList<OrganizationRelation>) property.getInstance());
            return true;
        } else if ((property.getName().equals(WORKINGTIME) && (property.getType() == WorkingTime.class))) {
            this.setWorkingTime(((WorkingTime) property.getInstance()));
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if ((this == obj)) {
            return true;
        }
        if ((obj == null)) {
            return false;
        }
        if ((this.getClass() != obj.getClass())) {
            return false;
        }
        if ((!super.equals(obj))) {
            return false;
        }
        final OrganizationCharacteristic other = ((OrganizationCharacteristic) obj);
        if ((this.characteristicType == null)) {
            if ((other.characteristicType != null))
                return false;
        } else if ((!this.characteristicType.equals(other.characteristicType)))
            return false;
        if ((this.master == null)) {
            if ((other.master != null))
                return false;
        } else if ((!this.master.equals(other.master)))
            return false;
        if ((this.workingTime == null)) {
            if ((other.workingTime != null))
                return false;
        } else if ((!this.workingTime.equals(other.workingTime)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.characteristicType == null) ? 0 : this.characteristicType.hashCode()));
        result = ((PRIME * result) + ((this.master == null) ? 0 : this.master.hashCode()));
        result = ((PRIME * result) + ((this.workingTime == null) ? 0 : this.workingTime.hashCode()));
        return result;
    }

    @Override
    public abstract OrganizationCharacteristic cloneObject();

    /**
     * Missing description at method getCharacteristicType.
     *
     * @return the OrganizationCharacteristicType.
     */
    public OrganizationCharacteristicType getCharacteristicType() {
        return this.characteristicType;
    }

    /**
     * Missing description at method setCharacteristicType.
     *
     * @param characteristicType the OrganizationCharacteristicType.
     */
    public void setCharacteristicType(OrganizationCharacteristicType characteristicType) {
        this.characteristicType = characteristicType;
    }

    /**
     * Missing description at method setCharacteristicType.
     *
     * @param characteristicType the String.
     */
    public void setCharacteristicType(String characteristicType) {
        if ((characteristicType == null)) {
            this.characteristicType = null;
        } else {
            this.characteristicType = OrganizationCharacteristicType.valueOf(characteristicType);
        }
    }

    /**
     * Missing description at method setMaster.
     *
     * @param master the OrganizationMaster.
     */
    public void setMaster(OrganizationMaster master) {
        this.master = master;
    }

    /**
     * Missing description at method getMaster.
     *
     * @return the OrganizationMaster.
     */
    public OrganizationMaster getMaster() {
        return this.master;
    }

    /**
     * Missing description at method getSectorList.
     *
     * @return the NabuccoList<Sector>.
     */
    public NabuccoList<Sector> getSectorList() {
        if ((this.sectorList == null)) {
            this.sectorList = new NabuccoListImpl<Sector>(NabuccoCollectionState.INITIALIZED);
        }
        return this.sectorList;
    }

    /**
     * Missing description at method getRelationList.
     *
     * @return the NabuccoList<OrganizationRelation>.
     */
    public NabuccoList<OrganizationRelation> getRelationList() {
        if ((this.relationList == null)) {
            this.relationList = new NabuccoListImpl<OrganizationRelation>(NabuccoCollectionState.INITIALIZED);
        }
        return this.relationList;
    }

    /**
     * Missing description at method setWorkingTime.
     *
     * @param workingTime the WorkingTime.
     */
    public void setWorkingTime(WorkingTime workingTime) {
        this.workingTime = workingTime;
    }

    /**
     * Missing description at method getWorkingTime.
     *
     * @return the WorkingTime.
     */
    public WorkingTime getWorkingTime() {
        return this.workingTime;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(OrganizationCharacteristic.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(OrganizationCharacteristic.class).getAllProperties();
    }
}
