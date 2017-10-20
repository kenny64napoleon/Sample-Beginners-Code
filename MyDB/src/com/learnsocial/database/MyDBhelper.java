package com.learnsocial.database;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
//import android.provider.SyncStateContract.Constants;

import android.util.Log;

public class MyDBhelper  {

	//variables
	private static final String CREATE_TABLE="create table " + Constants.TABLE_NAME + "("+ Constants.KEY_ID+" integer primary key autoincrement "+
	                                                          Constants.TITLE_NAME+" text not null, "+ 
	                                                          Constants.CONTENT_NAME+" text not null, "+
	                                                          Constants.DATE_NAME+" long);";
	
	
	public MyDBhelper(Context context, String name, CursorFactory factory, int version){
		
		super(context, name, factory, version);
	}
	
	
	public void onCreate(SQLiteDatabase db) {
		
		//missing statement to create table.
		
		
		Log.v("MyDBHelper onCreate", "Creating all the tables");
		
		try{
			db.execSQL(CREATE_TABLE);
		}
		catch(SQLiteException et){
			Log.v("Create table exception", et.getMessage());
		}
	}
	
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		
		Log.v("TaskDBAdapter", "Upgrading from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
		
		db.execSQL("drop table if exists " + Constants.TABLE_NAME);
		onCreate(db);
		
		
	}
	
	
	public SQLiteDatabase getWriteableDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	public SQLiteDatabase getReadableDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

}
