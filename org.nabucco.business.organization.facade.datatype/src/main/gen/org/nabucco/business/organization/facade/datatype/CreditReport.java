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
import org.nabucco.framework.base.facade.datatype.Amount;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.FunctionalIdentifier;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * CreditReport
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-01-10
 */
public class CreditReport extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;",
            "l0,n;u0,n;m0,1;", "m0,1;", "m0,1;", "m0,1;" };

    public static final String CREDITWORTHINESS = "creditWorthiness";

    public static final String EXTERNALID = "externalId";

    public static final String CREDITLIMIT = "creditLimit";

    public static final String EXTERNALCREDITLIMIT = "externalCreditLimit";

    public static final String CREDITLIMITCURRENCY = "creditLimitCurrency";

    public static final String EXTERNALCREDITLIMITCURRENCY = "externalCreditLimitCurrency";

    public static final String TERMSOFPAYMENT = "termsofpayment";

    private FunctionalIdentifier creditWorthiness;

    private FunctionalIdentifier externalId;

    private Amount creditLimit;

    private Amount externalCreditLimit;

    private Code creditLimitCurrency;

    private Long creditLimitCurrencyRefId;

    protected static final String CREDITLIMITCURRENCY_CODEPATH = "nabucco.framework.currency";

    private Code externalCreditLimitCurrency;

    private Long externalCreditLimitCurrencyRefId;

    protected static final String EXTERNALCREDITLIMITCURRENCY_CODEPATH = "nabucco.framework.currency";

    private Code termsofpayment;

    private Long termsofpaymentRefId;

    protected static final String TERMSOFPAYMENT_CODEPATH = "nabucco.business.contracting.termsofpayment";

    /** Constructs a new CreditReport instance. */
    public CreditReport() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the CreditReport.
     */
    protected void cloneObject(CreditReport clone) {
        super.cloneObject(clone);
        if ((this.getCreditWorthiness() != null)) {
            clone.setCreditWorthiness(this.getCreditWorthiness().cloneObject());
        }
        if ((this.getExternalId() != null)) {
            clone.setExternalId(this.getExternalId().cloneObject());
        }
        if ((this.getCreditLimit() != null)) {
            clone.setCreditLimit(this.getCreditLimit().cloneObject());
        }
        if ((this.getExternalCreditLimit() != null)) {
            clone.setExternalCreditLimit(this.getExternalCreditLimit().cloneObject());
        }
        if ((this.getCreditLimitCurrency() != null)) {
            clone.setCreditLimitCurrency(this.getCreditLimitCurrency().cloneObject());
        }
        if ((this.getCreditLimitCurrencyRefId() != null)) {
            clone.setCreditLimitCurrencyRefId(this.getCreditLimitCurrencyRefId());
        }
        if ((this.getExternalCreditLimitCurrency() != null)) {
            clone.setExternalCreditLimitCurrency(this.getExternalCreditLimitCurrency().cloneObject());
        }
        if ((this.getExternalCreditLimitCurrencyRefId() != null)) {
            clone.setExternalCreditLimitCurrencyRefId(this.getExternalCreditLimitCurrencyRefId());
        }
        if ((this.getTermsofpayment() != null)) {
            clone.setTermsofpayment(this.getTermsofpayment().cloneObject());
        }
        if ((this.getTermsofpaymentRefId() != null)) {
            clone.setTermsofpaymentRefId(this.getTermsofpaymentRefId());
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
        propertyMap.put(CREDITWORTHINESS, PropertyDescriptorSupport.createBasetype(CREDITWORTHINESS,
                FunctionalIdentifier.class, 3, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(EXTERNALID, PropertyDescriptorSupport.createBasetype(EXTERNALID, FunctionalIdentifier.class, 4,
                PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(CREDITLIMIT,
                PropertyDescriptorSupport.createBasetype(CREDITLIMIT, Amount.class, 5, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(EXTERNALCREDITLIMIT, PropertyDescriptorSupport.createBasetype(EXTERNALCREDITLIMIT,
                Amount.class, 6, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(CREDITLIMITCURRENCY, PropertyDescriptorSupport.createDatatype(CREDITLIMITCURRENCY, Code.class,
                7, PROPERTY_CONSTRAINTS[4], false, PropertyAssociationType.COMPONENT, CREDITLIMITCURRENCY_CODEPATH));
        propertyMap.put(EXTERNALCREDITLIMITCURRENCY, PropertyDescriptorSupport.createDatatype(
                EXTERNALCREDITLIMITCURRENCY, Code.class, 8, PROPERTY_CONSTRAINTS[5], false,
                PropertyAssociationType.COMPONENT, EXTERNALCREDITLIMITCURRENCY_CODEPATH));
        propertyMap.put(TERMSOFPAYMENT, PropertyDescriptorSupport.createDatatype(TERMSOFPAYMENT, Code.class, 9,
                PROPERTY_CONSTRAINTS[6], false, PropertyAssociationType.COMPONENT, TERMSOFPAYMENT_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(CreditReport.getPropertyDescriptor(CREDITWORTHINESS),
                this.creditWorthiness, null));
        properties.add(super.createProperty(CreditReport.getPropertyDescriptor(EXTERNALID), this.externalId, null));
        properties.add(super.createProperty(CreditReport.getPropertyDescriptor(CREDITLIMIT), this.creditLimit, null));
        properties.add(super.createProperty(CreditReport.getPropertyDescriptor(EXTERNALCREDITLIMIT),
                this.externalCreditLimit, null));
        properties.add(super.createProperty(CreditReport.getPropertyDescriptor(CREDITLIMITCURRENCY),
                this.getCreditLimitCurrency(), this.creditLimitCurrencyRefId));
        properties.add(super.createProperty(CreditReport.getPropertyDescriptor(EXTERNALCREDITLIMITCURRENCY),
                this.getExternalCreditLimitCurrency(), this.externalCreditLimitCurrencyRefId));
        properties.add(super.createProperty(CreditReport.getPropertyDescriptor(TERMSOFPAYMENT),
                this.getTermsofpayment(), this.termsofpaymentRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(CREDITWORTHINESS) && (property.getType() == FunctionalIdentifier.class))) {
            this.setCreditWorthiness(((FunctionalIdentifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(EXTERNALID) && (property.getType() == FunctionalIdentifier.class))) {
            this.setExternalId(((FunctionalIdentifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CREDITLIMIT) && (property.getType() == Amount.class))) {
            this.setCreditLimit(((Amount) property.getInstance()));
            return true;
        } else if ((property.getName().equals(EXTERNALCREDITLIMIT) && (property.getType() == Amount.class))) {
            this.setExternalCreditLimit(((Amount) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CREDITLIMITCURRENCY) && (property.getType() == Code.class))) {
            this.setCreditLimitCurrency(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(EXTERNALCREDITLIMITCURRENCY) && (property.getType() == Code.class))) {
            this.setExternalCreditLimitCurrency(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TERMSOFPAYMENT) && (property.getType() == Code.class))) {
            this.setTermsofpayment(((Code) property.getInstance()));
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
        final CreditReport other = ((CreditReport) obj);
        if ((this.creditWorthiness == null)) {
            if ((other.creditWorthiness != null))
                return false;
        } else if ((!this.creditWorthiness.equals(other.creditWorthiness)))
            return false;
        if ((this.externalId == null)) {
            if ((other.externalId != null))
                return false;
        } else if ((!this.externalId.equals(other.externalId)))
            return false;
        if ((this.creditLimit == null)) {
            if ((other.creditLimit != null))
                return false;
        } else if ((!this.creditLimit.equals(other.creditLimit)))
            return false;
        if ((this.externalCreditLimit == null)) {
            if ((other.externalCreditLimit != null))
                return false;
        } else if ((!this.externalCreditLimit.equals(other.externalCreditLimit)))
            return false;
        if ((this.creditLimitCurrency == null)) {
            if ((other.creditLimitCurrency != null))
                return false;
        } else if ((!this.creditLimitCurrency.equals(other.creditLimitCurrency)))
            return false;
        if ((this.creditLimitCurrencyRefId == null)) {
            if ((other.creditLimitCurrencyRefId != null))
                return false;
        } else if ((!this.creditLimitCurrencyRefId.equals(other.creditLimitCurrencyRefId)))
            return false;
        if ((this.externalCreditLimitCurrency == null)) {
            if ((other.externalCreditLimitCurrency != null))
                return false;
        } else if ((!this.externalCreditLimitCurrency.equals(other.externalCreditLimitCurrency)))
            return false;
        if ((this.externalCreditLimitCurrencyRefId == null)) {
            if ((other.externalCreditLimitCurrencyRefId != null))
                return false;
        } else if ((!this.externalCreditLimitCurrencyRefId.equals(other.externalCreditLimitCurrencyRefId)))
            return false;
        if ((this.termsofpayment == null)) {
            if ((other.termsofpayment != null))
                return false;
        } else if ((!this.termsofpayment.equals(other.termsofpayment)))
            return false;
        if ((this.termsofpaymentRefId == null)) {
            if ((other.termsofpaymentRefId != null))
                return false;
        } else if ((!this.termsofpaymentRefId.equals(other.termsofpaymentRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.creditWorthiness == null) ? 0 : this.creditWorthiness.hashCode()));
        result = ((PRIME * result) + ((this.externalId == null) ? 0 : this.externalId.hashCode()));
        result = ((PRIME * result) + ((this.creditLimit == null) ? 0 : this.creditLimit.hashCode()));
        result = ((PRIME * result) + ((this.externalCreditLimit == null) ? 0 : this.externalCreditLimit.hashCode()));
        result = ((PRIME * result) + ((this.creditLimitCurrency == null) ? 0 : this.creditLimitCurrency.hashCode()));
        result = ((PRIME * result) + ((this.creditLimitCurrencyRefId == null) ? 0 : this.creditLimitCurrencyRefId
                .hashCode()));
        result = ((PRIME * result) + ((this.externalCreditLimitCurrency == null) ? 0 : this.externalCreditLimitCurrency
                .hashCode()));
        result = ((PRIME * result) + ((this.externalCreditLimitCurrencyRefId == null) ? 0
                : this.externalCreditLimitCurrencyRefId.hashCode()));
        result = ((PRIME * result) + ((this.termsofpayment == null) ? 0 : this.termsofpayment.hashCode()));
        result = ((PRIME * result) + ((this.termsofpaymentRefId == null) ? 0 : this.termsofpaymentRefId.hashCode()));
        return result;
    }

    @Override
    public CreditReport cloneObject() {
        CreditReport clone = new CreditReport();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getCreditWorthiness.
     *
     * @return the FunctionalIdentifier.
     */
    public FunctionalIdentifier getCreditWorthiness() {
        return this.creditWorthiness;
    }

    /**
     * Missing description at method setCreditWorthiness.
     *
     * @param creditWorthiness the FunctionalIdentifier.
     */
    public void setCreditWorthiness(FunctionalIdentifier creditWorthiness) {
        this.creditWorthiness = creditWorthiness;
    }

    /**
     * Missing description at method setCreditWorthiness.
     *
     * @param creditWorthiness the String.
     */
    public void setCreditWorthiness(String creditWorthiness) {
        if ((this.creditWorthiness == null)) {
            if ((creditWorthiness == null)) {
                return;
            }
            this.creditWorthiness = new FunctionalIdentifier();
        }
        this.creditWorthiness.setValue(creditWorthiness);
    }

    /**
     * Missing description at method getExternalId.
     *
     * @return the FunctionalIdentifier.
     */
    public FunctionalIdentifier getExternalId() {
        return this.externalId;
    }

    /**
     * Missing description at method setExternalId.
     *
     * @param externalId the FunctionalIdentifier.
     */
    public void setExternalId(FunctionalIdentifier externalId) {
        this.externalId = externalId;
    }

    /**
     * Missing description at method setExternalId.
     *
     * @param externalId the String.
     */
    public void setExternalId(String externalId) {
        if ((this.externalId == null)) {
            if ((externalId == null)) {
                return;
            }
            this.externalId = new FunctionalIdentifier();
        }
        this.externalId.setValue(externalId);
    }

    /**
     * Missing description at method getCreditLimit.
     *
     * @return the Amount.
     */
    public Amount getCreditLimit() {
        return this.creditLimit;
    }

    /**
     * Missing description at method setCreditLimit.
     *
     * @param creditLimit the Amount.
     */
    public void setCreditLimit(Amount creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * Missing description at method setCreditLimit.
     *
     * @param creditLimit the java.math.BigDecimal.
     */
    public void setCreditLimit(java.math.BigDecimal creditLimit) {
        if ((this.creditLimit == null)) {
            if ((creditLimit == null)) {
                return;
            }
            this.creditLimit = new Amount();
        }
        this.creditLimit.setValue(creditLimit);
    }

    /**
     * Missing description at method getExternalCreditLimit.
     *
     * @return the Amount.
     */
    public Amount getExternalCreditLimit() {
        return this.externalCreditLimit;
    }

    /**
     * Missing description at method setExternalCreditLimit.
     *
     * @param externalCreditLimit the Amount.
     */
    public void setExternalCreditLimit(Amount externalCreditLimit) {
        this.externalCreditLimit = externalCreditLimit;
    }

    /**
     * Missing description at method setExternalCreditLimit.
     *
     * @param externalCreditLimit the java.math.BigDecimal.
     */
    public void setExternalCreditLimit(java.math.BigDecimal externalCreditLimit) {
        if ((this.externalCreditLimit == null)) {
            if ((externalCreditLimit == null)) {
                return;
            }
            this.externalCreditLimit = new Amount();
        }
        this.externalCreditLimit.setValue(externalCreditLimit);
    }

    /**
     * Missing description at method setCreditLimitCurrency.
     *
     * @param creditLimitCurrency the Code.
     */
    public void setCreditLimitCurrency(Code creditLimitCurrency) {
        this.creditLimitCurrency = creditLimitCurrency;
        if ((creditLimitCurrency != null)) {
            this.setCreditLimitCurrencyRefId(creditLimitCurrency.getId());
        } else {
            this.setCreditLimitCurrencyRefId(null);
        }
    }

    /**
     * Missing description at method getCreditLimitCurrency.
     *
     * @return the Code.
     */
    public Code getCreditLimitCurrency() {
        return this.creditLimitCurrency;
    }

    /**
     * Getter for the CreditLimitCurrencyRefId.
     *
     * @return the Long.
     */
    public Long getCreditLimitCurrencyRefId() {
        return this.creditLimitCurrencyRefId;
    }

    /**
     * Setter for the CreditLimitCurrencyRefId.
     *
     * @param creditLimitCurrencyRefId the Long.
     */
    public void setCreditLimitCurrencyRefId(Long creditLimitCurrencyRefId) {
        this.creditLimitCurrencyRefId = creditLimitCurrencyRefId;
    }

    /**
     * Missing description at method setExternalCreditLimitCurrency.
     *
     * @param externalCreditLimitCurrency the Code.
     */
    public void setExternalCreditLimitCurrency(Code externalCreditLimitCurrency) {
        this.externalCreditLimitCurrency = externalCreditLimitCurrency;
        if ((externalCreditLimitCurrency != null)) {
            this.setExternalCreditLimitCurrencyRefId(externalCreditLimitCurrency.getId());
        } else {
            this.setExternalCreditLimitCurrencyRefId(null);
        }
    }

    /**
     * Missing description at method getExternalCreditLimitCurrency.
     *
     * @return the Code.
     */
    public Code getExternalCreditLimitCurrency() {
        return this.externalCreditLimitCurrency;
    }

    /**
     * Getter for the ExternalCreditLimitCurrencyRefId.
     *
     * @return the Long.
     */
    public Long getExternalCreditLimitCurrencyRefId() {
        return this.externalCreditLimitCurrencyRefId;
    }

    /**
     * Setter for the ExternalCreditLimitCurrencyRefId.
     *
     * @param externalCreditLimitCurrencyRefId the Long.
     */
    public void setExternalCreditLimitCurrencyRefId(Long externalCreditLimitCurrencyRefId) {
        this.externalCreditLimitCurrencyRefId = externalCreditLimitCurrencyRefId;
    }

    /**
     * Missing description at method setTermsofpayment.
     *
     * @param termsofpayment the Code.
     */
    public void setTermsofpayment(Code termsofpayment) {
        this.termsofpayment = termsofpayment;
        if ((termsofpayment != null)) {
            this.setTermsofpaymentRefId(termsofpayment.getId());
        } else {
            this.setTermsofpaymentRefId(null);
        }
    }

    /**
     * Missing description at method getTermsofpayment.
     *
     * @return the Code.
     */
    public Code getTermsofpayment() {
        return this.termsofpayment;
    }

    /**
     * Getter for the TermsofpaymentRefId.
     *
     * @return the Long.
     */
    public Long getTermsofpaymentRefId() {
        return this.termsofpaymentRefId;
    }

    /**
     * Setter for the TermsofpaymentRefId.
     *
     * @param termsofpaymentRefId the Long.
     */
    public void setTermsofpaymentRefId(Long termsofpaymentRefId) {
        this.termsofpaymentRefId = termsofpaymentRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(CreditReport.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(CreditReport.class).getAllProperties();
    }

    /**
     * Getter for the CreditLimitCurrencyCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getCreditLimitCurrencyCodePath() {
        return new CodePath(CREDITLIMITCURRENCY_CODEPATH);
    }

    /**
     * Getter for the ExternalCreditLimitCurrencyCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getExternalCreditLimitCurrencyCodePath() {
        return new CodePath(EXTERNALCREDITLIMITCURRENCY_CODEPATH);
    }

    /**
     * Getter for the TermsofpaymentCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getTermsofpaymentCodePath() {
        return new CodePath(TERMSOFPAYMENT_CODEPATH);
    }
}
