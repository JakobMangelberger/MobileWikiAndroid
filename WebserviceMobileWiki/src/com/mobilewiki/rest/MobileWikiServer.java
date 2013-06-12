package com.mobilewiki.rest;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

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
				int article_id, content_id, main_id, result_insert, result_delete, result_update;
				String content, date_change, logo_link, title, tag, wiki_name = "";
				List<Integer> ids;
				HashMap<String, String> hash_map;

				switch (function_name) {
				case "getArticleIds":
					ids = webservice.getArticleIds();
					jsonobj_response.put("result", ids);
					break;
					
				case "getTitleForArticleId":
					article_id = Integer.parseInt(jsonobject_request.get("article_id").toString());
					
					title = webservice.getTitleForArticleId(article_id);
					jsonobj_response.put("result", title);
					break;
					
				case "getArticleIdForTitle":
					article_id = webservice.getArticleIdForTitle(jsonobject_request.get("title").toString());
					jsonobj_response.put("result", article_id);
					break;
					
				case "getContentIdsforArticleId":
					article_id = Integer.parseInt(jsonobject_request.get("article_id").toString());
					
					ids = webservice.getContentIdsforArticleId(article_id);
					jsonobj_response.put("result", ids);
					break;
					
				case "getDateChangeForContentId":
					content_id = Integer.parseInt(jsonobject_request.get("content_id").toString());
					
					date_change = webservice.getDateChangeForContentId(content_id);
					jsonobj_response.put("result", date_change);
					break;
					
				case "getArticleIdForContentId":
					content_id = Integer.parseInt(jsonobject_request.get("content_id").toString());
					
					article_id = webservice.getArticleIdForContentId(content_id);
					jsonobj_response.put("result", article_id);
					break;
					
				case "getContentForContentId":
					content_id = Integer.parseInt(jsonobject_request.get("content_id").toString());
					
					content = webservice.getContentForContentId(content_id);
					jsonobj_response.put("result", content);
					break;
					
				case "getTagForContentId":
					content_id = Integer.parseInt(jsonobject_request.get("content_id").toString());
					
					tag = webservice.getTagForContentId(content_id);
					jsonobj_response.put("result", tag);
					break;

				case "createMain":
					wiki_name = jsonobject_request.get("wiki_name").toString();
					logo_link = jsonobject_request.get("logo_link").toString();
					
					result_insert = webservice.createMain(wiki_name, logo_link);
					jsonobj_response.put("result", result_insert);
					break;

				case "createArticle":
					title = jsonobject_request.get("title").toString();
					logo_link = jsonobject_request.get("logo_link").toString();
					
					result_insert = webservice.createArticle(title);
					jsonobj_response.put("result", result_insert);
					break;
					
				case "createContent":
					article_id = Integer.parseInt(jsonobject_request.get("article_id").toString());
					content = jsonobject_request.get("content").toString();
					tag = jsonobject_request.get("tag").toString();
					
					result_insert = webservice.createContent(article_id, content, tag);
					jsonobj_response.put("result", result_insert);
					break;

				case "editMain":
					main_id = Integer.parseInt(jsonobject_request.get("main_id").toString());
					wiki_name = jsonobject_request.get("wiki_name").toString();
					logo_link = jsonobject_request.get("logo_link").toString();
					
					result_update = webservice.editMain(main_id, wiki_name, logo_link);
					jsonobj_response.put("result", result_update);
					break;

				case "editArticle":
					article_id = Integer.parseInt(jsonobject_request.get("article_id").toString());
					title = jsonobject_request.get("title").toString();
					
					result_update = webservice.editArticle(article_id, title);
					jsonobj_response.put("result", result_update);
					break;
					
				case "editContent":
					content_id = Integer.parseInt(jsonobject_request.get("content_id").toString());
					article_id = Integer.parseInt(jsonobject_request.get("article_id").toString());
					content = jsonobject_request.get("content").toString();
					tag = jsonobject_request.get("tag").toString();
					
					result_update = webservice.editContent(content_id, article_id, content, tag);
					jsonobj_response.put("result", result_update);
					break;

				case "deleteMain":
					main_id = Integer.parseInt(jsonobject_request.get("main_id").toString());
					
					result_delete = webservice.deleteMain(main_id);
					jsonobj_response.put("result", result_delete);
					break;
					
				case "deleteArticle":
					article_id = Integer.parseInt(jsonobject_request.get("article_id").toString());
					
					result_delete = webservice.deleteArticle(article_id);
					jsonobj_response.put("result", result_delete);
					break;
					
				case "deleteContent":
					content_id = Integer.parseInt(jsonobject_request.get("content_id").toString());
					
					result_delete = webservice.deleteContent(content_id);
					jsonobj_response.put("result", result_delete);
					break;
					
				case "getContentTitleTagForArticleId":
					article_id = Integer.parseInt(jsonobject_request.get("article_id").toString());
					
					hash_map = webservice.getContentTitleTagForArticleId(article_id);
					jsonobj_response.put("result", hash_map);
                    break;

				case "getContentTitleTagForContentId":
					content_id = Integer.parseInt(jsonobject_request.get("content_id").toString());
					
					hash_map = webservice.getContentTitleTagForContentId(content_id);
					jsonobj_response.put("result", hash_map);
                    break;
                    
				case "getContentTitleTagForTitle":
					title = jsonobject_request.get("title").toString();
					
					hash_map = webservice.getContentTitleTagForTitle(title);
					jsonobj_response.put("result", hash_map);
                    break;
                    
                case "getAllTitlesWithTags":
                    jsonobj_response.put("result", webservice.getAllTitlesWithTags());
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
