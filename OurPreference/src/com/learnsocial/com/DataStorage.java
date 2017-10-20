package com.learnsocial.com;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.*;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DataStorage  extends Activity  {
	
	//variables
	SharedPreferences ourprefs;
	EditText userET, passwordET;
	Button loginBT;
		
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//Intent i = new Intent(this, OurPreference.class);
		//startActivity(i);
		
		ourprefs = PreferenceManager.getDefaultSharedPreferences(this);
		
		final String username = ourprefs.getString("username", null);
		
		final String password = ourprefs.getString("password", null);
		
		if(username != null && password != null) 
		{
		
			setContentView(R.layout.main);
			
			userET = (EditText) findViewById(R.id.userText);
			passwordET = (EditText) findViewByID(R.id.passwordtext);
			
			loginBT = (Button) findViewById(R.id.loginButton);
			
			loginBT.setOnClickListener(new OnClickListener()
			{

				@Override
				public void onClick(View v) 
				{
					// TODO Auto-generated method stub
					
					try{
						if (username.equals(userET.getText().toString()) && password.equals(passwordET.getText().toString()))
						{
							
							Toast.makeText(DataStorage.this, "login passed", Toast.LENGTH_SHORT).show();
							
							Intent i1 = new Intent(DataStorage.this, OurPreference.class);
							
							startActivity(i1);		
						}else {
							Toast.makeText(DataStorage.this, "login failed", Toast.LENGTH_SHORT).show();
						}
						
					} catch(Exception e){
						e.printStackTrace();
					}
					
					
				  }//end of onClick()
				
				});//end of the setOnClickListener()
			
			
			}else {
				Intent i2 = new Intent(this, OurPreference.class);
				
				startActivity(i2);
			}
					
				
		}
				
			      
			
			
			
			
		
		
		
		
		
		
	}

}
