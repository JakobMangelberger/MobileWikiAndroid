package com.mobilewiki.tables;

import java.sql.Timestamp;

public class WikiArticle implements IWikiArticle {
	
	private int arcticle_id;
	private String title;
	private Timestamp date_edit;
	
	
	public WikiArticle()
	{
		this.arcticle_id = -1;
		this.title = "";
		this.date_edit = null;
	}
	
	public WikiArticle(int article_id, String title)
	{
		this.arcticle_id = article_id;
		this.title = title;
	}

	@Override
	public int getArcticle_id() {
		return arcticle_id;
	}

	@Override
	public void setArcticle_id(int arcticle_id) {
		this.arcticle_id = arcticle_id;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public Timestamp getDate_edit() {
		return date_edit;
	}

	@Override
	public void setDate_edit(Timestamp date_edit) {
		this.date_edit = date_edit;
	}

}
