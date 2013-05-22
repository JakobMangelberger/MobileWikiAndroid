package com.mobilewiki.tables;

import com.mobilewiki.SQLHandler;

import java.sql.Timestamp;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class WikiArticle implements IWikiArticle {
    SortedMap<Timestamp, Integer> contents;
    private int article_id;
    private String title;


    public WikiArticle(int articleId) {
        SQLHandler sqlHandler = new SQLHandler();

        this.article_id = articleId;
        this.title = sqlHandler.get_title(articleId);
        this.contents = new TreeMap<Timestamp, Integer>();
        List<Integer> contents_from_db = sqlHandler.get_contents_for_article(article_id);
        for (int content_id : contents_from_db) {
            contents.put(sqlHandler.get_timestampt_for_content(content_id), content_id);
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
    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }


}
