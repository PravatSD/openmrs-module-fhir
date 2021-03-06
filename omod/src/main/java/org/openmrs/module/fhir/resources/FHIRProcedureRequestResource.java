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

import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.hl7.fhir.dstu3.model.IdType;
import org.hl7.fhir.dstu3.model.ProcedureRequest;
import org.openmrs.api.context.Context;
import org.openmrs.module.fhir.api.ProcedureRequestService;

public class FHIRProcedureRequestResource extends Resource {

	public ProcedureRequest getByUniqueId(IdType id) {
		ProcedureRequestService service = Context.getService(ProcedureRequestService.class);
		ProcedureRequest procedureRequest = service.getById(id.getIdPart());
		if (procedureRequest == null) {
			throw new ResourceNotFoundException("Procedure request is not found for the given Id " + id.getIdPart());
		}
		return procedureRequest;
	}

	public ProcedureRequest createFHIRProcedureRequest(ProcedureRequest procedureRequest) {
		ProcedureRequestService service = Context.getService(ProcedureRequestService.class);
		return service.createFHIRProcedureRequest(procedureRequest);
	}

	public ProcedureRequest updateFHIRProcedureRequest(ProcedureRequest procedureRequest, String theId) {
		ProcedureRequestService service = Context.getService(ProcedureRequestService.class);
		return service.updateFHIRProcedureRequest(procedureRequest, theId);
	}

	public void deleteProcedureRequest(String theId) {
		ProcedureRequestService service = Context.getService(ProcedureRequestService.class);
		service.delete(theId);
	}
}
