package Consult;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import File.FileReader;
import domain.Event;

public class EventConsult
{
	private ArrayList<Event> eventList = new ArrayList<Event>();
	private ArrayList<Event> eventFilter = new ArrayList<Event>();
	
	//Author: Esteban Coto
	//Created day: 02/18/2018 17:20
	//Last modification: 02/18/2018 17:35 by Esteban Coto
	//Description: Receives a string and return all the events with that name
	public ArrayList<Event> eventByName(String pName) throws FileNotFoundException, ClassNotFoundException
	{
		FileReader file = new FileReader();
		eventList = file.readEvent();
		for(int i = 0; i < eventList.size(); i++)
		{
			if (eventList.get(i).getName().equals(pName))
			{
				eventFilter.add(eventList.get(i));
			}
		}
		return eventFilter;
	}
	
	//Author: Esteban Coto
	//Created day: 02/18/2018 17:35
	//Last modification: 02/18/2018 17:40 by Esteban Coto
	//Description: Receives a string and return all the events with that location
	public ArrayList<Event> eventByLocation(String pLocation) throws FileNotFoundException, ClassNotFoundException
	{
		FileReader file = new FileReader();
		eventList = file.readEvent();
		for(int i = 0; i < eventList.size(); i++)
		{
			if (eventList.get(i).getLocation().equals(pLocation))
			{
				eventFilter.add(eventList.get(i));
			}
		}
		return eventFilter;
	}
	
	//Author: Esteban Coto
	//Created day: 02/18/2018 17:45
	//Last modification: 02/18/2018 18:30 by Esteban Coto
	//Description: Receives a string and return all the events that are on time
	public ArrayList<Event> eventByDate(String pStringDate) throws FileNotFoundException, ClassNotFoundException, ParseException
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
        Date eventDate = (Date) dateFormat.parse(pStringDate);
        FileReader file = new FileReader();
		eventList = file.readEvent();
		/*for(int i = 0; i < eventList.size(); i++)
		{
			if (eventList.get(i).getEventDuration().getStart().after(pDate))))
			{
				eventFilter.add(eventList.get(i));
			}
		}*/
		return null; //eventFilter;
	}
}
