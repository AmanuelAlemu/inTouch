package com.example.intouch;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NameGroupActivity extends ActionBarActivity {

	public final static String EXTRA_MESSAGE = "com.example.inTouch.SELECT_CONTACTS";
	ArrayList<Contact> contacts;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_name_group);
		Intent intent = getIntent();
		contacts = intent.getParcelableArrayListExtra("com.example.inTouch.NAME_GROUP");
		
		
		Button selectContacts = (Button)findViewById(R.id.selectContacts);
		selectContacts.setOnClickListener(selectContactsHandler);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.name_group, menu);
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

	private OnClickListener selectContactsHandler = new OnClickListener()
	{
		public void onClick(View v)
		{
			EditText textField = (EditText)findViewById(R.id.nameGroup);
			String groupName = textField.getText().toString();
			Intent intent = new Intent(NameGroupActivity.this, SelectContactsForGroup.class);
			intent.putExtra("groupNameField", groupName);
			intent.putParcelableArrayListExtra(EXTRA_MESSAGE, contacts);
			startActivity(intent);
		}
	};


}
