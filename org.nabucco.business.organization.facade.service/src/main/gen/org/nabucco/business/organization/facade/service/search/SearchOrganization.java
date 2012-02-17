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
package org.nabucco.business.organization.facade.service.search;

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
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * SearchOrganization<p/>Search Service for Organization<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public interface SearchOrganization extends Service {

    /**
     * Missing description at method searchOrganizationMaster.
     *
     * @param rq the ServiceRequest<OrganizationMasterSearchRq>.
     * @return the ServiceResponse<OrganizationMasterListMsg>.
     * @throws SearchException
     */
    ServiceResponse<OrganizationMasterListMsg> searchOrganizationMaster(ServiceRequest<OrganizationMasterSearchRq> rq)
            throws SearchException;

    /**
     * Missing description at method searchDepartment.
     *
     * @param rq the ServiceRequest<DepartmentSearchRq>.
     * @return the ServiceResponse<DepartmentListMsg>.
     * @throws SearchException
     */
    ServiceResponse<DepartmentListMsg> searchDepartment(ServiceRequest<DepartmentSearchRq> rq) throws SearchException;

    /**
     * Missing description at method searchSubsidiary.
     *
     * @param rq the ServiceRequest<SubsidiarySearchRq>.
     * @return the ServiceResponse<SubsidiaryListMsg>.
     * @throws SearchException
     */
    ServiceResponse<SubsidiaryListMsg> searchSubsidiary(ServiceRequest<SubsidiarySearchRq> rq) throws SearchException;

    /**
     * Missing description at method searchCorporation.
     *
     * @param rq the ServiceRequest<CorporationSearchRq>.
     * @return the ServiceResponse<CorporationListMsg>.
     * @throws SearchException
     */
    ServiceResponse<CorporationListMsg> searchCorporation(ServiceRequest<CorporationSearchRq> rq)
            throws SearchException;

    /**
     * Missing description at method searchCustomer.
     *
     * @param rq the ServiceRequest<CustomerSearchRq>.
     * @return the ServiceResponse<CustomerListMsg>.
     * @throws SearchException
     */
    ServiceResponse<CustomerListMsg> searchCustomer(ServiceRequest<CustomerSearchRq> rq) throws SearchException;

    /**
     * Missing description at method searchVendor.
     *
     * @param rq the ServiceRequest<VendorSearchRq>.
     * @return the ServiceResponse<VendorListMsg>.
     * @throws SearchException
     */
    ServiceResponse<VendorListMsg> searchVendor(ServiceRequest<VendorSearchRq> rq) throws SearchException;
}
