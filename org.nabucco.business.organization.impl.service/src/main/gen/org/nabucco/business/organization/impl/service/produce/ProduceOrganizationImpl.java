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
package org.nabucco.business.organization.impl.service.produce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
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
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * ProduceOrganizationImpl<p/>Produce Service for Organization<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class ProduceOrganizationImpl extends ServiceSupport implements ProduceOrganization {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProduceOrganization";

    private static Map<String, String[]> ASPECTS;

    private ProduceOrganizationMasterServiceHandler produceOrganizationMasterServiceHandler;

    private ProduceOrganizationRelationServiceHandler produceOrganizationRelationServiceHandler;

    private ProduceDepartmentServiceHandler produceDepartmentServiceHandler;

    private ProduceSubsidiaryServiceHandler produceSubsidiaryServiceHandler;

    private ProduceCorporationServiceHandler produceCorporationServiceHandler;

    private ProduceCustomerServiceHandler produceCustomerServiceHandler;

    private ProduceCustomerDepartmentServiceHandler produceCustomerDepartmentServiceHandler;

    private ProduceVendorServiceHandler produceVendorServiceHandler;

    private ProduceWorkingTimeServiceHandler produceWorkingTimeServiceHandler;

    private ProduceCreditReportServiceHandler produceCreditReportServiceHandler;

    private ProduceOrganizationStatisticServiceHandler produceOrganizationStatisticServiceHandler;

    private ProduceEUCorporationServiceHandler produceEUCorporationServiceHandler;

    private ProduceBusinessVolumeServiceHandler produceBusinessVolumeServiceHandler;

    private ProduceSectorServiceHandler produceSectorServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ProduceOrganizationImpl instance. */
    public ProduceOrganizationImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.produceOrganizationMasterServiceHandler = injector.inject(ProduceOrganizationMasterServiceHandler.getId());
        if ((this.produceOrganizationMasterServiceHandler != null)) {
            this.produceOrganizationMasterServiceHandler.setPersistenceManager(persistenceManager);
            this.produceOrganizationMasterServiceHandler.setLogger(super.getLogger());
        }
        this.produceOrganizationRelationServiceHandler = injector.inject(ProduceOrganizationRelationServiceHandler
                .getId());
        if ((this.produceOrganizationRelationServiceHandler != null)) {
            this.produceOrganizationRelationServiceHandler.setPersistenceManager(persistenceManager);
            this.produceOrganizationRelationServiceHandler.setLogger(super.getLogger());
        }
        this.produceDepartmentServiceHandler = injector.inject(ProduceDepartmentServiceHandler.getId());
        if ((this.produceDepartmentServiceHandler != null)) {
            this.produceDepartmentServiceHandler.setPersistenceManager(persistenceManager);
            this.produceDepartmentServiceHandler.setLogger(super.getLogger());
        }
        this.produceSubsidiaryServiceHandler = injector.inject(ProduceSubsidiaryServiceHandler.getId());
        if ((this.produceSubsidiaryServiceHandler != null)) {
            this.produceSubsidiaryServiceHandler.setPersistenceManager(persistenceManager);
            this.produceSubsidiaryServiceHandler.setLogger(super.getLogger());
        }
        this.produceCorporationServiceHandler = injector.inject(ProduceCorporationServiceHandler.getId());
        if ((this.produceCorporationServiceHandler != null)) {
            this.produceCorporationServiceHandler.setPersistenceManager(persistenceManager);
            this.produceCorporationServiceHandler.setLogger(super.getLogger());
        }
        this.produceCustomerServiceHandler = injector.inject(ProduceCustomerServiceHandler.getId());
        if ((this.produceCustomerServiceHandler != null)) {
            this.produceCustomerServiceHandler.setPersistenceManager(persistenceManager);
            this.produceCustomerServiceHandler.setLogger(super.getLogger());
        }
        this.produceCustomerDepartmentServiceHandler = injector.inject(ProduceCustomerDepartmentServiceHandler.getId());
        if ((this.produceCustomerDepartmentServiceHandler != null)) {
            this.produceCustomerDepartmentServiceHandler.setPersistenceManager(persistenceManager);
            this.produceCustomerDepartmentServiceHandler.setLogger(super.getLogger());
        }
        this.produceVendorServiceHandler = injector.inject(ProduceVendorServiceHandler.getId());
        if ((this.produceVendorServiceHandler != null)) {
            this.produceVendorServiceHandler.setPersistenceManager(persistenceManager);
            this.produceVendorServiceHandler.setLogger(super.getLogger());
        }
        this.produceWorkingTimeServiceHandler = injector.inject(ProduceWorkingTimeServiceHandler.getId());
        if ((this.produceWorkingTimeServiceHandler != null)) {
            this.produceWorkingTimeServiceHandler.setPersistenceManager(persistenceManager);
            this.produceWorkingTimeServiceHandler.setLogger(super.getLogger());
        }
        this.produceCreditReportServiceHandler = injector.inject(ProduceCreditReportServiceHandler.getId());
        if ((this.produceCreditReportServiceHandler != null)) {
            this.produceCreditReportServiceHandler.setPersistenceManager(persistenceManager);
            this.produceCreditReportServiceHandler.setLogger(super.getLogger());
        }
        this.produceOrganizationStatisticServiceHandler = injector.inject(ProduceOrganizationStatisticServiceHandler
                .getId());
        if ((this.produceOrganizationStatisticServiceHandler != null)) {
            this.produceOrganizationStatisticServiceHandler.setPersistenceManager(persistenceManager);
            this.produceOrganizationStatisticServiceHandler.setLogger(super.getLogger());
        }
        this.produceEUCorporationServiceHandler = injector.inject(ProduceEUCorporationServiceHandler.getId());
        if ((this.produceEUCorporationServiceHandler != null)) {
            this.produceEUCorporationServiceHandler.setPersistenceManager(persistenceManager);
            this.produceEUCorporationServiceHandler.setLogger(super.getLogger());
        }
        this.produceBusinessVolumeServiceHandler = injector.inject(ProduceBusinessVolumeServiceHandler.getId());
        if ((this.produceBusinessVolumeServiceHandler != null)) {
            this.produceBusinessVolumeServiceHandler.setPersistenceManager(persistenceManager);
            this.produceBusinessVolumeServiceHandler.setLogger(super.getLogger());
        }
        this.produceSectorServiceHandler = injector.inject(ProduceSectorServiceHandler.getId());
        if ((this.produceSectorServiceHandler != null)) {
            this.produceSectorServiceHandler.setPersistenceManager(persistenceManager);
            this.produceSectorServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("produceOrganizationMaster", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceOrganizationRelation", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceDepartment", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceSubsidiary", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceCorporation", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceCustomer", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceCustomerDepartment", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceVendor", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceWorkingTime", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceCreditReport", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceOrganizationStatistic", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceEUCorporation", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceBusinessVolume", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceSector", new String[] { "org.nabucco.aspect.initializing" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<OrganizationMasterListMsg> produceOrganizationMaster(
            ServiceRequest<OrganizationMasterProduceRq> rq) throws ProduceException {
        if ((this.produceOrganizationMasterServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceOrganizationMaster().");
            throw new InjectionException("No service implementation configured for produceOrganizationMaster().");
        }
        ServiceResponse<OrganizationMasterListMsg> rs;
        this.produceOrganizationMasterServiceHandler.init();
        rs = this.produceOrganizationMasterServiceHandler.invoke(rq);
        this.produceOrganizationMasterServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<OrganizationRelationListMsg> produceOrganizationRelation(
            ServiceRequest<OrganizationRelationProduceRq> rq) throws ProduceException {
        if ((this.produceOrganizationRelationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceOrganizationRelation().");
            throw new InjectionException("No service implementation configured for produceOrganizationRelation().");
        }
        ServiceResponse<OrganizationRelationListMsg> rs;
        this.produceOrganizationRelationServiceHandler.init();
        rs = this.produceOrganizationRelationServiceHandler.invoke(rq);
        this.produceOrganizationRelationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<DepartmentListMsg> produceDepartment(ServiceRequest<DepartmentProduceRq> rq)
            throws ProduceException {
        if ((this.produceDepartmentServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceDepartment().");
            throw new InjectionException("No service implementation configured for produceDepartment().");
        }
        ServiceResponse<DepartmentListMsg> rs;
        this.produceDepartmentServiceHandler.init();
        rs = this.produceDepartmentServiceHandler.invoke(rq);
        this.produceDepartmentServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<SubsidiaryListMsg> produceSubsidiary(ServiceRequest<SubsidiaryProduceRq> rq)
            throws ProduceException {
        if ((this.produceSubsidiaryServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceSubsidiary().");
            throw new InjectionException("No service implementation configured for produceSubsidiary().");
        }
        ServiceResponse<SubsidiaryListMsg> rs;
        this.produceSubsidiaryServiceHandler.init();
        rs = this.produceSubsidiaryServiceHandler.invoke(rq);
        this.produceSubsidiaryServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<CorporationListMsg> produceCorporation(ServiceRequest<CorporationProduceRq> rq)
            throws ProduceException {
        if ((this.produceCorporationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceCorporation().");
            throw new InjectionException("No service implementation configured for produceCorporation().");
        }
        ServiceResponse<CorporationListMsg> rs;
        this.produceCorporationServiceHandler.init();
        rs = this.produceCorporationServiceHandler.invoke(rq);
        this.produceCorporationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<CustomerListMsg> produceCustomer(ServiceRequest<CustomerProduceRq> rq)
            throws ProduceException {
        if ((this.produceCustomerServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceCustomer().");
            throw new InjectionException("No service implementation configured for produceCustomer().");
        }
        ServiceResponse<CustomerListMsg> rs;
        this.produceCustomerServiceHandler.init();
        rs = this.produceCustomerServiceHandler.invoke(rq);
        this.produceCustomerServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<CustomerListMsg> produceCustomerDepartment(ServiceRequest<CustomerProduceRq> rq)
            throws ProduceException {
        if ((this.produceCustomerDepartmentServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceCustomerDepartment().");
            throw new InjectionException("No service implementation configured for produceCustomerDepartment().");
        }
        ServiceResponse<CustomerListMsg> rs;
        this.produceCustomerDepartmentServiceHandler.init();
        rs = this.produceCustomerDepartmentServiceHandler.invoke(rq);
        this.produceCustomerDepartmentServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<VendorListMsg> produceVendor(ServiceRequest<VendorProduceRq> rq) throws ProduceException {
        if ((this.produceVendorServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceVendor().");
            throw new InjectionException("No service implementation configured for produceVendor().");
        }
        ServiceResponse<VendorListMsg> rs;
        this.produceVendorServiceHandler.init();
        rs = this.produceVendorServiceHandler.invoke(rq);
        this.produceVendorServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<WorkingTimeListMsg> produceWorkingTime(ServiceRequest<WorkingTimeProduceRq> rq)
            throws ProduceException {
        if ((this.produceWorkingTimeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceWorkingTime().");
            throw new InjectionException("No service implementation configured for produceWorkingTime().");
        }
        ServiceResponse<WorkingTimeListMsg> rs;
        this.produceWorkingTimeServiceHandler.init();
        rs = this.produceWorkingTimeServiceHandler.invoke(rq);
        this.produceWorkingTimeServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<CreditReportListMsg> produceCreditReport(ServiceRequest<CreditReportProduceRq> rq)
            throws ProduceException {
        if ((this.produceCreditReportServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceCreditReport().");
            throw new InjectionException("No service implementation configured for produceCreditReport().");
        }
        ServiceResponse<CreditReportListMsg> rs;
        this.produceCreditReportServiceHandler.init();
        rs = this.produceCreditReportServiceHandler.invoke(rq);
        this.produceCreditReportServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<OrganizationStatisticListMsg> produceOrganizationStatistic(
            ServiceRequest<OrganizationStatisticProduceRq> rq) throws ProduceException {
        if ((this.produceOrganizationStatisticServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceOrganizationStatistic().");
            throw new InjectionException("No service implementation configured for produceOrganizationStatistic().");
        }
        ServiceResponse<OrganizationStatisticListMsg> rs;
        this.produceOrganizationStatisticServiceHandler.init();
        rs = this.produceOrganizationStatisticServiceHandler.invoke(rq);
        this.produceOrganizationStatisticServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<EUCorporationListMsg> produceEUCorporation(ServiceRequest<EUCorporationProduceRq> rq)
            throws ProduceException {
        if ((this.produceEUCorporationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceEUCorporation().");
            throw new InjectionException("No service implementation configured for produceEUCorporation().");
        }
        ServiceResponse<EUCorporationListMsg> rs;
        this.produceEUCorporationServiceHandler.init();
        rs = this.produceEUCorporationServiceHandler.invoke(rq);
        this.produceEUCorporationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<BusinessVolumeListMsg> produceBusinessVolume(ServiceRequest<BusinessVolumeProduceRq> rq)
            throws ProduceException {
        if ((this.produceBusinessVolumeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceBusinessVolume().");
            throw new InjectionException("No service implementation configured for produceBusinessVolume().");
        }
        ServiceResponse<BusinessVolumeListMsg> rs;
        this.produceBusinessVolumeServiceHandler.init();
        rs = this.produceBusinessVolumeServiceHandler.invoke(rq);
        this.produceBusinessVolumeServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<SectorListMsg> produceSector(ServiceRequest<SectorProduceRq> rq) throws ProduceException {
        if ((this.produceSectorServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceSector().");
            throw new InjectionException("No service implementation configured for produceSector().");
        }
        ServiceResponse<SectorListMsg> rs;
        this.produceSectorServiceHandler.init();
        rs = this.produceSectorServiceHandler.invoke(rq);
        this.produceSectorServiceHandler.finish();
        return rs;
    }
}
