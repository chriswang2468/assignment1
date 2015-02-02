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

import com.example.claimit123.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button claimit =(Button) findViewById(R.id.createNewButton);
		Button history=(Button) findViewById(R.id.historyButton);
		claimit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent myClaim= new Intent(v.getContext(),EventActivity.class);
				startActivityForResult(myClaim, 0);
			}
		});
		history.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myHistory = new Intent(v.getContext(), ListHistoryEventActivity.class);
				startActivityForResult(myHistory, 0);
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
	