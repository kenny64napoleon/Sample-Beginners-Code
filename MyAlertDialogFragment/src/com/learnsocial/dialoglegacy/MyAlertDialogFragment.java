package com.learnsocial.dialoglegacy;

import android.app.*;
import android.content.DialogInterface;
import android.content.*;

import android.os.*;


public class MyAlertDialogFragment extends DialogFragment {

	//constructor
	public static MyAlertDialogFragment newInstance (String fragmentNumber) {
		
		MyAlertDialogFragment newInstance = new MyAlertDialogFragment();
		
		Bundle args = new Bundle();
		
		args.putString("fragnum", fragmentNumber);
		
		newInstance.setArguments(args);
		
		return newInstance;
		
	}
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		final String fragNum = getArguments().getString("fragNum");
		
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
		
		alertDialog.setTitle("Alert Dialog");
		
		alertDialog.setMessage("This alert brought to you by " + fragNum);
		
		alertDialog.setIcon(android.R.drawable.btn_default);
		
		alertDialog.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
			
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				((SimpleFragDialogActivity) getActivity()).doPositiveClick(fragNum);
				return;
			}
		});
		return alertDialog.create();
		
		
		
	}
	
	
}
