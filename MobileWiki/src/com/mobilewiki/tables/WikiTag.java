package com.mobilewiki.tables;

import java.sql.Timestamp;

public class WikiTag implements IWikiTag {
	
	private int tag_id;
	private IWikiArticle article;
	private String tag;
	private Timestamp date_change;

	public WikiTag() {
		this.tag_id = -1;
		this.article = null;
		this.tag = "";
	}
	
	public WikiTag(int tag_id, IWikiArticle article, String tag) {
		this.tag_id = tag_id;
		this.article = article;
		this.tag = tag;
	}	
	
	@Override
	public int getTag_id() {
		return tag_id;
	}
	@Override
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
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
	public String getTag() {
		return tag;
	}
	@Override
	public void setTag(String tag) {
		this.tag = tag;
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
