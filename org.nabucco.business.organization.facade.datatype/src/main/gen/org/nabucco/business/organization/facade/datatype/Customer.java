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
import org.nabucco.business.organization.facade.datatype.CreditReport;
import org.nabucco.business.organization.facade.datatype.OrganizationCharacteristic;
import org.nabucco.business.organization.facade.datatype.OrganizationCharacteristicType;
import org.nabucco.business.organization.facade.datatype.OrganizationStatistic;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.FunctionalIdentifier;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * Customer
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-23
 */
public class Customer extends OrganizationCharacteristic implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final OrganizationCharacteristicType CHARACTERISTICTYPE_DEFAULT = OrganizationCharacteristicType.CUSTOMER;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m0,1;", "m0,1;", "m0,1;", "m0,1;" };

    public static final String CUSTOMERID = "customerId";

    public static final String FUNCTIONALSTATUSTYPE = "functionalStatusType";

    public static final String CREDITREPORT = "creditReport";

    public static final String STATISTIC = "statistic";

    private FunctionalIdentifier customerId;

    private Code functionalStatusType;

    private Long functionalStatusTypeRefId;

    protected static final String FUNCTIONALSTATUSTYPE_CODEPATH = "nabucco.business.organization.customer.functionalstatustype";

    private CreditReport creditReport;

    private OrganizationStatistic statistic;

    /** Constructs a new Customer instance. */
    public Customer() {
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
     * @param clone the Customer.
     */
    protected void cloneObject(Customer clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        if ((this.getCustomerId() != null)) {
            clone.setCustomerId(this.getCustomerId().cloneObject());
        }
        if ((this.getFunctionalStatusType() != null)) {
            clone.setFunctionalStatusType(this.getFunctionalStatusType().cloneObject());
        }
        if ((this.getFunctionalStatusTypeRefId() != null)) {
            clone.setFunctionalStatusTypeRefId(this.getFunctionalStatusTypeRefId());
        }
        if ((this.getCreditReport() != null)) {
            clone.setCreditReport(this.getCreditReport().cloneObject());
        }
        if ((this.getStatistic() != null)) {
            clone.setStatistic(this.getStatistic().cloneObject());
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
        propertyMap.put(CUSTOMERID, PropertyDescriptorSupport.createBasetype(CUSTOMERID, FunctionalIdentifier.class, 8,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(FUNCTIONALSTATUSTYPE, PropertyDescriptorSupport.createDatatype(FUNCTIONALSTATUSTYPE,
                Code.class, 9, PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPONENT,
                FUNCTIONALSTATUSTYPE_CODEPATH));
        propertyMap.put(CREDITREPORT, PropertyDescriptorSupport.createDatatype(CREDITREPORT, CreditReport.class, 10,
                PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(STATISTIC, PropertyDescriptorSupport.createDatatype(STATISTIC, OrganizationStatistic.class, 11,
                PROPERTY_CONSTRAINTS[3], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(Customer.getPropertyDescriptor(CUSTOMERID), this.customerId, null));
        properties.add(super.createProperty(Customer.getPropertyDescriptor(FUNCTIONALSTATUSTYPE),
                this.getFunctionalStatusType(), this.functionalStatusTypeRefId));
        properties
                .add(super.createProperty(Customer.getPropertyDescriptor(CREDITREPORT), this.getCreditReport(), null));
        properties.add(super.createProperty(Customer.getPropertyDescriptor(STATISTIC), this.getStatistic(), null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(CUSTOMERID) && (property.getType() == FunctionalIdentifier.class))) {
            this.setCustomerId(((FunctionalIdentifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(FUNCTIONALSTATUSTYPE) && (property.getType() == Code.class))) {
            this.setFunctionalStatusType(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CREDITREPORT) && (property.getType() == CreditReport.class))) {
            this.setCreditReport(((CreditReport) property.getInstance()));
            return true;
        } else if ((property.getName().equals(STATISTIC) && (property.getType() == OrganizationStatistic.class))) {
            this.setStatistic(((OrganizationStatistic) property.getInstance()));
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
        final Customer other = ((Customer) obj);
        if ((this.customerId == null)) {
            if ((other.customerId != null))
                return false;
        } else if ((!this.customerId.equals(other.customerId)))
            return false;
        if ((this.functionalStatusType == null)) {
            if ((other.functionalStatusType != null))
                return false;
        } else if ((!this.functionalStatusType.equals(other.functionalStatusType)))
            return false;
        if ((this.functionalStatusTypeRefId == null)) {
            if ((other.functionalStatusTypeRefId != null))
                return false;
        } else if ((!this.functionalStatusTypeRefId.equals(other.functionalStatusTypeRefId)))
            return false;
        if ((this.creditReport == null)) {
            if ((other.creditReport != null))
                return false;
        } else if ((!this.creditReport.equals(other.creditReport)))
            return false;
        if ((this.statistic == null)) {
            if ((other.statistic != null))
                return false;
        } else if ((!this.statistic.equals(other.statistic)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.customerId == null) ? 0 : this.customerId.hashCode()));
        result = ((PRIME * result) + ((this.functionalStatusType == null) ? 0 : this.functionalStatusType.hashCode()));
        result = ((PRIME * result) + ((this.functionalStatusTypeRefId == null) ? 0 : this.functionalStatusTypeRefId
                .hashCode()));
        result = ((PRIME * result) + ((this.creditReport == null) ? 0 : this.creditReport.hashCode()));
        result = ((PRIME * result) + ((this.statistic == null) ? 0 : this.statistic.hashCode()));
        return result;
    }

    @Override
    public Customer cloneObject() {
        Customer clone = new Customer();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getCustomerId.
     *
     * @return the FunctionalIdentifier.
     */
    public FunctionalIdentifier getCustomerId() {
        return this.customerId;
    }

    /**
     * Missing description at method setCustomerId.
     *
     * @param customerId the FunctionalIdentifier.
     */
    public void setCustomerId(FunctionalIdentifier customerId) {
        this.customerId = customerId;
    }

    /**
     * Missing description at method setCustomerId.
     *
     * @param customerId the String.
     */
    public void setCustomerId(String customerId) {
        if ((this.customerId == null)) {
            if ((customerId == null)) {
                return;
            }
            this.customerId = new FunctionalIdentifier();
        }
        this.customerId.setValue(customerId);
    }

    /**
     * Missing description at method setFunctionalStatusType.
     *
     * @param functionalStatusType the Code.
     */
    public void setFunctionalStatusType(Code functionalStatusType) {
        this.functionalStatusType = functionalStatusType;
        if ((functionalStatusType != null)) {
            this.setFunctionalStatusTypeRefId(functionalStatusType.getId());
        } else {
            this.setFunctionalStatusTypeRefId(null);
        }
    }

    /**
     * Missing description at method getFunctionalStatusType.
     *
     * @return the Code.
     */
    public Code getFunctionalStatusType() {
        return this.functionalStatusType;
    }

    /**
     * Getter for the FunctionalStatusTypeRefId.
     *
     * @return the Long.
     */
    public Long getFunctionalStatusTypeRefId() {
        return this.functionalStatusTypeRefId;
    }

    /**
     * Setter for the FunctionalStatusTypeRefId.
     *
     * @param functionalStatusTypeRefId the Long.
     */
    public void setFunctionalStatusTypeRefId(Long functionalStatusTypeRefId) {
        this.functionalStatusTypeRefId = functionalStatusTypeRefId;
    }

    /**
     * Missing description at method setCreditReport.
     *
     * @param creditReport the CreditReport.
     */
    public void setCreditReport(CreditReport creditReport) {
        this.creditReport = creditReport;
    }

    /**
     * Missing description at method getCreditReport.
     *
     * @return the CreditReport.
     */
    public CreditReport getCreditReport() {
        return this.creditReport;
    }

    /**
     * Missing description at method setStatistic.
     *
     * @param statistic the OrganizationStatistic.
     */
    public void setStatistic(OrganizationStatistic statistic) {
        this.statistic = statistic;
    }

    /**
     * Missing description at method getStatistic.
     *
     * @return the OrganizationStatistic.
     */
    public OrganizationStatistic getStatistic() {
        return this.statistic;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(Customer.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(Customer.class).getAllProperties();
    }

    /**
     * Getter for the FunctionalStatusTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getFunctionalStatusTypeCodePath() {
        return new CodePath(FUNCTIONALSTATUSTYPE_CODEPATH);
    }
}
