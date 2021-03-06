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
package org.nabucco.business.organization.ui.web.communication.search;

import org.nabucco.business.organization.facade.message.CorporationListMsg;
import org.nabucco.business.organization.facade.message.CustomerListMsg;
import org.nabucco.business.organization.facade.message.DepartmentListMsg;
import org.nabucco.business.organization.facade.message.OrganizationMasterListMsg;
import org.nabucco.business.organization.facade.message.SubsidiaryListMsg;
import org.nabucco.business.organization.facade.message.VendorListMsg;
import org.nabucco.business.organization.facade.message.search.CorporationSearchRq;
import org.nabucco.business.organization.facade.message.search.CustomerSearchRq;
import org.nabucco.business.organization.facade.message.search.DepartmentSearchRq;
import org.nabucco.business.organization.facade.message.search.OrganizationMasterSearchRq;
import org.nabucco.business.organization.facade.message.search.SubsidiarySearchRq;
import org.nabucco.business.organization.facade.message.search.VendorSearchRq;
import org.nabucco.business.organization.facade.service.search.SearchOrganization;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;

/**
 * SearchOrganizationDelegate<p/>Search Service for Organization<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class SearchOrganizationDelegate extends ServiceDelegateSupport {

    private SearchOrganization service;

    /**
     * Constructs a new SearchOrganizationDelegate instance.
     *
     * @param service the SearchOrganization.
     */
    public SearchOrganizationDelegate(SearchOrganization service) {
        super();
        this.service = service;
    }

    /**
     * SearchOrganizationMaster.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the OrganizationMasterSearchRq.
     * @return the OrganizationMasterListMsg.
     * @throws SearchException
     */
    public OrganizationMasterListMsg searchOrganizationMaster(OrganizationMasterSearchRq message,
            NabuccoSession session, ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<OrganizationMasterSearchRq> request = new ServiceRequest<OrganizationMasterSearchRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<OrganizationMasterListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchOrganizationMaster(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchOrganization.class, "searchOrganizationMaster", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchOrganization.searchOrganizationMaster");
    }

    /**
     * SearchDepartment.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the DepartmentSearchRq.
     * @return the DepartmentListMsg.
     * @throws SearchException
     */
    public DepartmentListMsg searchDepartment(DepartmentSearchRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<DepartmentSearchRq> request = new ServiceRequest<DepartmentSearchRq>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DepartmentListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchDepartment(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchOrganization.class, "searchDepartment", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchOrganization.searchDepartment");
    }

    /**
     * SearchSubsidiary.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the SubsidiarySearchRq.
     * @return the SubsidiaryListMsg.
     * @throws SearchException
     */
    public SubsidiaryListMsg searchSubsidiary(SubsidiarySearchRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<SubsidiarySearchRq> request = new ServiceRequest<SubsidiarySearchRq>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SubsidiaryListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchSubsidiary(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchOrganization.class, "searchSubsidiary", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchOrganization.searchSubsidiary");
    }

    /**
     * SearchCorporation.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the CorporationSearchRq.
     * @return the CorporationListMsg.
     * @throws SearchException
     */
    public CorporationListMsg searchCorporation(CorporationSearchRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<CorporationSearchRq> request = new ServiceRequest<CorporationSearchRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CorporationListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchCorporation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchOrganization.class, "searchCorporation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchOrganization.searchCorporation");
    }

    /**
     * SearchCustomer.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the CustomerSearchRq.
     * @return the CustomerListMsg.
     * @throws SearchException
     */
    public CustomerListMsg searchCustomer(CustomerSearchRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<CustomerSearchRq> request = new ServiceRequest<CustomerSearchRq>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CustomerListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchCustomer(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchOrganization.class, "searchCustomer", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchOrganization.searchCustomer");
    }

    /**
     * SearchVendor.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the VendorSearchRq.
     * @return the VendorListMsg.
     * @throws SearchException
     */
    public VendorListMsg searchVendor(VendorSearchRq message, NabuccoSession session, ServiceSubContext... subContexts)
            throws SearchException {
        ServiceRequest<VendorSearchRq> request = new ServiceRequest<VendorSearchRq>(super.createServiceContext(session,
                subContexts));
        request.setRequestMessage(message);
        ServiceResponse<VendorListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchVendor(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchOrganization.class, "searchVendor", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchOrganization.searchVendor");
    }
}
