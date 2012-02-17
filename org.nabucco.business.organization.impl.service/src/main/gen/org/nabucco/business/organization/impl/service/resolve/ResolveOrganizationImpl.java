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
package org.nabucco.business.organization.impl.service.resolve;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.business.organization.facade.message.CorporationMsg;
import org.nabucco.business.organization.facade.message.CustomerMsg;
import org.nabucco.business.organization.facade.message.DepartmentMsg;
import org.nabucco.business.organization.facade.message.OrganizationMasterMsg;
import org.nabucco.business.organization.facade.message.SubsidiaryMsg;
import org.nabucco.business.organization.facade.message.VendorMsg;
import org.nabucco.business.organization.facade.message.resolve.ResolveDatatypeListRq;
import org.nabucco.business.organization.facade.message.resolve.ResolveDatatypeListRs;
import org.nabucco.business.organization.facade.service.resolve.ResolveOrganization;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * ResolveOrganizationImpl<p/>Resolve Service for Organization<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class ResolveOrganizationImpl extends ServiceSupport implements ResolveOrganization {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ResolveOrganization";

    private static Map<String, String[]> ASPECTS;

    private ResolveOrganizationMasterServiceHandler resolveOrganizationMasterServiceHandler;

    private ResolveDepartmentServiceHandler resolveDepartmentServiceHandler;

    private ResolveSubsidiaryServiceHandler resolveSubsidiaryServiceHandler;

    private ResolveCorporationServiceHandler resolveCorporationServiceHandler;

    private ResolveCustomerServiceHandler resolveCustomerServiceHandler;

    private ResolveCustomerDepartmentServiceHandler resolveCustomerDepartmentServiceHandler;

    private ResolveVendorServiceHandler resolveVendorServiceHandler;

    private ResolveDatatypeListServiceHandler resolveDatatypeListServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ResolveOrganizationImpl instance. */
    public ResolveOrganizationImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.resolveOrganizationMasterServiceHandler = injector.inject(ResolveOrganizationMasterServiceHandler.getId());
        if ((this.resolveOrganizationMasterServiceHandler != null)) {
            this.resolveOrganizationMasterServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveOrganizationMasterServiceHandler.setLogger(super.getLogger());
        }
        this.resolveDepartmentServiceHandler = injector.inject(ResolveDepartmentServiceHandler.getId());
        if ((this.resolveDepartmentServiceHandler != null)) {
            this.resolveDepartmentServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveDepartmentServiceHandler.setLogger(super.getLogger());
        }
        this.resolveSubsidiaryServiceHandler = injector.inject(ResolveSubsidiaryServiceHandler.getId());
        if ((this.resolveSubsidiaryServiceHandler != null)) {
            this.resolveSubsidiaryServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveSubsidiaryServiceHandler.setLogger(super.getLogger());
        }
        this.resolveCorporationServiceHandler = injector.inject(ResolveCorporationServiceHandler.getId());
        if ((this.resolveCorporationServiceHandler != null)) {
            this.resolveCorporationServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveCorporationServiceHandler.setLogger(super.getLogger());
        }
        this.resolveCustomerServiceHandler = injector.inject(ResolveCustomerServiceHandler.getId());
        if ((this.resolveCustomerServiceHandler != null)) {
            this.resolveCustomerServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveCustomerServiceHandler.setLogger(super.getLogger());
        }
        this.resolveCustomerDepartmentServiceHandler = injector.inject(ResolveCustomerDepartmentServiceHandler.getId());
        if ((this.resolveCustomerDepartmentServiceHandler != null)) {
            this.resolveCustomerDepartmentServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveCustomerDepartmentServiceHandler.setLogger(super.getLogger());
        }
        this.resolveVendorServiceHandler = injector.inject(ResolveVendorServiceHandler.getId());
        if ((this.resolveVendorServiceHandler != null)) {
            this.resolveVendorServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveVendorServiceHandler.setLogger(super.getLogger());
        }
        this.resolveDatatypeListServiceHandler = injector.inject(ResolveDatatypeListServiceHandler.getId());
        if ((this.resolveDatatypeListServiceHandler != null)) {
            this.resolveDatatypeListServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveDatatypeListServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("resolveOrganizationMaster", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveDepartment", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveSubsidiary", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveCorporation", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveCustomer", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.journaling", "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveCustomerDepartment", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveVendor", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveDatatypeList", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<OrganizationMasterMsg> resolveOrganizationMaster(ServiceRequest<OrganizationMasterMsg> rq)
            throws ResolveException {
        if ((this.resolveOrganizationMasterServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveOrganizationMaster().");
            throw new InjectionException("No service implementation configured for resolveOrganizationMaster().");
        }
        ServiceResponse<OrganizationMasterMsg> rs;
        this.resolveOrganizationMasterServiceHandler.init();
        rs = this.resolveOrganizationMasterServiceHandler.invoke(rq);
        this.resolveOrganizationMasterServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<DepartmentMsg> resolveDepartment(ServiceRequest<DepartmentMsg> rq) throws ResolveException {
        if ((this.resolveDepartmentServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveDepartment().");
            throw new InjectionException("No service implementation configured for resolveDepartment().");
        }
        ServiceResponse<DepartmentMsg> rs;
        this.resolveDepartmentServiceHandler.init();
        rs = this.resolveDepartmentServiceHandler.invoke(rq);
        this.resolveDepartmentServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<SubsidiaryMsg> resolveSubsidiary(ServiceRequest<SubsidiaryMsg> rq) throws ResolveException {
        if ((this.resolveSubsidiaryServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveSubsidiary().");
            throw new InjectionException("No service implementation configured for resolveSubsidiary().");
        }
        ServiceResponse<SubsidiaryMsg> rs;
        this.resolveSubsidiaryServiceHandler.init();
        rs = this.resolveSubsidiaryServiceHandler.invoke(rq);
        this.resolveSubsidiaryServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<CorporationMsg> resolveCorporation(ServiceRequest<CorporationMsg> rq)
            throws ResolveException {
        if ((this.resolveCorporationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveCorporation().");
            throw new InjectionException("No service implementation configured for resolveCorporation().");
        }
        ServiceResponse<CorporationMsg> rs;
        this.resolveCorporationServiceHandler.init();
        rs = this.resolveCorporationServiceHandler.invoke(rq);
        this.resolveCorporationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<CustomerMsg> resolveCustomer(ServiceRequest<CustomerMsg> rq) throws ResolveException {
        if ((this.resolveCustomerServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveCustomer().");
            throw new InjectionException("No service implementation configured for resolveCustomer().");
        }
        ServiceResponse<CustomerMsg> rs;
        this.resolveCustomerServiceHandler.init();
        rs = this.resolveCustomerServiceHandler.invoke(rq);
        this.resolveCustomerServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<CustomerMsg> resolveCustomerDepartment(ServiceRequest<CustomerMsg> rq)
            throws ResolveException {
        if ((this.resolveCustomerDepartmentServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveCustomerDepartment().");
            throw new InjectionException("No service implementation configured for resolveCustomerDepartment().");
        }
        ServiceResponse<CustomerMsg> rs;
        this.resolveCustomerDepartmentServiceHandler.init();
        rs = this.resolveCustomerDepartmentServiceHandler.invoke(rq);
        this.resolveCustomerDepartmentServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<VendorMsg> resolveVendor(ServiceRequest<VendorMsg> rq) throws ResolveException {
        if ((this.resolveVendorServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveVendor().");
            throw new InjectionException("No service implementation configured for resolveVendor().");
        }
        ServiceResponse<VendorMsg> rs;
        this.resolveVendorServiceHandler.init();
        rs = this.resolveVendorServiceHandler.invoke(rq);
        this.resolveVendorServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ResolveDatatypeListRs> resolveDatatypeList(ServiceRequest<ResolveDatatypeListRq> rq)
            throws ResolveException {
        if ((this.resolveDatatypeListServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveDatatypeList().");
            throw new InjectionException("No service implementation configured for resolveDatatypeList().");
        }
        ServiceResponse<ResolveDatatypeListRs> rs;
        this.resolveDatatypeListServiceHandler.init();
        rs = this.resolveDatatypeListServiceHandler.invoke(rq);
        this.resolveDatatypeListServiceHandler.finish();
        return rs;
    }
}
