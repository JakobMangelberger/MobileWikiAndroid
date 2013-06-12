package com.mobilewiki.tables;

import com.mobilewiki.RequestHandler;

import java.sql.Timestamp;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class WikiArticle implements IWikiArticle {
    SortedMap<Timestamp, Integer> contents;
    private int article_id;
    private String title;


    public WikiArticle(int articleId) {
        RequestHandler sqlHandler = RequestHandler.getInstance();

        this.article_id = articleId;
        this.title = sqlHandler.getTitleForArticleId(articleId);
        this.contents = new TreeMap<Timestamp, Integer>();
        List<Integer> contents_from_db = sqlHandler.getContentIdsforArticleId(article_id);
        for (int content_id : contents_from_db) {
            contents.put(Timestamp.valueOf(sqlHandler.getDateChangeForContentId(content_id)), content_id);
        }
    }

    public WikiArticle(int article_id, String title) {
        this.article_id = article_id;
        this.title = title;
    }

    @Override
    public int getArticle_id() {
        return article_id;
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
    public int getLastContentId() {
        return contents.get(contents.lastKey());
    }

    @Override
    public Timestamp getLastContentTimestamp() {
        return contents.lastKey();
    }
}
