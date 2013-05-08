package com.mobilewiki;

import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
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

		TextView article_text_view = (TextView) findViewById(R.id.article_content);
		article_text_view.setMovementMethod(new ScrollingMovementMethod());
		article_text_view.requestFocus();
		// article_text_view.setText("line1 \nline2 \nline3 \nline4 \nline5 \nline6 \nline7 \nline8 \nline9 \nline10 line1 \nline2 \nline3 \nline4 \nline5 \nline6 \nline7 \nline8 \nline9 \nline10 line1 \nline2 \nline3 \nline4 \nline5 \nline6 \nline7 \nline8 \nline9 \nline10 line1 \nline2 \nline3 \nline4 \nline5 \nline6 \nline7 \nline8 \nline9 \nline10 line1 \nline2 \nline3 \nline4 \nline5 \nline6 \nline7 \nline8 \nline9 \nline10 line1 \nline2 \nline3 \nline4 \nline5 \nline6 \nline7 \nline8 \nline9 \nline10 line1 \nline2 \nline3 \nline4 \nline5 \nline6 \nline7 \nline8 \nline9 \nline10 \n");
		String title = "<h2>Title</h2><br>";
		String str = "<p> Descripti<br/>on here<br/> Descriptio<br/>n here Desc<br/>ription her<br/>e Descripti<br/>on here Desc<br/>ription hereD<br/>escription here<br/> Descripti<br/>on here D<br/>escri<br/>p<br/>tion here<br/>D<br/>e<br/><br/><br/><br/>scription here Description hereDescription here Description hereDescription hereDescription hereDescription here</p>";
		article_text_view.setMaxLines(article_text_view.getHeight()/article_text_view.getLineHeight());
		article_text_view.setText(Html.fromHtml(title + str + str + title + str + str + str));
		return true;
		
		//      android:maxLines="20"
		   
	}

}
