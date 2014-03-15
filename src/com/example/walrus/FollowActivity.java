package com.example.walrus;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class FollowActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_follower);
		
		ActionBar bar = getActionBar();
		bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		bar.setCustomView(R.layout.actionbar_clean);
		bar.setDisplayHomeAsUpEnabled(true);
		
		
		TextView txt = (TextView) bar.getCustomView().findViewById(R.id.wallrus); 
		Typeface font = Typeface.createFromAsset(getAssets(), "HARRINGT.TTF");  
		txt.setTypeface(font);
		
		TextView txtMessage = (TextView) findViewById(R.id.follower_textViewPeopleWhoSee);
		TextView txtTitle = (TextView) findViewById(R.id.follower_textViewFollersTitle);
		
		if(getIntent().getExtras().getString("type").equals("follower")){
			txtTitle.setText("Followers");
			txtMessage.setText("People who see your pins");
		}
		else{
			txtTitle.setText("Following");
			txtMessage.setText("People who show up in your feed");
		}
		
		ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(new FollowAdapter(this));



	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
}

