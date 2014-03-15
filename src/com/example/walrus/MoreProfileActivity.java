package com.example.walrus;


import android.app.ActionBar;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.widget.TextView;

public class MoreProfileActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_more_profile);
		
		ActionBar bar = getActionBar();
		bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		bar.setCustomView(R.layout.actionbar_clean);
		
		TextView txt = (TextView) bar.getCustomView().findViewById(R.id.wallrus); 
		Typeface font = Typeface.createFromAsset(getAssets(), "HARRINGT.TTF");  
		txt.setTypeface(font); 
		
		FragmentTabHost mtabHost = (FragmentTabHost) findViewById(android.R.id.tabhost); // The activity TabHost
		mtabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		
		mtabHost.addTab(mtabHost.newTabSpec("Feed").setIndicator("Boards"),
        BoardsFragment.class, null);
		
		mtabHost.addTab(mtabHost.newTabSpec("ToWatch").setIndicator("About"),
        AboutFragment.class, null);
		
		
		mtabHost.setCurrentTab(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.more_profile, menu);
		return true;
	}

}
