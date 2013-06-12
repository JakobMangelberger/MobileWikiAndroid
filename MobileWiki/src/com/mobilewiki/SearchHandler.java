package com.mobilewiki;

import com.mobilewiki.tables.IWikiArticle;
import com.mobilewiki.tables.IWikiContent;
import com.mobilewiki.tables.WikiArticle;
import com.mobilewiki.tables.WikiContent;

import java.util.ArrayList;
import java.util.List;

public class SearchHandler {
    private static SearchHandler _instance;

    private SearchHandler() {
        _instance = this;
    }

    public static SearchHandler getInstance() {
        if (null == _instance)
            new SearchHandler();
        return _instance;
    }

    public List<IWikiArticle> search_articles(String phrase, boolean allKeywords) {
        RequestHandler sqlHandler = RequestHandler.getInstance();
        List<Integer> ids = sqlHandler.getArticleIds();
        String[] keywords = phrase.split(" ");

        List<IWikiArticle> articles = new ArrayList<IWikiArticle>();
        for (int i = 0; i < ids.size(); i++) {
            IWikiArticle tempArticle = new WikiArticle(ids.get(i));
            IWikiContent tempContent = new WikiContent(tempArticle.getLastContentId());
            if (!allKeywords) {
                for (String keyword : keywords) {
                    boolean contains = false;
                    for(String tag : tempContent.getTags()) {
                        if(tag.equalsIgnoreCase(keyword)) {
                            contains = true;
                            break;
                        }
                    }
                    if (contains) {
                        articles.add(tempArticle);
                        break;
                    }
                }
            } else {
                boolean allKeywordsFound = true;
                for(String keyword : keywords) {
                    boolean contains = false;
                    for(String tag : tempContent.getTags()) {
                        if(tag.equalsIgnoreCase(keyword)) {
                            contains = true;
                            break;
                        }
                    }
                    if(!contains) {
                        allKeywordsFound = false;
                        break;
                    }
                }
                if(allKeywordsFound)
                    articles.add((tempArticle));
            }
        }

        return articles;
    }
}
