package com.learnsocial.com;

import android.R;
import android.os.*;
import android.preference.PreferenceActivity;



public class OurPreference extends PreferenceActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		
		addPreferencesFromReources(R.xml.preferences);
		
	}

}
