package com.example.walrus;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		
		ActionBar bar = getActionBar();
		bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//		bar.setCustomView(R.layout.actionbar);
		View cView = getLayoutInflater().inflate(R.layout.actionbar_register, null);
        bar.setCustomView(cView);
		
		TextView txt = (TextView) bar.getCustomView().findViewById(R.id.wallrus); 
		Typeface font = Typeface.createFromAsset(getAssets(), "HARRINGT.TTF");  
		txt.setTypeface(font); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}
	
	public void goToNewsFeed(View v){
		Intent intent = new Intent(getApplicationContext(), NewsFeedActivity.class);
		startActivity(intent);
		finish();
	}

}
