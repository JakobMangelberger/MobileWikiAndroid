package com.mobilewiki;

public interface IHTMLConstants {

	static String HTML_START_TITLE_TAG = "<h2>";
	static String HTML_END_TITLE_TAG = "</h2>";
	static String CUSTOM_START_TITLE_TAG = "<subtitle-start>";
    static String CUSTOM_END_TITLE_TAG = "<subtitle-end>";
    
	static String HTML_START_BOLD_TAG = "<b>";
	static String HTML_END_BOLD_TAG = "</b>";
	static String CUSTOM_START_BOLD_TAG = "<bold-start>";
    static String CUSTOM_END_BOLD_TAG = "<bold-end>";
	
	static String HTML_START_PARA_TAG = "<p>";
	static String HTML_END_PARA_TAG = "</p>";
	static String CUSTOM_START_PARA_TAG = "<paragraph-start>";
	static String CUSTOM_END_PARA_TAG = "<paragraph-end>";
	
	static String HTML_START_IMAGE_TAG = "<img src=\"";
	static String HTML_END_IMAGE_TAG = "\"/>";
	static String CUSTOM_START_IMAGE_TAG = "<image-start>";
	static String CUSTOM_END_IMAGE_TAG = "<image-end>";
	
	static String HTML_BREAKLINE_TAG = "<br/>";
	static String CUSTOM_BREAKLINE_TAG = "<empty-line>";
	
	static String NEWLINE = "\n";
	static String DOUBLE_NEWLINE = NEWLINE + NEWLINE;

	
}
