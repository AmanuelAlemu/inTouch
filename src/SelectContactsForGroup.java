package com.example.intouch;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SelectContactsForGroup extends ActionBarActivity {

	private LinearLayout linearLayout;
	private int numContactsSelected = 0;
	ArrayList<Contact> contacts = new ArrayList<Contact>();
	String groupName;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		linearLayout = (LinearLayout)findViewById(R.id.info);
		Intent intent = getIntent();
		ArrayList<Contact> contactList = intent.getParcelableArrayListExtra("com.example.inTouch.SELECT_CONTACTS");
		groupName = intent.getExtras().getString("groupNameField");
		
		
		displayContacts(contactList);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select_contacts_for_group, menu);
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

	private OnClickListener nextHandler = new OnClickListener()
	{
		public void onClick(View v)
		{
			Group newGroup = new Group(groupName, contacts);
			Intent intent = new Intent(SelectContactsForGroup.this, UserProfileActivity.class);
			intent.putExtra("com.example.inTouch.GROUP", newGroup);
			startActivity(intent);
		}
	};
	
	
	public void displayContacts(ArrayList<Contact> contactList)
    {
    	final TextView nextButton = (TextView)findViewById(R.id.next_button);
        nextButton.setOnClickListener(nextHandler);
    	
    	for (int i=0; i<contactList.size(); i++)
    	{
    		final Contact contact = contactList.get(i);
	    	TextView tv = (TextView)LayoutInflater.from(SelectContactsForGroup.this).inflate(R.layout.contacts_list_item, linearLayout, false);
			
			   tv.setId(i+1);
			   tv.setText(contactList.get(i).getContactName());
			   final int index = i;
			   tv.setTextSize(20); // Size of letters
			   tv.setPadding(0,35,0,35); // Padding between name and border
			   
			   tv.setOnClickListener(new View.OnClickListener()
			   {
				   public void onClick(View v)
				   {
					   TextView tv = (TextView)findViewById(index+1);
					   if (tv.isSelected() == true)	    // This is the logic to keep track of whether to display the next button or not.
					   {   
						   numContactsSelected--;	    // It works the opposite way of what you'd expect. I guess isSelected() starts off as true
					   	   contacts.remove(contact);	// then changes to false
					   }   
					   else
					   {
						   numContactsSelected++;
						   contacts.add(contact);
					   }
					   tv.setSelected(!v.isSelected());
					   
					   if (numContactsSelected == 0)
						   nextButton.setVisibility(View.GONE);
					   else
						   nextButton.setVisibility(View.VISIBLE);
				   } 
			   });
			   linearLayout.addView(tv);
    	}
    }

}
