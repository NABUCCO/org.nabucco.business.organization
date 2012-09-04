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
package org.nabucco.business.organization.facade.message.corporationstructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * CorporationStructureSearchDependenciesRq<p/>Search message for Corporation sturcture dependencies<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-05-25
 */
public class CorporationStructureSearchDependenciesRq extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;u0,n;m1,1;", "l0,n;u0,n;m1,1;" };

    public static final String COMPONENTRELATIONTYPE = "componentRelationType";

    public static final String SOURCEID = "sourceId";

    private Name componentRelationType;

    private Identifier sourceId;

    /** Constructs a new CorporationStructureSearchDependenciesRq instance. */
    public CorporationStructureSearchDependenciesRq() {
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
        propertyMap.put(COMPONENTRELATIONTYPE, PropertyDescriptorSupport.createBasetype(COMPONENTRELATIONTYPE,
                Name.class, 0, PROPERTY_CONSTRAINTS[0], false));
        propertyMap
                .put(SOURCEID, PropertyDescriptorSupport.createBasetype(SOURCEID, Identifier.class, 1,
                        PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(
                CorporationStructureSearchDependenciesRq.getPropertyDescriptor(COMPONENTRELATIONTYPE),
                this.componentRelationType));
        properties.add(super.createProperty(CorporationStructureSearchDependenciesRq.getPropertyDescriptor(SOURCEID),
                this.sourceId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(COMPONENTRELATIONTYPE) && (property.getType() == Name.class))) {
            this.setComponentRelationType(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SOURCEID) && (property.getType() == Identifier.class))) {
            this.setSourceId(((Identifier) property.getInstance()));
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
        final CorporationStructureSearchDependenciesRq other = ((CorporationStructureSearchDependenciesRq) obj);
        if ((this.componentRelationType == null)) {
            if ((other.componentRelationType != null))
                return false;
        } else if ((!this.componentRelationType.equals(other.componentRelationType)))
            return false;
        if ((this.sourceId == null)) {
            if ((other.sourceId != null))
                return false;
        } else if ((!this.sourceId.equals(other.sourceId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.componentRelationType == null) ? 0 : this.componentRelationType.hashCode()));
        result = ((PRIME * result) + ((this.sourceId == null) ? 0 : this.sourceId.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getComponentRelationType.
     *
     * @return the Name.
     */
    public Name getComponentRelationType() {
        return this.componentRelationType;
    }

    /**
     * Missing description at method setComponentRelationType.
     *
     * @param componentRelationType the Name.
     */
    public void setComponentRelationType(Name componentRelationType) {
        this.componentRelationType = componentRelationType;
    }

    /**
     * Missing description at method getSourceId.
     *
     * @return the Identifier.
     */
    public Identifier getSourceId() {
        return this.sourceId;
    }

    /**
     * Missing description at method setSourceId.
     *
     * @param sourceId the Identifier.
     */
    public void setSourceId(Identifier sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(CorporationStructureSearchDependenciesRq.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(CorporationStructureSearchDependenciesRq.class).getAllProperties();
    }
}
