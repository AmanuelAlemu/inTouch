package com.example.intouch;

import java.util.ArrayList;

import android.os.Parcelable;
import android.os.Parcel;

public class Group implements Parcelable
{
	// Private members - a group has a name and an arrayList of Contacts
	private String groupName;
	private ArrayList<Contact> contactsList = new ArrayList<Contact>();
	
	// Constructor
	public Group(String name, ArrayList<Contact> contacts)
	{
		groupName = name;
		contactsList = contacts;
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
	
	public void addContact(Contact contact)
	{
		contactsList.add(contact);
	}
	
	public void removeContact(Contact contact)
	{
		contactsList.remove(contact);
	}
	
	public ArrayList<Contact> getContacts()
	{
		return contactsList;
	}
	
	public int getNumberOfContacts()
	{
		return contactsList.size();
	}
	
	@Override
	public int describeContents()
	{
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeString(groupName);
		dest.writeTypedList(contactsList);
	}
	
	public Group(Parcel in)
	{
		this.groupName = in.readString();
		in.readTypedList(contactsList, Contact.CREATOR);
	}
	
	public static final Parcelable.Creator<Group> CREATOR = new Parcelable.Creator<Group>()
			{
				@Override
				public Group createFromParcel(Parcel in)
				{
					return new Group(in);
				}
				
				@Override
				public Group[] newArray(int size)
				{
					return new Group[size];
				}
			};
	
}
