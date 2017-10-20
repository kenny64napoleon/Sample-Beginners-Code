package com.learnsocial.launch_for_result;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class RecognizerIntentExample extends Activity {

	private static final int RECOGNIZER_EXAMPLE = 1001;
	private TextView tv;
	
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		tv = (TextView) findViewById(R.id.text_result);
		
		//set up Button listener
		Button startButton = findViewById(R.id.trigger);
		
		startButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				
				//RecognizerIntent prompts user for speech input and returns text
				Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				
				intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
				
				intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say a word or phrase\nand it will show as text");
				
				startActivityForResult(intent, RECOGNIZER_EXAMPLE);
				
				
			}
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		
		//Use a switch statement for more than oen request code check
		if(requestCode == RECOGNIZER_EXAMPLE && resultCode == RESULT_OK) {
			
			//Returned data is a list of matches to the speech input
			ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			
			//Display on screen
			tv.setText(result.toString());
		}
		
		super.onActivityResult(requestCode, resultCode, data);
	}
	
}
