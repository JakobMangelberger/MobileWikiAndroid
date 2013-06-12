package com.mobilewiki;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ImageGetter imgGetter = new ImageGetter() {
		public Drawable getDrawable(String source) {
			Drawable drawable = getResources().getDrawable(
					R.drawable.borat);
			drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
					drawable.getIntrinsicHeight());
			return drawable;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_main); 
	}

	@Override
	public void onStart() {  
		super.onStart();
		final EditText searchPhrase = (EditText) findViewById(R.id.search_text);

		Bundle b = getIntent().getExtras();
		String title, value = null;
		if (b != null)
			value = b.getString("title");

		TextView article_text_view = (TextView) findViewById(R.id.article_content);
		article_text_view.setMovementMethod(new ScrollingMovementMethod());
		if (value != null)
			title = "<h2>" + value + "</h2>";
		else
			title = "<h2>Startseite</h2>";
		String str = "<p>Das ist ein Test<p/>";
		String cont_bla = (title + str + str + title + str
				+ str + "<p>Das ist ein <b>Borat!!</b></p>" + "<img src=\"image.png\"/>" + str + str + str + str + str + str + str
				+ str); 
		article_text_view.setText(Html.fromHtml(cont_bla, imgGetter, null));
		

		ImageButton searchButton = (ImageButton) findViewById(R.id.search_button);
		searchButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						SearchActivity.class);
				Bundle parameters = new Bundle(1);
				parameters.putString("SEARCH_PHRASE", searchPhrase.getText()
						.toString());
				intent.putExtras(parameters);
				startActivity(intent);
			}
		});

		searchButton.requestFocus();

		setKeyboardSearchButtonListener();
	}

	private void setKeyboardSearchButtonListener() {
		EditText searchText = (EditText) findViewById(R.id.search_text);
		final ImageButton searchButton = (ImageButton) findViewById(R.id.search_button);
		if (null != searchText) {
			searchText
					.setOnEditorActionListener(new EditText.OnEditorActionListener() {
						@Override
						public boolean onEditorAction(TextView v, int actionId,
								KeyEvent event) {
							if (actionId == EditorInfo.IME_ACTION_SEARCH) {
								searchButton.performClick();
								return true;
							}
							return false;
						}
					});
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.edit_article:
			intent = new Intent(MainActivity.this, EditorActivity.class);
			Bundle parameters = new Bundle(1);
			parameters.putString("ARTICLE_ID", "1");
			intent.putExtras(parameters);
			startActivity(intent);
			return true;
		case R.id.about:
            intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
