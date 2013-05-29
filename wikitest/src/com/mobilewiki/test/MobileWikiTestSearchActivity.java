package com.mobilewiki.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;

import com.mobilewiki.R;
import com.mobilewiki.SearchActivity;

public class MobileWikiTestSearchActivity extends
ActivityInstrumentationTestCase2<SearchActivity>{

	@SuppressWarnings("deprecation")
	public MobileWikiTestSearchActivity() {
		super("com.mobilewiki", SearchActivity.class);
	}
	
	private ListView listView;
	private SearchActivity activity;

	protected void setUp() throws Exception {
		super.setUp();

	}

	public void test_view() {
		activity = getActivity();
		listView = (ListView) activity.findViewById(R.id.listView1);

		assertNotNull(listView);
	}
	
	public void test_excessiveSearch() {
		activity = getActivity();
		listView = (ListView) activity.findViewById(R.id.listView1);

		assertNotNull(listView);
	}
}
