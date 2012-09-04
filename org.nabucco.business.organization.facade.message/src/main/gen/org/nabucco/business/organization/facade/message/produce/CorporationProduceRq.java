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
package org.nabucco.business.organization.facade.message.produce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.organization.facade.datatype.OrganizationMaster;
import org.nabucco.framework.base.facade.datatype.Number;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * CorporationProduceRq<p/>Request Message for Corporation Production<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-01-18
 */
public class CorporationProduceRq extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,1;", "l0,n;u0,n;m1,1;" };

    public static final String MASTER = "master";

    public static final String AMOUNT = "amount";

    /** The master object of the new produced corporation (when null a new master object is created). */
    private OrganizationMaster master;

    /** The amount of corporations to produce. */
    private Number amount;

    /** Constructs a new CorporationProduceRq instance. */
    public CorporationProduceRq() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(MASTER, PropertyDescriptorSupport.createDatatype(MASTER, OrganizationMaster.class, 0,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(AMOUNT,
                PropertyDescriptorSupport.createBasetype(AMOUNT, Number.class, 1, PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(CorporationProduceRq.getPropertyDescriptor(MASTER), this.getMaster()));
        properties.add(super.createProperty(CorporationProduceRq.getPropertyDescriptor(AMOUNT), this.amount));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(MASTER) && (property.getType() == OrganizationMaster.class))) {
            this.setMaster(((OrganizationMaster) property.getInstance()));
            return true;
        } else if ((property.getName().equals(AMOUNT) && (property.getType() == Number.class))) {
            this.setAmount(((Number) property.getInstance()));
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
        final CorporationProduceRq other = ((CorporationProduceRq) obj);
        if ((this.master == null)) {
            if ((other.master != null))
                return false;
        } else if ((!this.master.equals(other.master)))
            return false;
        if ((this.amount == null)) {
            if ((other.amount != null))
                return false;
        } else if ((!this.amount.equals(other.amount)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.master == null) ? 0 : this.master.hashCode()));
        result = ((PRIME * result) + ((this.amount == null) ? 0 : this.amount.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * The master object of the new produced corporation (when null a new master object is created).
     *
     * @return the OrganizationMaster.
     */
    public OrganizationMaster getMaster() {
        return this.master;
    }

    /**
     * The master object of the new produced corporation (when null a new master object is created).
     *
     * @param master the OrganizationMaster.
     */
    public void setMaster(OrganizationMaster master) {
        this.master = master;
    }

    /**
     * The amount of corporations to produce.
     *
     * @return the Number.
     */
    public Number getAmount() {
        return this.amount;
    }

    /**
     * The amount of corporations to produce.
     *
     * @param amount the Number.
     */
    public void setAmount(Number amount) {
        this.amount = amount;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(CorporationProduceRq.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(CorporationProduceRq.class).getAllProperties();
    }
}
