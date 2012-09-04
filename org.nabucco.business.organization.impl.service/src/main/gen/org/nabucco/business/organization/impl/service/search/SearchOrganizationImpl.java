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
package org.nabucco.business.organization.impl.service.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
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
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * SearchOrganizationImpl<p/>Search Service for Organization<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class SearchOrganizationImpl extends ServiceSupport implements SearchOrganization {

    private static final long serialVersionUID = 1L;

    private static final String ID = "SearchOrganization";

    private static Map<String, String[]> ASPECTS;

    private SearchOrganizationMasterServiceHandler searchOrganizationMasterServiceHandler;

    private SearchDepartmentServiceHandler searchDepartmentServiceHandler;

    private SearchSubsidiaryServiceHandler searchSubsidiaryServiceHandler;

    private SearchCorporationServiceHandler searchCorporationServiceHandler;

    private SearchCustomerServiceHandler searchCustomerServiceHandler;

    private SearchVendorServiceHandler searchVendorServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new SearchOrganizationImpl instance. */
    public SearchOrganizationImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.searchOrganizationMasterServiceHandler = injector.inject(SearchOrganizationMasterServiceHandler.getId());
        if ((this.searchOrganizationMasterServiceHandler != null)) {
            this.searchOrganizationMasterServiceHandler.setPersistenceManager(persistenceManager);
            this.searchOrganizationMasterServiceHandler.setLogger(super.getLogger());
        }
        this.searchDepartmentServiceHandler = injector.inject(SearchDepartmentServiceHandler.getId());
        if ((this.searchDepartmentServiceHandler != null)) {
            this.searchDepartmentServiceHandler.setPersistenceManager(persistenceManager);
            this.searchDepartmentServiceHandler.setLogger(super.getLogger());
        }
        this.searchSubsidiaryServiceHandler = injector.inject(SearchSubsidiaryServiceHandler.getId());
        if ((this.searchSubsidiaryServiceHandler != null)) {
            this.searchSubsidiaryServiceHandler.setPersistenceManager(persistenceManager);
            this.searchSubsidiaryServiceHandler.setLogger(super.getLogger());
        }
        this.searchCorporationServiceHandler = injector.inject(SearchCorporationServiceHandler.getId());
        if ((this.searchCorporationServiceHandler != null)) {
            this.searchCorporationServiceHandler.setPersistenceManager(persistenceManager);
            this.searchCorporationServiceHandler.setLogger(super.getLogger());
        }
        this.searchCustomerServiceHandler = injector.inject(SearchCustomerServiceHandler.getId());
        if ((this.searchCustomerServiceHandler != null)) {
            this.searchCustomerServiceHandler.setPersistenceManager(persistenceManager);
            this.searchCustomerServiceHandler.setLogger(super.getLogger());
        }
        this.searchVendorServiceHandler = injector.inject(SearchVendorServiceHandler.getId());
        if ((this.searchVendorServiceHandler != null)) {
            this.searchVendorServiceHandler.setPersistenceManager(persistenceManager);
            this.searchVendorServiceHandler.setLogger(super.getLogger());
        }
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
    }

    @Override
    public String[] getAspects(String operationName) {
        if ((ASPECTS == null)) {
            ASPECTS = new HashMap<String, String[]>();
            ASPECTS.put("searchOrganizationMaster", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchDepartment", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchSubsidiary", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchCorporation", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchCustomer", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchVendor", new String[] { "org.nabucco.aspect.resolving" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<OrganizationMasterListMsg> searchOrganizationMaster(
            ServiceRequest<OrganizationMasterSearchRq> rq) throws SearchException {
        if ((this.searchOrganizationMasterServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchOrganizationMaster().");
            throw new InjectionException("No service implementation configured for searchOrganizationMaster().");
        }
        ServiceResponse<OrganizationMasterListMsg> rs;
        this.searchOrganizationMasterServiceHandler.init();
        rs = this.searchOrganizationMasterServiceHandler.invoke(rq);
        this.searchOrganizationMasterServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<DepartmentListMsg> searchDepartment(ServiceRequest<DepartmentSearchRq> rq)
            throws SearchException {
        if ((this.searchDepartmentServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchDepartment().");
            throw new InjectionException("No service implementation configured for searchDepartment().");
        }
        ServiceResponse<DepartmentListMsg> rs;
        this.searchDepartmentServiceHandler.init();
        rs = this.searchDepartmentServiceHandler.invoke(rq);
        this.searchDepartmentServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<SubsidiaryListMsg> searchSubsidiary(ServiceRequest<SubsidiarySearchRq> rq)
            throws SearchException {
        if ((this.searchSubsidiaryServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchSubsidiary().");
            throw new InjectionException("No service implementation configured for searchSubsidiary().");
        }
        ServiceResponse<SubsidiaryListMsg> rs;
        this.searchSubsidiaryServiceHandler.init();
        rs = this.searchSubsidiaryServiceHandler.invoke(rq);
        this.searchSubsidiaryServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<CorporationListMsg> searchCorporation(ServiceRequest<CorporationSearchRq> rq)
            throws SearchException {
        if ((this.searchCorporationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchCorporation().");
            throw new InjectionException("No service implementation configured for searchCorporation().");
        }
        ServiceResponse<CorporationListMsg> rs;
        this.searchCorporationServiceHandler.init();
        rs = this.searchCorporationServiceHandler.invoke(rq);
        this.searchCorporationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<CustomerListMsg> searchCustomer(ServiceRequest<CustomerSearchRq> rq) throws SearchException {
        if ((this.searchCustomerServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchCustomer().");
            throw new InjectionException("No service implementation configured for searchCustomer().");
        }
        ServiceResponse<CustomerListMsg> rs;
        this.searchCustomerServiceHandler.init();
        rs = this.searchCustomerServiceHandler.invoke(rq);
        this.searchCustomerServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<VendorListMsg> searchVendor(ServiceRequest<VendorSearchRq> rq) throws SearchException {
        if ((this.searchVendorServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchVendor().");
            throw new InjectionException("No service implementation configured for searchVendor().");
        }
        ServiceResponse<VendorListMsg> rs;
        this.searchVendorServiceHandler.init();
        rs = this.searchVendorServiceHandler.invoke(rq);
        this.searchVendorServiceHandler.finish();
        return rs;
    }
}
