package com.mobilewiki.rest;

import org.restlet.representation.ObjectRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.mobilewiki.webservice.MobileWiki;

public class MobileWikiServer extends ServerResource {

	@Get
	public String present() {
		MobileWiki webservice = new MobileWiki();

		String x = webservice.getTitleForArticleId(3);
		String y = webservice.getContentForContentId(2);
		
		String result = x + ": \n" + y;

		return result;
	}

	@Post
	public Representation handlePost(Representation representation) {

		if (representation.getClass().toString()
				.equals(ObjectRepresentation.class.toString())) {

		}

		return representation;
	}
}
