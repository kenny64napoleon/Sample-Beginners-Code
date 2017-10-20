package com.learnsocial.runnable_activity;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EdgeDetection extends Activity implements Runnable 
{
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		final TextView tv = (TextView) findViewById(R.id.text);
		
		Thread thread = new Thread(EdgeDetection.this);
		
		thread.start();
		
		Button startButton = findViewById(R.id.trigger);
		
		startButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				int numberOfTimesPressed;
				tv.setText("Pressed Button" + ++numberOfTimesPressed + " times\nAnd computation computation loop at " 
				+ "(" +xi + ", " + yi + ") pixels");
			}
		});
		
			
		
	}//end onCreate method
	
	@Override
	public void run(){
		
		detectEdges();
	}
	
	//Edge Detection
	int xi, yi;
	
	private double detectEdges() {
		
		int x_pixels = 4000;
		int y_pixels = 3000;
		
		double image_transform = 0;
		
		for (xi=0; xi<x_pixels; xi++) {
			
			for (yi=0; yi<y_pixels; yi++){
				
				image_transform = Math.cosh(xi*yi/x_pixels/y_pixels);
				
			}
		}
		return image_transform;
	}

}//end of class
