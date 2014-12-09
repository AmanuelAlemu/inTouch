
package com.example.intouch;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity 
{
	public final static String EXTRA_MESSAGE = "com.example.inTouch.MESSAGE";
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private LinearLayout linearLayout;
	private int numContactsSelected = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout)findViewById(R.id.info);
        ArrayList<Contact> tempContactList = searchContacts();
        
        displayContacts(tempContactList);
    }
    
    public OnClickListener nextHandler = new OnClickListener()
    {
    	public void onClick(View v)
    	{
    		Intent intent = new Intent(MainActivity.this, CreateGroupActivity.class);
    		intent.putParcelableArrayListExtra(EXTRA_MESSAGE, contacts);
    		startActivity(intent);
    	}	
    };
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    public ArrayList<Contact> searchContacts() 
    {
    	LinkedHashMap<String, Contact> contactList = new LinkedHashMap<String, Contact>();	
    	ArrayList<Contact> tempContactList = new ArrayList<Contact>();
	    
    	String[] projection = 
	    {
	    		ContactsContract.Data.CONTACT_ID, 
	    		ContactsContract.Data.MIMETYPE,
	    		ContactsContract.CommonDataKinds.Email.ADDRESS,
	    		ContactsContract.Contacts.DISPLAY_NAME,
	    		ContactsContract.CommonDataKinds.Phone.NUMBER,
	    		ContactsContract.Contacts.HAS_PHONE_NUMBER
	    };
	    String sortOrder = "DISPLAY_NAME";
	    Cursor people = getContentResolver().query(ContactsContract.Data.CONTENT_URI, projection, null, null, sortOrder);
	    
	    final int mimeTypeIdx = people.getColumnIndex(ContactsContract.Data.MIMETYPE);
	    final int idIdx = people.getColumnIndex(ContactsContract.Data.CONTACT_ID);
	    final int nameIdx = people.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
	    final int emailIdx = people.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS);
	    final int numberIdx = people.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
	    final int hasPhoneIdx = people.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);

	    while(people.moveToNext()) 
	    {
		   int hasPhone = people.getInt(hasPhoneIdx); 							  
		   if (hasPhone == 1)
		   {
			   final Contact contact;
			   
			   String id = people.getString(idIdx);
			   String mimeType = people.getString(mimeTypeIdx);
			   String name = people.getString(nameIdx);
			   String number = people.getString(numberIdx);
			   String email = people.getString(emailIdx);
			   
			   if (contactList.containsKey(id))
				   contact = contactList.get(id);
			   
			   else
			   {
				   contact = new Contact();
				   contactList.put(id, contact);
			   }
		   
			   if (mimeType.equals(ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE))
			   {
				   contact.setContactName(name);
			   }
			   if (mimeType.equals(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE))
			   {
				   contact.setContactNumber(number);
			   }
			   if (mimeType.equals(ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE))
			   {
				   contact.setContactEmail(email);
			   }  
		   }
	    }
	    people.close();
	    
	    tempContactList.addAll(contactList.values());
	    
	    for (Contact _contact : contacts)
	    {
	    	if (_contact.getContactName() == null &&
	    		_contact.getContactNumber() == null &&
	    		_contact.getContactEmail() == null)
	    	{
	    		tempContactList.remove(_contact);
	    	}
	    	
	    }
	    return tempContactList;
	}
		   
    public void displayContacts(ArrayList<Contact> contactList)
    {
    	final TextView nextButton = (TextView)findViewById(R.id.next_button);
        nextButton.setOnClickListener(nextHandler);
    	
    	for (int i=0; i<contactList.size(); i++)
    	{
    		final Contact contact = contactList.get(i);
	    	TextView tv = (TextView)LayoutInflater.from(MainActivity.this).inflate(R.layout.contacts_list_item, linearLayout, false);
			
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
