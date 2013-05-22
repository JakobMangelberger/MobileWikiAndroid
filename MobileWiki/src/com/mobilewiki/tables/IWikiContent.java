package com.mobilewiki.tables;

import java.sql.Timestamp;

public interface IWikiContent {

	public abstract int getContent_id();

	public abstract int getArticle_id();

	public abstract String getText();

	public abstract Timestamp getDate_change();

}