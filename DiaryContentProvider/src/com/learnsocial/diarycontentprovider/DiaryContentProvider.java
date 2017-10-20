package com.learnsocial.diarycontentprovider;

import android.content.*;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import com.learnsocial.Constants;
import com.learnsocial.MyDB;

public class DiaryContentProvider extends ContentProvider {

	private MyDB data;
	private static final UriMatcher sUriMatcher;
	
	private static final in DIARIES = 1;
	
	public static final String AUTHORITY = "com.learnsocial.datastorage";
	
	static {
		
		sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		
		sUriMatcher.addURI(AUTHORITY, Constants.TABLE_NAME, DIARIES);
	}
	
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
		
	}
	
	public String getType(Uri uri) {
		
		return null;
	}
	
	public Uri insert(Uri uri, ContentValues values) {
		
		return null;
	}
	
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		
		return 0;
	}
	
	public boolean onCreate(){
		com.learnsocial.diarycontentprovider.MyDB dba = new MyDB(this.getContext());
		
		dba.open();
		
		return false;
		
	}
	
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		
		Cursor c=null;
		
		switch (sUriMatcher.match(uri)){
		
		case DIARIES:
			
			c = dba.getDiaries();
			break;
			
			default:
				throw new IllegalArgumentException("Unknown URI" + uri);
				
				
		}
		
		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}
	
}
