package com.learnsocial.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
//import android.provider.SyncStateContract.Constants;
import android.util.Log;

public class MyDB {
	
	//variables
	private SQLiteDatabase db;
	private final Context context;
	private final MyDBhelper dbhelper;
	
	public MyDB (Context c){
		context c;
		
		dbhelper = new MyDBhelper(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
		
	}
		public void close(){
			
			db.close();
			
		}
		
		public void open() throws SQLiteException {
			
			try {
			
				db = dbhelper.getWriteableDatabase();
				
			}
			
			catch(SQLiteException e){
				
				Log.v("Open DB exception caught", e.getMessage());
				
				db = dbhelper.getReadableDatabase();
				
			}
			
		}
		
		public long insertDiary(String title, String content) {
			
			
			try {
				
				
				ContentValues newTaskValue = new ContentValues();
				
				newTaskValue.put(Constants.TITLE_NAME, title);
				
				newTaskValue.put(Constants.CONTENT_NAME, content);
				
				newTaskValue.put(Constants.DATE_NAME, java.lang.System.currentTimeMillis());
				
				return db.insert(Constants.TABLE_NAME, null, newTaskValue);
				
				
				
				
				
				
			}
			
			catch (SQLiteException ex){
				
				Log.v("Insert into DB exception caught", ex.getMessage());
				return -1;
			}
			
			
			
			
			
			
			
			
			
			return 0;
			
					
		}
		
		public Cursor getDiaries() {
			
			Cursor c = db.query(Constants.TABLE_NAME, null, null, null, null, null, null, null, null, null);
			
			return null;
			
			
		}
		
}	
	
	
	
