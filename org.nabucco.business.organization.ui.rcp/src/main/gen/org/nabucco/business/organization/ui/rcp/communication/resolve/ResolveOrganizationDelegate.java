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
package org.nabucco.business.organization.ui.rcp.communication.resolve;

import org.nabucco.business.organization.facade.message.CorporationMsg;
import org.nabucco.business.organization.facade.message.CustomerMsg;
import org.nabucco.business.organization.facade.message.DepartmentMsg;
import org.nabucco.business.organization.facade.message.OrganizationMasterMsg;
import org.nabucco.business.organization.facade.message.SubsidiaryMsg;
import org.nabucco.business.organization.facade.message.VendorMsg;
import org.nabucco.business.organization.facade.message.resolve.ResolveDatatypeListRq;
import org.nabucco.business.organization.facade.message.resolve.ResolveDatatypeListRs;
import org.nabucco.business.organization.facade.service.resolve.ResolveOrganization;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * ResolveOrganizationDelegate<p/>Resolve Service for Organization<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class ResolveOrganizationDelegate extends ServiceDelegateSupport {

    private ResolveOrganization service;

    /**
     * Constructs a new ResolveOrganizationDelegate instance.
     *
     * @param service the ResolveOrganization.
     */
    public ResolveOrganizationDelegate(ResolveOrganization service) {
        super();
        this.service = service;
    }

    /**
     * ResolveOrganizationMaster.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the OrganizationMasterMsg.
     * @return the OrganizationMasterMsg.
     * @throws ClientException
     */
    public OrganizationMasterMsg resolveOrganizationMaster(OrganizationMasterMsg message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<OrganizationMasterMsg> request = new ServiceRequest<OrganizationMasterMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<OrganizationMasterMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveOrganizationMaster(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveOrganization.class, "resolveOrganizationMaster", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveOrganization.resolveOrganizationMaster");
    }

    /**
     * ResolveDepartment.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the DepartmentMsg.
     * @return the DepartmentMsg.
     * @throws ClientException
     */
    public DepartmentMsg resolveDepartment(DepartmentMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<DepartmentMsg> request = new ServiceRequest<DepartmentMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DepartmentMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveDepartment(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveOrganization.class, "resolveDepartment", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveOrganization.resolveDepartment");
    }

    /**
     * ResolveSubsidiary.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the SubsidiaryMsg.
     * @return the SubsidiaryMsg.
     * @throws ClientException
     */
    public SubsidiaryMsg resolveSubsidiary(SubsidiaryMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<SubsidiaryMsg> request = new ServiceRequest<SubsidiaryMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SubsidiaryMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveSubsidiary(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveOrganization.class, "resolveSubsidiary", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveOrganization.resolveSubsidiary");
    }

    /**
     * ResolveCorporation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the CorporationMsg.
     * @return the CorporationMsg.
     * @throws ClientException
     */
    public CorporationMsg resolveCorporation(CorporationMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<CorporationMsg> request = new ServiceRequest<CorporationMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CorporationMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveCorporation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveOrganization.class, "resolveCorporation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveOrganization.resolveCorporation");
    }

    /**
     * ResolveCustomer.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the CustomerMsg.
     * @return the CustomerMsg.
     * @throws ClientException
     */
    public CustomerMsg resolveCustomer(CustomerMsg message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<CustomerMsg> request = new ServiceRequest<CustomerMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CustomerMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveCustomer(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveOrganization.class, "resolveCustomer", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveOrganization.resolveCustomer");
    }

    /**
     * ResolveCustomerDepartment.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the CustomerMsg.
     * @return the CustomerMsg.
     * @throws ClientException
     */
    public CustomerMsg resolveCustomerDepartment(CustomerMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<CustomerMsg> request = new ServiceRequest<CustomerMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CustomerMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveCustomerDepartment(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveOrganization.class, "resolveCustomerDepartment", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveOrganization.resolveCustomerDepartment");
    }

    /**
     * ResolveVendor.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the VendorMsg.
     * @return the VendorMsg.
     * @throws ClientException
     */
    public VendorMsg resolveVendor(VendorMsg message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<VendorMsg> request = new ServiceRequest<VendorMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<VendorMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveVendor(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveOrganization.class, "resolveVendor", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveOrganization.resolveVendor");
    }

    /**
     * ResolveDatatypeList.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ResolveDatatypeListRq.
     * @return the ResolveDatatypeListRs.
     * @throws ClientException
     */
    public ResolveDatatypeListRs resolveDatatypeList(ResolveDatatypeListRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ResolveDatatypeListRq> request = new ServiceRequest<ResolveDatatypeListRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ResolveDatatypeListRs> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveDatatypeList(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveOrganization.class, "resolveDatatypeList", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveOrganization.resolveDatatypeList");
    }
}
