package com.mobilewiki;

import com.mobilewiki.tables.IWikiArticle;
import com.mobilewiki.tables.WikiArticle;

public class SearchHandler {

    public void init_search(String search_item) {

    }

    public IWikiArticle[] search_articles(String phrase) {
        return new IWikiArticle[] { new WikiArticle(0, "Test")};
    }
}
