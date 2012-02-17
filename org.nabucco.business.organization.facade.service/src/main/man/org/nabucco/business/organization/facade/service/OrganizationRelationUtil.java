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
package org.nabucco.business.organization.facade.service;

import java.util.List;

import org.nabucco.business.organization.facade.datatype.Corporation;
import org.nabucco.business.organization.facade.datatype.Customer;
import org.nabucco.business.organization.facade.datatype.Department;
import org.nabucco.business.organization.facade.datatype.EUCorporation;
import org.nabucco.business.organization.facade.datatype.OrganizationCharacteristic;
import org.nabucco.business.organization.facade.datatype.OrganizationRelation;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodeFacade;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.exception.client.ClientException;

/**
 * OrganizationRelationUtil
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class OrganizationRelationUtil {

    /**
     * Singleton instance.
     */
    private static OrganizationRelationUtil instance;

    /**
     * Singleton access.
     * 
     * @return the OrganizationRelationUtil instance.
     */
    public static OrganizationRelationUtil getInstance() {

        if (instance == null) {
            instance = new OrganizationRelationUtil();
        }

        return instance;
    }

    /**
     * Private constructor.
     */
    private OrganizationRelationUtil() {
        super();
    }

    private OrganizationCharacteristic getCharacteristic(OrganizationCharacteristic source,
            String codePath, String codeFilter) throws ClientException {

        OrganizationRelation organizationRelation = getOrganizationRelation(source, codePath,
                codeFilter);

        if (organizationRelation != null) {
            return organizationRelation.getCharacteristic();
        }

        return null;
    }

    private OrganizationRelation getOrganizationRelation(OrganizationCharacteristic source,
            String codePath, String name) throws ClientException {

        if (source == null) {
            throw new ClientException("Organization characteristic musn't be null!");
        }

        if (codePath == null) {
            throw new ClientException("Code path musn't be null!");
        }

        if (name == null) {
            throw new ClientException("Code filter musn't be null!");
        }

        try {
            Code code = CodeFacade.getInstance().getCode(new CodePath(codePath), new Name(name));
            return getOrganizationRelation(source, code);

        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    private OrganizationRelation getOrganizationRelation(OrganizationCharacteristic source,
            Code code) throws ClientException {

        if (source == null) {
            throw new ClientException("Organization characteristic musn't be null!");
        }

        if (code == null) {
            throw new ClientException("Code musn't be null!");
        }

        List<OrganizationRelation> relationList = source.getRelationList();
        for (OrganizationRelation organizationRelation : relationList) {

            if (organizationRelation.getFunctionalType() == null) {
                if (organizationRelation.getFunctionalTypeRefId().equals(code.getId())) {
                    return organizationRelation;
                }

            } else {
                if (organizationRelation.getFunctionalType().equals(code)) {
                    return organizationRelation;
                }
            }
        }

        return null;
    }

    // --------------------------------------------------------------------

    public OrganizationRelation getCorporationRelationFromCustomer(Customer customer)
            throws Exception {

        return getOrganizationRelation(customer, OrganizationRelation.getFunctionalTypeCodePath()
                .getValue(), "customer_corporation");
    }

    public Corporation getCorporationFromCustomer(Customer customer) throws Exception {

        return (Corporation) getCharacteristic(customer, OrganizationRelation
                .getFunctionalTypeCodePath().getValue(), "customer_corporation");
    }

    public Department getDepartmentFromCustomer(Customer customer) throws Exception {

        return (Department) getCharacteristic(customer, OrganizationRelation
                .getFunctionalTypeCodePath().getValue(), "customer_department");
    }

    public OrganizationRelation getEUCorporationRelationFormCorporation(Corporation corporation)
            throws Exception {

        return getOrganizationRelation(corporation, OrganizationRelation
                .getFunctionalTypeCodePath().getValue(), "eucorporation");
    }

    public EUCorporation getEUCorporationFromCorporation(Corporation corporation) throws Exception {

        return (EUCorporation) getCharacteristic(corporation, OrganizationRelation
                .getFunctionalTypeCodePath().getValue(), "eucorporation");
    }
}
