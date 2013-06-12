package com.mobilewiki;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.*;
import com.mobilewiki.tables.IWikiArticle;
import com.mobilewiki.tables.WikiArticle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SearchActivity extends Activity {
    SearchHandler searchHandler;
    ArrayList<String> list;
    StableArrayAdapter adapter;
    StableArrayAdapter noEntriesAdapter;
    boolean areThereEntries = true;
    int sortMode = 0;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    @Override
    protected void onResume() {
        super.onResume();
        performSearch();
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
        noEntriesList.add(getString(R.string.no_entries));
        noEntriesAdapter = new StableArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1, noEntriesList);

        listview.setAdapter(adapter);

        EditText searchPhraseBox = (EditText) findViewById(R.id.search_text);
        searchPhraseBox.setText(searchPhrase);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                if (!areThereEntries)
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

        ImageButton searchButton = (ImageButton) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performSearch();
                Log.d("SEARCH", Integer.toString(list.size()));
                ((StableArrayAdapter) listview.getAdapter()).notifyDataSetChanged();
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.search_sort_selector);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sortMode = i;
                sort();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        setKeyboardSearchButtonListener();
    }

    void sort() {
        if (sortMode == 0) {
            adapter.sort(new Comparator<String>() {
                @Override
                public int compare(String s, String s2) {
                    return s.toLowerCase().compareTo(s2.toLowerCase());
                }
            });
        } else if (sortMode == 1) {
            adapter.sort(new Comparator<String>() {
                @Override
                public int compare(String s, String s2) {
                    return s2.toLowerCase().compareTo(s.toLowerCase());
                }
            });
        } else if (sortMode == 2) {
            adapter.sort(new Comparator<String>() {
                @Override
                public int compare(String s, String s2) {
                    IWikiArticle article1 = new WikiArticle(RequestHandler.getInstance().getArticleIdForTitle(s));
                    IWikiArticle article2 = new WikiArticle(RequestHandler.getInstance().getArticleIdForTitle(s2));
                    return article1.getLastContentTimestamp().compareTo(article2.getLastContentTimestamp());
                }
            });
        } else if (sortMode == 3) {
            adapter.sort(new Comparator<String>() {
                @Override
                public int compare(String s, String s2) {
                    IWikiArticle article1 = new WikiArticle(RequestHandler.getInstance().getArticleIdForTitle(s2));
                    IWikiArticle article2 = new WikiArticle(RequestHandler.getInstance().getArticleIdForTitle(s));
                    return article1.getLastContentTimestamp().compareTo(article2.getLastContentTimestamp());
                }
            });
        }
    }

    private void setKeyboardSearchButtonListener() {
        EditText searchText = (EditText) findViewById(R.id.search_text);
        final ImageButton searchButton = (ImageButton) findViewById(R.id.search_button);
        if (null != searchText) {
            searchText.setOnEditorActionListener(new EditText.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        searchButton.performClick();
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    private void performSearch() {
        ListView listView = (ListView) findViewById(R.id.listView1);
        SearchHandler searchHandler = SearchHandler.getInstance();
        ToggleButton typeButton = (ToggleButton) findViewById(R.id.search_type_button);
        boolean matchAllKeywords = false;
        if (null != typeButton) {
            matchAllKeywords = typeButton.isChecked();
        }

        EditText searchPhraseBox = (EditText) findViewById(R.id.search_text);
        List<String> articles = searchHandler.search_articles(searchPhraseBox.getText().toString(), matchAllKeywords);
        list.clear();

        for (String article : articles) {
            list.add(article);
        }
        if (list.size() == 0) {
            listView.setAdapter(noEntriesAdapter);
            areThereEntries = false;
        } else {
            listView.setAdapter(adapter);
            areThereEntries = true;
        }

        sort();
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
