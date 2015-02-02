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


public class Event{
	protected String eventName;
	protected String eventDate;
	protected String eventStartDate;
	protected String eventEndDate;
	public Event(String eventName) {
		this.eventName=eventName;
	}


	public String getName() {
		return this.eventName;
	}
	
	public String eventDate(String eventStartDate, String eventEndDate) {
		return this.eventDate=eventStartDate+"to"+eventEndDate;
	}

	public String updateEventName(String eventName,String eventDate) {
		this.eventName=eventName+eventDate;
		return eventName;
	}
}