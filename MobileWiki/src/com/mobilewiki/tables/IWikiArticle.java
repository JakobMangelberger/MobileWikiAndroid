package com.mobilewiki.tables;

import java.sql.Timestamp;

public interface IWikiArticle {


	public abstract int getArticle_id();

	public abstract String getTitle();

	public abstract void setTitle(String title);

    public abstract int getLastContentId();

    public abstract Timestamp getLastContentTimestamp();
}