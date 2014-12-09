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
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class CreateGroupActivity extends ActionBarActivity 
{
	public final static String EXTRA_MESSAGE = "com.example.inTouch.NAME_GROUP";
	private ArrayList<Contact> contacts;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_group);
		//RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.create_groups_page);
		Intent intent = getIntent();
		
		
		contacts = intent.getParcelableArrayListExtra("com.example.inTouch.MESSAGE");
		
		
		Button createGroupButton = (Button)findViewById(R.id.create_group);
		createGroupButton.setOnClickListener(createGroupHandler);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_group, menu);
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
	
	private OnClickListener createGroupHandler = new OnClickListener()
	{
		public void onClick(View v)
		{
			
			Intent intent = new Intent(CreateGroupActivity.this, NameGroupActivity.class);
			intent.putParcelableArrayListExtra(EXTRA_MESSAGE, contacts);
			startActivity(intent);
		}
	};
	
}
