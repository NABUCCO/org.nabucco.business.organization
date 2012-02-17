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
package org.nabucco.business.organization.ui.web.communication.maintain;

import org.nabucco.business.organization.facade.message.CorporationMsg;
import org.nabucco.business.organization.facade.message.CustomerMsg;
import org.nabucco.business.organization.facade.message.DepartmentMsg;
import org.nabucco.business.organization.facade.message.OrganizationMasterMsg;
import org.nabucco.business.organization.facade.message.SubsidiaryMsg;
import org.nabucco.business.organization.facade.message.VendorMsg;
import org.nabucco.business.organization.facade.service.maintain.MaintainOrganization;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;

/**
 * MaintainOrganizationDelegate<p/>Maintain Service for Organization<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class MaintainOrganizationDelegate extends ServiceDelegateSupport {

    private MaintainOrganization service;

    /**
     * Constructs a new MaintainOrganizationDelegate instance.
     *
     * @param service the MaintainOrganization.
     */
    public MaintainOrganizationDelegate(MaintainOrganization service) {
        super();
        this.service = service;
    }

    /**
     * MaintainOrganizationMaster.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the OrganizationMasterMsg.
     * @return the OrganizationMasterMsg.
     * @throws MaintainException
     */
    public OrganizationMasterMsg maintainOrganizationMaster(OrganizationMasterMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<OrganizationMasterMsg> request = new ServiceRequest<OrganizationMasterMsg>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<OrganizationMasterMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainOrganizationMaster(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainOrganization.class, "maintainOrganizationMaster", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainOrganization.maintainOrganizationMaster");
    }

    /**
     * MaintainDepartment.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the DepartmentMsg.
     * @return the DepartmentMsg.
     * @throws MaintainException
     */
    public DepartmentMsg maintainDepartment(DepartmentMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<DepartmentMsg> request = new ServiceRequest<DepartmentMsg>(super.createServiceContext(session,
                subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DepartmentMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainDepartment(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainOrganization.class, "maintainDepartment", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainOrganization.maintainDepartment");
    }

    /**
     * MaintainSubsidiary.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the SubsidiaryMsg.
     * @return the SubsidiaryMsg.
     * @throws MaintainException
     */
    public SubsidiaryMsg maintainSubsidiary(SubsidiaryMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<SubsidiaryMsg> request = new ServiceRequest<SubsidiaryMsg>(super.createServiceContext(session,
                subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SubsidiaryMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainSubsidiary(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainOrganization.class, "maintainSubsidiary", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainOrganization.maintainSubsidiary");
    }

    /**
     * MaintainCorporation.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the CorporationMsg.
     * @return the CorporationMsg.
     * @throws MaintainException
     */
    public CorporationMsg maintainCorporation(CorporationMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<CorporationMsg> request = new ServiceRequest<CorporationMsg>(super.createServiceContext(session,
                subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CorporationMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainCorporation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainOrganization.class, "maintainCorporation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainOrganization.maintainCorporation");
    }

    /**
     * MaintainCustomer.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the CustomerMsg.
     * @return the CustomerMsg.
     * @throws MaintainException
     */
    public CustomerMsg maintainCustomer(CustomerMsg message, NabuccoSession session, ServiceSubContext... subContexts)
            throws MaintainException {
        ServiceRequest<CustomerMsg> request = new ServiceRequest<CustomerMsg>(super.createServiceContext(session,
                subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CustomerMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainCustomer(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainOrganization.class, "maintainCustomer", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainOrganization.maintainCustomer");
    }

    /**
     * MaintainCustomerDepartment.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the CustomerMsg.
     * @return the CustomerMsg.
     * @throws MaintainException
     */
    public CustomerMsg maintainCustomerDepartment(CustomerMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<CustomerMsg> request = new ServiceRequest<CustomerMsg>(super.createServiceContext(session,
                subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CustomerMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainCustomerDepartment(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainOrganization.class, "maintainCustomerDepartment", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainOrganization.maintainCustomerDepartment");
    }

    /**
     * MaintainVendor.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the VendorMsg.
     * @return the VendorMsg.
     * @throws MaintainException
     */
    public VendorMsg maintainVendor(VendorMsg message, NabuccoSession session, ServiceSubContext... subContexts)
            throws MaintainException {
        ServiceRequest<VendorMsg> request = new ServiceRequest<VendorMsg>(super.createServiceContext(session,
                subContexts));
        request.setRequestMessage(message);
        ServiceResponse<VendorMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainVendor(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainOrganization.class, "maintainVendor", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainOrganization.maintainVendor");
    }
}
