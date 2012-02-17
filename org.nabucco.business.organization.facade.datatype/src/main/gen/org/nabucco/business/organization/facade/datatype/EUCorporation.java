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
import org.nabucco.business.organization.facade.datatype.OrganizationCharacteristic;
import org.nabucco.business.organization.facade.datatype.OrganizationCharacteristicType;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.FunctionalIdentifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * EUCorporation
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-01-10
 */
public class EUCorporation extends OrganizationCharacteristic implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final OrganizationCharacteristicType CHARACTERISTICTYPE_DEFAULT = OrganizationCharacteristicType.EU_CORPORATION;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m0,1;", "l0,255;u0,n;m0,1;", "l0,n;u0,n;m0,1;" };

    public static final String USTID = "ustId";

    public static final String AMTSGERICHT = "amtsgericht";

    public static final String HANDELSREGISTER = "handelsregister";

    private FunctionalIdentifier ustId;

    private Name amtsgericht;

    private FunctionalIdentifier handelsregister;

    /** Constructs a new EUCorporation instance. */
    public EUCorporation() {
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
     * @param clone the EUCorporation.
     */
    protected void cloneObject(EUCorporation clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        if ((this.getUstId() != null)) {
            clone.setUstId(this.getUstId().cloneObject());
        }
        if ((this.getAmtsgericht() != null)) {
            clone.setAmtsgericht(this.getAmtsgericht().cloneObject());
        }
        if ((this.getHandelsregister() != null)) {
            clone.setHandelsregister(this.getHandelsregister().cloneObject());
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
        propertyMap.put(USTID, PropertyDescriptorSupport.createBasetype(USTID, FunctionalIdentifier.class, 8,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(AMTSGERICHT,
                PropertyDescriptorSupport.createBasetype(AMTSGERICHT, Name.class, 9, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(HANDELSREGISTER, PropertyDescriptorSupport.createBasetype(HANDELSREGISTER,
                FunctionalIdentifier.class, 10, PROPERTY_CONSTRAINTS[2], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(EUCorporation.getPropertyDescriptor(USTID), this.ustId, null));
        properties.add(super.createProperty(EUCorporation.getPropertyDescriptor(AMTSGERICHT), this.amtsgericht, null));
        properties.add(super.createProperty(EUCorporation.getPropertyDescriptor(HANDELSREGISTER), this.handelsregister,
                null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(USTID) && (property.getType() == FunctionalIdentifier.class))) {
            this.setUstId(((FunctionalIdentifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(AMTSGERICHT) && (property.getType() == Name.class))) {
            this.setAmtsgericht(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(HANDELSREGISTER) && (property.getType() == FunctionalIdentifier.class))) {
            this.setHandelsregister(((FunctionalIdentifier) property.getInstance()));
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
        final EUCorporation other = ((EUCorporation) obj);
        if ((this.ustId == null)) {
            if ((other.ustId != null))
                return false;
        } else if ((!this.ustId.equals(other.ustId)))
            return false;
        if ((this.amtsgericht == null)) {
            if ((other.amtsgericht != null))
                return false;
        } else if ((!this.amtsgericht.equals(other.amtsgericht)))
            return false;
        if ((this.handelsregister == null)) {
            if ((other.handelsregister != null))
                return false;
        } else if ((!this.handelsregister.equals(other.handelsregister)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.ustId == null) ? 0 : this.ustId.hashCode()));
        result = ((PRIME * result) + ((this.amtsgericht == null) ? 0 : this.amtsgericht.hashCode()));
        result = ((PRIME * result) + ((this.handelsregister == null) ? 0 : this.handelsregister.hashCode()));
        return result;
    }

    @Override
    public EUCorporation cloneObject() {
        EUCorporation clone = new EUCorporation();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getUstId.
     *
     * @return the FunctionalIdentifier.
     */
    public FunctionalIdentifier getUstId() {
        return this.ustId;
    }

    /**
     * Missing description at method setUstId.
     *
     * @param ustId the FunctionalIdentifier.
     */
    public void setUstId(FunctionalIdentifier ustId) {
        this.ustId = ustId;
    }

    /**
     * Missing description at method setUstId.
     *
     * @param ustId the String.
     */
    public void setUstId(String ustId) {
        if ((this.ustId == null)) {
            if ((ustId == null)) {
                return;
            }
            this.ustId = new FunctionalIdentifier();
        }
        this.ustId.setValue(ustId);
    }

    /**
     * Missing description at method getAmtsgericht.
     *
     * @return the Name.
     */
    public Name getAmtsgericht() {
        return this.amtsgericht;
    }

    /**
     * Missing description at method setAmtsgericht.
     *
     * @param amtsgericht the Name.
     */
    public void setAmtsgericht(Name amtsgericht) {
        this.amtsgericht = amtsgericht;
    }

    /**
     * Missing description at method setAmtsgericht.
     *
     * @param amtsgericht the String.
     */
    public void setAmtsgericht(String amtsgericht) {
        if ((this.amtsgericht == null)) {
            if ((amtsgericht == null)) {
                return;
            }
            this.amtsgericht = new Name();
        }
        this.amtsgericht.setValue(amtsgericht);
    }

    /**
     * Missing description at method getHandelsregister.
     *
     * @return the FunctionalIdentifier.
     */
    public FunctionalIdentifier getHandelsregister() {
        return this.handelsregister;
    }

    /**
     * Missing description at method setHandelsregister.
     *
     * @param handelsregister the FunctionalIdentifier.
     */
    public void setHandelsregister(FunctionalIdentifier handelsregister) {
        this.handelsregister = handelsregister;
    }

    /**
     * Missing description at method setHandelsregister.
     *
     * @param handelsregister the String.
     */
    public void setHandelsregister(String handelsregister) {
        if ((this.handelsregister == null)) {
            if ((handelsregister == null)) {
                return;
            }
            this.handelsregister = new FunctionalIdentifier();
        }
        this.handelsregister.setValue(handelsregister);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(EUCorporation.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(EUCorporation.class).getAllProperties();
    }
}
