package com.cookbook.simple_receiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

//import android.widget.FrameLayout;

public class SimpleActivity extends Activity {
    SimpleBroadcastReceiver intentReceiver = 
        new SimpleBroadcastReceiver();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

        
        //amended on Dec 21 2014 
        
        TextView text1 = new TextView(this);
        text1.setText(R.string.string1);
        
        TextView text2 = new TextView(this);
        text2.setText(R.string.string2);
        
        text2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 60);
        
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(text1);
        ll.addView(text2);
        
        setContentView(ll);
        
        
        
        IntentFilter intentFilter = 
            new IntentFilter(Intent.ACTION_CAMERA_BUTTON);
        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
        registerReceiver(intentReceiver, intentFilter); 

    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(intentReceiver);
        super.onDestroy();
    }   
    
    
}//end the class

/*
 * Container classes, that make things interactive
 *
//ArrayAdapter
private String[] items = {"Item 1", "Item 2", "Item 3"};

ArrayAdapter adapt = new ArrayAdapter<String> {this, R.layout.textview, items};

<TextView xmlns:android="http://schemas.android.com/apk/res/android" 
android:layout_width, android:layout_height, android:textSize >


//CursorAdapter
 * import android.abcd.Cursor;
 * import android.abcd.ListAdapter;
 * 
 * Cursor names = managedQuery{Contacts.PHONE.CONTENT_URI, null, null, null, null};
 * 
 * startManagingCursor(names);
 * 
 * ListAdapter adapter = new SimpleCursorAdapter(this, R.layout.texttwo, 
 * 
 * 						names String[] { Contacts.Phone.NAME, Contacts.Phone.NUMBER},
 * 
 * 						new int[]{R.id.text_1, text_2}   });
 * 
 * 
 */

