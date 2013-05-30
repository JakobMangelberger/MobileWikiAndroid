package com.mobilewiki;

public interface IHTMLConstants {

	static String HTML_START_TITLE_TAG = "<h2>";
	static String HTML_END_TITLE_TAG = "</h2>";
	static String CUSTOM_START_TITLE_TAG = "<subtitle-start>\n";
    static String CUSTOM_END_TITLE_TAG = "\n<subtitle-end>\n\n";
    
	static String HTML_START_BOLD_TAG = "<b>";
	static String HTML_END_BOLD_TAG = "</b>";
	static String CUSTOM_START_BOLD_TAG = "<bold-start>";
    static String CUSTOM_END_BOLD_TAG = "<bold-end>";
	
	static String HTML_START_PARA_TAG = "<p>";
	static String HTML_END_PARA_TAG = "</p>";
	static String CUSTOM_START_PARA_TAG = "<paragraph-start>\n";
	static String CUSTOM_END_PARA_TAG = "\n<paragraph-end>\n\n";
	
}
