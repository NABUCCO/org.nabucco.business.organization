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
package org.nabucco.business.organization.ui.web.communication.produce;

import org.nabucco.business.organization.facade.message.BusinessVolumeListMsg;
import org.nabucco.business.organization.facade.message.CorporationListMsg;
import org.nabucco.business.organization.facade.message.CreditReportListMsg;
import org.nabucco.business.organization.facade.message.CustomerListMsg;
import org.nabucco.business.organization.facade.message.DepartmentListMsg;
import org.nabucco.business.organization.facade.message.EUCorporationListMsg;
import org.nabucco.business.organization.facade.message.OrganizationMasterListMsg;
import org.nabucco.business.organization.facade.message.OrganizationRelationListMsg;
import org.nabucco.business.organization.facade.message.OrganizationStatisticListMsg;
import org.nabucco.business.organization.facade.message.SectorListMsg;
import org.nabucco.business.organization.facade.message.SubsidiaryListMsg;
import org.nabucco.business.organization.facade.message.VendorListMsg;
import org.nabucco.business.organization.facade.message.WorkingTimeListMsg;
import org.nabucco.business.organization.facade.message.produce.BusinessVolumeProduceRq;
import org.nabucco.business.organization.facade.message.produce.CorporationProduceRq;
import org.nabucco.business.organization.facade.message.produce.CreditReportProduceRq;
import org.nabucco.business.organization.facade.message.produce.CustomerProduceRq;
import org.nabucco.business.organization.facade.message.produce.DepartmentProduceRq;
import org.nabucco.business.organization.facade.message.produce.EUCorporationProduceRq;
import org.nabucco.business.organization.facade.message.produce.OrganizationMasterProduceRq;
import org.nabucco.business.organization.facade.message.produce.OrganizationRelationProduceRq;
import org.nabucco.business.organization.facade.message.produce.OrganizationStatisticProduceRq;
import org.nabucco.business.organization.facade.message.produce.SectorProduceRq;
import org.nabucco.business.organization.facade.message.produce.SubsidiaryProduceRq;
import org.nabucco.business.organization.facade.message.produce.VendorProduceRq;
import org.nabucco.business.organization.facade.message.produce.WorkingTimeProduceRq;
import org.nabucco.business.organization.facade.service.produce.ProduceOrganization;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;

