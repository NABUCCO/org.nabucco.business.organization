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

import org.nabucco.business.organization.facade.datatype.OrganizationCharacteristic;
import org.nabucco.business.organization.facade.datatype.OrganizationRelation;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollection;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;

/**
 * OrganizationCharacteristicNetworkLinearizer
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class OrganizationCharacteristicNetworkLinearizer {

    /**
     * Lineraize the the organization characteristic network.
     * 
     * @param characteristic
     *            the characteristic root
     * 
     * @return the lineraized network
     */
    public OrganizationCharacteristicNetworkLinearized linearizeNetwork(OrganizationCharacteristic characteristic) {

        OrganizationCharacteristicNetworkLinearized networkLinearized = new OrganizationCharacteristicNetworkLinearized();

        linearize(characteristic, networkLinearized);

        return networkLinearized;
    }

    private void linearize(OrganizationCharacteristic sourceCharacteristic,
            OrganizationCharacteristicNetworkLinearized networkLinearized) {

        networkLinearized.addCharacteristic(sourceCharacteristic);

        NabuccoCollection<OrganizationRelation> list = sourceCharacteristic.getRelationList();

        // skip if list is lazy loaded
        if (list.getState() == NabuccoCollectionState.LAZY) {
            return;
        }

        for (OrganizationRelation relation : list) {
            networkLinearized.addRelation(relation);

            OrganizationCharacteristic targetCharacteristic = relation.getCharacteristic();
            if (!networkLinearized.getCharacteristics().contains(targetCharacteristic)) {
                linearize(targetCharacteristic, networkLinearized);
            }
        }
    }

}
