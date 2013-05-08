package com.mobilewiki;

import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.widget.TextView;

public class TestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) { 
		getMenuInflater().inflate(R.menu.main, menu);
  
		TextView tv = (TextView) findViewById(R.id.article_content);
		tv.setText("article_contentarticle_contentarticle_conte" +
				"ntarticle_contentarticle_contentarticle_con" +
  				"tentarticle_contentarticle_contentarticl" +
				"   e_contentarticle_contentarticle_content");

		TextView article_text_view = (TextView) findViewById(R.id.article_content);
		article_text_view.setMovementMethod(new ScrollingMovementMethod());
		article_text_view.requestFocus();
		String title = "<h2>Title</h2>";
		String str = "<p>This is some paragraph with text. Test post, please ignore. Test post, please ignore. Test post, please ignore. Test post, please ignore.<p/>";
		article_text_view.setMaxLines(article_text_view.getHeight()/article_text_view.getLineHeight());
		article_text_view.setText(Html.fromHtml(title + str + str + title + str + str + str+ str + str + str+ str + str + str+ str + str + str));
		return true;	   
	}

}
