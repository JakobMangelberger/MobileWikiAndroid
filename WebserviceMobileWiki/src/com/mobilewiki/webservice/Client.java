package com.mobilewiki.webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;


public class Client {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		ClientResource resource = new ClientResource("http://localhost:8080/WebserviceMobileWiki");  
 
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
			e.printStackTrace();
		} 
		
	}
	
	public static ArrayList<Integer> convertJsonArrayToArrayList(JSONArray jsonArray)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i < jsonArray.length(); i++)
		{
			try {
				list.add(Integer.parseInt(jsonArray.get(i).toString()));
			} catch (NumberFormatException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}