/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.fhir.resources;

import ca.uhn.fhir.model.dstu.resource.Practitioner;
import org.openmrs.api.context.Context;
import org.openmrs.module.fhir.api.PractitionerService;
import org.openmrs.module.fhir.exception.FHIRModuleOmodException;
import org.openmrs.module.fhir.util.Parser;
import org.openmrs.module.fhir.api.util.FHIRPractitionerUtil;

public class FHIRPractitionerResource extends Resource {

	public Object retrieve(String uuid) throws Exception {

		Object delegate = getByUniqueId(uuid, null);
		System.out.println(delegate);
		if (delegate == null) {
			throw new Exception();
		}

		return delegate;
	}

	public String getByUniqueId(String uuid, String contentType) throws FHIRModuleOmodException {

		PractitionerService practitionerService = Context.getService(PractitionerService.class);
		Practitioner fhirPractitioner = practitionerService.getPractitioner(uuid);

		return Parser.parse(fhirPractitioner, contentType);
	}

    public String searchById(String id, String contentType) {

        PractitionerService practitionerService = Context.getService(PractitionerService.class);
        ca.uhn.fhir.model.api.Bundle practitionerBundle = practitionerService.getPractitionersById(id);
        return FHIRPractitionerUtil.parseBundle(practitionerBundle);
    }

}