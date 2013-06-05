package com.mobilewiki.webservice;

import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class Client {

	public static void main(String[] args) throws Exception {
		// Create the client resource  
		ClientResource resource = new ClientResource("http://localhost:8080/WebserviceMobileWiki");  
 
		// Write the response entity on the console
		try {
			JSONObject jsonobject_request = new JSONObject();
			jsonobject_request.put("function", "getTitleForArticleId");
			jsonobject_request.put("article_id", "2");
			
			JsonRepresentation jsonrepresentation_request = new JsonRepresentation(jsonobject_request);
			
			Representation representation_response = resource.post(jsonrepresentation_request);
			
			if (representation_response.getMediaType().equals(MediaType.APPLICATION_JSON)) {
				JsonRepresentation jsonrepresentation_response = new JsonRepresentation(representation_response);
				JSONObject jsonobject_response = jsonrepresentation_response.getJsonObject();
				
				String result = jsonobject_response.get("result").toString();
				System.out.println(result);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}