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
package org.nabucco.business.organization.impl.service.corporationstructure;

import java.util.ArrayList;
import java.util.List;

import org.nabucco.business.organization.facade.component.OrganizationComponentLocator;
import org.nabucco.business.organization.facade.datatype.Customer;
import org.nabucco.business.organization.facade.datatype.CustomerComponentRelation;
import org.nabucco.business.organization.facade.message.CustomerListMsg;
import org.nabucco.business.organization.facade.message.CustomerMsg;
import org.nabucco.business.organization.facade.message.corporationstructure.CorporationStructureSearchDependenciesRq;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelation;
import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelationType;
import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelationTypeMapper;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.componentrelation.ComponentRelationListMsg;
import org.nabucco.framework.base.facade.message.componentrelation.ComponentRelationSearchRq;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * SearchDependenciesServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class SearchDependenciesServiceHandlerImpl extends SearchDependenciesServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected CustomerListMsg searchDependencies(CorporationStructureSearchDependenciesRq msg) throws SearchException {

        try {
            ComponentRelationType componentRelationType = ComponentRelationTypeMapper.getInstance().valueOf(
                    msg.getComponentRelationType().getValue());

            List<Customer> result = new ArrayList<Customer>();

            addPointedCustomer(msg.getSourceId(), componentRelationType, result);
            addPointingCustomer(msg.getSourceId(), componentRelationType, result);

            CustomerListMsg response = new CustomerListMsg();
            response.getCustomerList().addAll(result);
            return response;

        } catch (Exception e) {
            throw new SearchException("Error during search for corporation structure dependencies!", e);
        }
    }

    /**
     * Search dependencies which points to source.
     * 
     * @param sourceId
     * @param componentRelationType
     * @param customerList
     * @throws Exception
     */
    private void addPointingCustomer(Identifier sourceId, ComponentRelationType componentRelationType,
            List<Customer> customerList) throws Exception {

        String relationType = componentRelationType.getClass().getName() + "#" + componentRelationType.getId();

        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT c FROM Customer c, CustomerComponentRelation cr");
        queryString.append(" WHERE cr.type = :relationType");
        queryString.append(" AND cr.target.master.id = :sourceId");
        queryString.append(" AND c.master.id = cr.sourceId");

        NabuccoQuery<Customer> query = getPersistenceManager().createQuery(queryString.toString());
        query.setParameter("sourceId", sourceId.getValue());
        query.setParameter("relationType", relationType);

        List<Customer> list = query.getResultList();
        resolveAndAdd2(list, customerList);
    }

    /**
     * Search dependencies which are pointed by source.
     * 
     * @param sourceId
     * @param componentRelationType
     * @param customerList
     * @throws Exception
     */
    private void addPointedCustomer(Identifier sourceId, ComponentRelationType componentRelationType,
            List<Customer> customerList) throws Exception {

        ComponentRelationSearchRq searchMsg = new ComponentRelationSearchRq();
        searchMsg.setSourceId(sourceId);
        searchMsg.setRelationType(componentRelationType);
        searchMsg.setComponentRelationClass(new Name(componentRelationType.getRelation().getSimpleName()));

        ServiceRequest<ComponentRelationSearchRq> request = new ServiceRequest<ComponentRelationSearchRq>(getContext());
        request.setRequestMessage(searchMsg);

        ServiceResponse<ComponentRelationListMsg> response = OrganizationComponentLocator.getInstance().getComponent()
                .getComponentRelationService().searchComponentRelation(request);

        List<ComponentRelation<?>> componentRelationList = response.getResponseMessage().getComponentRelationList();
        resolveAndAdd(componentRelationList, customerList);
    }

    private void resolveAndAdd(List<ComponentRelation<?>> componentRelationList, List<Customer> customerList)
            throws Exception {

        for (ComponentRelation<?> componentRelation : componentRelationList) {
            CustomerComponentRelation relation = (CustomerComponentRelation) componentRelation;
            Customer customer = resolveCustomer(relation.getTarget());
            customerList.add(customer);
        }
    }

    private void resolveAndAdd2(List<Customer> foundList, List<Customer> customerList) throws Exception {

        for (Customer customer : foundList) {
            customer = resolveCustomer(customer);
            customerList.add(customer);
        }
    }

    private Customer resolveCustomer(Customer customer) throws Exception {

        CustomerMsg msg = new CustomerMsg();
        msg.setCustomer(customer);

        ServiceRequest<CustomerMsg> rq = new ServiceRequest<CustomerMsg>(getContext());
        rq.setRequestMessage(msg);

        ServiceResponse<CustomerMsg> rs = OrganizationComponentLocator.getInstance().getComponent()
                .getResolveOrganization().resolveCustomer(rq);
        return rs.getResponseMessage().getCustomer();
    }
}
