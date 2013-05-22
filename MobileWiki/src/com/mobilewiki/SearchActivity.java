package com.mobilewiki;

import com.mobilewiki.controls.StableArrayAdapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.mobilewiki.tables.IWikiArticle;

import java.util.ArrayList;

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
