package com.example.bluetoothcontectsharer;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<ContectItem>{
    private final Context context;
	private List<ContectItem> contectlist;
	
	public ListAdapter(Context context, List<ContectItem> contactList ) {
		 super(context, R.layout.device_contect_list, contactList); 
	    	this.contectlist = contactList;
	        this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
	LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	View rowView = layoutInflater.inflate(R.layout.contect_item,parent,false);
	
	ContectItem contectItem = contectlist.get(position);
	
	TextView name = (TextView) rowView.findViewById(R.id.tv_name);
	name.setText(contectItem.getFirstname()+contectItem.getLastname());
	
	TextView contect = (TextView) rowView.findViewById(R.id.tv_contectno);
	contect.setText(contectItem.getContect1());
	
    	return rowView;
	}

	
	
}
