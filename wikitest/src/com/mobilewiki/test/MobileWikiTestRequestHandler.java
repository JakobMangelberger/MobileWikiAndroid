package com.mobilewiki.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.*;

import org.json.JSONException;
import org.json.JSONObject;
import com.mobilewiki.RequestHandler;
import com.mobilewiki.controls.WebserviceAdapter;

import junit.framework.TestCase;

public class MobileWikiTestRequestHandler extends TestCase {

	private RequestHandler requestHandler;
	WebServiceAdapterStub myWebServiceAdapter;
	
	public MobileWikiTestRequestHandler(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		requestHandler = RequestHandler.getInstance();
		myWebServiceAdapter = new WebServiceAdapterStub();
		
		Field field;
		try {
			field = RequestHandler.class.getDeclaredField("webserivce_adapter");
		
			field.setAccessible(true);

			field.set(requestHandler, myWebServiceAdapter);
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e2 ) {
			e2.printStackTrace();
		} catch (NoSuchFieldException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetArticleIds() {

		List<Integer> result_list = new ArrayList<Integer>();
		result_list.add(2);
		result_list.add(3);

		assertEquals(requestHandler.getArticleIds(), result_list);
		// fail("Not yet implemented");
	}

	public void testGetTitleForArticleId() {
		
		String title_five = "Five";
		String title_six = "Six";
		
		int article_id_five = 5;
		int article_id_six = 6;
		
		assertEquals(title_five, requestHandler.getTitleForArticleId(article_id_five));
		assertEquals(title_six, requestHandler.getTitleForArticleId(article_id_six));
	}

	public void testGetArticleIdForTitle() {

		String title = "Five";
		
		int article_id = 5;
		
		assertEquals(article_id, requestHandler.getArticleIdForTitle(title));
	}

	public void testGetContentIdsforArticleId() {

		int article_id = 5;
		
		List<Integer> contentIds = new ArrayList<Integer>();
		contentIds.add(5);
		contentIds.add(4);
		
		assertEquals(contentIds, requestHandler.getContentIdsforArticleId(article_id));
	}

	public void testGetDateChangeForContentId() {

		int contentId = 6;
		
		String dateChange = "20130505";
		
		assertEquals(dateChange, requestHandler.getDateChangeForContentId(contentId));
	}

	public void testGetArticleIdForContentId() {
		int contentId = 6;
		
		int articleId = 5;
		
		assertEquals(articleId, requestHandler.getArticleIdForContentId(contentId));
	}

	public void testGetContentForContentId() {

		int contentId = 6;
		
		String content = "Ich bin ein Content";
		
		assertEquals(content, requestHandler.getContentForContentId(contentId));
	}

	public void testGetTagForContentId() {
		int contentId = 6;
		
		String tag = "Tag Tag Tag";
		
		assertEquals(tag, requestHandler.getTagForContentId(contentId));
	}

	public void testGet_all_titles_with_tags() {
		
		Map<String,String> resultMap = new HashMap<String, String>();
		
		resultMap.put("Title1", "Tag1 Tag2 Tag3");
		resultMap.put("Title2", "Tag4 Tag5 Tag6");
		
		assertEquals(resultMap, requestHandler.get_all_titles_with_tags());
	}

	class WebServiceAdapterStub extends WebserviceAdapter {
		@Override
		public JSONObject callWebservice(JSONObject jsonobject_request) {
			JSONObject jsonobject_response = new JSONObject();

			String request = "";

			try {
				request = jsonobject_request.getString("function");

				if(request.equals("getArticleIds")) {
					List<Integer> responseList = new ArrayList<Integer>();
					responseList.add(2);
					responseList.add(3);

					jsonobject_response.put("result", responseList);
				}
				else if( request.equals("getTitleForArticleId")) {
					if(jsonobject_request.getInt("article_id") == 5) {
						jsonobject_response.put("result", "Five");
					}
					else if (jsonobject_request.getInt("article_id") == 6) {
						jsonobject_response.put("result", "Six");
					}
				}
				else if( request.equals("getArticleIdForTitle")) {
					if(jsonobject_request.getString("title").equals("Five")) {
						jsonobject_response.put("result", 5);
					}
				}
				else if( request.equals("getContentIdsforArticleId")) {
					if(jsonobject_request.getInt("article_id") == 5) {
						List<Integer> contentIds = new ArrayList<Integer>();
						contentIds.add(5);
						contentIds.add(4);
						
						jsonobject_response.put("result", contentIds);
					}
				}
				else if( request.equals("getDateChangeForContentId")) {
					if(jsonobject_request.getInt("content_id") == 6) {
						
						jsonobject_response.put("result", "20130505");
					}
				}
				else if( request.equals( "getArticleIdForContentId")) {
					if(jsonobject_request.getInt("content_id") == 6) {
												
						jsonobject_response.put("result", 5);
					}
				}
				else if( request.equals( "getContentForContentId")) {
					if(jsonobject_request.getInt("content_id") == 6) {
												
						jsonobject_response.put("result", "Ich bin ein Content");
					}
				}
				else if( request.equals( "getTagForContentId")) {
					if(jsonobject_request.getInt("content_id") == 6) {
												
						jsonobject_response.put("result", "Tag Tag Tag");
					}
				}
					else if( request.equals( "getAllTitlesWithTags")) {


					jsonobject_response.put("result", "Title1\nTag1 Tag2 Tag3\nTitle2\nTag4 Tag5 Tag6");
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return jsonobject_response;
		}
	}
}
