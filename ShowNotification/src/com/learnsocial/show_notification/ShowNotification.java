package com.learnsocial.show_notification;

import android.app.Activity;
import android.os.Bundle;

import android.app.Notification;
import android.app.NotificationManager;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;

public class ShowNotification extends Activity 
{

	//variables
	private NotificationManager mNManager;
	private static final int NOTIFY_ID = 1100;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		String ns = Context.NOTIFICATION_SERVICE;
		
		mNManager = (NotificationManager) getSystemService(ns);
		
		//final Notification msg = new Notification(R.drawable.icon, "New event of importance", System.currentTimeMillis());
		
		Context mContext = null;
		
		Notification msg = new Notification.Builder(mContext).build();

		Button start = (Button) findViewById(R.id.start);
		Button cancel = (Button) findViewById(R.id.cancel);
		
		start.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Context mContext  = getApplicationContext();
				
				CharSequence contentTitle = "ShowNotification Example";
				CharSequence contentText = "Browse Learn Social Site";
				
				Intent msg = new Intent(Intent.ACTION_VIEW, Uri.parse("http:/www.learnsocial.com"));
				
				PendingIntent intent = PendingIntent.getActivity(ShowNotification.this, 0, msg, Intent.FLAG_ACTIVITY_NEW_TASK);
				
				msg.defaults = Notification.DEFAULT_SOUND;
				msg.flags = Notification.FLAG_AUTO_CANCEL;
		
				//msg.setLatestEventInfo(mContext, contentTitle, contentText, intent);
				//msg.setData(mContext);
				
				//mNManager.notify(NOTIFY_ID, msg);
				mNManager.notifyAll();
		
			}
			
			
		});
			
		cancel.setOnClickListener(new OnClickListener() 
		{

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				mNManager.cancel(NOTIFY_ID);
			}
			
		
			
		});
	
	}
}
	
	

