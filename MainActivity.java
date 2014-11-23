package com.example.intouch;

import android.support.v7.app.ActionBarActivity;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.database.Cursor;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	// Create an entire Linear Layout. We add each contact into the 
	// Layout if they have a phone number.
	LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Up to here comes included on a new project, the rest is new
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout)findViewById(R.id.info);
        searchContacts();
    }
    
    // Given, not mine
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    // Given, not mine
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    // New
    public void searchContacts() {
    // Still not sure how cursors work, these first three lines are from the internet
    Cursor people = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);{
    
    while(people.moveToNext()) {
	   int nameFieldColumnIndex = people.getColumnIndex(PhoneLookup.DISPLAY_NAME);
	   // Each contact has a table with a large number of columns containing info about him/her. 
	   // Column 21 is the one for HAS_PHONE_NUMBER. 0 for no, 1 for yes.
	   int hasPhone = people.getInt(21); 							  
	   if (hasPhone == 1)
	   {
		   String contact = people.getString(nameFieldColumnIndex); // Get person's name
		   TextView tv = new TextView(this);
		   tv.setText(String.valueOf(contact));
		   tv.setTextSize(20); // Size of letters
		   tv.setPadding(0,35,0,35); // Padding between name and border
		   linearLayout.addView(tv);
	   }
    }
    people.close();
}
}
}

