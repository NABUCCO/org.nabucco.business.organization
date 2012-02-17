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
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.date.Time;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * WorkingTime
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-01-10
 */
public class WorkingTime extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;",
            "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;",
            "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;",
            "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;" };

    public static final String MONDAYFROM = "mondayFrom";

    public static final String MONDAYTILL = "mondayTill";

    public static final String TUESDAYFROM = "tuesdayFrom";

    public static final String TUESDAYTILL = "tuesdayTill";

    public static final String WEDNESDAYFROM = "wednesdayFrom";

    public static final String WEDNESDAYTILL = "wednesdayTill";

    public static final String THURSDAYFROM = "thursdayFrom";

    public static final String THURSDAYTILL = "thursdayTill";

    public static final String FRIDAYFROM = "fridayFrom";

    public static final String FRIDAYTILL = "fridayTill";

    public static final String SATURDAYFROM = "saturdayFrom";

    public static final String SATURDAYTILL = "saturdayTill";

    public static final String SUNDAYFROM = "sundayFrom";

    public static final String SUNDAYTILL = "sundayTill";

    public static final String OVERALL = "overAll";

    private Time mondayFrom;

    private Time mondayTill;

    private Time tuesdayFrom;

    private Time tuesdayTill;

    private Time wednesdayFrom;

    private Time wednesdayTill;

    private Time thursdayFrom;

    private Time thursdayTill;

    private Time fridayFrom;

    private Time fridayTill;

    private Time saturdayFrom;

    private Time saturdayTill;

    private Time sundayFrom;

    private Time sundayTill;

    private Amount overAll;

    /** Constructs a new WorkingTime instance. */
    public WorkingTime() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the WorkingTime.
     */
    protected void cloneObject(WorkingTime clone) {
        super.cloneObject(clone);
        if ((this.getMondayFrom() != null)) {
            clone.setMondayFrom(this.getMondayFrom().cloneObject());
        }
        if ((this.getMondayTill() != null)) {
            clone.setMondayTill(this.getMondayTill().cloneObject());
        }
        if ((this.getTuesdayFrom() != null)) {
            clone.setTuesdayFrom(this.getTuesdayFrom().cloneObject());
        }
        if ((this.getTuesdayTill() != null)) {
            clone.setTuesdayTill(this.getTuesdayTill().cloneObject());
        }
        if ((this.getWednesdayFrom() != null)) {
            clone.setWednesdayFrom(this.getWednesdayFrom().cloneObject());
        }
        if ((this.getWednesdayTill() != null)) {
            clone.setWednesdayTill(this.getWednesdayTill().cloneObject());
        }
        if ((this.getThursdayFrom() != null)) {
            clone.setThursdayFrom(this.getThursdayFrom().cloneObject());
        }
        if ((this.getThursdayTill() != null)) {
            clone.setThursdayTill(this.getThursdayTill().cloneObject());
        }
        if ((this.getFridayFrom() != null)) {
            clone.setFridayFrom(this.getFridayFrom().cloneObject());
        }
        if ((this.getFridayTill() != null)) {
            clone.setFridayTill(this.getFridayTill().cloneObject());
        }
        if ((this.getSaturdayFrom() != null)) {
            clone.setSaturdayFrom(this.getSaturdayFrom().cloneObject());
        }
        if ((this.getSaturdayTill() != null)) {
            clone.setSaturdayTill(this.getSaturdayTill().cloneObject());
        }
        if ((this.getSundayFrom() != null)) {
            clone.setSundayFrom(this.getSundayFrom().cloneObject());
        }
        if ((this.getSundayTill() != null)) {
            clone.setSundayTill(this.getSundayTill().cloneObject());
        }
        if ((this.getOverAll() != null)) {
            clone.setOverAll(this.getOverAll().cloneObject());
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
        propertyMap.put(MONDAYFROM,
                PropertyDescriptorSupport.createBasetype(MONDAYFROM, Time.class, 3, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(MONDAYTILL,
                PropertyDescriptorSupport.createBasetype(MONDAYTILL, Time.class, 4, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(TUESDAYFROM,
                PropertyDescriptorSupport.createBasetype(TUESDAYFROM, Time.class, 5, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(TUESDAYTILL,
                PropertyDescriptorSupport.createBasetype(TUESDAYTILL, Time.class, 6, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(WEDNESDAYFROM,
                PropertyDescriptorSupport.createBasetype(WEDNESDAYFROM, Time.class, 7, PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(WEDNESDAYTILL,
                PropertyDescriptorSupport.createBasetype(WEDNESDAYTILL, Time.class, 8, PROPERTY_CONSTRAINTS[5], false));
        propertyMap.put(THURSDAYFROM,
                PropertyDescriptorSupport.createBasetype(THURSDAYFROM, Time.class, 9, PROPERTY_CONSTRAINTS[6], false));
        propertyMap.put(THURSDAYTILL,
                PropertyDescriptorSupport.createBasetype(THURSDAYTILL, Time.class, 10, PROPERTY_CONSTRAINTS[7], false));
        propertyMap.put(FRIDAYFROM,
                PropertyDescriptorSupport.createBasetype(FRIDAYFROM, Time.class, 11, PROPERTY_CONSTRAINTS[8], false));
        propertyMap.put(FRIDAYTILL,
                PropertyDescriptorSupport.createBasetype(FRIDAYTILL, Time.class, 12, PROPERTY_CONSTRAINTS[9], false));
        propertyMap
                .put(SATURDAYFROM, PropertyDescriptorSupport.createBasetype(SATURDAYFROM, Time.class, 13,
                        PROPERTY_CONSTRAINTS[10], false));
        propertyMap
                .put(SATURDAYTILL, PropertyDescriptorSupport.createBasetype(SATURDAYTILL, Time.class, 14,
                        PROPERTY_CONSTRAINTS[11], false));
        propertyMap.put(SUNDAYFROM,
                PropertyDescriptorSupport.createBasetype(SUNDAYFROM, Time.class, 15, PROPERTY_CONSTRAINTS[12], false));
        propertyMap.put(SUNDAYTILL,
                PropertyDescriptorSupport.createBasetype(SUNDAYTILL, Time.class, 16, PROPERTY_CONSTRAINTS[13], false));
        propertyMap.put(OVERALL,
                PropertyDescriptorSupport.createBasetype(OVERALL, Amount.class, 17, PROPERTY_CONSTRAINTS[14], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(WorkingTime.getPropertyDescriptor(MONDAYFROM), this.mondayFrom, null));
        properties.add(super.createProperty(WorkingTime.getPropertyDescriptor(MONDAYTILL), this.mondayTill, null));
        properties.add(super.createProperty(WorkingTime.getPropertyDescriptor(TUESDAYFROM), this.tuesdayFrom, null));
        properties.add(super.createProperty(WorkingTime.getPropertyDescriptor(TUESDAYTILL), this.tuesdayTill, null));
        properties
                .add(super.createProperty(WorkingTime.getPropertyDescriptor(WEDNESDAYFROM), this.wednesdayFrom, null));
        properties
                .add(super.createProperty(WorkingTime.getPropertyDescriptor(WEDNESDAYTILL), this.wednesdayTill, null));
        properties.add(super.createProperty(WorkingTime.getPropertyDescriptor(THURSDAYFROM), this.thursdayFrom, null));
        properties.add(super.createProperty(WorkingTime.getPropertyDescriptor(THURSDAYTILL), this.thursdayTill, null));
        properties.add(super.createProperty(WorkingTime.getPropertyDescriptor(FRIDAYFROM), this.fridayFrom, null));
        properties.add(super.createProperty(WorkingTime.getPropertyDescriptor(FRIDAYTILL), this.fridayTill, null));
        properties.add(super.createProperty(WorkingTime.getPropertyDescriptor(SATURDAYFROM), this.saturdayFrom, null));
        properties.add(super.createProperty(WorkingTime.getPropertyDescriptor(SATURDAYTILL), this.saturdayTill, null));
        properties.add(super.createProperty(WorkingTime.getPropertyDescriptor(SUNDAYFROM), this.sundayFrom, null));
        properties.add(super.createProperty(WorkingTime.getPropertyDescriptor(SUNDAYTILL), this.sundayTill, null));
        properties.add(super.createProperty(WorkingTime.getPropertyDescriptor(OVERALL), this.overAll, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(MONDAYFROM) && (property.getType() == Time.class))) {
            this.setMondayFrom(((Time) property.getInstance()));
            return true;
        } else if ((property.getName().equals(MONDAYTILL) && (property.getType() == Time.class))) {
            this.setMondayTill(((Time) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TUESDAYFROM) && (property.getType() == Time.class))) {
            this.setTuesdayFrom(((Time) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TUESDAYTILL) && (property.getType() == Time.class))) {
            this.setTuesdayTill(((Time) property.getInstance()));
            return true;
        } else if ((property.getName().equals(WEDNESDAYFROM) && (property.getType() == Time.class))) {
            this.setWednesdayFrom(((Time) property.getInstance()));
            return true;
        } else if ((property.getName().equals(WEDNESDAYTILL) && (property.getType() == Time.class))) {
            this.setWednesdayTill(((Time) property.getInstance()));
            return true;
        } else if ((property.getName().equals(THURSDAYFROM) && (property.getType() == Time.class))) {
            this.setThursdayFrom(((Time) property.getInstance()));
            return true;
        } else if ((property.getName().equals(THURSDAYTILL) && (property.getType() == Time.class))) {
            this.setThursdayTill(((Time) property.getInstance()));
            return true;
        } else if ((property.getName().equals(FRIDAYFROM) && (property.getType() == Time.class))) {
            this.setFridayFrom(((Time) property.getInstance()));
            return true;
        } else if ((property.getName().equals(FRIDAYTILL) && (property.getType() == Time.class))) {
            this.setFridayTill(((Time) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SATURDAYFROM) && (property.getType() == Time.class))) {
            this.setSaturdayFrom(((Time) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SATURDAYTILL) && (property.getType() == Time.class))) {
            this.setSaturdayTill(((Time) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SUNDAYFROM) && (property.getType() == Time.class))) {
            this.setSundayFrom(((Time) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SUNDAYTILL) && (property.getType() == Time.class))) {
            this.setSundayTill(((Time) property.getInstance()));
            return true;
        } else if ((property.getName().equals(OVERALL) && (property.getType() == Amount.class))) {
            this.setOverAll(((Amount) property.getInstance()));
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
        final WorkingTime other = ((WorkingTime) obj);
        if ((this.mondayFrom == null)) {
            if ((other.mondayFrom != null))
                return false;
        } else if ((!this.mondayFrom.equals(other.mondayFrom)))
            return false;
        if ((this.mondayTill == null)) {
            if ((other.mondayTill != null))
                return false;
        } else if ((!this.mondayTill.equals(other.mondayTill)))
            return false;
        if ((this.tuesdayFrom == null)) {
            if ((other.tuesdayFrom != null))
                return false;
        } else if ((!this.tuesdayFrom.equals(other.tuesdayFrom)))
            return false;
        if ((this.tuesdayTill == null)) {
            if ((other.tuesdayTill != null))
                return false;
        } else if ((!this.tuesdayTill.equals(other.tuesdayTill)))
            return false;
        if ((this.wednesdayFrom == null)) {
            if ((other.wednesdayFrom != null))
                return false;
        } else if ((!this.wednesdayFrom.equals(other.wednesdayFrom)))
            return false;
        if ((this.wednesdayTill == null)) {
            if ((other.wednesdayTill != null))
                return false;
        } else if ((!this.wednesdayTill.equals(other.wednesdayTill)))
            return false;
        if ((this.thursdayFrom == null)) {
            if ((other.thursdayFrom != null))
                return false;
        } else if ((!this.thursdayFrom.equals(other.thursdayFrom)))
            return false;
        if ((this.thursdayTill == null)) {
            if ((other.thursdayTill != null))
                return false;
        } else if ((!this.thursdayTill.equals(other.thursdayTill)))
            return false;
        if ((this.fridayFrom == null)) {
            if ((other.fridayFrom != null))
                return false;
        } else if ((!this.fridayFrom.equals(other.fridayFrom)))
            return false;
        if ((this.fridayTill == null)) {
            if ((other.fridayTill != null))
                return false;
        } else if ((!this.fridayTill.equals(other.fridayTill)))
            return false;
        if ((this.saturdayFrom == null)) {
            if ((other.saturdayFrom != null))
                return false;
        } else if ((!this.saturdayFrom.equals(other.saturdayFrom)))
            return false;
        if ((this.saturdayTill == null)) {
            if ((other.saturdayTill != null))
                return false;
        } else if ((!this.saturdayTill.equals(other.saturdayTill)))
            return false;
        if ((this.sundayFrom == null)) {
            if ((other.sundayFrom != null))
                return false;
        } else if ((!this.sundayFrom.equals(other.sundayFrom)))
            return false;
        if ((this.sundayTill == null)) {
            if ((other.sundayTill != null))
                return false;
        } else if ((!this.sundayTill.equals(other.sundayTill)))
            return false;
        if ((this.overAll == null)) {
            if ((other.overAll != null))
                return false;
        } else if ((!this.overAll.equals(other.overAll)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.mondayFrom == null) ? 0 : this.mondayFrom.hashCode()));
        result = ((PRIME * result) + ((this.mondayTill == null) ? 0 : this.mondayTill.hashCode()));
        result = ((PRIME * result) + ((this.tuesdayFrom == null) ? 0 : this.tuesdayFrom.hashCode()));
        result = ((PRIME * result) + ((this.tuesdayTill == null) ? 0 : this.tuesdayTill.hashCode()));
        result = ((PRIME * result) + ((this.wednesdayFrom == null) ? 0 : this.wednesdayFrom.hashCode()));
        result = ((PRIME * result) + ((this.wednesdayTill == null) ? 0 : this.wednesdayTill.hashCode()));
        result = ((PRIME * result) + ((this.thursdayFrom == null) ? 0 : this.thursdayFrom.hashCode()));
        result = ((PRIME * result) + ((this.thursdayTill == null) ? 0 : this.thursdayTill.hashCode()));
        result = ((PRIME * result) + ((this.fridayFrom == null) ? 0 : this.fridayFrom.hashCode()));
        result = ((PRIME * result) + ((this.fridayTill == null) ? 0 : this.fridayTill.hashCode()));
        result = ((PRIME * result) + ((this.saturdayFrom == null) ? 0 : this.saturdayFrom.hashCode()));
        result = ((PRIME * result) + ((this.saturdayTill == null) ? 0 : this.saturdayTill.hashCode()));
        result = ((PRIME * result) + ((this.sundayFrom == null) ? 0 : this.sundayFrom.hashCode()));
        result = ((PRIME * result) + ((this.sundayTill == null) ? 0 : this.sundayTill.hashCode()));
        result = ((PRIME * result) + ((this.overAll == null) ? 0 : this.overAll.hashCode()));
        return result;
    }

    @Override
    public WorkingTime cloneObject() {
        WorkingTime clone = new WorkingTime();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getMondayFrom.
     *
     * @return the Time.
     */
    public Time getMondayFrom() {
        return this.mondayFrom;
    }

    /**
     * Missing description at method setMondayFrom.
     *
     * @param mondayFrom the Time.
     */
    public void setMondayFrom(Time mondayFrom) {
        this.mondayFrom = mondayFrom;
    }

    /**
     * Missing description at method setMondayFrom.
     *
     * @param mondayFrom the java.util.Date.
     */
    public void setMondayFrom(java.util.Date mondayFrom) {
        if ((this.mondayFrom == null)) {
            if ((mondayFrom == null)) {
                return;
            }
            this.mondayFrom = new Time();
        }
        this.mondayFrom.setValue(mondayFrom);
    }

    /**
     * Missing description at method getMondayTill.
     *
     * @return the Time.
     */
    public Time getMondayTill() {
        return this.mondayTill;
    }

    /**
     * Missing description at method setMondayTill.
     *
     * @param mondayTill the Time.
     */
    public void setMondayTill(Time mondayTill) {
        this.mondayTill = mondayTill;
    }

    /**
     * Missing description at method setMondayTill.
     *
     * @param mondayTill the java.util.Date.
     */
    public void setMondayTill(java.util.Date mondayTill) {
        if ((this.mondayTill == null)) {
            if ((mondayTill == null)) {
                return;
            }
            this.mondayTill = new Time();
        }
        this.mondayTill.setValue(mondayTill);
    }

    /**
     * Missing description at method getTuesdayFrom.
     *
     * @return the Time.
     */
    public Time getTuesdayFrom() {
        return this.tuesdayFrom;
    }

    /**
     * Missing description at method setTuesdayFrom.
     *
     * @param tuesdayFrom the Time.
     */
    public void setTuesdayFrom(Time tuesdayFrom) {
        this.tuesdayFrom = tuesdayFrom;
    }

    /**
     * Missing description at method setTuesdayFrom.
     *
     * @param tuesdayFrom the java.util.Date.
     */
    public void setTuesdayFrom(java.util.Date tuesdayFrom) {
        if ((this.tuesdayFrom == null)) {
            if ((tuesdayFrom == null)) {
                return;
            }
            this.tuesdayFrom = new Time();
        }
        this.tuesdayFrom.setValue(tuesdayFrom);
    }

    /**
     * Missing description at method getTuesdayTill.
     *
     * @return the Time.
     */
    public Time getTuesdayTill() {
        return this.tuesdayTill;
    }

    /**
     * Missing description at method setTuesdayTill.
     *
     * @param tuesdayTill the Time.
     */
    public void setTuesdayTill(Time tuesdayTill) {
        this.tuesdayTill = tuesdayTill;
    }

    /**
     * Missing description at method setTuesdayTill.
     *
     * @param tuesdayTill the java.util.Date.
     */
    public void setTuesdayTill(java.util.Date tuesdayTill) {
        if ((this.tuesdayTill == null)) {
            if ((tuesdayTill == null)) {
                return;
            }
            this.tuesdayTill = new Time();
        }
        this.tuesdayTill.setValue(tuesdayTill);
    }

    /**
     * Missing description at method getWednesdayFrom.
     *
     * @return the Time.
     */
    public Time getWednesdayFrom() {
        return this.wednesdayFrom;
    }

    /**
     * Missing description at method setWednesdayFrom.
     *
     * @param wednesdayFrom the Time.
     */
    public void setWednesdayFrom(Time wednesdayFrom) {
        this.wednesdayFrom = wednesdayFrom;
    }

    /**
     * Missing description at method setWednesdayFrom.
     *
     * @param wednesdayFrom the java.util.Date.
     */
    public void setWednesdayFrom(java.util.Date wednesdayFrom) {
        if ((this.wednesdayFrom == null)) {
            if ((wednesdayFrom == null)) {
                return;
            }
            this.wednesdayFrom = new Time();
        }
        this.wednesdayFrom.setValue(wednesdayFrom);
    }

    /**
     * Missing description at method getWednesdayTill.
     *
     * @return the Time.
     */
    public Time getWednesdayTill() {
        return this.wednesdayTill;
    }

    /**
     * Missing description at method setWednesdayTill.
     *
     * @param wednesdayTill the Time.
     */
    public void setWednesdayTill(Time wednesdayTill) {
        this.wednesdayTill = wednesdayTill;
    }

    /**
     * Missing description at method setWednesdayTill.
     *
     * @param wednesdayTill the java.util.Date.
     */
    public void setWednesdayTill(java.util.Date wednesdayTill) {
        if ((this.wednesdayTill == null)) {
            if ((wednesdayTill == null)) {
                return;
            }
            this.wednesdayTill = new Time();
        }
        this.wednesdayTill.setValue(wednesdayTill);
    }

    /**
     * Missing description at method getThursdayFrom.
     *
     * @return the Time.
     */
    public Time getThursdayFrom() {
        return this.thursdayFrom;
    }

    /**
     * Missing description at method setThursdayFrom.
     *
     * @param thursdayFrom the Time.
     */
    public void setThursdayFrom(Time thursdayFrom) {
        this.thursdayFrom = thursdayFrom;
    }

    /**
     * Missing description at method setThursdayFrom.
     *
     * @param thursdayFrom the java.util.Date.
     */
    public void setThursdayFrom(java.util.Date thursdayFrom) {
        if ((this.thursdayFrom == null)) {
            if ((thursdayFrom == null)) {
                return;
            }
            this.thursdayFrom = new Time();
        }
        this.thursdayFrom.setValue(thursdayFrom);
    }

    /**
     * Missing description at method getThursdayTill.
     *
     * @return the Time.
     */
    public Time getThursdayTill() {
        return this.thursdayTill;
    }

    /**
     * Missing description at method setThursdayTill.
     *
     * @param thursdayTill the Time.
     */
    public void setThursdayTill(Time thursdayTill) {
        this.thursdayTill = thursdayTill;
    }

    /**
     * Missing description at method setThursdayTill.
     *
     * @param thursdayTill the java.util.Date.
     */
    public void setThursdayTill(java.util.Date thursdayTill) {
        if ((this.thursdayTill == null)) {
            if ((thursdayTill == null)) {
                return;
            }
            this.thursdayTill = new Time();
        }
        this.thursdayTill.setValue(thursdayTill);
    }

    /**
     * Missing description at method getFridayFrom.
     *
     * @return the Time.
     */
    public Time getFridayFrom() {
        return this.fridayFrom;
    }

    /**
     * Missing description at method setFridayFrom.
     *
     * @param fridayFrom the Time.
     */
    public void setFridayFrom(Time fridayFrom) {
        this.fridayFrom = fridayFrom;
    }

    /**
     * Missing description at method setFridayFrom.
     *
     * @param fridayFrom the java.util.Date.
     */
    public void setFridayFrom(java.util.Date fridayFrom) {
        if ((this.fridayFrom == null)) {
            if ((fridayFrom == null)) {
                return;
            }
            this.fridayFrom = new Time();
        }
        this.fridayFrom.setValue(fridayFrom);
    }

    /**
     * Missing description at method getFridayTill.
     *
     * @return the Time.
     */
    public Time getFridayTill() {
        return this.fridayTill;
    }

    /**
     * Missing description at method setFridayTill.
     *
     * @param fridayTill the Time.
     */
    public void setFridayTill(Time fridayTill) {
        this.fridayTill = fridayTill;
    }

    /**
     * Missing description at method setFridayTill.
     *
     * @param fridayTill the java.util.Date.
     */
    public void setFridayTill(java.util.Date fridayTill) {
        if ((this.fridayTill == null)) {
            if ((fridayTill == null)) {
                return;
            }
            this.fridayTill = new Time();
        }
        this.fridayTill.setValue(fridayTill);
    }

    /**
     * Missing description at method getSaturdayFrom.
     *
     * @return the Time.
     */
    public Time getSaturdayFrom() {
        return this.saturdayFrom;
    }

    /**
     * Missing description at method setSaturdayFrom.
     *
     * @param saturdayFrom the Time.
     */
    public void setSaturdayFrom(Time saturdayFrom) {
        this.saturdayFrom = saturdayFrom;
    }

    /**
     * Missing description at method setSaturdayFrom.
     *
     * @param saturdayFrom the java.util.Date.
     */
    public void setSaturdayFrom(java.util.Date saturdayFrom) {
        if ((this.saturdayFrom == null)) {
            if ((saturdayFrom == null)) {
                return;
            }
            this.saturdayFrom = new Time();
        }
        this.saturdayFrom.setValue(saturdayFrom);
    }

    /**
     * Missing description at method getSaturdayTill.
     *
     * @return the Time.
     */
    public Time getSaturdayTill() {
        return this.saturdayTill;
    }

    /**
     * Missing description at method setSaturdayTill.
     *
     * @param saturdayTill the Time.
     */
    public void setSaturdayTill(Time saturdayTill) {
        this.saturdayTill = saturdayTill;
    }

    /**
     * Missing description at method setSaturdayTill.
     *
     * @param saturdayTill the java.util.Date.
     */
    public void setSaturdayTill(java.util.Date saturdayTill) {
        if ((this.saturdayTill == null)) {
            if ((saturdayTill == null)) {
                return;
            }
            this.saturdayTill = new Time();
        }
        this.saturdayTill.setValue(saturdayTill);
    }

    /**
     * Missing description at method getSundayFrom.
     *
     * @return the Time.
     */
    public Time getSundayFrom() {
        return this.sundayFrom;
    }

    /**
     * Missing description at method setSundayFrom.
     *
     * @param sundayFrom the Time.
     */
    public void setSundayFrom(Time sundayFrom) {
        this.sundayFrom = sundayFrom;
    }

    /**
     * Missing description at method setSundayFrom.
     *
     * @param sundayFrom the java.util.Date.
     */
    public void setSundayFrom(java.util.Date sundayFrom) {
        if ((this.sundayFrom == null)) {
            if ((sundayFrom == null)) {
                return;
            }
            this.sundayFrom = new Time();
        }
        this.sundayFrom.setValue(sundayFrom);
    }

    /**
     * Missing description at method getSundayTill.
     *
     * @return the Time.
     */
    public Time getSundayTill() {
        return this.sundayTill;
    }

    /**
     * Missing description at method setSundayTill.
     *
     * @param sundayTill the Time.
     */
    public void setSundayTill(Time sundayTill) {
        this.sundayTill = sundayTill;
    }

    /**
     * Missing description at method setSundayTill.
     *
     * @param sundayTill the java.util.Date.
     */
    public void setSundayTill(java.util.Date sundayTill) {
        if ((this.sundayTill == null)) {
            if ((sundayTill == null)) {
                return;
            }
            this.sundayTill = new Time();
        }
        this.sundayTill.setValue(sundayTill);
    }

    /**
     * Missing description at method getOverAll.
     *
     * @return the Amount.
     */
    public Amount getOverAll() {
        return this.overAll;
    }

    /**
     * Missing description at method setOverAll.
     *
     * @param overAll the Amount.
     */
    public void setOverAll(Amount overAll) {
        this.overAll = overAll;
    }

    /**
     * Missing description at method setOverAll.
     *
     * @param overAll the java.math.BigDecimal.
     */
    public void setOverAll(java.math.BigDecimal overAll) {
        if ((this.overAll == null)) {
            if ((overAll == null)) {
                return;
            }
            this.overAll = new Amount();
        }
        this.overAll.setValue(overAll);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(WorkingTime.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(WorkingTime.class).getAllProperties();
    }
}
