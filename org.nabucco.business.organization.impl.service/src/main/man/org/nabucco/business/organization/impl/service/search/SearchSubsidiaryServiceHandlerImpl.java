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

import org.nabucco.business.organization.facade.datatype.Subsidiary;
import org.nabucco.business.organization.facade.message.SubsidiaryListMsg;
import org.nabucco.business.organization.facade.message.search.SubsidiarySearchRq;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * SearchSubsidiaryServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class SearchSubsidiaryServiceHandlerImpl extends SearchSubsidiaryServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected SubsidiaryListMsg searchSubsidiary(SubsidiarySearchRq msg) throws SearchException {

        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT d FROM Subsidiary d");

        List<Subsidiary> resultList;
        try {
            NabuccoQuery<Subsidiary> query = getPersistenceManager().createQuery(queryString.toString());
            resultList = query.getResultList();
        } catch (Exception e) {
            throw new SearchException(e);
        }

        SubsidiaryListMsg response = new SubsidiaryListMsg();
        response.getSubsidiaryList().addAll(resultList);
        return response;
    }

}
