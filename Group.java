package com.example.intouch;

import java.util.ArrayList;
import android.provider.ContactsContract;

public class Group extends MainActivity
{
	// Private members - a group has a name and an arrayList of Contacts
	private ArrayList<ContactsContract> contactsList;
	private String groupName;
	
	// Constructor
	public Group(String name, ArrayList<ContactsContract> contacts)
	{
		contactsList = contacts;
		groupName = name;
	}
	
	// Methods
	public String getName()
	{
		return groupName;
	}
	
	public void changeName(String name)
	{
		groupName = name;
	}
	
	public void addContact(ContactsContract contact)
	{
		contactsList.add(contact);
	}
	
	public void removeContact(ContactsContract contact)
	{
		contactsList.add(contact);
	}
	

}
