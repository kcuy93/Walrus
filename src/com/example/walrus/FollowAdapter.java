package com.example.walrus;


import java.util.jar.Attributes.Name;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FollowAdapter extends BaseAdapter {

	String[] userName;
	TypedArray userImages;
	Context context;
	
	@SuppressLint("Recycle")
	FollowAdapter(Context c) {
		
		context = c;
		Resources res = c.getResources();
		userName = res.getStringArray(R.array.user_names);
		userImages = res.obtainTypedArray(R.array.userImage);
		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return userName.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method s	tub
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View row;
		if(convertView!=null){
			row = convertView;
		}else{
			row = inflater.inflate(R.layout.layout_follow, parent, false);
		}
		
		TextView txtuserName = (TextView) row.findViewById(R.id.follow_userName);
		ImageView imgUser = (ImageView) row.findViewById(R.id.follow_imgViewEntry);
		
		txtuserName.setText(userName[position]);
		imgUser.setImageResource(userImages.getResourceId(position, -1));
		
		final Button btnFollow = (Button)row.findViewById(R.id.follow_btnEntry);
		final Button btnUnfollow = (Button)row.findViewById(R.id.follow_btnUnfollowEntry);

		btnFollow.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//change buttons accordingly
				btnFollow.setVisibility(View.GONE);
				btnUnfollow.setVisibility(View.VISIBLE);		
			}
		});
		btnUnfollow.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				btnUnfollow.setVisibility(View.GONE);	
				btnFollow.setVisibility(View.VISIBLE);
			}
		});

		
		/*TypedArray imgs = getResources().obtainTypedArray(R.array.random_imgs);
		//get resourceid by index
		imgs.getResourceId(i, -1)
		// or set you ImageView's resource to the id
		mImgView1.setImageResource(imgs.getResourceId(i, -1));*/
		
		return row;
	}

}
