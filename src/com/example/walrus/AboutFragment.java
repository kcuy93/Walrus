package com.example.walrus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class AboutFragment extends Fragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		final View layout = inflater.inflate(R.layout.activity_about_fragment, container, false);
		
		ImageButton btnAddWebsite = (ImageButton) layout.findViewById(R.id.about_next);
		btnAddWebsite.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), " Coming Soon! ", Toast.LENGTH_SHORT).show();
			}
		});
		
		Button btnSetPic = (Button) layout.findViewById(R.id.about_setProfilePic);
		btnSetPic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), " Coming Soon! ", Toast.LENGTH_SHORT).show();
			}
		});
		return layout;
	}

}
