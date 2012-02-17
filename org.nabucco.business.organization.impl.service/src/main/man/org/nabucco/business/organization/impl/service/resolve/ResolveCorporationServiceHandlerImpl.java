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
package org.nabucco.business.organization.impl.service.resolve;

import org.nabucco.business.organization.facade.datatype.Corporation;
import org.nabucco.business.organization.facade.message.CorporationMsg;
import org.nabucco.framework.base.facade.exception.service.ResolveException;

/**
 * ResolveCorporationServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ResolveCorporationServiceHandlerImpl extends ResolveCorporationServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected CorporationMsg resolveCorporation(CorporationMsg msg) throws ResolveException {

        Corporation corporation = msg.getCorporation();

        try {
            corporation = super.getPersistenceManager().find(msg.getCorporation());
            corporation.getBusinessVolumeList().size();
            corporation.getRelationList().size();
            corporation.getSectorList().size();

        } catch (Exception e) {
            throw new ResolveException("Cannot resolve Corporation with id " + corporation.getId(), e);
        }

        CorporationMsg response = new CorporationMsg();
        response.setCorporation(corporation);
        return response;
    }

}
