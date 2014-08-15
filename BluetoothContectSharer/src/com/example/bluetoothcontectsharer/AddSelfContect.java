package com.example.bluetoothcontectsharer;

import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddSelfContect extends Activity implements OnClickListener{

	EditText et_firstname;
	EditText et_lastname;
	EditText et_contect1;
	EditText et_contect2;
	Button bt_save;
	String bluetoothname = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	  setContentView(R.layout.add_self_info);	
		
	  et_firstname = (EditText)findViewById(R.id.et_firstname);
	  et_lastname = (EditText)findViewById(R.id.et_lastname);
	  et_contect1 = (EditText)findViewById(R.id.et_contect1);
	  et_contect2 = (EditText)findViewById(R.id.et_contect2);
	  bt_save = (Button)findViewById(R.id.bt_save);
	  bt_save.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
     String bluetoothname = null;
     String firstname =  et_firstname.getText().toString();
     String lastname = et_lastname.getText().toString();
     String contect1 = et_contect1.getText().toString();
     String contect2 = et_contect2.getText().toString();
    
  /*-----------check---------*/
     if(firstname == null || contect1 == null){
    	 Toast.makeText(getApplicationContext(),"First Name and FirstContectNo is necessary to fill", Toast.LENGTH_LONG).show();
    	 return;
     }
     if(!firstname.matches("[a-zA-Z]") ){ 
     	 Toast.makeText(getApplicationContext(),"First Name and FirstContectNo is necessary to fill", Toast.LENGTH_LONG).show();
    	 return;
     }
     if(!Pattern.matches("[a-zA-Z0-9 ]+", firstname)) 
     { 
     Toast.makeText(getApplicationContext(),"Name must contain Alphanumerical and Spaces only", Toast.LENGTH_LONG).show();
     return;
     }
	/*--------------------*/
     
     StringBuilder stringBuilder = new StringBuilder();
     stringBuilder.append(firstname+";");
     stringBuilder.append(lastname+";");
     stringBuilder.append(contect1+";");
     stringBuilder.append(contect2);

     bluetoothname = stringBuilder.toString();
     
  
     String appAdd = "com.example.bluetoothcontectsharer." ;
     SharedPreferences prefs = this.getSharedPreferences(
    	      "com.example.bluetoothcontectsharer", Context.MODE_PRIVATE);
     
     prefs.edit().putString(appAdd+firstname, firstname).apply();
     prefs.edit().putString(appAdd+lastname, lastname).apply();
     prefs.edit().putString(appAdd+contect1, contect1).apply();
     prefs.edit().putString(appAdd+contect2, contect2).apply();

     Intent i = new Intent(getApplicationContext() , MainActivity.class);
	 startActivity(i);
	
	}
	
}
