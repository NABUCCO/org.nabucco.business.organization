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

import org.nabucco.business.organization.facade.datatype.OrganizationMaster;
import org.nabucco.business.organization.facade.message.OrganizationMasterMsg;
import org.nabucco.framework.base.facade.exception.service.ResolveException;

/**
 * 
 * ResolveOrganizationMasterServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ResolveOrganizationMasterServiceHandlerImpl extends ResolveOrganizationMasterServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected OrganizationMasterMsg resolveOrganizationMaster(OrganizationMasterMsg msg) throws ResolveException {

        OrganizationMaster organizationMaster = msg.getOrganizationMaster();

        try {
            organizationMaster = super.getPersistenceManager().find(msg.getOrganizationMaster());

        } catch (Exception e) {
            throw new ResolveException("Cannot resolve OrganizationMaster with id " + organizationMaster.getId(), e);
        }

        OrganizationMasterMsg response = new OrganizationMasterMsg();
        response.setOrganizationMaster(organizationMaster);
        return response;
    }

}
