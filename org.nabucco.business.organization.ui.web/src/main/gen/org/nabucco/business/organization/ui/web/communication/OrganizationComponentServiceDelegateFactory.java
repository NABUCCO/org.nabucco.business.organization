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
package org.nabucco.business.organization.ui.web.communication;

import org.nabucco.business.organization.facade.component.OrganizationComponent;
import org.nabucco.business.organization.facade.component.OrganizationComponentLocator;
import org.nabucco.business.organization.ui.web.communication.corporationstructure.CorporationStructureDelegate;
import org.nabucco.business.organization.ui.web.communication.maintain.MaintainOrganizationDelegate;
import org.nabucco.business.organization.ui.web.communication.produce.ProduceOrganizationDelegate;
import org.nabucco.business.organization.ui.web.communication.resolve.ResolveOrganizationDelegate;
import org.nabucco.business.organization.ui.web.communication.search.SearchOrganizationDelegate;
import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateFactorySupport;

/**
 * ServiceDelegateFactoryTemplate<p/>Organization component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class OrganizationComponentServiceDelegateFactory extends ServiceDelegateFactorySupport<OrganizationComponent> {

    private static OrganizationComponentServiceDelegateFactory instance = new OrganizationComponentServiceDelegateFactory();

    private MaintainOrganizationDelegate maintainOrganizationDelegate;

    private ProduceOrganizationDelegate produceOrganizationDelegate;

    private ResolveOrganizationDelegate resolveOrganizationDelegate;

    private SearchOrganizationDelegate searchOrganizationDelegate;

    private CorporationStructureDelegate corporationStructureDelegate;

    /** Constructs a new OrganizationComponentServiceDelegateFactory instance. */
    private OrganizationComponentServiceDelegateFactory() {
        super(OrganizationComponentLocator.getInstance());
    }

    /**
     * Getter for the MaintainOrganization.
     *
     * @return the MaintainOrganizationDelegate.
     * @throws ClientException
     */
    public MaintainOrganizationDelegate getMaintainOrganization() throws ClientException {
        try {
            if ((this.maintainOrganizationDelegate == null)) {
                this.maintainOrganizationDelegate = new MaintainOrganizationDelegate(this.getComponent()
                        .getMaintainOrganization());
            }
            return this.maintainOrganizationDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: MaintainOrganization", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the ProduceOrganization.
     *
     * @return the ProduceOrganizationDelegate.
     * @throws ClientException
     */
    public ProduceOrganizationDelegate getProduceOrganization() throws ClientException {
        try {
            if ((this.produceOrganizationDelegate == null)) {
                this.produceOrganizationDelegate = new ProduceOrganizationDelegate(this.getComponent()
                        .getProduceOrganization());
            }
            return this.produceOrganizationDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ProduceOrganization", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the ResolveOrganization.
     *
     * @return the ResolveOrganizationDelegate.
     * @throws ClientException
     */
    public ResolveOrganizationDelegate getResolveOrganization() throws ClientException {
        try {
            if ((this.resolveOrganizationDelegate == null)) {
                this.resolveOrganizationDelegate = new ResolveOrganizationDelegate(this.getComponent()
                        .getResolveOrganization());
            }
            return this.resolveOrganizationDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ResolveOrganization", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the SearchOrganization.
     *
     * @return the SearchOrganizationDelegate.
     * @throws ClientException
     */
    public SearchOrganizationDelegate getSearchOrganization() throws ClientException {
        try {
            if ((this.searchOrganizationDelegate == null)) {
                this.searchOrganizationDelegate = new SearchOrganizationDelegate(this.getComponent()
                        .getSearchOrganization());
            }
            return this.searchOrganizationDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: SearchOrganization", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the CorporationStructure.
     *
     * @return the CorporationStructureDelegate.
     * @throws ClientException
     */
    public CorporationStructureDelegate getCorporationStructure() throws ClientException {
        try {
            if ((this.corporationStructureDelegate == null)) {
                this.corporationStructureDelegate = new CorporationStructureDelegate(this.getComponent()
                        .getCorporationStructure());
            }
            return this.corporationStructureDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: CorporationStructure", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the Instance.
     *
     * @return the OrganizationComponentServiceDelegateFactory.
     */
    public static OrganizationComponentServiceDelegateFactory getInstance() {
        return instance;
    }
}
