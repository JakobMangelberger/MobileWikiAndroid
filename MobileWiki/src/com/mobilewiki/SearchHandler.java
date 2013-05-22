package com.mobilewiki;

import android.util.Log;
import com.mobilewiki.tables.IWikiArticle;
import com.mobilewiki.tables.IWikiContent;
import com.mobilewiki.tables.WikiArticle;
import com.mobilewiki.tables.WikiContent;

import java.util.ArrayList;
import java.util.List;

public class SearchHandler {

    public void init_search(String search_item) {

    }

    public List<IWikiArticle> search_articles(String phrase) {
        SQLHandler sqlHandler = SQLHandler.getInstance();
        int[] ids = sqlHandler.get_ids();
        String[] keywords = phrase.split(" ");

        List<IWikiArticle> articles = new ArrayList<IWikiArticle>();
        for(int i = 0; i < ids.length; i++)
        {
            IWikiArticle tempArticle = new WikiArticle(i);
            IWikiContent tempContent = new WikiContent(tempArticle.getLastContentId());
            for(String keyword : keywords) {
                if(tempContent.getTags().contains(keyword))
                {
                    articles.add(tempArticle);
                    break;
                }
            }
        }

        return articles;
    }
}
