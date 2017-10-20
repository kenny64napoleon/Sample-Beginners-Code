package com.learnsocial.blutooth;

import java.io.IOException;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.bluetooth.*;

public class BluThread extends Thread {

	private final BluetoothServerSocket kkSS = 0;
	
	
	public void AcceptThread() {
		
		Object NAME;
		Object MY_UUID;
		
		BluetoothServerSocket tmp = null;
		
		try{
			
			tmp = mAdapter.listenUsingRfcommWithServiceRecord(NAME, MY_UUID);
		}
		catch (IOException ett){}
			kkSS = tmp;
	}
		
		
		public void run() {
			
			BluetoothSocket socket = null;
			
			while (true){
				
				try {
					
					socket = kkSS.accept();
					
				}
				catch (IOException ettt){
					
					break;
				}
				
				if (socket != null){
					
					manageConnectedSocket(socket);
					
					kkSS.close();
					
				}
				
				
			}
			
			public cancel() {
				
				try {
					
					kkSS.close();
				}catch (IOException ext) {}
			}
			
		}


		
	}



	/* discover bluetooth devices
	 * 
	 * private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
	 * 
	 *  public void onReceive(Context context, Intent intent){
	 *  
	 *                    String action = intent.getAction();
	 *                    
	 *                    if(BluetoothDevice.ACTION_FOUND.equals(action)) {
	 *                    
	 *  
	 *                         BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
	 *                         
	 *                         Log.v("Bluetooth Testing", device.getName() + "\n" + device.getAddress())
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 * 
	 * 						}
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *    };
	 * 
	 * 
	 * }
	 */
	
	
	
	
	
	
	

