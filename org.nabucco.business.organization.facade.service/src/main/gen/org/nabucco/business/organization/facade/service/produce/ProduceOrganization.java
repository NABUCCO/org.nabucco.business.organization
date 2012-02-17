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
package org.nabucco.business.organization.facade.service.produce;

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
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * ProduceOrganization<p/>Produce Service for Organization<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public interface ProduceOrganization extends Service {

    /**
     * Missing description at method produceOrganizationMaster.
     *
     * @param rq the ServiceRequest<OrganizationMasterProduceRq>.
     * @return the ServiceResponse<OrganizationMasterListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<OrganizationMasterListMsg> produceOrganizationMaster(ServiceRequest<OrganizationMasterProduceRq> rq)
            throws ProduceException;

    /**
     * Missing description at method produceOrganizationRelation.
     *
     * @param rq the ServiceRequest<OrganizationRelationProduceRq>.
     * @return the ServiceResponse<OrganizationRelationListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<OrganizationRelationListMsg> produceOrganizationRelation(
            ServiceRequest<OrganizationRelationProduceRq> rq) throws ProduceException;

    /**
     * Missing description at method produceDepartment.
     *
     * @param rq the ServiceRequest<DepartmentProduceRq>.
     * @return the ServiceResponse<DepartmentListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<DepartmentListMsg> produceDepartment(ServiceRequest<DepartmentProduceRq> rq)
            throws ProduceException;

    /**
     * Missing description at method produceSubsidiary.
     *
     * @param rq the ServiceRequest<SubsidiaryProduceRq>.
     * @return the ServiceResponse<SubsidiaryListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<SubsidiaryListMsg> produceSubsidiary(ServiceRequest<SubsidiaryProduceRq> rq)
            throws ProduceException;

    /**
     * Missing description at method produceCorporation.
     *
     * @param rq the ServiceRequest<CorporationProduceRq>.
     * @return the ServiceResponse<CorporationListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<CorporationListMsg> produceCorporation(ServiceRequest<CorporationProduceRq> rq)
            throws ProduceException;

    /**
     * Missing description at method produceCustomer.
     *
     * @param rq the ServiceRequest<CustomerProduceRq>.
     * @return the ServiceResponse<CustomerListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<CustomerListMsg> produceCustomer(ServiceRequest<CustomerProduceRq> rq) throws ProduceException;

    /**
     * Missing description at method produceCustomerDepartment.
     *
     * @param rq the ServiceRequest<CustomerProduceRq>.
     * @return the ServiceResponse<CustomerListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<CustomerListMsg> produceCustomerDepartment(ServiceRequest<CustomerProduceRq> rq)
            throws ProduceException;

    /**
     * Missing description at method produceVendor.
     *
     * @param rq the ServiceRequest<VendorProduceRq>.
     * @return the ServiceResponse<VendorListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<VendorListMsg> produceVendor(ServiceRequest<VendorProduceRq> rq) throws ProduceException;

    /**
     * Missing description at method produceWorkingTime.
     *
     * @param rq the ServiceRequest<WorkingTimeProduceRq>.
     * @return the ServiceResponse<WorkingTimeListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<WorkingTimeListMsg> produceWorkingTime(ServiceRequest<WorkingTimeProduceRq> rq)
            throws ProduceException;

    /**
     * Missing description at method produceCreditReport.
     *
     * @param rq the ServiceRequest<CreditReportProduceRq>.
     * @return the ServiceResponse<CreditReportListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<CreditReportListMsg> produceCreditReport(ServiceRequest<CreditReportProduceRq> rq)
            throws ProduceException;

    /**
     * Missing description at method produceOrganizationStatistic.
     *
     * @param rq the ServiceRequest<OrganizationStatisticProduceRq>.
     * @return the ServiceResponse<OrganizationStatisticListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<OrganizationStatisticListMsg> produceOrganizationStatistic(
            ServiceRequest<OrganizationStatisticProduceRq> rq) throws ProduceException;

    /**
     * Missing description at method produceEUCorporation.
     *
     * @param rq the ServiceRequest<EUCorporationProduceRq>.
     * @return the ServiceResponse<EUCorporationListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<EUCorporationListMsg> produceEUCorporation(ServiceRequest<EUCorporationProduceRq> rq)
            throws ProduceException;

    /**
     * Missing description at method produceBusinessVolume.
     *
     * @param rq the ServiceRequest<BusinessVolumeProduceRq>.
     * @return the ServiceResponse<BusinessVolumeListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<BusinessVolumeListMsg> produceBusinessVolume(ServiceRequest<BusinessVolumeProduceRq> rq)
            throws ProduceException;

    /**
     * Missing description at method produceSector.
     *
     * @param rq the ServiceRequest<SectorProduceRq>.
     * @return the ServiceResponse<SectorListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<SectorListMsg> produceSector(ServiceRequest<SectorProduceRq> rq) throws ProduceException;
}
