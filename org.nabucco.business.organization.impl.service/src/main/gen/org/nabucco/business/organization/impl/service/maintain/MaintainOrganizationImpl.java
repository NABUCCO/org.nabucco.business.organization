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
package org.nabucco.business.organization.impl.service.maintain;

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
import org.nabucco.business.organization.facade.service.maintain.MaintainOrganization;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * MaintainOrganizationImpl<p/>Maintain Service for Organization<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class MaintainOrganizationImpl extends ServiceSupport implements MaintainOrganization {

    private static final long serialVersionUID = 1L;

    private static final String ID = "MaintainOrganization";

    private static Map<String, String[]> ASPECTS;

    private MaintainOrganizationMasterServiceHandler maintainOrganizationMasterServiceHandler;

    private MaintainDepartmentServiceHandler maintainDepartmentServiceHandler;

    private MaintainSubsidiaryServiceHandler maintainSubsidiaryServiceHandler;

    private MaintainCorporationServiceHandler maintainCorporationServiceHandler;

    private MaintainCustomerServiceHandler maintainCustomerServiceHandler;

    private MaintainCustomerDepartmentServiceHandler maintainCustomerDepartmentServiceHandler;

    private MaintainVendorServiceHandler maintainVendorServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new MaintainOrganizationImpl instance. */
    public MaintainOrganizationImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.maintainOrganizationMasterServiceHandler = injector.inject(MaintainOrganizationMasterServiceHandler
                .getId());
        if ((this.maintainOrganizationMasterServiceHandler != null)) {
            this.maintainOrganizationMasterServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainOrganizationMasterServiceHandler.setLogger(super.getLogger());
        }
        this.maintainDepartmentServiceHandler = injector.inject(MaintainDepartmentServiceHandler.getId());
        if ((this.maintainDepartmentServiceHandler != null)) {
            this.maintainDepartmentServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainDepartmentServiceHandler.setLogger(super.getLogger());
        }
        this.maintainSubsidiaryServiceHandler = injector.inject(MaintainSubsidiaryServiceHandler.getId());
        if ((this.maintainSubsidiaryServiceHandler != null)) {
            this.maintainSubsidiaryServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainSubsidiaryServiceHandler.setLogger(super.getLogger());
        }
        this.maintainCorporationServiceHandler = injector.inject(MaintainCorporationServiceHandler.getId());
        if ((this.maintainCorporationServiceHandler != null)) {
            this.maintainCorporationServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainCorporationServiceHandler.setLogger(super.getLogger());
        }
        this.maintainCustomerServiceHandler = injector.inject(MaintainCustomerServiceHandler.getId());
        if ((this.maintainCustomerServiceHandler != null)) {
            this.maintainCustomerServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainCustomerServiceHandler.setLogger(super.getLogger());
        }
        this.maintainCustomerDepartmentServiceHandler = injector.inject(MaintainCustomerDepartmentServiceHandler
                .getId());
        if ((this.maintainCustomerDepartmentServiceHandler != null)) {
            this.maintainCustomerDepartmentServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainCustomerDepartmentServiceHandler.setLogger(super.getLogger());
        }
        this.maintainVendorServiceHandler = injector.inject(MaintainVendorServiceHandler.getId());
        if ((this.maintainVendorServiceHandler != null)) {
            this.maintainVendorServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainVendorServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("maintainOrganizationMaster", new String[] { "org.nabucco.aspect.validating",
                    "org.nabucco.aspect.indexing", "org.nabucco.aspect.transitioning" });
            ASPECTS.put("maintainDepartment", new String[] { "org.nabucco.aspect.validating",
                    "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving", "org.nabucco.aspect.indexing",
                    "org.nabucco.aspect.journaling", "org.nabucco.aspect.transitioning" });
            ASPECTS.put("maintainSubsidiary", new String[] { "org.nabucco.aspect.validating",
                    "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving", "org.nabucco.aspect.indexing",
                    "org.nabucco.aspect.journaling", "org.nabucco.aspect.transitioning" });
            ASPECTS.put("maintainCorporation", new String[] { "org.nabucco.aspect.validating",
                    "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving", "org.nabucco.aspect.indexing",
                    "org.nabucco.aspect.journaling", "org.nabucco.aspect.transitioning" });
            ASPECTS.put("maintainCustomer", new String[] { "org.nabucco.aspect.validating",
                    "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving", "org.nabucco.aspect.indexing",
                    "org.nabucco.aspect.journaling", "org.nabucco.aspect.transitioning" });
            ASPECTS.put("maintainCustomerDepartment", new String[] { "org.nabucco.aspect.validating",
                    "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving", "org.nabucco.aspect.indexing",
                    "org.nabucco.aspect.journaling", "org.nabucco.aspect.transitioning" });
            ASPECTS.put("maintainVendor", new String[] { "org.nabucco.aspect.validating",
                    "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving", "org.nabucco.aspect.indexing",
                    "org.nabucco.aspect.journaling", "org.nabucco.aspect.transitioning" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<OrganizationMasterMsg> maintainOrganizationMaster(ServiceRequest<OrganizationMasterMsg> rq)
            throws MaintainException {
        if ((this.maintainOrganizationMasterServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainOrganizationMaster().");
            throw new InjectionException("No service implementation configured for maintainOrganizationMaster().");
        }
        ServiceResponse<OrganizationMasterMsg> rs;
        this.maintainOrganizationMasterServiceHandler.init();
        rs = this.maintainOrganizationMasterServiceHandler.invoke(rq);
        this.maintainOrganizationMasterServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<DepartmentMsg> maintainDepartment(ServiceRequest<DepartmentMsg> rq) throws MaintainException {
        if ((this.maintainDepartmentServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainDepartment().");
            throw new InjectionException("No service implementation configured for maintainDepartment().");
        }
        ServiceResponse<DepartmentMsg> rs;
        this.maintainDepartmentServiceHandler.init();
        rs = this.maintainDepartmentServiceHandler.invoke(rq);
        this.maintainDepartmentServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<SubsidiaryMsg> maintainSubsidiary(ServiceRequest<SubsidiaryMsg> rq) throws MaintainException {
        if ((this.maintainSubsidiaryServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainSubsidiary().");
            throw new InjectionException("No service implementation configured for maintainSubsidiary().");
        }
        ServiceResponse<SubsidiaryMsg> rs;
        this.maintainSubsidiaryServiceHandler.init();
        rs = this.maintainSubsidiaryServiceHandler.invoke(rq);
        this.maintainSubsidiaryServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<CorporationMsg> maintainCorporation(ServiceRequest<CorporationMsg> rq)
            throws MaintainException {
        if ((this.maintainCorporationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainCorporation().");
            throw new InjectionException("No service implementation configured for maintainCorporation().");
        }
        ServiceResponse<CorporationMsg> rs;
        this.maintainCorporationServiceHandler.init();
        rs = this.maintainCorporationServiceHandler.invoke(rq);
        this.maintainCorporationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<CustomerMsg> maintainCustomer(ServiceRequest<CustomerMsg> rq) throws MaintainException {
        if ((this.maintainCustomerServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainCustomer().");
            throw new InjectionException("No service implementation configured for maintainCustomer().");
        }
        ServiceResponse<CustomerMsg> rs;
        this.maintainCustomerServiceHandler.init();
        rs = this.maintainCustomerServiceHandler.invoke(rq);
        this.maintainCustomerServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<CustomerMsg> maintainCustomerDepartment(ServiceRequest<CustomerMsg> rq)
            throws MaintainException {
        if ((this.maintainCustomerDepartmentServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainCustomerDepartment().");
            throw new InjectionException("No service implementation configured for maintainCustomerDepartment().");
        }
        ServiceResponse<CustomerMsg> rs;
        this.maintainCustomerDepartmentServiceHandler.init();
        rs = this.maintainCustomerDepartmentServiceHandler.invoke(rq);
        this.maintainCustomerDepartmentServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<VendorMsg> maintainVendor(ServiceRequest<VendorMsg> rq) throws MaintainException {
        if ((this.maintainVendorServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainVendor().");
            throw new InjectionException("No service implementation configured for maintainVendor().");
        }
        ServiceResponse<VendorMsg> rs;
        this.maintainVendorServiceHandler.init();
        rs = this.maintainVendorServiceHandler.invoke(rq);
        this.maintainVendorServiceHandler.finish();
        return rs;
    }
}
