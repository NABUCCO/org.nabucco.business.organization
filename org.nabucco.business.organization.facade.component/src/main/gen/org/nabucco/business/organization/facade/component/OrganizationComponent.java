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
import org.nabucco.framework.base.facade.component.Component;
import org.nabucco.framework.base.facade.exception.service.ServiceException;

/**
 * OrganizationComponent<p/>Organization component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public interface OrganizationComponent extends Component {

    final String COMPONENT_NAME = "org.nabucco.business.organization";

    final String COMPONENT_PREFIX = "orga";

    final String JNDI_NAME = ((((JNDI_PREFIX + "/") + COMPONENT_NAME) + "/") + "org.nabucco.business.organization.facade.component.OrganizationComponent");

    /**
     * Getter for the MaintainOrganization.
     *
     * @return the MaintainOrganization.
     * @throws ServiceException
     */
    MaintainOrganization getMaintainOrganization() throws ServiceException;

    /**
     * Getter for the ProduceOrganization.
     *
     * @return the ProduceOrganization.
     * @throws ServiceException
     */
    ProduceOrganization getProduceOrganization() throws ServiceException;

    /**
     * Getter for the ResolveOrganization.
     *
     * @return the ResolveOrganization.
     * @throws ServiceException
     */
    ResolveOrganization getResolveOrganization() throws ServiceException;

    /**
     * Getter for the SearchOrganization.
     *
     * @return the SearchOrganization.
     * @throws ServiceException
     */
    SearchOrganization getSearchOrganization() throws ServiceException;

    /**
     * Getter for the CorporationStructure.
     *
     * @return the CorporationStructure.
     * @throws ServiceException
     */
    CorporationStructure getCorporationStructure() throws ServiceException;
}
