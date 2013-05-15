package com.mobilewiki.tables;

import java.sql.Timestamp;

public interface IWikiContent {

	public abstract int getContent_id();

	public abstract void setContent_id(int content_id);

	public abstract IWikiArticle getArticle();

	public abstract void setArticle(IWikiArticle article);

	public abstract String getText();

	public abstract void setText(String text);

	public abstract Timestamp getDate_change();

	public abstract void setDate_change(Timestamp date_change);

}