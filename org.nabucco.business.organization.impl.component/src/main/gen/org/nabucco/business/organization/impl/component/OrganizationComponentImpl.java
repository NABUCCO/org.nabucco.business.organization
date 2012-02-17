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
package org.nabucco.business.organization.impl.component;

import org.nabucco.business.organization.facade.component.OrganizationComponentLocal;
import org.nabucco.business.organization.facade.component.OrganizationComponentRemote;
import org.nabucco.business.organization.facade.service.corporationstructure.CorporationStructure;
import org.nabucco.business.organization.facade.service.maintain.MaintainOrganization;
import org.nabucco.business.organization.facade.service.produce.ProduceOrganization;
import org.nabucco.business.organization.facade.service.resolve.ResolveOrganization;
import org.nabucco.business.organization.facade.service.search.SearchOrganization;
import org.nabucco.framework.base.facade.component.handler.PostConstructHandler;
import org.nabucco.framework.base.facade.component.handler.PreDestroyHandler;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;
import org.nabucco.framework.base.impl.component.ComponentSupport;

/**
 * OrganizationComponentImpl<p/>Organization component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class OrganizationComponentImpl extends ComponentSupport implements OrganizationComponentLocal,
        OrganizationComponentRemote {

    private static final long serialVersionUID = 1L;

    private static final String ID = "OrganizationComponent";

    /** Constructs a new OrganizationComponentImpl instance. */
    public OrganizationComponentImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PostConstructHandler handler = injector.inject(PostConstructHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No post construct handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PreDestroyHandler handler = injector.inject(PreDestroyHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No pre destroy handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getName() {
        return COMPONENT_NAME;
    }

    @Override
    public String getJndiName() {
        return JNDI_NAME;
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return super.lookup(OrganizationComponentJndiNames.COMPONENT_RELATION_SERVICE_REMOTE,
                ComponentRelationService.class);
    }

    @Override
    public ComponentRelationService getComponentRelationServiceLocal() throws ServiceException {
        return super.lookup(OrganizationComponentJndiNames.COMPONENT_RELATION_SERVICE_LOCAL,
                ComponentRelationService.class);
    }

    @Override
    public QueryFilterService getQueryFilterService() throws ServiceException {
        return super.lookup(OrganizationComponentJndiNames.QUERY_FILTER_SERVICE_REMOTE, QueryFilterService.class);
    }

    @Override
    public QueryFilterService getQueryFilterServiceLocal() throws ServiceException {
        return super.lookup(OrganizationComponentJndiNames.QUERY_FILTER_SERVICE_LOCAL, QueryFilterService.class);
    }

    @Override
    public MaintainOrganization getMaintainOrganizationLocal() throws ServiceException {
        return super.lookup(OrganizationComponentJndiNames.MAINTAIN_ORGANIZATION_LOCAL, MaintainOrganization.class);
    }

    @Override
    public MaintainOrganization getMaintainOrganization() throws ServiceException {
        return super.lookup(OrganizationComponentJndiNames.MAINTAIN_ORGANIZATION_REMOTE, MaintainOrganization.class);
    }

    @Override
    public ProduceOrganization getProduceOrganizationLocal() throws ServiceException {
        return super.lookup(OrganizationComponentJndiNames.PRODUCE_ORGANIZATION_LOCAL, ProduceOrganization.class);
    }

    @Override
    public ProduceOrganization getProduceOrganization() throws ServiceException {
        return super.lookup(OrganizationComponentJndiNames.PRODUCE_ORGANIZATION_REMOTE, ProduceOrganization.class);
    }

    @Override
    public ResolveOrganization getResolveOrganizationLocal() throws ServiceException {
        return super.lookup(OrganizationComponentJndiNames.RESOLVE_ORGANIZATION_LOCAL, ResolveOrganization.class);
    }

    @Override
    public ResolveOrganization getResolveOrganization() throws ServiceException {
        return super.lookup(OrganizationComponentJndiNames.RESOLVE_ORGANIZATION_REMOTE, ResolveOrganization.class);
    }

    @Override
    public SearchOrganization getSearchOrganizationLocal() throws ServiceException {
        return super.lookup(OrganizationComponentJndiNames.SEARCH_ORGANIZATION_LOCAL, SearchOrganization.class);
    }

    @Override
    public SearchOrganization getSearchOrganization() throws ServiceException {
        return super.lookup(OrganizationComponentJndiNames.SEARCH_ORGANIZATION_REMOTE, SearchOrganization.class);
    }

    @Override
    public CorporationStructure getCorporationStructureLocal() throws ServiceException {
        return super.lookup(OrganizationComponentJndiNames.CORPORATION_STRUCTURE_LOCAL, CorporationStructure.class);
    }

    @Override
    public CorporationStructure getCorporationStructure() throws ServiceException {
        return super.lookup(OrganizationComponentJndiNames.CORPORATION_STRUCTURE_REMOTE, CorporationStructure.class);
    }
}
