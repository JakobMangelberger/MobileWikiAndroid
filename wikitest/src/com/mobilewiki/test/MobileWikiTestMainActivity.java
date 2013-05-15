package com.mobilewiki.test;

import com.mobilewiki.MainActivity;
import com.mobilewiki.R;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;


public class MobileWikiTestMainActivity extends ActivityInstrumentationTestCase2<MainActivity> {

	private TextView field;
	
	@SuppressWarnings("deprecation")
	public MobileWikiTestMainActivity() {
		super("com.mobilewiki", MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
	}
	
	/*public void test_view()
	{
		MainActivity activity = getActivity();
		
		field = (TextView) activity.findViewById(R.id.article_content);
		
		String mathResult = field.getText().toString();  
		//assertTrue("False content in TextView", !mathResult.equals(""));  
	}*/

}
