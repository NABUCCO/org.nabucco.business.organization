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

import org.nabucco.business.organization.facade.datatype.Vendor;
import org.nabucco.business.organization.facade.message.VendorListMsg;
import org.nabucco.business.organization.facade.message.produce.VendorProduceRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * ProduceVendorServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ProduceVendorServiceHandlerImpl extends ProduceVendorServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected VendorListMsg produceVendor(VendorProduceRq msg) throws ProduceException {

        VendorListMsg response = new VendorListMsg();

        for (int i = 0; i < msg.getNumber().getValue(); i++) {
            Vendor datatype = new Vendor();
            datatype.setDatatypeState(DatatypeState.INITIALIZED);

            response.getVendorList().add(datatype);
        }

        return response;
    }

}
