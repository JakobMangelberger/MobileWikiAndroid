package com.mobilewiki;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.util.Log;

public class ContentHTMLParser implements IHTMLConstants{
    static ContentHTMLParser instance_;
	public static ContentHTMLParser getInstance() {
		if (instance_ == null) {
			instance_ = new ContentHTMLParser();
		}
		return instance_;
	}
	
	public String parseFromHtmlToCustom(String source)
	{
		String destination = source;
		destination = parseTags(destination, HTML_START_TITLE_TAG, CUSTOM_START_TITLE_TAG, HTML_END_TITLE_TAG, CUSTOM_END_TITLE_TAG);
		destination = parseTags(destination, HTML_START_PARA_TAG,  CUSTOM_START_PARA_TAG,  HTML_END_PARA_TAG,  CUSTOM_END_PARA_TAG);
		destination = parseTags(destination, HTML_START_BOLD_TAG,  CUSTOM_START_BOLD_TAG,  HTML_END_BOLD_TAG,  CUSTOM_END_BOLD_TAG);
		return destination;
	}
	
	public String parseFromCustomToHtml(String source)
	{
		String destination = source;
		destination = parseTags(destination, CUSTOM_START_TITLE_TAG, HTML_START_TITLE_TAG, CUSTOM_END_TITLE_TAG, HTML_END_TITLE_TAG);
		destination = parseTags(destination, CUSTOM_START_PARA_TAG,  HTML_START_PARA_TAG,  CUSTOM_END_PARA_TAG,  HTML_END_PARA_TAG);
		destination = parseTags(destination, CUSTOM_START_BOLD_TAG,  HTML_START_BOLD_TAG,  CUSTOM_END_BOLD_TAG,  HTML_END_BOLD_TAG);
		return destination;
	}

	public String parseTags(String source, String source_tag1, String dest_tag1, String source_tag2, String dest_tag2) {
		String destination = source;

		 Log.e("source", source);
		Pattern pattern = Pattern.compile(source_tag1);
		Matcher matcher = pattern.matcher(destination);
		// Check all occurance
		while (matcher.find()) {
			destination = matcher.replaceAll(dest_tag1);
		}

		pattern = Pattern.compile(source_tag2);
		matcher = pattern.matcher(destination);
		// Check all occurance
		while (matcher.find()) {
			destination = matcher.replaceAll(dest_tag2);
		}
		
		Log.e("destination", destination);

		return destination;
	}

}
