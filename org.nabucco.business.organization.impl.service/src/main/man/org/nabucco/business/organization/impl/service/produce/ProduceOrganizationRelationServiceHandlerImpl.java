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
package org.nabucco.business.organization.impl.service.produce;

import org.nabucco.business.organization.facade.datatype.OrganizationRelation;
import org.nabucco.business.organization.facade.message.OrganizationRelationListMsg;
import org.nabucco.business.organization.facade.message.produce.OrganizationRelationProduceRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * ProduceOrganizationRelationServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ProduceOrganizationRelationServiceHandlerImpl extends ProduceOrganizationRelationServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected OrganizationRelationListMsg produceOrganizationRelation(OrganizationRelationProduceRq msg)
            throws ProduceException {

        OrganizationRelationListMsg response = new OrganizationRelationListMsg();

        for (int i = 0; i < msg.getNumber().getValue(); i++) {
            OrganizationRelation datatype = new OrganizationRelation();
            datatype.setDatatypeState(DatatypeState.INITIALIZED);

            response.getOrganizationRelationList().add(datatype);
        }

        return response;
    }

}
