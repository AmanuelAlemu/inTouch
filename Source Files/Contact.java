package com.example.intouch;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable 
{	
	private String name;
	private String number;
	private String email;
	private String dateContacted;
	private int numDaysSinceContacted;
	
	public Contact()
	{
		this.name = "";
		this.number = "";
		this.email="";
		this.dateContacted = "";
		this.numDaysSinceContacted = 0;
	}
	
	public Contact(String name, String number, String email)
	{
		this.name = name;
		this.number = number;
		this.email = email;
		this.dateContacted = "";
		this.numDaysSinceContacted = 0;
	}
	
	public void setContactName(String name)
	{
		this.name = name;
	}
	
	public void setContactNumber(String number)
	{
		this.number = number;
	}
	
	public void setContactEmail(String email)
	{
		this.email = email;
	}
	public void setDateContacted(String date)
	{
		dateContacted = date;
	}
	
	public void setNumDaysSinceContacted(int numDays)
	{
		numDaysSinceContacted = numDays;
	}
	
	public String getContactName()
	{
		return name;
	}
	
	public String getContactNumber()
	{
		return number;
	}
	
	public String getContactEmail()
	{
		return email;
	}
	
	public String getDateContacted()
	{
		return dateContacted;
	}
	
	public int getNumDaysSinceContacted()
	{
		return numDaysSinceContacted;
	}

	@Override
	public int describeContents() 
	{
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) 
	{
		dest.writeString(name);
		dest.writeString(number);
		dest.writeString(email);
		dest.writeString(dateContacted);
		dest.writeInt(numDaysSinceContacted);
	}
	
	public Contact(Parcel in)
	{
		this.name = in.readString();
		this.number = in.readString();
		this.email = in.readString();
		this.dateContacted = in.readString();
		this.numDaysSinceContacted = in.readInt();
	}
	
	public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>()
	{
		@Override
		public Contact createFromParcel(Parcel in)
		{
			return new Contact(in);
		}
		
		@Override
		public Contact[] newArray(int size)
		{
			return new Contact[size];
		}
	};
}



