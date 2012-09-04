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

import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.component.locator.ComponentLocator;
import org.nabucco.framework.base.facade.component.locator.ComponentLocatorSupport;

/**
 * Locator for OrganizationComponent.
 *
 * @author NABUCCO Generator, PRODYNA AG
 */
public class OrganizationComponentLocator extends ComponentLocatorSupport<OrganizationComponent> implements
        ComponentLocator<OrganizationComponent> {

    private static OrganizationComponentLocator instance;

    /**
     * Constructs a new OrganizationComponentLocator instance.
     *
     * @param component the Class<OrganizationComponent>.
     * @param jndiName the String.
     */
    private OrganizationComponentLocator(String jndiName, Class<OrganizationComponent> component) {
        super(jndiName, component);
    }

    @Override
    public OrganizationComponent getComponent() throws ConnectionException {
        OrganizationComponent component = super.getComponent();
        if ((component instanceof OrganizationComponentLocal)) {
            return new OrganizationComponentLocalProxy(((OrganizationComponentLocal) component));
        }
        return component;
    }

    /**
     * Getter for the Instance.
     *
     * @return the OrganizationComponentLocator.
     */
    public static OrganizationComponentLocator getInstance() {
        if ((instance == null)) {
            instance = new OrganizationComponentLocator(OrganizationComponent.JNDI_NAME, OrganizationComponent.class);
        }
        return instance;
    }
}
