package com.mobilewiki;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class EditorActivity extends Activity implements IHTMLConstants {

	private int article_id;
	private String title = "<h2>Some article</h2>";
	private String str = "<p>Das ist ein <b>Test</b></p> ";
	private EditText ed_view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editor_layout); // TODO layout
		ed_view = (EditText) findViewById(R.id.edit_text);

		String cnt = ContentHTMLParser.getInstance().parseFromHtmlToCustom(title + 
				str + "<p>Das ist ein <b>Borat!!</b></p>" + "<img src=\"borat.jpeg\"/>" + 
		title + str + str);
		
		ed_view.setText(cnt);
	}

	@Override
	public void onStart() {
		super.onStart();
		Bundle parameters = getIntent().getExtras();
		String editorID = null;
		if (null != parameters) {
			editorID = parameters.getString("ARTICLE_ID");
			if (editorID == null)
				editorID = "";

		} else {
			article_id = Integer.parseInt(editorID);
		}

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.editor, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.add_bold:
			addTagsToContent(2);
			return super.onOptionsItemSelected(item);
		case R.id.add_paragraph:
			addTagsToContent(1);
			return super.onOptionsItemSelected(item);
		case R.id.add_image:
			addTagsToContent(3);
			return super.onOptionsItemSelected(item);
		case R.id.preview_art:
			Intent intent = new Intent(EditorActivity.this,
					PreviewActivity.class);
			Bundle parameters = new Bundle(1);
			String raw = ed_view.getText().toString();
			raw = ContentHTMLParser.getInstance().parseFromCustomToHtml(raw);
			parameters.putString("PREVIEW_TEXT", raw);
			intent.putExtras(parameters);
			Toast.makeText(this, "This is just a preview!", Toast.LENGTH_LONG)
					.show();
			startActivity(intent);
			return super.onOptionsItemSelected(item);
		case R.id.save_art:
			Toast.makeText(this, "Article saved!", Toast.LENGTH_SHORT).show();
			finish();
			return super.onOptionsItemSelected(item);
		case R.id.cancel_edit:
			finish();
			return super.onOptionsItemSelected(item);
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void addTagsToContent(int switch_num) {
		int pos = ed_view.getSelectionStart();

		String whole_string = ed_view.getText().toString();
		String first_part = whole_string.substring(0, pos);
		String end_part = whole_string.substring(pos);

		String new_string = null;
		int temp_pos = 0;
		switch (switch_num) {
		case 1:
			new_string = first_part + CUSTOM_START_PARA_TAG
					+ CUSTOM_END_PARA_TAG + end_part;
			temp_pos = first_part.length() + CUSTOM_START_PARA_TAG.length();
			break;
		case 2:
			new_string = first_part + CUSTOM_START_TITLE_TAG
					+ CUSTOM_END_TITLE_TAG + end_part;
			temp_pos = first_part.length() + CUSTOM_START_TITLE_TAG.length();
			break;
		case 3:
			
			break;
		default:
			break;
		}

		ed_view.setText(new_string);
		final int new_pos = temp_pos;
		ed_view.post(new Runnable() {
			@Override
			public void run() {
				ed_view.setSelection(new_pos);
			}
		});
	}
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState){
		super.onSaveInstanceState(savedInstanceState);
		  savedInstanceState.putString("Content", ed_view.getText().toString());
	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		ed_view.setText(savedInstanceState.getString("Content"));
	}
}