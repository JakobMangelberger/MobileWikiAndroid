package com.mobilewiki;

import com.mobilewiki.tables.IWikiArticle;
import com.mobilewiki.tables.WikiArticle;

public class SearchHandler {

    public void init_search(String search_item) {

    }

    public IWikiArticle[] search_articles(String phrase) {
        SQLHandler sqlHandler = SQLHandler.getInstance();
        int[] ids =sqlHandler.get_ids();

        IWikiArticle[] articles = new IWikiArticle[ids.length];
        for(int i = 0; i < articles.length; i++)
        {
            articles[i] = new WikiArticle(i);
        }

        return articles;
    }
}
