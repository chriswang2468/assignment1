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

import java.util.Collection;


public class EventList {
	protected ArrayList<Event> eventList;
	
	public EventList() {
		eventList=new ArrayList<Event>();
	}
	
	public Collection<Event> getEvent() {
		return eventList;
	}

	public void addEvent(Event testEvent) {
		eventList.add(testEvent);
		
	}

	public void removeEvent(Event testEvent) {
		eventList.remove(testEvent);
		
	}

	public void editEventList(Event testEvent, Event newEvent) {
		int n=eventList.indexOf(testEvent);
		eventList.remove(testEvent);
		eventList.add(n,newEvent);
	}
	public void eventName(){
		eventList.get(eventList.size());
	}

}
