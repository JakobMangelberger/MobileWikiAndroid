package com.mobilewiki.test;

import com.mobilewiki.MainActivity;
import com.mobilewiki.R;
import com.mobilewiki.SearchActivity;
import com.mobilewiki.controls.StableArrayAdapter;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class MobileWikiTestMainActivity extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private TextView field;
	private MainActivity activity;

	@SuppressWarnings("deprecation")
	public MobileWikiTestMainActivity() {
		super("com.mobilewiki", MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();

	}

	public void test_view() {
		activity = getActivity();
		field = (TextView) activity.findViewById(R.id.article_content);

		String mathResult = field.getText().toString();
		assertTrue("False content in TextView", !mathResult.equals(""));
	}

	/*Press Search Button and start activity*/
	public void test_startSearchActivity() {
		activity = getActivity();
		assertNotNull(activity);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Create an ActivityMonitor that monitor ChildActivity, do not
		// interrupt, do not return mock result:
		Instrumentation.ActivityMonitor activityMonitor = getInstrumentation()
				.addMonitor(SearchActivity.class.getName(), null, false);

		// Simulate a button click in MainActivity that start ChildActivity for
		// result:
		final ImageButton button = (ImageButton) activity
				.findViewById(R.id.search_button);
		activity.runOnUiThread(new Runnable() {
			public void run() {
				button.performClick();
			}
		});

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		getInstrumentation().waitForIdleSync();
		SearchActivity childActivity = (SearchActivity) getInstrumentation()
				.waitForMonitorWithTimeout(activityMonitor, 5);
		//ChildActivity is created and gain focus on screen:
		assertNotNull(childActivity);

		final ImageButton button2 = (ImageButton) childActivity
				.findViewById(R.id.search_button);

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		childActivity.finish();
		
		try {
			getInstrumentation().waitForIdleSync();
			assertNotNull(button2);			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			childActivity.finish();
		}

	}

	/*Execute search with query that should fail*/
	public void test_executeSearchNoResults() {
		activity = getActivity();
		assertNotNull(activity);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Create an ActivityMonitor that monitor ChildActivity, do not
		// interrupt, do not return mock result:
		Instrumentation.ActivityMonitor activityMonitor = getInstrumentation()
				.addMonitor(SearchActivity.class.getName(), null, false);

		// Simulate a button click in MainActivity that start ChildActivity for
		// result:
		final ImageButton button = (ImageButton) activity
				.findViewById(R.id.search_button);
		activity.runOnUiThread(new Runnable() {
			public void run() {
				button.performClick();
			}
		});

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		getInstrumentation().waitForIdleSync();
		SearchActivity childActivity = (SearchActivity) getInstrumentation()
				.waitForMonitorWithTimeout(activityMonitor, 5);
		//ChildActivity is created and gain focus on screen:
		assertNotNull(childActivity);

		final ListView listView = (ListView) childActivity
				.findViewById(R.id.listView1);

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		try {
			getInstrumentation().waitForIdleSync();
			assertNotNull(listView);
			assertEquals(listView.getCount(), 1);
			StableArrayAdapter adapter = (StableArrayAdapter)listView.getAdapter();
			assertEquals(adapter.getItem(0), activity.getResources().getString(R.string.noentries));			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			childActivity.finish();
		}		
	}
	
}
