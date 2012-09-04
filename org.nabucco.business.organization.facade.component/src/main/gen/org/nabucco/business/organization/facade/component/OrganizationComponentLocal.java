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
package org.nabucco.business.organization.facade.component;

import org.nabucco.business.organization.facade.service.corporationstructure.CorporationStructure;
import org.nabucco.business.organization.facade.service.maintain.MaintainOrganization;
import org.nabucco.business.organization.facade.service.produce.ProduceOrganization;
import org.nabucco.business.organization.facade.service.resolve.ResolveOrganization;
import org.nabucco.business.organization.facade.service.search.SearchOrganization;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;

/**
 * OrganizationComponentLocal<p/>Organization component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public interface OrganizationComponentLocal extends OrganizationComponent {

    /**
     * Getter for the ComponentRelationServiceLocal.
     *
     * @return the ComponentRelationService.
     * @throws ServiceException
     */
    ComponentRelationService getComponentRelationServiceLocal() throws ServiceException;

    /**
     * Getter for the QueryFilterServiceLocal.
     *
     * @return the QueryFilterService.
     * @throws ServiceException
     */
    QueryFilterService getQueryFilterServiceLocal() throws ServiceException;

    /**
     * Getter for the MaintainOrganizationLocal.
     *
     * @return the MaintainOrganization.
     * @throws ServiceException
     */
    MaintainOrganization getMaintainOrganizationLocal() throws ServiceException;

    /**
     * Getter for the ProduceOrganizationLocal.
     *
     * @return the ProduceOrganization.
     * @throws ServiceException
     */
    ProduceOrganization getProduceOrganizationLocal() throws ServiceException;

    /**
     * Getter for the ResolveOrganizationLocal.
     *
     * @return the ResolveOrganization.
     * @throws ServiceException
     */
    ResolveOrganization getResolveOrganizationLocal() throws ServiceException;

    /**
     * Getter for the SearchOrganizationLocal.
     *
     * @return the SearchOrganization.
     * @throws ServiceException
     */
    SearchOrganization getSearchOrganizationLocal() throws ServiceException;

    /**
     * Getter for the CorporationStructureLocal.
     *
     * @return the CorporationStructure.
     * @throws ServiceException
     */
    CorporationStructure getCorporationStructureLocal() throws ServiceException;
}
