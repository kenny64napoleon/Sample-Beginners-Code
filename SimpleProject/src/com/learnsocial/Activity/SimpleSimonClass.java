package com.learnsocial.Activity;

import android.R;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.SeekBar;
import android.widget.TextView;



public class SimpleSimonClass extends Activity implements Runnable{

	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setViewContent(R.layout.main);
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	String mystring = getResources().getString(R.string.hello);
	
	int myColor = getResources().getColor(R.color.primary_text_dark);
	
	int myColor2 = getResources().getColor(R.color.prettyTextColor);
	
	float myDimen = getResources().getDimension(R.dimen.app_icon_size);
	
	ColorDrawable myDraw = (ColorDrawable) getResources().getDrawable(R.drawable.alert_dark_frame);
	
	String[] aFlavours = getResources().getStringArray(R.array.flavours);
	
	boolean bAdvancedMode = getResources().getBoolean(R.bool.bAdvancedFeaturesEnabled);
	
	int[] myint = getResources().getIntArray(R.array.name);

	/*
	.png
	.9.png
	.jpg
	.gif
	*/
	
	ImageView flagImageView = (ImageView) findViewById(R.id.ImageView01);
	
	//all about layouts
	TextView txt = (TextView) findViewById(R.id.text1);
	
	//auto complete
	MultiAutoCompleteTextView mtext = (MultiAutoCompleteTextView)findViewById(R.id.MultiAutoCompleteText1);
	
	//Progressbar
	
	//Spinner
	
	//SeekBar
	SeekBar seek = (SeekBar)findViewById(R.id.seekBar1);
	
	
	
	
	
	
	
	
}
