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
package org.nabucco.business.organization.facade.service.resolve;

import org.nabucco.business.organization.facade.message.CorporationMsg;
import org.nabucco.business.organization.facade.message.CustomerMsg;
import org.nabucco.business.organization.facade.message.DepartmentMsg;
import org.nabucco.business.organization.facade.message.OrganizationMasterMsg;
import org.nabucco.business.organization.facade.message.SubsidiaryMsg;
import org.nabucco.business.organization.facade.message.VendorMsg;
import org.nabucco.business.organization.facade.message.resolve.ResolveDatatypeListRq;
import org.nabucco.business.organization.facade.message.resolve.ResolveDatatypeListRs;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * ResolveOrganization<p/>Resolve Service for Organization<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public interface ResolveOrganization extends Service {

    /**
     * Missing description at method resolveOrganizationMaster.
     *
     * @param rq the ServiceRequest<OrganizationMasterMsg>.
     * @return the ServiceResponse<OrganizationMasterMsg>.
     * @throws ResolveException
     */
    ServiceResponse<OrganizationMasterMsg> resolveOrganizationMaster(ServiceRequest<OrganizationMasterMsg> rq)
            throws ResolveException;

    /**
     * Missing description at method resolveDepartment.
     *
     * @param rq the ServiceRequest<DepartmentMsg>.
     * @return the ServiceResponse<DepartmentMsg>.
     * @throws ResolveException
     */
    ServiceResponse<DepartmentMsg> resolveDepartment(ServiceRequest<DepartmentMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolveSubsidiary.
     *
     * @param rq the ServiceRequest<SubsidiaryMsg>.
     * @return the ServiceResponse<SubsidiaryMsg>.
     * @throws ResolveException
     */
    ServiceResponse<SubsidiaryMsg> resolveSubsidiary(ServiceRequest<SubsidiaryMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolveCorporation.
     *
     * @param rq the ServiceRequest<CorporationMsg>.
     * @return the ServiceResponse<CorporationMsg>.
     * @throws ResolveException
     */
    ServiceResponse<CorporationMsg> resolveCorporation(ServiceRequest<CorporationMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolveCustomer.
     *
     * @param rq the ServiceRequest<CustomerMsg>.
     * @return the ServiceResponse<CustomerMsg>.
     * @throws ResolveException
     */
    ServiceResponse<CustomerMsg> resolveCustomer(ServiceRequest<CustomerMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolveCustomerDepartment.
     *
     * @param rq the ServiceRequest<CustomerMsg>.
     * @return the ServiceResponse<CustomerMsg>.
     * @throws ResolveException
     */
    ServiceResponse<CustomerMsg> resolveCustomerDepartment(ServiceRequest<CustomerMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolveVendor.
     *
     * @param rq the ServiceRequest<VendorMsg>.
     * @return the ServiceResponse<VendorMsg>.
     * @throws ResolveException
     */
    ServiceResponse<VendorMsg> resolveVendor(ServiceRequest<VendorMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolveDatatypeList.
     *
     * @param rq the ServiceRequest<ResolveDatatypeListRq>.
     * @return the ServiceResponse<ResolveDatatypeListRs>.
     * @throws ResolveException
     */
    ServiceResponse<ResolveDatatypeListRs> resolveDatatypeList(ServiceRequest<ResolveDatatypeListRq> rq)
            throws ResolveException;
}
