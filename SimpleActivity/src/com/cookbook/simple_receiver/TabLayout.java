package com.cookbook.simple_receiver;

import java.util.Date;

import android.R;
import android.os.*;
import android.app.*;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

public class TabLayout extends TabActivity implements android.widget.TabHost.TabContentFactory{
	
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		
		TabHost tabHost = getTabHost();
		
		LayoutInflater.from(this).inflate(R.layout.example_layout, tabHost.getTabContentView(), true);
		
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Grid").setContent(new Intent(this, GridLayout.class)));
		
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("List").setContent(new Intent(this, List.class)));
		
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Basic").setContent(R.id.texttwo));
		
		tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("Factory").setContent(this));
		
		
	}

	@Override
	public View createTabContent(String tag) {
		// TODO Auto-generated method stub
		if(tag.compareTo("tab4") == 0) {
			
			TextView tv = new TextView(this);
			Date now = new Date();
			
			tv.setText("I' from a factory. Created: " + now.toString());
			
			tv.setTextSize((float) 24);
			return(tv);
		}
		else {
			return null;
		}
			
	}
		
		
	
}
	

}
