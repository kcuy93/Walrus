package com.example.walrus;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ProfileActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
		ActionBar bar = getActionBar();
		bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//		bar.setCustomView(R.layout.actionbar_profile);
		View cView = getLayoutInflater().inflate(R.layout.actionbar_profile, null);
        bar.setCustomView(cView);
		
		TextView txt = (TextView) bar.getCustomView().findViewById(R.id.wallrus); 
		Typeface font = Typeface.createFromAsset(getAssets(), "HARRINGT.TTF");  
		txt.setTypeface(font);  
		
		ListView list = (ListView) findViewById(R.id.profile_listProfileNotifications);
		list.setAdapter(new NotificationAdapter(this));
		
		Button btnFollowers = (Button)findViewById(R.id.profile_followers);
		Button btnFollowing = (Button)findViewById(R.id.profile_following);
		
		btnFollowers.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), FollowActivity.class);
				intent.putExtra("type", "follower");
				startActivity(intent);
			}
		});
		
		btnFollowing.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), FollowActivity.class);
				intent.putExtra("type", "following");
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}
	
	public void goToOtherProfile(View view){
		Intent intent = new Intent(getApplicationContext(), MoreProfileActivity.class);
		startActivity(intent);
	}
	
	public void goToSearch(View view){
		Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
		startActivity(intent);
	}
	
	

}
