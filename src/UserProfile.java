package com.example.intouch;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class UserProfile
{
	
	// Private Member - UserProfile has a list of groups
	private ArrayList<Contact> defaultGroup;
	private ArrayList<Group> groupList;
	
	// Default Constructor
	
	public UserProfile()
	{
		defaultGroup = new ArrayList<Contact>();
		groupList = new ArrayList<Group>();
	}
	
	// Constructor 
	public UserProfile(ArrayList<Contact> defaultGroup)
	{
		this.defaultGroup = defaultGroup;
		this.groupList = new ArrayList<Group>();
	}
	
	// Methods
	public void addGroup(Group group) 
	{
		groupList.add(group);
	}

	public void removeGroup(Group group)
	{
		groupList.remove(group);
	}
	
}
