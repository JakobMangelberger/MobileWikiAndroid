package com.mobilewiki;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.EditText;

public class ContentHTMLParser implements IHTMLConstants {
	private static Matcher m_array;
	private static Pattern p_array;
	static ContentHTMLParser instance_;

	public ContentHTMLParser() {

		Log.e("length",
				Integer.toString(IHTMLConstants.custom_tag_array.length));

		p_array = Pattern.compile(IHTMLConstants.custom_tag_array[1]);

		// for (int iter = 0; iter < IHTMLConstants.custom_tag_array.length;
		// iter++) {
		// p_array[iter] = Pattern
		// .compile(IHTMLConstants.custom_tag_array[iter]);
		// }
	}

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
				destination = matcher.replaceAll(NEWLINE + dest_tag1 + NEWLINE);
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

	/**
	 * 
	 * @deprecated
	 */
	public EditText highlightSyntax(EditText et) {

		String content = et.getText().toString();

		m_array = Pattern.compile(IHTMLConstants.custom_tag_array[1]).matcher(
				content);

		while (m_array.find()) {
			Log.e("some tag", m_array.group());
			SpannableStringBuilder sb = new SpannableStringBuilder(
					m_array.group());
			SpannableStringBuilder sb_2 = new SpannableStringBuilder(
					m_array.group());
			final ForegroundColorSpan fcs = new ForegroundColorSpan(Color.rgb(
					255, 100, 50));
			final ForegroundColorSpan fcs_2 = new ForegroundColorSpan(
					Color.rgb(255, 100, 50));

			// Set the text color for first 4 characters
			sb.setSpan(fcs, 0, m_array.group().length(),
					Spannable.SPAN_INCLUSIVE_INCLUSIVE);
			sb_2.setSpan(fcs_2, 0, m_array.group().length(),
					Spannable.SPAN_INCLUSIVE_INCLUSIVE);

			SpannableStringBuilder sb2 = (SpannableStringBuilder) TextUtils
					.concat(sb, " ", sb_2);

			// make them also bold
			et.setText(sb);
		}

		return et;

	}

}
