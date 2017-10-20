package com.learnsocial.activity_lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ActivityLifecycle extends Activity {
	
	float[] localFloatArray = {3.14f, 2.71f, 0.577f};
	String localUserName = "Euler";
	
	
	@Override
	public void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState){
		super.onSaveInstanceState(outState);
		
		//save the relevant information
		outState.putString("name", localUserName);
		outState.putFloatArray("array", localFloatArray);
	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState){
		super.onRestoreInstanceState(savedInstanceState);
		
		//Restore the relevant information
		localUserName =savedInstanceState.getString("name");
		localFloatArray = savedInstanceState.getFloatArray("array");
		
	}
	@Override
	protected void onStart(){
		super.onStart();
				
		Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
		
	}
	
	@Override
	protected void onResume(){
		super.onResume();
				
		Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
		
	}
	
	@Override
	protected void onRestart(){
		super.onRestart();
				
		Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
		
	}
	
	@Override
	protected void onPause(){
		super.onPause();
				
		Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
		
	}
	
	@Override
	protected void onStop(){
		super.onStop();
				
		Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
		
	}

	@Override
	protected void onDestroy(){
		super.onDestroy();
				
		Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
		
	}
	
}
