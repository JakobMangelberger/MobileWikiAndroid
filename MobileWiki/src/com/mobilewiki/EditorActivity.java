 package com.mobilewiki;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


public class EditorActivity extends Activity{

	private int article_id;
	private String title = "<h2>Some article</h2>";
	private String str = "<p>Das ist ein Test<p/>";
	private EditText ed_view;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editor_layout); // TODO layout 
    }
    
    @Override
    public void onStart(){
    	 super.onStart();
         Bundle parameters = getIntent().getExtras();
         String editorID = null;
         if (null != parameters) {
             editorID = parameters.getString("ARTICLE_ID");
             if (editorID == null)
            	 editorID = "";
            
         } 
         else {
        	 article_id = Integer.parseInt(editorID);
         }
         
         ed_view = (EditText) findViewById(R.id.edit_text);
         
         String cnt =  ContentHTMLParser.getInstance().parseFromHtmlToCustom(title + str + str);
        
         ed_view.setText(cnt);
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
	        case R.id.preview_art: 
	        	Intent intent = new Intent(EditorActivity.this, PreviewActivity.class);
                Bundle parameters = new Bundle(1);
                String raw = ed_view.getText().toString();
                raw = ContentHTMLParser.getInstance().parseFromCustomToHtml(raw);
                parameters.putString("PREVIEW_TEXT", raw);
                intent.putExtras(parameters);
                Toast.makeText(this, "This is just a preview!", Toast.LENGTH_LONG).show();
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
}
