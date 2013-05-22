package com.mobilewiki.tables;

import android.R;
import com.mobilewiki.SQLHandler;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

public class WikiContent implements IWikiContent {
		
	private int content_id;
	private int article_id;
	private String text;
	private Timestamp date_change;
    private List<String> tags;
	
	WikiContent(int content_id) {
        SQLHandler sqlHandler = SQLHandler.getInstance();
		this.content_id = content_id;
		this.article_id = sqlHandler.get_article_id_for_content(content_id);
		this.text = sqlHandler.get_text_for_content(content_id);
		this.date_change = sqlHandler.get_timestamp_for_content(content_id);
        this.tags = sqlHandler.get_tags_for_content(content_id);
	}
	
	WikiContent(int content_id, int article_id, String text, List<String> tags) {
		this.content_id = content_id;
		this.article_id = article_id;
		this.text = text;
        this.date_change = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.tags = tags;
	}

	@Override
	public int getContent_id() {
		return content_id;
	}

	@Override
	public int getArticle_id() {
		return article_id;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public Timestamp getDate_change() {
		return date_change;
	}
}
