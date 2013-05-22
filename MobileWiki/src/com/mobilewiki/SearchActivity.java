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

        performSearch(this, searchHandler, list, searchPhrase);

        final ListView listview = (ListView) findViewById(R.id.listView1);
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

        final EditText searchPhraseBox = (EditText) findViewById(R.id.search_text);
        final Activity context = this;
        ImageButton searchButton = (ImageButton) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                performSearch(context, searchHandler, list, searchPhraseBox.getText().toString());
                Log.d("SEARCH", Integer.toString(list.size()));
                ((StableArrayAdapter)listview.getAdapter()).notifyDataSetChanged();
            }
        });
    }

    private static void performSearch(Activity context, SearchHandler searchHandler, List<String> list, String searchPhrase) {
        List<IWikiArticle> articles = searchHandler.search_articles(searchPhrase);
        list.clear();

        for (IWikiArticle article : articles) {
            list.add(article.getTitle());
        }
        if(list.size() == 0) {
            //list.add(context.getString(R.string.no));
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
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return false;
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