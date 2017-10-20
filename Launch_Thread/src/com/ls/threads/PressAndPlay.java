package com.ls.threads;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PressAndPlay extends Activity 
{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button startButton = (Button) findViewById(R.id.trigger);
		
		startButton.setOnClickListener(new View.OnClickListener() 
		{

				public void onClick(View view) 
				{
				
					// TODO Auto-generated method stub
					//Stand-alone play_music() function call causes
					//main thread to hang. Instead, create
					//separate thread for time-consuming task
					Thread initBkgdThread = new Thread(new Runnable()
					{
						
						public void run()
						{
							play_music();
						
						}
					});
					initBkgdThread.start();
				  }	
					
			});
				
		}//end onCreate() Method
		
		int[] notes = {R.raw.c5, R.raw.b4, R.raw.a4, R.raw.g4 };
		
		int NOTE_DURATION = 400;		//millisecond
		
		MediaPlayer m_mediaPlayer;
		
		private void play_music() 
		{
			
			for(int ii=0; ii< 12; ii++) 
			{
				
				//check to ensure main activity is not paused
				if(!paused) 
				{
					
					if(m_mediaPlayer !=null) 
					{
						m_mediaPlayer.release();
					}
					
					m_mediaPlayer = MediaPlayer.create(this, notes[ii%4]);
					
					m_mediaPlayer.start();
					
					try
					{
						Thread.sleep(NOTE_DURATION);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					
					}
				
				}//if conditional statement
		
			}//end the for loop
		
		}//end the method play_music()
		
		boolean paused = false;
		
		@Override
		protected void onPause() {
			
			paused=true;
			super.onPause();
		}
	  
		@Override
		protected void onResume(){
			super.onPause();
			paused=false;
		}
		
	
	
	
	
}//end class code
