package com.example.walrus;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchAdapter extends BaseAdapter{
	
	Context context;
	String[] category, description;
	TypedArray images;
	
	public SearchAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
		category = context.getResources().getStringArray(R.array.categories);
		images = context.getResources().obtainTypedArray(R.array.smallImages2);
		description = context.getResources().getStringArray(R.array.descriptions2);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return category.length;
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
			row = inflater.inflate(R.layout.layout_search_result, parent, false);
		}
		
		TextView txtCategory = (TextView) row.findViewById(R.id.search_category);
		TextView txtDescription = (TextView) row.findViewById(R.id.search_text);
		ImageView imgUser = (ImageView) row.findViewById(R.id.search_image);
		
		txtCategory.setText(category[position]);
		txtDescription.setText(description[position]);
		imgUser.setImageResource(images.getResourceId(position, -1));
		
		return row;
	}

}
