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
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.Number;
import org.nabucco.framework.base.facade.datatype.date.Date;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * OrganizationStatistic
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-01-10
 */
public class OrganizationStatistic extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;",
            "l0,n;u0,n;m0,1;", "l0,255;u0,n;m0,1;", "l0,n;u0,n;m0,1;" };

    public static final String EMPLOYEENUMBER = "employeeNumber";

    public static final String LEASEDEMPLOYEENUMBER = "leasedEmployeeNumber";

    public static final String FOUNDATIONDATE = "foundationDate";

    public static final String LEASEDEMPLOYEEEXPERIENCE = "leasedEmployeeExperience";

    public static final String COLLECTIVEAGGREEMENT = "collectiveAggreement";

    public static final String COLLECTIVEBARGAININGCOVERAGE = "collectiveBargainingCoverage";

    private Number employeeNumber;

    private Number leasedEmployeeNumber;

    private Date foundationDate;

    private Flag leasedEmployeeExperience;

    private Name collectiveAggreement;

    private Flag collectiveBargainingCoverage;

    /** Constructs a new OrganizationStatistic instance. */
    public OrganizationStatistic() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the OrganizationStatistic.
     */
    protected void cloneObject(OrganizationStatistic clone) {
        super.cloneObject(clone);
        if ((this.getEmployeeNumber() != null)) {
            clone.setEmployeeNumber(this.getEmployeeNumber().cloneObject());
        }
        if ((this.getLeasedEmployeeNumber() != null)) {
            clone.setLeasedEmployeeNumber(this.getLeasedEmployeeNumber().cloneObject());
        }
        if ((this.getFoundationDate() != null)) {
            clone.setFoundationDate(this.getFoundationDate().cloneObject());
        }
        if ((this.getLeasedEmployeeExperience() != null)) {
            clone.setLeasedEmployeeExperience(this.getLeasedEmployeeExperience().cloneObject());
        }
        if ((this.getCollectiveAggreement() != null)) {
            clone.setCollectiveAggreement(this.getCollectiveAggreement().cloneObject());
        }
        if ((this.getCollectiveBargainingCoverage() != null)) {
            clone.setCollectiveBargainingCoverage(this.getCollectiveBargainingCoverage().cloneObject());
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
        propertyMap.put(EMPLOYEENUMBER, PropertyDescriptorSupport.createBasetype(EMPLOYEENUMBER, Number.class, 3,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(LEASEDEMPLOYEENUMBER, PropertyDescriptorSupport.createBasetype(LEASEDEMPLOYEENUMBER,
                Number.class, 4, PROPERTY_CONSTRAINTS[1], false));
        propertyMap
                .put(FOUNDATIONDATE, PropertyDescriptorSupport.createBasetype(FOUNDATIONDATE, Date.class, 5,
                        PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(LEASEDEMPLOYEEEXPERIENCE, PropertyDescriptorSupport.createBasetype(LEASEDEMPLOYEEEXPERIENCE,
                Flag.class, 6, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(COLLECTIVEAGGREEMENT, PropertyDescriptorSupport.createBasetype(COLLECTIVEAGGREEMENT,
                Name.class, 7, PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(COLLECTIVEBARGAININGCOVERAGE, PropertyDescriptorSupport.createBasetype(
                COLLECTIVEBARGAININGCOVERAGE, Flag.class, 8, PROPERTY_CONSTRAINTS[5], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(OrganizationStatistic.getPropertyDescriptor(EMPLOYEENUMBER),
                this.employeeNumber, null));
        properties.add(super.createProperty(OrganizationStatistic.getPropertyDescriptor(LEASEDEMPLOYEENUMBER),
                this.leasedEmployeeNumber, null));
        properties.add(super.createProperty(OrganizationStatistic.getPropertyDescriptor(FOUNDATIONDATE),
                this.foundationDate, null));
        properties.add(super.createProperty(OrganizationStatistic.getPropertyDescriptor(LEASEDEMPLOYEEEXPERIENCE),
                this.leasedEmployeeExperience, null));
        properties.add(super.createProperty(OrganizationStatistic.getPropertyDescriptor(COLLECTIVEAGGREEMENT),
                this.collectiveAggreement, null));
        properties.add(super.createProperty(OrganizationStatistic.getPropertyDescriptor(COLLECTIVEBARGAININGCOVERAGE),
                this.collectiveBargainingCoverage, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(EMPLOYEENUMBER) && (property.getType() == Number.class))) {
            this.setEmployeeNumber(((Number) property.getInstance()));
            return true;
        } else if ((property.getName().equals(LEASEDEMPLOYEENUMBER) && (property.getType() == Number.class))) {
            this.setLeasedEmployeeNumber(((Number) property.getInstance()));
            return true;
        } else if ((property.getName().equals(FOUNDATIONDATE) && (property.getType() == Date.class))) {
            this.setFoundationDate(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(LEASEDEMPLOYEEEXPERIENCE) && (property.getType() == Flag.class))) {
            this.setLeasedEmployeeExperience(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(COLLECTIVEAGGREEMENT) && (property.getType() == Name.class))) {
            this.setCollectiveAggreement(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(COLLECTIVEBARGAININGCOVERAGE) && (property.getType() == Flag.class))) {
            this.setCollectiveBargainingCoverage(((Flag) property.getInstance()));
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
        final OrganizationStatistic other = ((OrganizationStatistic) obj);
        if ((this.employeeNumber == null)) {
            if ((other.employeeNumber != null))
                return false;
        } else if ((!this.employeeNumber.equals(other.employeeNumber)))
            return false;
        if ((this.leasedEmployeeNumber == null)) {
            if ((other.leasedEmployeeNumber != null))
                return false;
        } else if ((!this.leasedEmployeeNumber.equals(other.leasedEmployeeNumber)))
            return false;
        if ((this.foundationDate == null)) {
            if ((other.foundationDate != null))
                return false;
        } else if ((!this.foundationDate.equals(other.foundationDate)))
            return false;
        if ((this.leasedEmployeeExperience == null)) {
            if ((other.leasedEmployeeExperience != null))
                return false;
        } else if ((!this.leasedEmployeeExperience.equals(other.leasedEmployeeExperience)))
            return false;
        if ((this.collectiveAggreement == null)) {
            if ((other.collectiveAggreement != null))
                return false;
        } else if ((!this.collectiveAggreement.equals(other.collectiveAggreement)))
            return false;
        if ((this.collectiveBargainingCoverage == null)) {
            if ((other.collectiveBargainingCoverage != null))
                return false;
        } else if ((!this.collectiveBargainingCoverage.equals(other.collectiveBargainingCoverage)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.employeeNumber == null) ? 0 : this.employeeNumber.hashCode()));
        result = ((PRIME * result) + ((this.leasedEmployeeNumber == null) ? 0 : this.leasedEmployeeNumber.hashCode()));
        result = ((PRIME * result) + ((this.foundationDate == null) ? 0 : this.foundationDate.hashCode()));
        result = ((PRIME * result) + ((this.leasedEmployeeExperience == null) ? 0 : this.leasedEmployeeExperience
                .hashCode()));
        result = ((PRIME * result) + ((this.collectiveAggreement == null) ? 0 : this.collectiveAggreement.hashCode()));
        result = ((PRIME * result) + ((this.collectiveBargainingCoverage == null) ? 0
                : this.collectiveBargainingCoverage.hashCode()));
        return result;
    }

    @Override
    public OrganizationStatistic cloneObject() {
        OrganizationStatistic clone = new OrganizationStatistic();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getEmployeeNumber.
     *
     * @return the Number.
     */
    public Number getEmployeeNumber() {
        return this.employeeNumber;
    }

    /**
     * Missing description at method setEmployeeNumber.
     *
     * @param employeeNumber the Number.
     */
    public void setEmployeeNumber(Number employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * Missing description at method setEmployeeNumber.
     *
     * @param employeeNumber the Integer.
     */
    public void setEmployeeNumber(Integer employeeNumber) {
        if ((this.employeeNumber == null)) {
            if ((employeeNumber == null)) {
                return;
            }
            this.employeeNumber = new Number();
        }
        this.employeeNumber.setValue(employeeNumber);
    }

    /**
     * Missing description at method getLeasedEmployeeNumber.
     *
     * @return the Number.
     */
    public Number getLeasedEmployeeNumber() {
        return this.leasedEmployeeNumber;
    }

    /**
     * Missing description at method setLeasedEmployeeNumber.
     *
     * @param leasedEmployeeNumber the Number.
     */
    public void setLeasedEmployeeNumber(Number leasedEmployeeNumber) {
        this.leasedEmployeeNumber = leasedEmployeeNumber;
    }

    /**
     * Missing description at method setLeasedEmployeeNumber.
     *
     * @param leasedEmployeeNumber the Integer.
     */
    public void setLeasedEmployeeNumber(Integer leasedEmployeeNumber) {
        if ((this.leasedEmployeeNumber == null)) {
            if ((leasedEmployeeNumber == null)) {
                return;
            }
            this.leasedEmployeeNumber = new Number();
        }
        this.leasedEmployeeNumber.setValue(leasedEmployeeNumber);
    }

    /**
     * Missing description at method getFoundationDate.
     *
     * @return the Date.
     */
    public Date getFoundationDate() {
        return this.foundationDate;
    }

    /**
     * Missing description at method setFoundationDate.
     *
     * @param foundationDate the Date.
     */
    public void setFoundationDate(Date foundationDate) {
        this.foundationDate = foundationDate;
    }

    /**
     * Missing description at method setFoundationDate.
     *
     * @param foundationDate the java.util.Date.
     */
    public void setFoundationDate(java.util.Date foundationDate) {
        if ((this.foundationDate == null)) {
            if ((foundationDate == null)) {
                return;
            }
            this.foundationDate = new Date();
        }
        this.foundationDate.setValue(foundationDate);
    }

    /**
     * Missing description at method getLeasedEmployeeExperience.
     *
     * @return the Flag.
     */
    public Flag getLeasedEmployeeExperience() {
        return this.leasedEmployeeExperience;
    }

    /**
     * Missing description at method setLeasedEmployeeExperience.
     *
     * @param leasedEmployeeExperience the Flag.
     */
    public void setLeasedEmployeeExperience(Flag leasedEmployeeExperience) {
        this.leasedEmployeeExperience = leasedEmployeeExperience;
    }

    /**
     * Missing description at method setLeasedEmployeeExperience.
     *
     * @param leasedEmployeeExperience the Boolean.
     */
    public void setLeasedEmployeeExperience(Boolean leasedEmployeeExperience) {
        if ((this.leasedEmployeeExperience == null)) {
            if ((leasedEmployeeExperience == null)) {
                return;
            }
            this.leasedEmployeeExperience = new Flag();
        }
        this.leasedEmployeeExperience.setValue(leasedEmployeeExperience);
    }

    /**
     * Missing description at method getCollectiveAggreement.
     *
     * @return the Name.
     */
    public Name getCollectiveAggreement() {
        return this.collectiveAggreement;
    }

    /**
     * Missing description at method setCollectiveAggreement.
     *
     * @param collectiveAggreement the Name.
     */
    public void setCollectiveAggreement(Name collectiveAggreement) {
        this.collectiveAggreement = collectiveAggreement;
    }

    /**
     * Missing description at method setCollectiveAggreement.
     *
     * @param collectiveAggreement the String.
     */
    public void setCollectiveAggreement(String collectiveAggreement) {
        if ((this.collectiveAggreement == null)) {
            if ((collectiveAggreement == null)) {
                return;
            }
            this.collectiveAggreement = new Name();
        }
        this.collectiveAggreement.setValue(collectiveAggreement);
    }

    /**
     * Missing description at method getCollectiveBargainingCoverage.
     *
     * @return the Flag.
     */
    public Flag getCollectiveBargainingCoverage() {
        return this.collectiveBargainingCoverage;
    }

    /**
     * Missing description at method setCollectiveBargainingCoverage.
     *
     * @param collectiveBargainingCoverage the Flag.
     */
    public void setCollectiveBargainingCoverage(Flag collectiveBargainingCoverage) {
        this.collectiveBargainingCoverage = collectiveBargainingCoverage;
    }

    /**
     * Missing description at method setCollectiveBargainingCoverage.
     *
     * @param collectiveBargainingCoverage the Boolean.
     */
    public void setCollectiveBargainingCoverage(Boolean collectiveBargainingCoverage) {
        if ((this.collectiveBargainingCoverage == null)) {
            if ((collectiveBargainingCoverage == null)) {
                return;
            }
            this.collectiveBargainingCoverage = new Flag();
        }
        this.collectiveBargainingCoverage.setValue(collectiveBargainingCoverage);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(OrganizationStatistic.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(OrganizationStatistic.class).getAllProperties();
    }
}
