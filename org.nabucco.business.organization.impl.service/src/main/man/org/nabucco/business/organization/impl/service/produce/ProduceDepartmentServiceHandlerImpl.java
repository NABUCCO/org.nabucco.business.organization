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
package org.nabucco.business.organization.impl.service.produce;

import org.nabucco.business.organization.facade.datatype.Department;
import org.nabucco.business.organization.facade.datatype.OrganizationMaster;
import org.nabucco.business.organization.facade.message.DepartmentListMsg;
import org.nabucco.business.organization.facade.message.produce.DepartmentProduceRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.StatusType;
import org.nabucco.framework.base.facade.datatype.security.User;
import org.nabucco.framework.base.facade.datatype.security.UserId;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * ProduceDepartmentServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ProduceDepartmentServiceHandlerImpl extends ProduceDepartmentServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected DepartmentListMsg produceDepartment(DepartmentProduceRq msg) throws ProduceException {

        DepartmentListMsg response = new DepartmentListMsg();

        OrganizationMaster master = msg.getMaster();

        if (master == null) {
            User user = getContext().getSubject().getUser();

            master = new OrganizationMaster();
            master.setOwner(user.getOwner());
            master.setName("New Department");
            master.setUserId(new UserId(user.getUsername().getValue()));
            master.setDatatypeState(DatatypeState.INITIALIZED);
            master.setStatusType(StatusType.ACTIVE);
        }

        for (int i = 0; i < msg.getAmount().getValue(); i++) {
            Department department = new Department();
            department.setDatatypeState(DatatypeState.INITIALIZED);
            department.setMaster(master);

            response.getDepartmentList().add(department);
        }

        return response;
    }

}
