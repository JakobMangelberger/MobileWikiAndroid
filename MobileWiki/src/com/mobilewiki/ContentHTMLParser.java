package com.mobilewiki;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentHTMLParser implements IHTMLConstants {
	static ContentHTMLParser instance_;

	public static ContentHTMLParser getInstance() {
		if (instance_ == null) {
			instance_ = new ContentHTMLParser();
		}
		return instance_;
	}

	public String parseFromHtmlToCustom(String source) {
		String destination = source;
		destination = parseTags(destination, HTML_START_TITLE_TAG,
				CUSTOM_START_TITLE_TAG, HTML_END_TITLE_TAG,
				CUSTOM_END_TITLE_TAG, false, false);
		destination = parseTags(destination, HTML_START_PARA_TAG,
				CUSTOM_START_PARA_TAG, HTML_END_PARA_TAG, CUSTOM_END_PARA_TAG,
				false, false);
		destination = parseTags(destination, HTML_START_BOLD_TAG,
				CUSTOM_START_BOLD_TAG, HTML_END_BOLD_TAG, CUSTOM_END_BOLD_TAG,
				false, false);
		destination = parseTags(destination, HTML_START_IMAGE_TAG,
				CUSTOM_START_IMAGE_TAG, HTML_END_IMAGE_TAG,
				CUSTOM_END_IMAGE_TAG, false, false);
		destination = parseTags(destination, HTML_BREAKLINE_TAG,
				CUSTOM_BREAKLINE_TAG, "", "", false, true);
		return destination;
	}

	public String parseFromCustomToHtml(String source) {
		String destination = source;
		destination = parseTags(destination, CUSTOM_START_TITLE_TAG,
				HTML_START_TITLE_TAG, CUSTOM_END_TITLE_TAG, HTML_END_TITLE_TAG,
				true, false);
		destination = parseTags(destination, CUSTOM_START_PARA_TAG,
				HTML_START_PARA_TAG, CUSTOM_END_PARA_TAG, HTML_END_PARA_TAG,
				true, false);
		destination = parseTags(destination, CUSTOM_START_BOLD_TAG,
				HTML_START_BOLD_TAG, CUSTOM_END_BOLD_TAG, HTML_END_BOLD_TAG,
				true, false);
		destination = parseTags(destination, CUSTOM_START_IMAGE_TAG,
				HTML_START_IMAGE_TAG, CUSTOM_END_IMAGE_TAG, HTML_END_IMAGE_TAG,
				true, false);
		destination = parseTags(destination, CUSTOM_BREAKLINE_TAG,
				HTML_BREAKLINE_TAG, "", "", true, true);
		return destination;
	}

	public String parseTags(String source, String source_tag1,
			String dest_tag1, String source_tag2, String dest_tag2,
			boolean customToHTML, boolean ignore_second_tag) {
		String destination = source;

		if (customToHTML) {
			Pattern pattern = Pattern.compile("\n");
			Matcher matcher = pattern.matcher(destination);
			// Check all occurance
			while (matcher.find()) {
				destination = matcher.replaceAll("");
			}
		}

		// Log.e("source", source);
		Pattern pattern = Pattern.compile(source_tag1);
		Matcher matcher = pattern.matcher(destination);
		// Check all occurance
		while (matcher.find()) {
			if (customToHTML) {
				destination = matcher.replaceAll(dest_tag1);
			} else {
				destination = matcher.replaceAll(NEWLINE + dest_tag1
						+ DOUBLE_NEWLINE);
			}
		}

		if (!ignore_second_tag) {
			pattern = Pattern.compile(source_tag2);
			matcher = pattern.matcher(destination);
			// Check all occurance
			while (matcher.find()) {
				if (customToHTML) {
					destination = matcher.replaceAll(dest_tag2);
				} else {
					destination = matcher.replaceAll(NEWLINE + dest_tag2
							+ DOUBLE_NEWLINE);
				}
			}
		}

		// Log.e("destination", destination);

		return destination;
	}

}
