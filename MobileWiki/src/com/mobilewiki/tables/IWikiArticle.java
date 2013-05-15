package com.mobilewiki.tables;

import java.sql.Timestamp;

public interface IWikiArticle {

	public abstract int getArcticle_id();

	public abstract void setArcticle_id(int arcticle_id);

	public abstract String getTitle();

	public abstract void setTitle(String title);

	public abstract Timestamp getDate_edit();

	public abstract void setDate_edit(Timestamp date_edit);

}