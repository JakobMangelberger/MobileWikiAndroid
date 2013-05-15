package com.mobilewiki.tables;

import java.sql.Timestamp;

public interface IWikiTag {

	public abstract int getTag_id();

	public abstract void setTag_id(int tag_id);

	public abstract IWikiArticle getArticle();

	public abstract void setArticle(IWikiArticle article);

	public abstract String getTag();

	public abstract void setTag(String tag);

	public abstract Timestamp getDate_change();

	public abstract void setDate_change(Timestamp date_change);

}