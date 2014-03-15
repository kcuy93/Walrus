package com.example.walrus;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewsFeedActivity extends Activity {

	String[] names;
	String[] captions;
	String[] descrptions;
	TypedArray userImages;
	TypedArray pinImages;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news_feed);
		
		ActionBar bar = getActionBar();
		bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//		bar.setCustomView(R.layout.actionbar);
		View cView = getLayoutInflater().inflate(R.layout.actionbar, null);
        bar.setCustomView(cView);
		
		TextView txt = (TextView) bar.getCustomView().findViewById(R.id.wallrus); 
		Typeface font = Typeface.createFromAsset(getAssets(), "HARRINGT.TTF");  
		txt.setTypeface(font); 
		
		names = getResources().getStringArray(R.array.user_names_2);
		captions = getResources().getStringArray(R.array.captions_2);
		descrptions = getResources().getStringArray(R.array.descriptions);
		userImages = getResources().obtainTypedArray(R.array.userImage_2);
		pinImages = getResources().obtainTypedArray(R.array.pinImage_2);
		
		for(int i =0; i<=2; i=i+2){
			
			final LinearLayout leftContainer = (LinearLayout) findViewById(R.id.home_leftLinearLayout);
			final LinearLayout rightContainer = (LinearLayout) findViewById(R.id.home_rightLinearLayout);
			
			leftContainer.addView(inflateLayout(i));
			rightContainer.addView(inflateLayout(i+1));
		}
	}
	
	private LinearLayout inflateLayout(final int ctr){
		
		LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		final LinearLayout pinView = (LinearLayout) layoutInflater.inflate(R.layout.layout_pin, null);
	
		ImageView imgPicture = (ImageView) pinView.findViewById(R.id.pin_image);
		ImageView imgUserPicture = (ImageView) pinView.findViewById(R.id.pin_picSmall);
		TextView txtDescription = (TextView) pinView.findViewById(R.id.pin_description);
		TextView txtCaption = (TextView) pinView.findViewById(R.id.pin_UserCaption);
		TextView txtName = (TextView) pinView.findViewById(R.id.pin_UserName);
		
		imgPicture.setImageResource(pinImages.getResourceId(ctr, -1));
		imgUserPicture.setImageResource(userImages.getResourceId(ctr, -1));
		txtDescription.setText(descrptions[ctr]);
		txtCaption.setText(captions[ctr]);
		txtName.setText(names[ctr]);
		
		pinView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(getApplicationContext(), PinActivity.class);
				intent.putExtra("pinImage", pinImages.getResourceId(ctr, -1));
				intent.putExtra("userImage", userImages.getResourceId(ctr, -1));
				intent.putExtra("description", descrptions[ctr]);
				intent.putExtra("caption", captions[ctr]);
				intent.putExtra("userName", names[ctr]);
				startActivity(intent);
				
			}
		});
		
		return pinView;
		
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
