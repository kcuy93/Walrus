package com.example.walrus;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PinActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pin);
		
		ActionBar bar = getActionBar();
		bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//		bar.setCustomView(R.layout.actionbar);
		View cView = getLayoutInflater().inflate(R.layout.actionbar, null);
        bar.setCustomView(cView);
		
		
		TextView txt = (TextView) bar.getCustomView().findViewById(R.id.wallrus); 
		Typeface font = Typeface.createFromAsset(getAssets(), "HARRINGT.TTF");  
		txt.setTypeface(font);  
	
		ImageView imgPin = (ImageView) findViewById(R.id.activityPin_Image);
		ImageView imgUser = (ImageView) findViewById(R.id.activityPin_picSmall);
		TextView txtUserName = (TextView) findViewById(R.id.activityPin_UserName);
		TextView txtDescription = (TextView) findViewById(R.id.activityPin_Comment);
		
		imgPin.setImageResource(getIntent().getExtras().getInt("pinImage"));
		imgUser.setImageResource(getIntent().getExtras().getInt("userImage"));
		txtUserName.setText(getIntent().getExtras().getString("userName"));
		txtDescription.setText(getIntent().getExtras().getString("description"));
		
		Button btnPin = (Button) findViewById(R.id.buttonNewsFeed_Pin);
		btnPin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "Successfully Pinned!", Toast.LENGTH_SHORT).show();
			}
		});
		
		LinearLayout btnSend = (LinearLayout) findViewById(R.id.pin_sendButton);
		btnSend.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "Coming Soon!", Toast.LENGTH_SHORT).show();
			}
		});
		final ImageView btnHeartOff = (ImageView) findViewById(R.id.pin_heartOff);
		final ImageView btnHeartOn = (ImageView) findViewById(R.id.pin_heartOn);
		btnHeartOn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				btnHeartOn.setVisibility(View.GONE);
				btnHeartOff.setVisibility(View.VISIBLE);
			}
		});
		btnHeartOff.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				btnHeartOn.setVisibility(View.VISIBLE);
				btnHeartOff.setVisibility(View.GONE);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.news_feed, menu);
		return true;
	}
	
	public void goToProfile(View v){
		Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
		startActivity(intent);
	}
	
	public void goToSearch(View v){
		Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
		startActivity(intent);
	}

}
