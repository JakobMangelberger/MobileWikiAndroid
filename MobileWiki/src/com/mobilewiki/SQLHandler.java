package com.mobilewiki;

import java.sql.Timestamp;
import java.util.*;

public class SQLHandler {
    private static SQLHandler _instance;
    private static int time_offset = 0;
    String[] titles = new String[]{"Android", "iPhone", "WindowsMobile",
            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
            "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
            "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
            "Android", "iPhone", "WindowsMobile"};


    private SQLHandler() {
        _instance = this;
    }

    public static SQLHandler getInstance() {
        if (null == _instance) {
            _instance = new SQLHandler();
        }
        return _instance;
    }

    public String get_title(int id) {
        if (id >= titles.length)
            return null;

        return titles[id];
    }

    public List<Integer> get_contents_for_article(int article_id) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);

        return result;
    }

    public Timestamp get_timestamp_for_content(int content_id) {
        return new Timestamp(Calendar.getInstance().getTime().getTime() + 100 * (time_offset++));
    }

    public int get_article_id_for_content(int content_id) {
        return 0;
    }

    public String get_text_for_content(int content_id) {
        return "Das ist ein Test.";
    }

    public List<String> get_tags_for_content(int content_id) {
        List<String> result = new ArrayList<String>();

        result.add("tag1");
        result.add("tag2");

        return result;
    }

    public int get_id_for_article_title(String title) {
        for (int i = 0; i < titles.length; i++) {
            if (titles[i] == title)
                return i;
        }
        return -1;
    }

    public Map<String, List<String>> get_all_titles_with_tags() {
        Map<String, List<String>> result = new HashMap<String, List<String>>();

        boolean odd = true;

        for (String title : titles) {
            List<String> tagList = new ArrayList<String>();
            if (odd) {
                tagList.add("tag1");
                odd = false;
            } else {
                tagList.add("tag2");
                odd = true;
            }
            result.put(title, tagList);
        }

        return result;
    }
}
