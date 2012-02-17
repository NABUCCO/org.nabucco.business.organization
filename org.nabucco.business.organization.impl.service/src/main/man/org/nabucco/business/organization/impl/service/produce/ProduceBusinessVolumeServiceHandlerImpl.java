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

import org.nabucco.business.organization.facade.datatype.BusinessVolume;
import org.nabucco.business.organization.facade.message.BusinessVolumeListMsg;
import org.nabucco.business.organization.facade.message.produce.BusinessVolumeProduceRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * ProduceBusinessVolumeServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ProduceBusinessVolumeServiceHandlerImpl extends ProduceBusinessVolumeServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected BusinessVolumeListMsg produceBusinessVolume(BusinessVolumeProduceRq msg) throws ProduceException {

        BusinessVolumeListMsg response = new BusinessVolumeListMsg();

        for (int i = 0; i < msg.getNumber().getValue(); i++) {
            BusinessVolume datatype = new BusinessVolume();
            datatype.setDatatypeState(DatatypeState.INITIALIZED);

            response.getBusinessVolumeList().add(datatype);
        }

        return response;
    }

}
