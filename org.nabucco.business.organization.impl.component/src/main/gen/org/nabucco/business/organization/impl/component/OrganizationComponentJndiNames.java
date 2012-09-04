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
package org.nabucco.business.organization.impl.component;

/**
 * OrganizationComponentJndiNames<p/>Organization component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public interface OrganizationComponentJndiNames {

    final String COMPONENT_RELATION_SERVICE_LOCAL = "nabucco/org.nabucco.business.organization/org.nabucco.business.organization.facade.component.ComponentRelationService/local";

    final String COMPONENT_RELATION_SERVICE_REMOTE = "nabucco/org.nabucco.business.organization/org.nabucco.business.organization.facade.component.ComponentRelationService/remote";

    final String QUERY_FILTER_SERVICE_LOCAL = "nabucco/org.nabucco.business.organization/org.nabucco.business.organization.facade.component.QueryFilterService/local";

    final String QUERY_FILTER_SERVICE_REMOTE = "nabucco/org.nabucco.business.organization/org.nabucco.business.organization.facade.component.QueryFilterService/remote";

    final String MAINTAIN_ORGANIZATION_LOCAL = "nabucco/org.nabucco.business.organization/org.nabucco.business.organization.facade.service.maintain.MaintainOrganization/local";

    final String MAINTAIN_ORGANIZATION_REMOTE = "nabucco/org.nabucco.business.organization/org.nabucco.business.organization.facade.service.maintain.MaintainOrganization/remote";

    final String PRODUCE_ORGANIZATION_LOCAL = "nabucco/org.nabucco.business.organization/org.nabucco.business.organization.facade.service.produce.ProduceOrganization/local";

    final String PRODUCE_ORGANIZATION_REMOTE = "nabucco/org.nabucco.business.organization/org.nabucco.business.organization.facade.service.produce.ProduceOrganization/remote";

    final String RESOLVE_ORGANIZATION_LOCAL = "nabucco/org.nabucco.business.organization/org.nabucco.business.organization.facade.service.resolve.ResolveOrganization/local";

    final String RESOLVE_ORGANIZATION_REMOTE = "nabucco/org.nabucco.business.organization/org.nabucco.business.organization.facade.service.resolve.ResolveOrganization/remote";

    final String SEARCH_ORGANIZATION_LOCAL = "nabucco/org.nabucco.business.organization/org.nabucco.business.organization.facade.service.search.SearchOrganization/local";

    final String SEARCH_ORGANIZATION_REMOTE = "nabucco/org.nabucco.business.organization/org.nabucco.business.organization.facade.service.search.SearchOrganization/remote";

    final String CORPORATION_STRUCTURE_LOCAL = "nabucco/org.nabucco.business.organization/org.nabucco.business.organization.facade.service.corporationstructure.CorporationStructure/local";

    final String CORPORATION_STRUCTURE_REMOTE = "nabucco/org.nabucco.business.organization/org.nabucco.business.organization.facade.service.corporationstructure.CorporationStructure/remote";
}
