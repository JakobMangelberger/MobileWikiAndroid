package com.mobilewiki;

import com.mobilewiki.tables.IWikiArticle;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SQLHandler {
    private static SQLHandler _instance;
    public static SQLHandler getInstance() {
        if(null == _instance) {
            _instance = new SQLHandler();
        }
        return _instance;
    }

    private static int time_offset = 0;


    String[] titles = new String[]{"Android", "iPhone", "WindowsMobile",
            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
            "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
            "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
            "Android", "iPhone", "WindowsMobile"};

    private SQLHandler() {
        _instance = this;
    }

    public int[] get_ids() {
        int[] result = new int[titles.length];

        for(int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    public String get_title(int id) {
        if(id >= titles.length)
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
        for(int i = 0; i < titles.length; i++) {
            if(titles[i] == title)
                return i;
        }
        return  -1;
    }
}
