package com.mobilewiki.test;

import com.mobilewiki.MainActivity;
import com.mobilewiki.R;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;


public class wikitest extends ActivityInstrumentationTestCase2<MainActivity> {

	private Button button_search;
	private TextView field;
	
	public wikitest() {
		super("com.mobilewiki", MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
	}
	
	public void test_view()
	{
		MainActivity activity = getActivity();
		
		field = (TextView) activity.findViewById(R.id.article_content);
		
		String mathResult = field.getText().toString();  
		assertTrue("False content in TextView", !mathResult.equals(""));  
	}

}