/**
 * ProduceOrganizationDelegate<p/>Produce Service for Organization<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class ProduceOrganizationDelegate extends ServiceDelegateSupport {

    private ProduceOrganization service;

    /**
     * Constructs a new ProduceOrganizationDelegate instance.
     *
     * @param service the ProduceOrganization.
     */
    public ProduceOrganizationDelegate(ProduceOrganization service) {
        super();
        this.service = service;
    }

    /**
     * ProduceOrganizationMaster.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the OrganizationMasterProduceRq.
     * @return the OrganizationMasterListMsg.
     * @throws ProduceException
     */
    public OrganizationMasterListMsg produceOrganizationMaster(OrganizationMasterProduceRq message,
            NabuccoSession session, ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<OrganizationMasterProduceRq> request = new ServiceRequest<OrganizationMasterProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<OrganizationMasterListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceOrganizationMaster(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceOrganization.class, "produceOrganizationMaster", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProduceOrganization.produceOrganizationMaster");
    }

    /**
     * ProduceOrganizationRelation.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the OrganizationRelationProduceRq.
     * @return the OrganizationRelationListMsg.
     * @throws ProduceException
     */
    public OrganizationRelationListMsg produceOrganizationRelation(OrganizationRelationProduceRq message,
            NabuccoSession session, ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<OrganizationRelationProduceRq> request = new ServiceRequest<OrganizationRelationProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<OrganizationRelationListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceOrganizationRelation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceOrganization.class, "produceOrganizationRelation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProduceOrganization.produceOrganizationRelation");
    }

    /**
     * ProduceDepartment.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the DepartmentProduceRq.
     * @return the DepartmentListMsg.
     * @throws ProduceException
     */
    public DepartmentListMsg produceDepartment(DepartmentProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<DepartmentProduceRq> request = new ServiceRequest<DepartmentProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DepartmentListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceDepartment(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceOrganization.class, "produceDepartment", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProduceOrganization.produceDepartment");
    }

    /**
     * ProduceSubsidiary.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the SubsidiaryProduceRq.
     * @return the SubsidiaryListMsg.
     * @throws ProduceException
     */
    public SubsidiaryListMsg produceSubsidiary(SubsidiaryProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<SubsidiaryProduceRq> request = new ServiceRequest<SubsidiaryProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SubsidiaryListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceSubsidiary(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceOrganization.class, "produceSubsidiary", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProduceOrganization.produceSubsidiary");
    }

    /**
     * ProduceCorporation.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the CorporationProduceRq.
     * @return the CorporationListMsg.
     * @throws ProduceException
     */
    public CorporationListMsg produceCorporation(CorporationProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<CorporationProduceRq> request = new ServiceRequest<CorporationProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CorporationListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceCorporation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceOrganization.class, "produceCorporation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProduceOrganization.produceCorporation");
    }

    /**
     * ProduceCustomer.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the CustomerProduceRq.
     * @return the CustomerListMsg.
     * @throws ProduceException
     */
    public CustomerListMsg produceCustomer(CustomerProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<CustomerProduceRq> request = new ServiceRequest<CustomerProduceRq>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CustomerListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceCustomer(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceOrganization.class, "produceCustomer", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProduceOrganization.produceCustomer");
    }

    /**
     * ProduceCustomerDepartment.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the CustomerProduceRq.
     * @return the CustomerListMsg.
     * @throws ProduceException
     */
    public CustomerListMsg produceCustomerDepartment(CustomerProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<CustomerProduceRq> request = new ServiceRequest<CustomerProduceRq>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CustomerListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceCustomerDepartment(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceOrganization.class, "produceCustomerDepartment", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProduceOrganization.produceCustomerDepartment");
    }

    /**
     * ProduceVendor.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the VendorProduceRq.
     * @return the VendorListMsg.
     * @throws ProduceException
     */
    public VendorListMsg produceVendor(VendorProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<VendorProduceRq> request = new ServiceRequest<VendorProduceRq>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<VendorListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceVendor(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceOrganization.class, "produceVendor", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProduceOrganization.produceVendor");
    }

    /**
     * ProduceWorkingTime.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the WorkingTimeProduceRq.
     * @return the WorkingTimeListMsg.
     * @throws ProduceException
     */
    public WorkingTimeListMsg produceWorkingTime(WorkingTimeProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<WorkingTimeProduceRq> request = new ServiceRequest<WorkingTimeProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<WorkingTimeListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceWorkingTime(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceOrganization.class, "produceWorkingTime", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProduceOrganization.produceWorkingTime");
    }

    /**
     * ProduceCreditReport.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the CreditReportProduceRq.
     * @return the CreditReportListMsg.
     * @throws ProduceException
     */
    public CreditReportListMsg produceCreditReport(CreditReportProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<CreditReportProduceRq> request = new ServiceRequest<CreditReportProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CreditReportListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceCreditReport(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceOrganization.class, "produceCreditReport", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProduceOrganization.produceCreditReport");
    }

    /**
     * ProduceOrganizationStatistic.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the OrganizationStatisticProduceRq.
     * @return the OrganizationStatisticListMsg.
     * @throws ProduceException
     */
    public OrganizationStatisticListMsg produceOrganizationStatistic(OrganizationStatisticProduceRq message,
            NabuccoSession session, ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<OrganizationStatisticProduceRq> request = new ServiceRequest<OrganizationStatisticProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<OrganizationStatisticListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceOrganizationStatistic(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceOrganization.class, "produceOrganizationStatistic", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProduceOrganization.produceOrganizationStatistic");
    }

    /**
     * ProduceEUCorporation.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the EUCorporationProduceRq.
     * @return the EUCorporationListMsg.
     * @throws ProduceException
     */
    public EUCorporationListMsg produceEUCorporation(EUCorporationProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<EUCorporationProduceRq> request = new ServiceRequest<EUCorporationProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EUCorporationListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceEUCorporation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceOrganization.class, "produceEUCorporation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProduceOrganization.produceEUCorporation");
    }

    /**
     * ProduceBusinessVolume.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the BusinessVolumeProduceRq.
     * @return the BusinessVolumeListMsg.
     * @throws ProduceException
     */
    public BusinessVolumeListMsg produceBusinessVolume(BusinessVolumeProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<BusinessVolumeProduceRq> request = new ServiceRequest<BusinessVolumeProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<BusinessVolumeListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceBusinessVolume(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceOrganization.class, "produceBusinessVolume", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProduceOrganization.produceBusinessVolume");
    }

    /**
     * ProduceSector.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the SectorProduceRq.
     * @return the SectorListMsg.
     * @throws ProduceException
     */
    public SectorListMsg produceSector(SectorProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<SectorProduceRq> request = new ServiceRequest<SectorProduceRq>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SectorListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceSector(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceOrganization.class, "produceSector", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProduceOrganization.produceSector");
    }
}
