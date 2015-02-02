/*  
ClaimIt123: Business claim, allows user to create claims, add expense and edit expenses, and email claims.
    Copyright (C) 2015  Chris Xichao Wang xinchao@ualberta.ca

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package ca.ualberta.cs.claimit123;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;

import com.example.claimit123.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Type;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class EventActivity extends Activity {
	private static final String FILENAME = "file.sav";
	private Button create;
	private ArrayList<String> fileName ;
	private EditText startDate;
	private EditText endDate;
	private EditText eventName;
	private Event event;
	private EventList eventList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_event);
		startDate=(EditText) findViewById(R.id.eventStartDate);
		endDate=(EditText) findViewById(R.id.eventEndDate);
		eventName=(EditText) findViewById(R.id.eventText);
		create=(Button) findViewById(R.id.eventCreateButton);
		create.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent= new Intent(v.getContext(),ca.ualberta.cs.claimit123.CreateEventActivity.class);
				//String text = eventName.getText().toString()+" on "+startDate.getText().toString()+" to "+endDate.getText().toString();
				//eventList.addEvent(new Event(text));
				startActivityForResult(intent, 0);
			}
		});
		
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.create_event, menu);
//		return true;
//	}
//	


	//public void addEventListActivity(View v){
	//	Toast.makeText(this,"Creating a claim", Toast.LENGTH_SHORT).show();
	//	EventListController et= new EventListController();
	//}
}
