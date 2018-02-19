package domain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import File.FileReader;
import File.FileWriter;

public class Day implements Serializable
{
	private ArrayList<Event> listEvent = new ArrayList<Event>();
	
	//GETTERS and SETTERS for the attributes
		public ArrayList<Event> getListEvent() {
			return listEvent;
		}

		public void setListEvent(ArrayList<Event> listEvent) {
			this.listEvent = listEvent;
		}
	
	public void addEvent(String pName, String pLocation, String pStartEvent, String pEndEvent) throws ParseException, FileNotFoundException, IOException, ClassNotFoundException
	{
		Event eventInfo = new Event(pName, pLocation, pStartEvent, pEndEvent);
		this.listEvent.add(eventInfo);
		FileWriter savior = new FileWriter();
		savior.saveEvent(eventInfo);	
	}

}
