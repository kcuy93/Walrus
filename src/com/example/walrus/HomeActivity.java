package com.example.walrus;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("Recycle")
public class HomeActivity extends Activity {
	
	String[] names;
	String[] captions;
	String[] descrptions;
	TypedArray userImages;
	TypedArray pinImages;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		ActionBar bar = getActionBar();
		bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		bar.setCustomView(R.layout.actionbar_clean);
		
		TextView txt = (TextView) bar.getCustomView().findViewById(R.id.wallrus); 
		Typeface font = Typeface.createFromAsset(getAssets(), "HARRINGT.TTF");  
		txt.setTypeface(font); 
		
		final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
		frameLayout.getForeground().setAlpha(0);
		
		names = getResources().getStringArray(R.array.user_names);
		captions = getResources().getStringArray(R.array.captions);
		descrptions = getResources().getStringArray(R.array.descriptions);
		userImages = getResources().obtainTypedArray(R.array.userImage);
		pinImages = getResources().obtainTypedArray(R.array.pinImage);
		
		for(int i =0; i<=2; i=i+2){
			
			final LinearLayout leftContainer = (LinearLayout) findViewById(R.id.home_leftLinearLayout);
			final LinearLayout rightContainer = (LinearLayout) findViewById(R.id.home_rightLinearLayout);
			
			leftContainer.addView(inflateLayout(i));
			rightContainer.addView(inflateLayout(i+1));
		}
		
		Button btnLogin = (Button) findViewById(R.id.home_login);
		
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				frameLayout.getForeground().setAlpha(220);//dim
				
				Display display = getWindowManager().getDefaultDisplay();
				Point size = new Point();
				display.getSize(size);
				int width = size.x;
				
				LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				final View layout = inflater.inflate(R.layout.popup_login,(ViewGroup) findViewById(R.id.loginPopup));
				
				final PopupWindow pw = new PopupWindow(layout, width-20, 400, true);
				pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
				
				Button btnCancel = (Button) layout.findViewById(R.id.popUp_btnCancel);
				
				btnCancel.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						frameLayout.getForeground().setAlpha(0);//undim
						pw.dismiss();
					}
				});
				
				
				Button btnLogIn = (Button) layout.findViewById(R.id.popUp_btnLogin);
				btnLogIn.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						EditText txtUserName = (EditText) layout.findViewById(R.id.popup_username);
						EditText txtPassword = (EditText) layout.findViewById(R.id.popup_password);
						if(txtUserName.getText().toString().equals("kevin")&&txtPassword.getText().toString().equals("salanga")){
							Intent intent = new Intent(getApplicationContext(), NewsFeedActivity.class);
							startActivity(intent);
							finish();
						}else if(txtUserName.getText().toString().isEmpty()||txtPassword.getText().toString().isEmpty())
							Toast.makeText(getApplicationContext(), "Please Fill all Fields", Toast.LENGTH_SHORT).show();
						else
							Toast.makeText(getApplicationContext(), "Invalid Username/Password", Toast.LENGTH_SHORT).show();
							
					}
				});
				Button btnFacebook = (Button) layout.findViewById(R.id.login_facebook);
				
				btnFacebook.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), " Coming Soon! ", Toast.LENGTH_SHORT).show();
					}
				});
				
				Button btnTwitter = (Button) layout.findViewById(R.id.login_twitter);
				
				btnTwitter.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), " Coming Soon! ", Toast.LENGTH_SHORT).show();
					}
				});
				
				
			}
		});
		
		Button btnRegister = (Button) findViewById(R.id.home_register);
		
		btnRegister.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
				startActivity(intent);
			}
		});
		
		

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
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
