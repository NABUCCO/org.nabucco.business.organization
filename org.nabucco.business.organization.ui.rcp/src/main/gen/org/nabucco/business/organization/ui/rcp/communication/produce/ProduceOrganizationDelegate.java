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
package org.nabucco.business.organization.ui.rcp.communication.produce;

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
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

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
     * @param message the OrganizationMasterProduceRq.
     * @return the OrganizationMasterListMsg.
     * @throws ClientException
     */
    public OrganizationMasterListMsg produceOrganizationMaster(OrganizationMasterProduceRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<OrganizationMasterProduceRq> request = new ServiceRequest<OrganizationMasterProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<OrganizationMasterListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceOrganization.produceOrganizationMaster");
    }

    /**
     * ProduceOrganizationRelation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the OrganizationRelationProduceRq.
     * @return the OrganizationRelationListMsg.
     * @throws ClientException
     */
    public OrganizationRelationListMsg produceOrganizationRelation(OrganizationRelationProduceRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<OrganizationRelationProduceRq> request = new ServiceRequest<OrganizationRelationProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<OrganizationRelationListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceOrganization.produceOrganizationRelation");
    }

    /**
     * ProduceDepartment.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the DepartmentProduceRq.
     * @return the DepartmentListMsg.
     * @throws ClientException
     */
    public DepartmentListMsg produceDepartment(DepartmentProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<DepartmentProduceRq> request = new ServiceRequest<DepartmentProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DepartmentListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceOrganization.produceDepartment");
    }

    /**
     * ProduceSubsidiary.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the SubsidiaryProduceRq.
     * @return the SubsidiaryListMsg.
     * @throws ClientException
     */
    public SubsidiaryListMsg produceSubsidiary(SubsidiaryProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<SubsidiaryProduceRq> request = new ServiceRequest<SubsidiaryProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SubsidiaryListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceOrganization.produceSubsidiary");
    }

    /**
     * ProduceCorporation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the CorporationProduceRq.
     * @return the CorporationListMsg.
     * @throws ClientException
     */
    public CorporationListMsg produceCorporation(CorporationProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<CorporationProduceRq> request = new ServiceRequest<CorporationProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CorporationListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceOrganization.produceCorporation");
    }

    /**
     * ProduceCustomer.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the CustomerProduceRq.
     * @return the CustomerListMsg.
     * @throws ClientException
     */
    public CustomerListMsg produceCustomer(CustomerProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<CustomerProduceRq> request = new ServiceRequest<CustomerProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CustomerListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceOrganization.produceCustomer");
    }

    /**
     * ProduceCustomerDepartment.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the CustomerProduceRq.
     * @return the CustomerListMsg.
     * @throws ClientException
     */
    public CustomerListMsg produceCustomerDepartment(CustomerProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<CustomerProduceRq> request = new ServiceRequest<CustomerProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CustomerListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceOrganization.produceCustomerDepartment");
    }

    /**
     * ProduceVendor.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the VendorProduceRq.
     * @return the VendorListMsg.
     * @throws ClientException
     */
    public VendorListMsg produceVendor(VendorProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<VendorProduceRq> request = new ServiceRequest<VendorProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<VendorListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceOrganization.produceVendor");
    }

    /**
     * ProduceWorkingTime.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the WorkingTimeProduceRq.
     * @return the WorkingTimeListMsg.
     * @throws ClientException
     */
    public WorkingTimeListMsg produceWorkingTime(WorkingTimeProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<WorkingTimeProduceRq> request = new ServiceRequest<WorkingTimeProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<WorkingTimeListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceOrganization.produceWorkingTime");
    }

    /**
     * ProduceCreditReport.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the CreditReportProduceRq.
     * @return the CreditReportListMsg.
     * @throws ClientException
     */
    public CreditReportListMsg produceCreditReport(CreditReportProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<CreditReportProduceRq> request = new ServiceRequest<CreditReportProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<CreditReportListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceOrganization.produceCreditReport");
    }

    /**
     * ProduceOrganizationStatistic.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the OrganizationStatisticProduceRq.
     * @return the OrganizationStatisticListMsg.
     * @throws ClientException
     */
    public OrganizationStatisticListMsg produceOrganizationStatistic(OrganizationStatisticProduceRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<OrganizationStatisticProduceRq> request = new ServiceRequest<OrganizationStatisticProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<OrganizationStatisticListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceOrganization.produceOrganizationStatistic");
    }

    /**
     * ProduceEUCorporation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EUCorporationProduceRq.
     * @return the EUCorporationListMsg.
     * @throws ClientException
     */
    public EUCorporationListMsg produceEUCorporation(EUCorporationProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EUCorporationProduceRq> request = new ServiceRequest<EUCorporationProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EUCorporationListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceOrganization.produceEUCorporation");
    }

    /**
     * ProduceBusinessVolume.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the BusinessVolumeProduceRq.
     * @return the BusinessVolumeListMsg.
     * @throws ClientException
     */
    public BusinessVolumeListMsg produceBusinessVolume(BusinessVolumeProduceRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<BusinessVolumeProduceRq> request = new ServiceRequest<BusinessVolumeProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<BusinessVolumeListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceOrganization.produceBusinessVolume");
    }

    /**
     * ProduceSector.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the SectorProduceRq.
     * @return the SectorListMsg.
     * @throws ClientException
     */
    public SectorListMsg produceSector(SectorProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<SectorProduceRq> request = new ServiceRequest<SectorProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SectorListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceOrganization.produceSector");
    }
}
