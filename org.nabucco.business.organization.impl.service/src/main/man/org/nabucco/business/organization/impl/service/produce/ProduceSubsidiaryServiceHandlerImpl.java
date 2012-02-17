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

import org.nabucco.business.organization.facade.datatype.Subsidiary;
import org.nabucco.business.organization.facade.message.SubsidiaryListMsg;
import org.nabucco.business.organization.facade.message.produce.SubsidiaryProduceRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * ProduceSubsidiaryServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ProduceSubsidiaryServiceHandlerImpl extends ProduceSubsidiaryServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected SubsidiaryListMsg produceSubsidiary(SubsidiaryProduceRq msg) throws ProduceException {

        SubsidiaryListMsg response = new SubsidiaryListMsg();

        for (int i = 0; i < msg.getNumber().getValue(); i++) {
            Subsidiary datatype = new Subsidiary();
            datatype.setDatatypeState(DatatypeState.INITIALIZED);

            response.getSubsidiaryList().add(datatype);
        }

        return response;
    }

}
