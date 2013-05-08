package com.mobilewiki;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
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
		TextView article_text_view = (TextView) findViewById(R.id.article_content);
		article_text_view.setMovementMethod(new ScrollingMovementMethod());
		String title = "<h2>Title</h2>"; 
		String str = "<p>This is some paragraph with text. Test post, please ignore. Test post, please ignore. Test post, please ignore. Test post, please ignore.<p/>";
	//	article_text_view.setMaxLines(article_text_view.getHeight()/article_text_view.getLineHeight());
		article_text_view.setTextColor(Color.BLACK);
		article_text_view.setText(Html.fromHtml(title + str + str + title + str + str + str+ str + str + str+ str + str + str+ str + str + str));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) { 
		getMenuInflater().inflate(R.menu.main, menu);
		return true;	   
	}

}
