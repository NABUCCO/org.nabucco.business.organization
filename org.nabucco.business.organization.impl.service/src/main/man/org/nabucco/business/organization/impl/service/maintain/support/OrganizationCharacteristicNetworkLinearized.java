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
package org.nabucco.business.organization.impl.service.maintain.support;

import java.util.ArrayList;
import java.util.List;

import org.nabucco.business.organization.facade.datatype.OrganizationCharacteristic;
import org.nabucco.business.organization.facade.datatype.OrganizationRelation;

/**
 * OrganizationCharacteristicNetworkLinearized
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public final class OrganizationCharacteristicNetworkLinearized {

    private List<OrganizationCharacteristic> characteristics;

    private List<OrganizationRelation> relations;

    /**
     * Creates a new {@link OrganizationCharacteristicNetworkLinearized} instance.
     */
    public OrganizationCharacteristicNetworkLinearized() {
        characteristics = new ArrayList<OrganizationCharacteristic>();
        relations = new ArrayList<OrganizationRelation>();
    }

    public List<OrganizationCharacteristic> getCharacteristics() {
        return characteristics;
    }

    public List<OrganizationRelation> getRelations() {
        return relations;
    }

    public void addRelation(OrganizationRelation relation) {
        relations.add(relation);
    }

    public void addCharacteristic(OrganizationCharacteristic characteristic) {
        characteristics.add(characteristic);
    }

}
