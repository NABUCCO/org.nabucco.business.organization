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

import java.util.List;

import org.nabucco.business.organization.facade.component.OrganizationComponentLocator;
import org.nabucco.business.organization.facade.datatype.CustomerComponentRelation;
import org.nabucco.business.organization.facade.message.corporationstructure.CorporationStructureDeleteDependencyRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelation;
import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelationType;
import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelationTypeMapper;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.componentrelation.ComponentRelationListMsg;
import org.nabucco.framework.base.facade.message.componentrelation.ComponentRelationMsg;
import org.nabucco.framework.base.facade.message.componentrelation.ComponentRelationSearchRq;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * DeleteDepenendencyServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class DeleteDepenendencyServiceHandlerImpl extends DeleteDepenendencyServiceHandler {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected EmptyServiceMessage deleteDepenendency(CorporationStructureDeleteDependencyRq msg)
            throws MaintainException {

        try {
            ComponentRelationType componentRelationType = ComponentRelationTypeMapper.getInstance()
                    .valueOf(msg.getComponentRelationType().getValue());

            // try to delete
            boolean deleted = deletePointedCustomer(msg.getSourceId(), msg.getTargetId(),
                    componentRelationType);

            if (deleted) {
                return new EmptyServiceMessage();
            }

            deleted = deletePointingCustomer(msg.getSourceId(), msg.getTargetId(),
                    componentRelationType);

            if (deleted) {
                return new EmptyServiceMessage();
            }

        } catch (Exception e) {
            throw new MaintainException("Error during delete corporation structure dependency!", e);
        }

        throw new MaintainException("No componant relation found to delete!");
    }

    private boolean deletePointingCustomer(Identifier sourceId, Identifier targetId,
            ComponentRelationType componentRelationType) throws Exception {

        String relationType = componentRelationType.getClass().getName()
                + "#"
                + componentRelationType.getId();

        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT cr FROM CustomerComponentRelation cr");
        queryString.append(" WHERE cr.sourceId = :targetId");
        queryString.append(" And cr.type = :relationType");
        queryString.append(" AND cr.target.master.id = :sourceId");

        NabuccoQuery<ComponentRelation<?>> query = getPersistenceManager().createQuery(
                queryString.toString());
        query.setParameter("sourceId", sourceId.getValue());
        query.setParameter("targetId", targetId);
        query.setParameter("relationType", relationType);

        List<ComponentRelation<?>> componentRelationList = query.getResultList();
        return delete(componentRelationList, sourceId);
    }

    private boolean deletePointedCustomer(Identifier sourceId, Identifier targetId,
            ComponentRelationType componentRelationType) throws Exception {

        ComponentRelationSearchRq searchMsg = new ComponentRelationSearchRq();
        searchMsg.setSourceId(sourceId);
        searchMsg.setRelationType(componentRelationType);
        searchMsg.setComponentRelationClass(new Name(componentRelationType.getRelation()
                .getSimpleName()));

        ServiceRequest<ComponentRelationSearchRq> request = new ServiceRequest<ComponentRelationSearchRq>(
                getContext());
        request.setRequestMessage(searchMsg);

        ServiceResponse<ComponentRelationListMsg> response = OrganizationComponentLocator
                .getInstance().getComponent().getComponentRelationService()
                .searchComponentRelation(request);

        List<ComponentRelation<?>> componentRelationList = response.getResponseMessage()
                .getComponentRelationList();
        return delete(componentRelationList, targetId);
    }

    private boolean delete(List<ComponentRelation<?>> componentRelationList, Identifier targetId)
            throws Exception {

        for (ComponentRelation<?> componentRelation : componentRelationList) {
            CustomerComponentRelation relation = (CustomerComponentRelation) componentRelation;
            if (relation.getTarget().getMaster().getId().equals(targetId.getValue())) {
                delete(componentRelation);
                return true;
            }
        }

        return false;
    }

    private void delete(ComponentRelation<?> componentRelation) throws Exception {

        componentRelation.setDatatypeState(DatatypeState.DELETED);

        ComponentRelationMsg msg = new ComponentRelationMsg();
        msg.setComponentRelation(componentRelation);

        ServiceRequest<ComponentRelationMsg> request = new ServiceRequest<ComponentRelationMsg>(
                getContext());
        request.setRequestMessage(msg);

        OrganizationComponentLocator.getInstance().getComponent().getComponentRelationService()
                .maintainComponentRelation(request);
    }
}
