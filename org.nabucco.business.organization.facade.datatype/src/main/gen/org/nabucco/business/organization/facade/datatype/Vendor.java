/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.business.organization.facade.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.organization.facade.datatype.OrganizationCharacteristic;
import org.nabucco.business.organization.facade.datatype.OrganizationCharacteristicType;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.FunctionalIdentifier;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * Vendor
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-23
 */
public class Vendor extends OrganizationCharacteristic implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final OrganizationCharacteristicType CHARACTERISTICTYPE_DEFAULT = OrganizationCharacteristicType.VENDOR;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m1,1;" };

    public static final String VENDORID = "vendorId";

    private FunctionalIdentifier vendorId;

    /** Constructs a new Vendor instance. */
    public Vendor() {
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
     * @param clone the Vendor.
     */
    protected void cloneObject(Vendor clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        if ((this.getVendorId() != null)) {
            clone.setVendorId(this.getVendorId().cloneObject());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(OrganizationCharacteristic.class).getPropertyMap());
        propertyMap.put(VENDORID, PropertyDescriptorSupport.createBasetype(VENDORID, FunctionalIdentifier.class, 8,
                PROPERTY_CONSTRAINTS[0], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(Vendor.getPropertyDescriptor(VENDORID), this.vendorId, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(VENDORID) && (property.getType() == FunctionalIdentifier.class))) {
            this.setVendorId(((FunctionalIdentifier) property.getInstance()));
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
        final Vendor other = ((Vendor) obj);
        if ((this.vendorId == null)) {
            if ((other.vendorId != null))
                return false;
        } else if ((!this.vendorId.equals(other.vendorId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.vendorId == null) ? 0 : this.vendorId.hashCode()));
        return result;
    }

    @Override
    public Vendor cloneObject() {
        Vendor clone = new Vendor();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getVendorId.
     *
     * @return the FunctionalIdentifier.
     */
    public FunctionalIdentifier getVendorId() {
        return this.vendorId;
    }

    /**
     * Missing description at method setVendorId.
     *
     * @param vendorId the FunctionalIdentifier.
     */
    public void setVendorId(FunctionalIdentifier vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * Missing description at method setVendorId.
     *
     * @param vendorId the String.
     */
    public void setVendorId(String vendorId) {
        if ((this.vendorId == null)) {
            if ((vendorId == null)) {
                return;
            }
            this.vendorId = new FunctionalIdentifier();
        }
        this.vendorId.setValue(vendorId);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(Vendor.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(Vendor.class).getAllProperties();
    }
}
