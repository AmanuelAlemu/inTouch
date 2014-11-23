package com.example.intouch;

import java.util.ArrayList;

public class UserProfile extends MainActivity {
	
	// Private Member - UserProfile has a list of groups
	private ArrayList<Group> grouplist;
	
	// Constructor 
	public UserProfile(ArrayList<Group> groups)
	{
		grouplist = groups;
	}
	
	// Methods
	public void addGroup(Group group) 
	{
		grouplist.add(group);
	}

	public void removeGroup(Group group)
	{
		grouplist.remove(group);
	}
}
