package com.example.walrus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NotificationAdapter extends BaseAdapter{
	String[] names;
	TypedArray images, userImage;
	Context context;
	@SuppressLint("Recycle")
	public NotificationAdapter(Context c) {
		// TODO Auto-generated constructor stub
		Resources res = c.getResources();
		names = res.getStringArray(R.array.user_names);
		userImage = res.obtainTypedArray(R.array.userImage);
		images = res.obtainTypedArray(R.array.smallImages);
		context = c;
		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return names.length;
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
		// TODO Auto-generated method stub
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View row;
		if(convertView!=null){
			row = convertView;
		}else{
			row = inflater.inflate(R.layout.layout_notification, parent, false);
		}
		
		TextView txtUserName = (TextView)row.findViewById(R.id.profile_otherUserName);
		ImageView imgUserImage = (ImageView)row.findViewById(R.id.profile_otherUserImage);
		ImageView imgImages = (ImageView)row.findViewById(R.id.profile_otherImage);
		
		txtUserName.setText(names[position]);
		imgUserImage.setImageResource(userImage.getResourceId(position, -1));
		imgImages.setImageResource(images.getResourceId(position, -1));
		
		return row;
	}

}
