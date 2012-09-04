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

import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelation;
import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelationType;

/**
 * CorporationComponentRelation
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-23
 */
public class CorporationComponentRelation extends ComponentRelation<Corporation> {

    private static final long serialVersionUID = 1L;

    /** Constructs a new CorporationComponentRelation instance. */
    protected CorporationComponentRelation() {
        super();
    }

    /**
     * Constructs a new CorporationComponentRelation instance.
     *
     * @param relationType the ComponentRelationType.
     */
    public CorporationComponentRelation(ComponentRelationType relationType) {
        super(relationType);
    }

    /**
     * Getter for the Tarthe .
     *
     * @return the Corporation.
     */
    public Corporation getTarget() {
        return super.getTarget();
    }

    /**
     * Setter for the Target.
     *
     * @param target the Corporation.
     */
    public void setTarget(Corporation target) {
        super.setTarget(target);
    }

    @Override
    public CorporationComponentRelation cloneObject() {
        CorporationComponentRelation clone = new CorporationComponentRelation();
        super.cloneObject(clone);
        return clone;
    }
}
