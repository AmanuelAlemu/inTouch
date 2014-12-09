package com.example.intouch;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UserProfileActivity extends ActionBarActivity {

	LinearLayout linearLayout;
	UserProfile profile;
	Group newGroup;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profile);
		
		Intent intent = getIntent();
		profile = new UserProfile();
		newGroup = (Group)intent.getExtras().getParcelable("com.example.inTouch.GROUP");
		
		linearLayout = (LinearLayout)findViewById(R.id.contact_in_group);
		
		TextView groupName = (TextView)findViewById(R.id.groupName);
		
		groupName.setText(newGroup.getName());
		groupName.setTextSize(20);
		
		ArrayList<Contact> groupContacts = newGroup.getContacts();
		
		for (int i=0; i<groupContacts.size(); i++)
		{
			TextView tv = (TextView)LayoutInflater.from(UserProfileActivity.this).inflate(R.layout.contacts_list_item2, linearLayout, false);
			tv.setText(groupContacts.get(i).getContactName());
			tv.setTextSize(25);
			linearLayout.addView(tv);
		}	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_profile, menu);
		return true;
	}

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
}
