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
package org.nabucco.business.organization.impl.service.search;

import java.util.List;

import org.nabucco.business.organization.facade.datatype.Corporation;
import org.nabucco.business.organization.facade.datatype.Customer;
import org.nabucco.business.organization.facade.datatype.OrganizationMaster;
import org.nabucco.business.organization.facade.datatype.OrganizationRelation;
import org.nabucco.business.organization.facade.message.CustomerListMsg;
import org.nabucco.business.organization.facade.message.search.CustomerSearchRq;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.datatype.StatusType;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodeFacade;
import org.nabucco.framework.base.facade.datatype.security.UserId;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * SearchCustomerServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class SearchCustomerServiceHandlerImpl extends SearchCustomerServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected CustomerListMsg searchCustomer(CustomerSearchRq msg) throws SearchException {

        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT c FROM Customer c");
//        queryString.append(" INNER JOIN c.relationListJPA as cr");
        queryString.append(" WHERE c.master.statusType = :statusType");

        if (msg.getCreditReportExternalId() != null) {
            queryString.append(" AND c.creditReport.externalId = :externalId");
        }
        if (msg.getCustomerId() != null) {
            queryString.append(" AND c.customerId = :customerId");
        }
        if (msg.getMasterId() != null) {
            queryString.append(" AND c.master.id = :masterId");
        }
        if (msg.getOwner() != null) {
            queryString.append(" AND c.master.owner = :owner");
        }
        if (!msg.getOwnerList().isEmpty()) {
            queryString.append(" AND c.master.owner IN " + createOwerList(msg.getOwnerList()));
        }
        if (!msg.getUserIdList().isEmpty()) {
            queryString.append(" AND c.master.userId IN " + createUserIdList(msg.getUserIdList()));
        }

        List<Customer> resultList;
        try {
            NabuccoQuery<Customer> query = getPersistenceManager().createQuery(queryString.toString());
            query.setParameter("statusType", StatusType.ACTIVE);

            if (msg.getCreditReportExternalId() != null) {
                query.setParameter("externalId", msg.getCreditReportExternalId());
            }
            if (msg.getCustomerId() != null) {
                query.setParameter("customerId", msg.getCustomerId());
            }
            if (msg.getMasterId() != null) {
                query.setParameter("masterId", msg.getMasterId().getValue());
            }
            if (msg.getOwner() != null) {
                query.setParameter("owner", msg.getOwner());
            }

            resultList = query.getResultList();

            for (Customer customer : resultList) {

                // set corporation form
                List<OrganizationRelation> relationList = customer.getRelationList();
                for (OrganizationRelation organizationRelation : relationList) {
                    if (organizationRelation.getCharacteristic() instanceof Corporation) {
                        Corporation corporation = (Corporation) organizationRelation.getCharacteristic();
                        Code code = CodeFacade.getInstance().getCode(corporation.getCorporationFormRefId());
                        corporation.setCorporationForm(code);
                    }
                }

                customer.setFunctionalStatusType(CodeFacade.getInstance().getCode(
                        customer.getFunctionalStatusTypeRefId()));

                OrganizationMaster master = customer.getMaster();
                master.setFunctionalType(CodeFacade.getInstance().getCode(master.getFunctionalTypeRefId()));
            }

        } catch (Exception e) {
            throw new SearchException(e);
        }

        CustomerListMsg response = new CustomerListMsg();
        response.getCustomerList().addAll(resultList);
        return response;
    }

    private String createOwerList(List<Owner> ownerList) {

        String listString = "(";

        for (Owner owner : ownerList) {
            listString += "'" + owner.getValue() + "', ";
        }

        if (listString.endsWith("', ")) {
            listString = listString.substring(0, listString.length() - 2);
        }

        listString += ")";
        return listString;
    }

    private String createUserIdList(List<UserId> userIdList) {

        String listString = "(";

        for (UserId userId : userIdList) {
            listString += "'" + userId.getValue() + "', ";
        }

        if (listString.endsWith("', ")) {
            listString = listString.substring(0, listString.length() - 2);
        }

        listString += ")";
        return listString;
    }

}
