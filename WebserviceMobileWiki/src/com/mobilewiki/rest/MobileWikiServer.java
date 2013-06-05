package com.mobilewiki.rest;

import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.mobilewiki.webservice.MobileWiki;

public class MobileWikiServer extends ServerResource {
	private MobileWiki webservice = new MobileWiki();

	@Get
	public String present() {
		String x = webservice.getTitleForArticleId(3);
		String y = webservice.getContentForContentId(2);

		String result = x + ": \n" + y;

		return result;
	}

	@Post("json")
	public JsonRepresentation handlePost(Representation representation) {
		JSONObject jsonobj_response = new JSONObject();

		try {
			if (representation.getMediaType().equals(MediaType.APPLICATION_JSON)) {
				JsonRepresentation jsonrepresentation_request = new JsonRepresentation(representation);
				JSONObject jsonobject_request = jsonrepresentation_request.getJsonObject();

				String function_name = jsonobject_request.get("function").toString();

				switch (function_name) {
					case "getTitleForArticleId":
						int article_id = Integer.parseInt(jsonobject_request.get("article_id").toString());
						String title = webservice.getTitleForArticleId(article_id);
						jsonobj_response.put("result", title);
						break;
	
					default:
						jsonobj_response.put("result", "Fehler");
				}

			} else {
				jsonobj_response.put("result", "Request Object is not Type of MediaType.APPLICATION_JSON");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonRepresentation test = new JsonRepresentation(jsonobj_response);

		return test;
	}
}
