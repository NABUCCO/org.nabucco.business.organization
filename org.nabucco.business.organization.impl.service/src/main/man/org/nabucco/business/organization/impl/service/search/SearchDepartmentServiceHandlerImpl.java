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

import org.nabucco.business.organization.facade.datatype.Department;
import org.nabucco.business.organization.facade.message.DepartmentListMsg;
import org.nabucco.business.organization.facade.message.search.DepartmentSearchRq;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * SearchDepartmentServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class SearchDepartmentServiceHandlerImpl extends SearchDepartmentServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected DepartmentListMsg searchDepartment(DepartmentSearchRq msg) throws SearchException {

        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT d FROM Department d");

        List<Department> resultList;
        try {
            NabuccoQuery<Department> query = getPersistenceManager().createQuery(queryString.toString());
            resultList = query.getResultList();
        } catch (Exception e) {
            throw new SearchException(e);
        }

        DepartmentListMsg response = new DepartmentListMsg();
        response.getDepartmentList().addAll(resultList);
        return response;
    }

}
