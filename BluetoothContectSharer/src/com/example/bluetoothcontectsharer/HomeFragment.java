package com.example.bluetoothcontectsharer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.home_fragment,
				container, false);
		TextView t = (TextView)v.findViewById(R.id.tv_xyz);
		
		return v;
	
	}
	}
