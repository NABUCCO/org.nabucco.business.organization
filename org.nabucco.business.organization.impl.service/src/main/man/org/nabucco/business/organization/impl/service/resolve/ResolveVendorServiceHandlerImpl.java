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
package org.nabucco.business.organization.impl.service.resolve;

import org.nabucco.business.organization.facade.datatype.Vendor;
import org.nabucco.business.organization.facade.message.VendorMsg;
import org.nabucco.framework.base.facade.exception.service.ResolveException;

/**
 * ResolveVendorServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ResolveVendorServiceHandlerImpl extends ResolveVendorServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected VendorMsg resolveVendor(VendorMsg msg) throws ResolveException {

        Vendor vendor = msg.getVendor();

        try {
            vendor = super.getPersistenceManager().find(msg.getVendor());
            vendor.getRelationList().size();
            vendor.getSectorList().size();

        } catch (Exception e) {
            throw new ResolveException("Cannot resolve Vendor with id " + vendor.getId(), e);
        }

        VendorMsg response = new VendorMsg();
        response.setVendor(vendor);
        return response;
    }

}
