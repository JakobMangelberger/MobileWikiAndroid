package com.mobilewiki;

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
}
