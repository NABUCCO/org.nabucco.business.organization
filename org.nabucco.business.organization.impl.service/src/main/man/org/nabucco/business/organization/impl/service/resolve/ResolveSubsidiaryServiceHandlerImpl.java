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

import org.nabucco.business.organization.facade.datatype.Subsidiary;
import org.nabucco.business.organization.facade.message.SubsidiaryMsg;
import org.nabucco.framework.base.facade.exception.service.ResolveException;

/**
 * ResolveSubsidiaryServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ResolveSubsidiaryServiceHandlerImpl extends ResolveSubsidiaryServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected SubsidiaryMsg resolveSubsidiary(SubsidiaryMsg msg) throws ResolveException {

        Subsidiary subsidiary = msg.getSubsidiary();

        try {
            subsidiary = super.getPersistenceManager().find(msg.getSubsidiary());
            subsidiary.getRelationList().size();
            subsidiary.getSectorList().size();

        } catch (Exception e) {
            throw new ResolveException("Cannot resolve Subsidiary with id " + subsidiary.getId(), e);
        }

        SubsidiaryMsg response = new SubsidiaryMsg();
        response.setSubsidiary(subsidiary);
        return response;
    }

}
