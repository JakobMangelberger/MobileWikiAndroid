package com.mobilewiki.tables;

import java.sql.Timestamp;
import java.util.List;

public interface IWikiContent {

	public abstract int getContent_id();

	public abstract int getArticle_id();

	public abstract String getText();

	public abstract Timestamp getDate_change();

    public abstract List<String> getTags();

}