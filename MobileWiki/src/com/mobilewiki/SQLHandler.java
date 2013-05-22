package com.mobilewiki;

import java.sql.Timestamp;
import java.util.List;

public class SQLHandler {
    String[] titles = new String[]{"Android", "iPhone", "WindowsMobile",
            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
            "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
            "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
            "Android", "iPhone", "WindowsMobile"};

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
        return null;
    }

    public Timestamp get_timestampt_for_content(int content_id) {
        return null;
    }
}
