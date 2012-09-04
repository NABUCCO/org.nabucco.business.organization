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
import org.nabucco.framework.base.facade.datatype.Amount;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Number;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * BusinessVolume
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-02-22
 */
public class BusinessVolume extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m1,1;", "l0,n;u0,n;m1,1;", "m1,1;" };

    public static final String VOLUME = "volume";

    public static final String YEAR = "year";

    public static final String VOLUMECURRENCY = "volumeCurrency";

    private Amount volume;

    private Number year;

    private Code volumeCurrency;

    private Long volumeCurrencyRefId;

    protected static final String VOLUMECURRENCY_CODEPATH = "nabucco.framework.currency";

    /** Constructs a new BusinessVolume instance. */
    public BusinessVolume() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the BusinessVolume.
     */
    protected void cloneObject(BusinessVolume clone) {
        super.cloneObject(clone);
        if ((this.getVolume() != null)) {
            clone.setVolume(this.getVolume().cloneObject());
        }
        if ((this.getYear() != null)) {
            clone.setYear(this.getYear().cloneObject());
        }
        if ((this.getVolumeCurrency() != null)) {
            clone.setVolumeCurrency(this.getVolumeCurrency().cloneObject());
        }
        if ((this.getVolumeCurrencyRefId() != null)) {
            clone.setVolumeCurrencyRefId(this.getVolumeCurrencyRefId());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class).getPropertyMap());
        propertyMap.put(VOLUME,
                PropertyDescriptorSupport.createBasetype(VOLUME, Amount.class, 3, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(YEAR,
                PropertyDescriptorSupport.createBasetype(YEAR, Number.class, 4, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(VOLUMECURRENCY, PropertyDescriptorSupport.createDatatype(VOLUMECURRENCY, Code.class, 5,
                PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPONENT, VOLUMECURRENCY_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(BusinessVolume.getPropertyDescriptor(VOLUME), this.volume, null));
        properties.add(super.createProperty(BusinessVolume.getPropertyDescriptor(YEAR), this.year, null));
        properties.add(super.createProperty(BusinessVolume.getPropertyDescriptor(VOLUMECURRENCY),
                this.getVolumeCurrency(), this.volumeCurrencyRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(VOLUME) && (property.getType() == Amount.class))) {
            this.setVolume(((Amount) property.getInstance()));
            return true;
        } else if ((property.getName().equals(YEAR) && (property.getType() == Number.class))) {
            this.setYear(((Number) property.getInstance()));
            return true;
        } else if ((property.getName().equals(VOLUMECURRENCY) && (property.getType() == Code.class))) {
            this.setVolumeCurrency(((Code) property.getInstance()));
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
        final BusinessVolume other = ((BusinessVolume) obj);
        if ((this.volume == null)) {
            if ((other.volume != null))
                return false;
        } else if ((!this.volume.equals(other.volume)))
            return false;
        if ((this.year == null)) {
            if ((other.year != null))
                return false;
        } else if ((!this.year.equals(other.year)))
            return false;
        if ((this.volumeCurrency == null)) {
            if ((other.volumeCurrency != null))
                return false;
        } else if ((!this.volumeCurrency.equals(other.volumeCurrency)))
            return false;
        if ((this.volumeCurrencyRefId == null)) {
            if ((other.volumeCurrencyRefId != null))
                return false;
        } else if ((!this.volumeCurrencyRefId.equals(other.volumeCurrencyRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.volume == null) ? 0 : this.volume.hashCode()));
        result = ((PRIME * result) + ((this.year == null) ? 0 : this.year.hashCode()));
        result = ((PRIME * result) + ((this.volumeCurrency == null) ? 0 : this.volumeCurrency.hashCode()));
        result = ((PRIME * result) + ((this.volumeCurrencyRefId == null) ? 0 : this.volumeCurrencyRefId.hashCode()));
        return result;
    }

    @Override
    public BusinessVolume cloneObject() {
        BusinessVolume clone = new BusinessVolume();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getVolume.
     *
     * @return the Amount.
     */
    public Amount getVolume() {
        return this.volume;
    }

    /**
     * Missing description at method setVolume.
     *
     * @param volume the Amount.
     */
    public void setVolume(Amount volume) {
        this.volume = volume;
    }

    /**
     * Missing description at method setVolume.
     *
     * @param volume the java.math.BigDecimal.
     */
    public void setVolume(java.math.BigDecimal volume) {
        if ((this.volume == null)) {
            if ((volume == null)) {
                return;
            }
            this.volume = new Amount();
        }
        this.volume.setValue(volume);
    }

    /**
     * Missing description at method getYear.
     *
     * @return the Number.
     */
    public Number getYear() {
        return this.year;
    }

    /**
     * Missing description at method setYear.
     *
     * @param year the Number.
     */
    public void setYear(Number year) {
        this.year = year;
    }

    /**
     * Missing description at method setYear.
     *
     * @param year the Integer.
     */
    public void setYear(Integer year) {
        if ((this.year == null)) {
            if ((year == null)) {
                return;
            }
            this.year = new Number();
        }
        this.year.setValue(year);
    }

    /**
     * Missing description at method setVolumeCurrency.
     *
     * @param volumeCurrency the Code.
     */
    public void setVolumeCurrency(Code volumeCurrency) {
        this.volumeCurrency = volumeCurrency;
        if ((volumeCurrency != null)) {
            this.setVolumeCurrencyRefId(volumeCurrency.getId());
        } else {
            this.setVolumeCurrencyRefId(null);
        }
    }

    /**
     * Missing description at method getVolumeCurrency.
     *
     * @return the Code.
     */
    public Code getVolumeCurrency() {
        return this.volumeCurrency;
    }

    /**
     * Getter for the VolumeCurrencyRefId.
     *
     * @return the Long.
     */
    public Long getVolumeCurrencyRefId() {
        return this.volumeCurrencyRefId;
    }

    /**
     * Setter for the VolumeCurrencyRefId.
     *
     * @param volumeCurrencyRefId the Long.
     */
    public void setVolumeCurrencyRefId(Long volumeCurrencyRefId) {
        this.volumeCurrencyRefId = volumeCurrencyRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(BusinessVolume.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(BusinessVolume.class).getAllProperties();
    }

    /**
     * Getter for the VolumeCurrencyCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getVolumeCurrencyCodePath() {
        return new CodePath(VOLUMECURRENCY_CODEPATH);
    }
}
