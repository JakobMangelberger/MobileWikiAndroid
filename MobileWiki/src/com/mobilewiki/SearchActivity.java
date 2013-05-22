package com.mobilewiki;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.mobilewiki.tables.IWikiArticle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchActivity extends Activity {
    SearchHandler searchHandler;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    @Override
    public void onStart() {
        super.onStart();
        searchHandler = new SearchHandler();

        Bundle parameters = getIntent().getExtras();
        String searchPhrase;
        if (null != parameters) {
            searchPhrase = parameters.getString("SEARCH_PHRASE");
            if (null == searchPhrase)
                searchPhrase = "";
        } else {
            searchPhrase = "";
        }

        final ListView listview = (ListView) findViewById(R.id.listView1);
        String[] values = new String[]{"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile"};

        IWikiArticle[] articles = searchHandler.search_articles(searchPhrase);

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < articles.length; ++i) {
            list.add(articles[i].getTitle());
        }

        final StableArrayAdapter adapter = new StableArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                Bundle b = new Bundle();
                b.putString("title", item); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
            }

        });
        listview.requestFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

}

class StableArrayAdapter extends ArrayAdapter<String> {

    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public StableArrayAdapter(Context context, int textViewResourceId,
                              List<String> objects) {
        super(context, textViewResourceId, objects);
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
        }
    }

    @Override
    public long getItemId(int position) {
        String item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        TextView tv = (TextView) view;
        tv.setTextColor(Color.BLACK);
        view.setBackgroundColor(Color.WHITE);
        return view;
    }
}