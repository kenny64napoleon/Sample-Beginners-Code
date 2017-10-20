package com.learnsocial.menuscreenexample;

//import android.R;
import com.learnsocial.launchactivityexample.PlayGame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MenuScreen extends Activity {
	
	@Override
	public void onCreate (Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//Setup button listener
		Button startButton = (Button) findViewById(R.id.play_game);
		startButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void startGame(){
		Intent launchGame = new Intent(this, PlayGame.class);
		startActivity(launchGame);
		
	}

}
