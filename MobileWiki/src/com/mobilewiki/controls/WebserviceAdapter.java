package com.mobilewiki.controls;

import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class WebserviceAdapter {

	public JSONObject callWebservice(JSONObject jsonobject_request)
	{
		JSONObject jsonobject_response = null;
		ClientResource resource = new ClientResource("http://localhost:8080/WebserviceMobileWiki");  
		 
		try {
			JsonRepresentation jsonrepresentation_request = new JsonRepresentation(jsonobject_request);
			
			Representation representation_response = resource.post(jsonrepresentation_request);
			
			if (representation_response.getMediaType().equals(MediaType.APPLICATION_JSON)) {
				JsonRepresentation jsonrepresentation_response = new JsonRepresentation(representation_response);
				jsonobject_response = jsonrepresentation_response.getJsonObject();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonobject_response;
	}
}
