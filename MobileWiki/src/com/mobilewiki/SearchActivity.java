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
import android.widget.*;
import com.mobilewiki.tables.IWikiArticle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchActivity extends Activity {
    SearchHandler searchHandler;
    ArrayList<String> list;
    StableArrayAdapter adapter;
    StableArrayAdapter noEntriesAdapter;
    boolean areThereEntries = true;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    @Override
    public void onStart() {
        super.onStart();
        searchHandler = SearchHandler.getInstance();
        list = new ArrayList<String>();

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


        adapter = new StableArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1, list);

        List<String> noEntriesList = new ArrayList<String>(1);
        noEntriesList.add(getString(R.string.noentries));
        noEntriesAdapter = new StableArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1, noEntriesList);

        listview.setAdapter(adapter);

        performSearch(listview, searchHandler, list, searchPhrase);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                if(!areThereEntries)
                    return;

                final String item = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                Bundle b = new Bundle();
                b.putString("title", item); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
            }

        });
        listview.requestFocus();

        final EditText searchPhraseBox = (EditText) findViewById(R.id.search_text);
        ImageButton searchButton = (ImageButton) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                performSearch(listview, searchHandler, list, searchPhraseBox.getText().toString());
                Log.d("SEARCH", Integer.toString(list.size()));
                ((StableArrayAdapter)listview.getAdapter()).notifyDataSetChanged();
            }
        });
    }

    private void performSearch(ListView listView, SearchHandler searchHandler, List<String> list, String searchPhrase) {
        List<IWikiArticle> articles = searchHandler.search_articles(searchPhrase);
        list.clear();

        for (IWikiArticle article : articles) {
            list.add(article.getTitle());
        }
        if(list.size() == 0) {
            listView.setAdapter(noEntriesAdapter);
            areThereEntries = false;
        } else {
            listView.setAdapter(adapter);
            areThereEntries = true;
        }
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
        try {
            return mIdMap.get(item);
        } catch (NullPointerException ex) {
            return 0;
        }
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