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

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.Date;

import ca.ualberta.cs.claimit123.EventList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CreateEventActivity extends Activity {
	private static final String FILENAME = "file.sav";
	private ArrayAdapter<String> adapter;
	ArrayList<String> m_listItems = new ArrayList<String>();
	private EditText expenseName;
	private EditText expenseDate;
	private EditText expenseValue;
	private EditText expenseCurrency;
	private ListView addview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.example.claimit123.R.layout.add_expense);
		Button add = (Button) findViewById(com.example.claimit123.R.id.itemAddButton);
		addview=(ListView) findViewById(com.example.claimit123.R.id.expenseListView);
		Button submit=(Button) findViewById(com.example.claimit123.R.id.submitExpenseButton);
		expenseName=(EditText) findViewById(com.example.claimit123.R.id.expenseNameEditText);
		expenseDate=(EditText) findViewById(com.example.claimit123.R.id.expenseDateEditText);
		expenseValue=(EditText) findViewById(com.example.claimit123.R.id.expenseValueEditText);
		expenseCurrency=(EditText) findViewById(com.example.claimit123.R.id.expenseCurrencyEditText);
		adapter=new ArrayAdapter<String>(this, R.layout.simple_list_item_1, m_listItems);
		addview.setAdapter(adapter);
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setResult(RESULT_OK);
				String name=expenseName.getText().toString();
				String date=expenseDate.getText().toString();
				String value=expenseValue.getText().toString();
				String currency=expenseCurrency.getText().toString();
				String updatename=name+" on "+date+" cost "+value+" "+currency;
				m_listItems.add(updatename);
				saveInFile(updatename);
				adapter.notifyDataSetChanged();
			
			}
		});
//		submit.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent myHistory = new Intent(v.getContext(), ListHistoryEventActivity.class);
//				startActivityForResult(myHistory, 0);
//				
//			}
//		});
		registerForContextMenu(addview);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(com.example.claimit123.R.menu.add_expense_menu,menu); 
		
	}
	

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		switch(item.getItemId()) {
		case com.example.claimit123.R.id.removeExpense:
			adapter.remove(adapter.getItem(info.position));
			return true;
		case com.example.claimit123.R.id.editExpense:
			adapter.insert("a",adapter.getPosition(adapter.getItem(info.position)));
			adapter.remove(adapter.getItem(info.position));
			return true;
			
		}
		return super.onContextItemSelected(item);
		
	}
//	@Override
//	protected void onStart() {
//		// TODO Auto-generated method stub
//		ArrayList<Object> objects;
//		
//		
//		super.onStart();
//		ArrayList <ExpenseList> expenseList=new ArrayList<ExpenseList>();
//		m_listItems = loadFromFile();
//		if (m_listItems==null){
//			m_listItems=new ArrayList<String>();
//		}
//		adapter = new ArrayAdapter<String>(this,
//				com.example.claimit123.R.layout.add_expense, m_listItems);
//		addview.setAdapter(adapter);
//	}
	private ArrayList<String> loadFromFile() {
		Gson gson = new Gson();
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis=openFileInput(FILENAME);
			InputStreamReader in= new InputStreamReader(fis);
			java.lang.reflect.Type typeOfT = new TypeToken<ArrayList<String>>(){}.getType();
			//http://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html#fromJson%28java.lang.String,%20java.lang.Class%29
			tweets=gson.fromJson(in, typeOfT);
			gson.fromJson(in, typeOfT);
			fis.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets;
	}
	private void saveInFile(String text) {
		Gson gson = new Gson();
		try {
			FileOutputStream fos = openFileOutput(FILENAME,0);
			OutputStreamWriter osw= new OutputStreamWriter(fos);
			gson.toJson(m_listItems,osw);
			osw.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(com.example.claimit123.R.menu.create_event, menu);
		return true;
	}
}
