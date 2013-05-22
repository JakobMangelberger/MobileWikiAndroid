package com.mobilewiki.tables;

public interface IWikiArticle {


	public abstract int getArticle_id();

	public abstract String getTitle();

	public abstract void setTitle(String title);

    public abstract int getLastContentId();
}