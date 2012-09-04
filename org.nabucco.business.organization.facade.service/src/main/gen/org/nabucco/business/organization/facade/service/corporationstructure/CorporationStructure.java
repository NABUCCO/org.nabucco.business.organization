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
package org.nabucco.business.organization.facade.service.corporationstructure;

import org.nabucco.business.organization.facade.message.CustomerListMsg;
import org.nabucco.business.organization.facade.message.corporationstructure.CorporationStructureDeleteDependencyRq;
import org.nabucco.business.organization.facade.message.corporationstructure.CorporationStructureSearchDependenciesRq;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * CorporationStructure<p/>CorporationStructure Service<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-05-25
 */
public interface CorporationStructure extends Service {

    /**
     * Missing description at method searchDependencies.
     *
     * @param rq the ServiceRequest<CorporationStructureSearchDependenciesRq>.
     * @return the ServiceResponse<CustomerListMsg>.
     * @throws SearchException
     */
    ServiceResponse<CustomerListMsg> searchDependencies(ServiceRequest<CorporationStructureSearchDependenciesRq> rq)
            throws SearchException;

    /**
     * Missing description at method deleteDepenendency.
     *
     * @param rq the ServiceRequest<CorporationStructureDeleteDependencyRq>.
     * @return the ServiceResponse<EmptyServiceMessage>.
     * @throws MaintainException
     */
    ServiceResponse<EmptyServiceMessage> deleteDepenendency(ServiceRequest<CorporationStructureDeleteDependencyRq> rq)
            throws MaintainException;
}
