package com.mobilewiki;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) { 
		getMenuInflater().inflate(R.menu.main, menu);

		TextView tv = (TextView) findViewById(R.id.article_content);
		tv.setText("article_contentarticle_contentarticle_conte" +
				"ntarticle_contentarticle_contentarticle_con" +
				"tentarticle_contentarticle_contentarticl" +
				"   e_contentarticle_contentarticle_content");

		return true;
	}

}
