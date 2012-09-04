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
package org.nabucco.business.organization.facade.service.maintain;

import org.nabucco.business.organization.facade.message.CorporationMsg;
import org.nabucco.business.organization.facade.message.CustomerMsg;
import org.nabucco.business.organization.facade.message.DepartmentMsg;
import org.nabucco.business.organization.facade.message.OrganizationMasterMsg;
import org.nabucco.business.organization.facade.message.SubsidiaryMsg;
import org.nabucco.business.organization.facade.message.VendorMsg;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * MaintainOrganization<p/>Maintain Service for Organization<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public interface MaintainOrganization extends Service {

    /**
     * Missing description at method maintainOrganizationMaster.
     *
     * @param rq the ServiceRequest<OrganizationMasterMsg>.
     * @return the ServiceResponse<OrganizationMasterMsg>.
     * @throws MaintainException
     */
    ServiceResponse<OrganizationMasterMsg> maintainOrganizationMaster(ServiceRequest<OrganizationMasterMsg> rq)
            throws MaintainException;

    /**
     * Missing description at method maintainDepartment.
     *
     * @param rq the ServiceRequest<DepartmentMsg>.
     * @return the ServiceResponse<DepartmentMsg>.
     * @throws MaintainException
     */
    ServiceResponse<DepartmentMsg> maintainDepartment(ServiceRequest<DepartmentMsg> rq) throws MaintainException;

    /**
     * Missing description at method maintainSubsidiary.
     *
     * @param rq the ServiceRequest<SubsidiaryMsg>.
     * @return the ServiceResponse<SubsidiaryMsg>.
     * @throws MaintainException
     */
    ServiceResponse<SubsidiaryMsg> maintainSubsidiary(ServiceRequest<SubsidiaryMsg> rq) throws MaintainException;

    /**
     * Missing description at method maintainCorporation.
     *
     * @param rq the ServiceRequest<CorporationMsg>.
     * @return the ServiceResponse<CorporationMsg>.
     * @throws MaintainException
     */
    ServiceResponse<CorporationMsg> maintainCorporation(ServiceRequest<CorporationMsg> rq) throws MaintainException;

    /**
     * Missing description at method maintainCustomer.
     *
     * @param rq the ServiceRequest<CustomerMsg>.
     * @return the ServiceResponse<CustomerMsg>.
     * @throws MaintainException
     */
    ServiceResponse<CustomerMsg> maintainCustomer(ServiceRequest<CustomerMsg> rq) throws MaintainException;

    /**
     * Missing description at method maintainCustomerDepartment.
     *
     * @param rq the ServiceRequest<CustomerMsg>.
     * @return the ServiceResponse<CustomerMsg>.
     * @throws MaintainException
     */
    ServiceResponse<CustomerMsg> maintainCustomerDepartment(ServiceRequest<CustomerMsg> rq) throws MaintainException;

    /**
     * Missing description at method maintainVendor.
     *
     * @param rq the ServiceRequest<VendorMsg>.
     * @return the ServiceResponse<VendorMsg>.
     * @throws MaintainException
     */
    ServiceResponse<VendorMsg> maintainVendor(ServiceRequest<VendorMsg> rq) throws MaintainException;
}
