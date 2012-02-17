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

import org.nabucco.business.organization.facade.datatype.Corporation;
import org.nabucco.business.organization.facade.datatype.OrganizationMaster;
import org.nabucco.business.organization.facade.message.CorporationListMsg;
import org.nabucco.business.organization.facade.message.produce.CorporationProduceRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.StatusType;
import org.nabucco.framework.base.facade.datatype.security.User;
import org.nabucco.framework.base.facade.datatype.security.UserId;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * 
 * ProduceCorporationServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ProduceCorporationServiceHandlerImpl extends ProduceCorporationServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected CorporationListMsg produceCorporation(CorporationProduceRq msg) throws ProduceException {

        CorporationListMsg response = new CorporationListMsg();

        OrganizationMaster master = msg.getMaster();

        if (master == null) {
            User user = getContext().getSubject().getUser();

            master = new OrganizationMaster();
            master.setOwner(user.getOwner());
            master.setName("New Corporation");
            master.setUserId(new UserId(user.getUsername().getValue()));
            master.setDatatypeState(DatatypeState.INITIALIZED);
            master.setStatusType(StatusType.ACTIVE);
        }

        for (int i = 0; i < msg.getAmount().getValue(); i++) {
            Corporation corporation = new Corporation();
            corporation.setDatatypeState(DatatypeState.INITIALIZED);
            corporation.setMaster(master);

            response.getCorporationList().add(corporation);
        }

        return response;
    }

}
