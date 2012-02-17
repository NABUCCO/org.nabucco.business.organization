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
import org.nabucco.business.organization.facade.datatype.BusinessVolume;
import org.nabucco.business.organization.facade.datatype.CorporationType;
import org.nabucco.business.organization.facade.datatype.OrganizationCharacteristic;
import org.nabucco.business.organization.facade.datatype.OrganizationCharacteristicType;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
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
 * Corporation
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-23
 */
public class Corporation extends OrganizationCharacteristic implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final OrganizationCharacteristicType CHARACTERISTICTYPE_DEFAULT = OrganizationCharacteristicType.CORPORATION;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,1;", "m0,n;" };

    public static final String CORPORATIONTYPE = "corporationType";

    public static final String CORPORATIONFORM = "corporationForm";

    public static final String BUSINESSVOLUMELIST = "businessVolumeList";

    private CorporationType corporationType;

    private Code corporationForm;

    private Long corporationFormRefId;

    protected static final String CORPORATIONFORM_CODEPATH = "nabucco.business.organization.corporationform";

    private NabuccoList<BusinessVolume> businessVolumeList;

    /** Constructs a new Corporation instance. */
    public Corporation() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        characteristicType = CHARACTERISTICTYPE_DEFAULT;
    }

    /**
     * CloneObject.
     *
     * @param clone the Corporation.
     */
    protected void cloneObject(Corporation clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        clone.setCorporationType(this.getCorporationType());
        if ((this.getCorporationForm() != null)) {
            clone.setCorporationForm(this.getCorporationForm().cloneObject());
        }
        if ((this.getCorporationFormRefId() != null)) {
            clone.setCorporationFormRefId(this.getCorporationFormRefId());
        }
        if ((this.businessVolumeList != null)) {
            clone.businessVolumeList = this.businessVolumeList.cloneCollection();
        }
    }

    /**
     * Getter for the BusinessVolumeListJPA.
     *
     * @return the List<BusinessVolume>.
     */
    List<BusinessVolume> getBusinessVolumeListJPA() {
        if ((this.businessVolumeList == null)) {
            this.businessVolumeList = new NabuccoListImpl<BusinessVolume>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<BusinessVolume>) this.businessVolumeList).getDelegate();
    }

    /**
     * Setter for the BusinessVolumeListJPA.
     *
     * @param businessVolumeList the List<BusinessVolume>.
     */
    void setBusinessVolumeListJPA(List<BusinessVolume> businessVolumeList) {
        if ((this.businessVolumeList == null)) {
            this.businessVolumeList = new NabuccoListImpl<BusinessVolume>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<BusinessVolume>) this.businessVolumeList).setDelegate(businessVolumeList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(OrganizationCharacteristic.class).getPropertyMap());
        propertyMap.put(CORPORATIONTYPE, PropertyDescriptorSupport.createEnumeration(CORPORATIONTYPE,
                CorporationType.class, 8, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(CORPORATIONFORM, PropertyDescriptorSupport.createDatatype(CORPORATIONFORM, Code.class, 9,
                PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPONENT, CORPORATIONFORM_CODEPATH));
        propertyMap.put(BUSINESSVOLUMELIST, PropertyDescriptorSupport.createCollection(BUSINESSVOLUMELIST,
                BusinessVolume.class, 10, PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(Corporation.getPropertyDescriptor(CORPORATIONTYPE),
                this.getCorporationType(), null));
        properties.add(super.createProperty(Corporation.getPropertyDescriptor(CORPORATIONFORM),
                this.getCorporationForm(), this.corporationFormRefId));
        properties.add(super.createProperty(Corporation.getPropertyDescriptor(BUSINESSVOLUMELIST),
                this.businessVolumeList, null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(CORPORATIONTYPE) && (property.getType() == CorporationType.class))) {
            this.setCorporationType(((CorporationType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CORPORATIONFORM) && (property.getType() == Code.class))) {
            this.setCorporationForm(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(BUSINESSVOLUMELIST) && (property.getType() == BusinessVolume.class))) {
            this.businessVolumeList = ((NabuccoList<BusinessVolume>) property.getInstance());
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
        final Corporation other = ((Corporation) obj);
        if ((this.corporationType == null)) {
            if ((other.corporationType != null))
                return false;
        } else if ((!this.corporationType.equals(other.corporationType)))
            return false;
        if ((this.corporationForm == null)) {
            if ((other.corporationForm != null))
                return false;
        } else if ((!this.corporationForm.equals(other.corporationForm)))
            return false;
        if ((this.corporationFormRefId == null)) {
            if ((other.corporationFormRefId != null))
                return false;
        } else if ((!this.corporationFormRefId.equals(other.corporationFormRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.corporationType == null) ? 0 : this.corporationType.hashCode()));
        result = ((PRIME * result) + ((this.corporationForm == null) ? 0 : this.corporationForm.hashCode()));
        result = ((PRIME * result) + ((this.corporationFormRefId == null) ? 0 : this.corporationFormRefId.hashCode()));
        return result;
    }

    @Override
    public Corporation cloneObject() {
        Corporation clone = new Corporation();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getCorporationType.
     *
     * @return the CorporationType.
     */
    public CorporationType getCorporationType() {
        return this.corporationType;
    }

    /**
     * Missing description at method setCorporationType.
     *
     * @param corporationType the CorporationType.
     */
    public void setCorporationType(CorporationType corporationType) {
        this.corporationType = corporationType;
    }

    /**
     * Missing description at method setCorporationType.
     *
     * @param corporationType the String.
     */
    public void setCorporationType(String corporationType) {
        if ((corporationType == null)) {
            this.corporationType = null;
        } else {
            this.corporationType = CorporationType.valueOf(corporationType);
        }
    }

    /**
     * Missing description at method setCorporationForm.
     *
     * @param corporationForm the Code.
     */
    public void setCorporationForm(Code corporationForm) {
        this.corporationForm = corporationForm;
        if ((corporationForm != null)) {
            this.setCorporationFormRefId(corporationForm.getId());
        } else {
            this.setCorporationFormRefId(null);
        }
    }

    /**
     * Missing description at method getCorporationForm.
     *
     * @return the Code.
     */
    public Code getCorporationForm() {
        return this.corporationForm;
    }

    /**
     * Getter for the CorporationFormRefId.
     *
     * @return the Long.
     */
    public Long getCorporationFormRefId() {
        return this.corporationFormRefId;
    }

    /**
     * Setter for the CorporationFormRefId.
     *
     * @param corporationFormRefId the Long.
     */
    public void setCorporationFormRefId(Long corporationFormRefId) {
        this.corporationFormRefId = corporationFormRefId;
    }

    /**
     * Missing description at method getBusinessVolumeList.
     *
     * @return the NabuccoList<BusinessVolume>.
     */
    public NabuccoList<BusinessVolume> getBusinessVolumeList() {
        if ((this.businessVolumeList == null)) {
            this.businessVolumeList = new NabuccoListImpl<BusinessVolume>(NabuccoCollectionState.INITIALIZED);
        }
        return this.businessVolumeList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(Corporation.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(Corporation.class).getAllProperties();
    }

    /**
     * Getter for the CorporationFormCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getCorporationFormCodePath() {
        return new CodePath(CORPORATIONFORM_CODEPATH);
    }
}
