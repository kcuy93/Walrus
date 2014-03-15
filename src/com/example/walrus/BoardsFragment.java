package com.example.walrus;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BoardsFragment extends Fragment {

	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		final View layout = inflater.inflate(R.layout.activity_boards_fragment, container, false);
		return layout;
	}

}
