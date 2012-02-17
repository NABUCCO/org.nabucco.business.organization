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

import org.nabucco.business.organization.facade.datatype.CreditReport;
import org.nabucco.business.organization.facade.message.CreditReportListMsg;
import org.nabucco.business.organization.facade.message.produce.CreditReportProduceRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * ProduceCreditReportServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ProduceCreditReportServiceHandlerImpl extends ProduceCreditReportServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected CreditReportListMsg produceCreditReport(CreditReportProduceRq msg) throws ProduceException {

        CreditReportListMsg response = new CreditReportListMsg();

        for (int i = 0; i < msg.getNumber().getValue(); i++) {
            CreditReport datatype = new CreditReport();
            datatype.setDatatypeState(DatatypeState.INITIALIZED);

            response.getCreditReportList().add(datatype);
        }

        return response;
    }

}
