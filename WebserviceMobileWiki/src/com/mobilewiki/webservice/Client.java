package com.mobilewiki.webservice;

import java.io.IOException;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class Client {

	public static void main(String[] args) throws Exception {
		MobileWikiStub stub = new MobileWikiStub();

//		// Creating the request
//		com.mobilewiki.webservice.MobileWikiStub.RespondMessage request = new com.mobilewiki.webservice.MobileWikiStub.RespondMessage();
//		request.setMessage("Dies ist ein Test");
//
//		// Invoking the service
//		com.mobilewiki.webservice.MobileWikiStub.RespondMessageResponse response = stub
//				.respondMessage(request);
//		System.out.println("Response : " + response.get_return());

		/*
		com.mobilewiki.webservice.MobileWikiStub.GetArticleIds request = new com.mobilewiki.webservice.MobileWikiStub.GetArticleIds();
		
		// Invoking the service
		//try {
		com.mobilewiki.webservice.MobileWikiStub.GetArticleIdsResponse response = stub.getArticleIds(request);
		
		if(response != null){
			int[] article_ids = response.get_return();
			
			if (article_ids.length > 0) {
				for (int i = 0; i < article_ids.length; i++) {
					System.out.println("Response : id = '" + article_ids[i] + "'");
				}
			}
		}
		*/
		
		// Create the client resource  
		ClientResource resource = new ClientResource("http://localhost:8080");  
 
		// Write the response entity on the console
		try {
			resource.get().write(System.out);
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	
}