package com.mobilewiki.tables;

import com.mobilewiki.RequestHandler;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class WikiContent implements IWikiContent {
		
	private int content_id;
	private int article_id;
	private String text;
	private Timestamp date_change;
    private List<String> tags;
	
	public WikiContent(int content_id) {
        RequestHandler sqlHandler = RequestHandler.getInstance();
		this.content_id = content_id;
		this.article_id = sqlHandler.getArticleIdForContentId(content_id);
		this.text = sqlHandler.getContentForContentId(content_id);
		this.date_change = Timestamp.valueOf(sqlHandler.getDateChangeForContentId(content_id));
        this.tags = Arrays.asList(sqlHandler.getTagForContentId(content_id).split(" "));
	}

    public WikiContent(int content_id, int article_id, String text, List<String> tags) {
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

    @Override
    public List<String> getTags() {
        return tags;
    }
}
