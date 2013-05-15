package com.mobilewiki.tables;

import java.sql.Timestamp;

public class WikiContent implements IWikiContent {
		
	private int content_id;
	private IWikiArticle article;
	private String text;
	private Timestamp date_change;
	
	WikiContent() {
		this.content_id = -1;
		this.article = null;
		this.text = "";
		this.date_change = null;
	}
	
	WikiContent(int content_id, IWikiArticle article, String text) {
		this.content_id = content_id;
		this.article = article;
		this.text = text;
	}

	@Override
	public int getContent_id() {
		return content_id;
	}

	@Override
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}

	@Override
	public IWikiArticle getArticle() {
		return article;
	}

	@Override
	public void setArticle(IWikiArticle article) {
		this.article = article;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public Timestamp getDate_change() {
		return date_change;
	}

	@Override
	public void setDate_change(Timestamp date_change) {
		this.date_change = date_change;
	}
}
