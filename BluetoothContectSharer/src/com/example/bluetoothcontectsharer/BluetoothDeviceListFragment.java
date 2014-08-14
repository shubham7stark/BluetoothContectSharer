package com.example.bluetoothcontectsharer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import android.app.ListFragment;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

public class BluetoothDeviceListFragment extends ListFragment implements OnClickListener{

	ListView lv;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
	
		View v = inflater.inflate(R.layout.device_contect_list,
				container, false);
		ListView lv = (ListView)v.findViewById(R.id.lv_contect);
	    (new GetBluetoothDeviceList(getActivity().getBaseContext())).execute();

		//lv.setOnItemClickListener(BluetoothDeviceListTask.this);
	  return v;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	}
	
	
	
	/*-------------------------Async Task---------------------------------*/
	
	public class GetBluetoothDeviceList extends AsyncTask<Void, Void, List<ContectItem>>{
         	Context context = null;
		 
         	public GetBluetoothDeviceList(Context activityContext){
			context = activityContext;
		    }
		 
		@Override
		protected List<ContectItem> doInBackground(Void... params) {
			// TODO Auto-generated method stub
		
		BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();

		List<String> s = new ArrayList<String>();
		for(BluetoothDevice bt : pairedDevices)
			   s.add(bt.getName());

		List<ContectItem> contectItemList = null;
			
		for(String st : s){
		String temp[] = st.split(";");
		if(temp[2]!= null){
			ContectItem cItem = new ContectItem();
			cItem.setFirstname(temp[0]);
			cItem.setLastname(temp[1]);
			cItem.setContect1(temp[2]);
			cItem.setContect2(temp[3]);
			contectItemList.add(cItem);
			}
		 }		
			return contectItemList;
		}

	
		@Override
		protected void onPostExecute(List<ContectItem> result) {
			super.onPostExecute(result);
			lv.setAdapter(new ListAdapter(context, result));
		}

		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}
		   
}
	
	/*---------------------------------------*/
	
}
