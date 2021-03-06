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
package org.nabucco.business.organization.impl.service.corporationstructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.business.organization.facade.message.CustomerListMsg;
import org.nabucco.business.organization.facade.message.corporationstructure.CorporationStructureDeleteDependencyRq;
import org.nabucco.business.organization.facade.message.corporationstructure.CorporationStructureSearchDependenciesRq;
import org.nabucco.business.organization.facade.service.corporationstructure.CorporationStructure;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * CorporationStructureImpl<p/>CorporationStructure Service<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-05-25
 */
public class CorporationStructureImpl extends ServiceSupport implements CorporationStructure {

    private static final long serialVersionUID = 1L;

    private static final String ID = "CorporationStructure";

    private static Map<String, String[]> ASPECTS;

    private SearchDependenciesServiceHandler searchDependenciesServiceHandler;

    private DeleteDepenendencyServiceHandler deleteDepenendencyServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new CorporationStructureImpl instance. */
    public CorporationStructureImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.searchDependenciesServiceHandler = injector.inject(SearchDependenciesServiceHandler.getId());
        if ((this.searchDependenciesServiceHandler != null)) {
            this.searchDependenciesServiceHandler.setPersistenceManager(persistenceManager);
            this.searchDependenciesServiceHandler.setLogger(super.getLogger());
        }
        this.deleteDepenendencyServiceHandler = injector.inject(DeleteDepenendencyServiceHandler.getId());
        if ((this.deleteDepenendencyServiceHandler != null)) {
            this.deleteDepenendencyServiceHandler.setPersistenceManager(persistenceManager);
            this.deleteDepenendencyServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("searchDependencies", NO_ASPECTS);
            ASPECTS.put("deleteDepenendency", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<CustomerListMsg> searchDependencies(
            ServiceRequest<CorporationStructureSearchDependenciesRq> rq) throws SearchException {
        if ((this.searchDependenciesServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchDependencies().");
            throw new InjectionException("No service implementation configured for searchDependencies().");
        }
        ServiceResponse<CustomerListMsg> rs;
        this.searchDependenciesServiceHandler.init();
        rs = this.searchDependenciesServiceHandler.invoke(rq);
        this.searchDependenciesServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<EmptyServiceMessage> deleteDepenendency(
            ServiceRequest<CorporationStructureDeleteDependencyRq> rq) throws MaintainException {
        if ((this.deleteDepenendencyServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for deleteDepenendency().");
            throw new InjectionException("No service implementation configured for deleteDepenendency().");
        }
        ServiceResponse<EmptyServiceMessage> rs;
        this.deleteDepenendencyServiceHandler.init();
        rs = this.deleteDepenendencyServiceHandler.invoke(rq);
        this.deleteDepenendencyServiceHandler.finish();
        return rs;
    }
}
