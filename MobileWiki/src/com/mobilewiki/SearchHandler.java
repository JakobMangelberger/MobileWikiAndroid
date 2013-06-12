package com.mobilewiki;

import com.mobilewiki.tables.IWikiArticle;
import com.mobilewiki.tables.IWikiContent;
import com.mobilewiki.tables.WikiArticle;
import com.mobilewiki.tables.WikiContent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public List<String> search_articles(String phrase, boolean allKeywords) {
        RequestHandler sqlHandler = RequestHandler.getInstance();
        String[] keywords = phrase.split(" ");

        Map<String, List<String>> allEntries = sqlHandler.get_all_titles_with_tags();

        List<String> articles = new ArrayList<String>();
        for (String entryTitle : allEntries.keySet()) {
            List<String> tags = allEntries.get(entryTitle);

            if (!allKeywords) {
                for (String keyword : keywords) {
                    boolean contains = false;
                    for(String tag : tags) {
                        if(tag.equalsIgnoreCase(keyword)) {
                            contains = true;
                            break;
                        }
                    }
                    if (contains) {
                        articles.add(entryTitle);
                        break;
                    }
                }
            } else {
                boolean allKeywordsFound = true;
                for(String keyword : keywords) {
                    boolean contains = false;
                    for(String tag : tags) {
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
                    articles.add((entryTitle));
            }
        }

        return articles;
    }
}
