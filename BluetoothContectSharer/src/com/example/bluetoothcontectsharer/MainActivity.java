package com.example.bluetoothcontectsharer;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends FragmentActivity implements OnClickListener {

	Button add_self;
	Button get_contectList;
	ListView listView;
	
	FragmentManager fragmentManager;
	FragmentTransaction ft;
	BluetoothDeviceListFragment bdListFragment;
	HomeFragment homeFragment;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	add_self = (Button)findViewById(R.id.bt_add_self);
	get_contectList = (Button)findViewById(R.id.bt_gen_list);
	
	add_self.setOnClickListener(this);
	get_contectList.setOnClickListener(this);
    
	addHomeFragment();
	}
	
	
	private void addListFragment(){
		bdListFragment = new BluetoothDeviceListFragment();

		// Getting reference to the FragmentManager
		fragmentManager = getSupportFragmentManager();

		// Creating a fragment transaction
		ft = fragmentManager.beginTransaction();

		// Adding a fragment to the fragment transaction
		ft.replace(R.id.bluetooth_device_list, bdListFragment);
		// Committing the transaction
		ft.addToBackStack(null);
		ft.commit();
	}

	private void addHomeFragment(){
		homeFragment = new HomeFragment();

		// Getting reference to the FragmentManager
		fragmentManager = getSupportFragmentManager();

		// Creating a fragment transaction
		ft = fragmentManager.beginTransaction();

		// Adding a fragment to the fragment transaction
		ft.replace(R.id.bluetooth_device_list, bdListFragment);
		// Committing the transaction
		ft.addToBackStack(null);	
		ft.commit();
	}

	public void renameBluetooth(){
		 SharedPreferences prefs = this.getSharedPreferences(
	    	      "com.example.bluetoothcontectsharer", Context.MODE_PRIVATE);
		 
		 String new_name = prefs.getString("firstname", null) + prefs.getString("lastname", null) + 
				    prefs.getString("contect1", null) + prefs.getString("contect2", null);
	
		 BluetoothAdapter blueAdapter = null;
		 blueAdapter = BluetoothAdapter.getDefaultAdapter();
		 blueAdapter.setName(new_name);  
	
	}


	@Override
	public void onClick(View v) {
	   switch (v.getId()) {
		case R.id.bt_add_self:
		   	Intent i = new Intent(getApplicationContext(),AddSelfContect.class);
			startActivity(i);
		   	break;
		case R.id.bt_gen_list:
		    renameBluetooth();
			addListFragment();
			break;
		}
	 	
	}
		
}
