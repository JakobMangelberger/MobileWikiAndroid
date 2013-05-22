package com.mobilewiki;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	public void onStart(){
		super.onStart();
		
		Bundle b = getIntent().getExtras();
		String title, value = null;
		if (b != null)
			value = b.getString("title");
		
		TextView article_text_view = (TextView) findViewById(R.id.article_content);
		article_text_view.setMovementMethod(new ScrollingMovementMethod());
		if (value != null)
			title = "<h2>"+value+"</h2>";
		else
			title = "<h2>Startseite</h2>";
		String str = "<p>Das ist ein Test<p/>";
		article_text_view.setText(Html.fromHtml(title + str + str + title + str + str + str+ str + str + str+ str + str + str+ str + str + str));
		
		ImageButton searchButton = (ImageButton) findViewById(R.id.search_button);
		searchButton.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				Intent intent = new Intent(MainActivity.this, SearchActivity.class);
		        startActivity(intent);
		}
		});
		
		searchButton.requestFocus();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) { 
		getMenuInflater().inflate(R.menu.main, menu);
		return true;	   
	}

}
