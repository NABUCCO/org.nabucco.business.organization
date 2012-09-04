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
package org.nabucco.business.organization.ui.web.communication.corporationstructure;

import org.nabucco.business.organization.facade.message.CustomerListMsg;
import org.nabucco.business.organization.facade.message.corporationstructure.CorporationStructureDeleteDependencyRq;
import org.nabucco.business.organization.facade.message.corporationstructure.CorporationStructureSearchDependenciesRq;
import org.nabucco.business.organization.facade.service.corporationstructure.CorporationStructure;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;

/**
 * CorporationStructureDelegate<p/>CorporationStructure Service<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-05-25
 */
public class CorporationStructureDelegate extends ServiceDelegateSupport {

    private CorporationStructure service;

    /**
     * Constructs a new CorporationStructureDelegate instance.
     *
     * @param service the CorporationStructure.
     */
    public CorporationStructureDelegate(CorporationStructure service) {
        super();
        this.service = service;
    }

    /**
     * SearchDependencies.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the CorporationStructureSearchDependenciesRq.
     * @return the CustomerListMsg.
     * @throws SearchException
     */
    public CustomerListMsg searchDependencies(CorporationStructureSearchDependenciesRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<CorporationStructureSearchDependenciesRq> request = new ServiceRequest<CorporationStructureSearchDependenciesRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CustomerListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchDependencies(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(CorporationStructure.class, "searchDependencies", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: CorporationStructure.searchDependencies");
    }

    /**
     * DeleteDepenendency.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the CorporationStructureDeleteDependencyRq.
     * @return the EmptyServiceMessage.
     * @throws MaintainException
     */
    public EmptyServiceMessage deleteDepenendency(CorporationStructureDeleteDependencyRq message,
            NabuccoSession session, ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<CorporationStructureDeleteDependencyRq> request = new ServiceRequest<CorporationStructureDeleteDependencyRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmptyServiceMessage> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.deleteDepenendency(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(CorporationStructure.class, "deleteDepenendency", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: CorporationStructure.deleteDepenendency");
    }
}
