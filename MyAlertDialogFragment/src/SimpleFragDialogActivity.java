import com.learnsocial.dialoglegacy.MyAlertDialogFragment;

import android.R;
import android.app.*;
import android.os.*;
import android.view.View;
import android.widget.*;


public class SimpleFragDialogActivity extends Activity {

	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//Handle Alert dialog button
		Button launchAlertDialog = (Button) findViewById(R.id.Button_AlertDialog);
		
		launchAlertDialog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialogFragment("Fragment Instance One");
				
			}
		});
	

			//Handle Alert dialog 2 button
			Button launchAlertDialog2 = (Button) findViewById(R.id.Button_AlertDialog2);
			
			launchAlertDialog2.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					showDialogFragment("Fragment Instance Two");
					
				}
			});
		}
	
	protected void showDialogFragment(String strFragmentNumber) {
		// TODO Auto-generated method stub
		
		DialogFragment newFragment = MyAlertDialogFragment.newInstance(strFragmentNumber);
		newFragment.show(getFragmentManager(), strFragmentNumber);
	}		
	
	public void doPositiveClick (String strFragmentNumber){
		Toast.makeText(getApplicationContext(), "Clicked OK! (" + strFragmentNumber + ")" ,Toast.LENGTH_SHORT).show();
	}
}