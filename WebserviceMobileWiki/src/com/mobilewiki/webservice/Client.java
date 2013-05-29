package com.mobilewiki.webservice;

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
		//} catch (Exception e) {
		//	System.out.println("Error: " + e.toString());
		//}
	}
}
