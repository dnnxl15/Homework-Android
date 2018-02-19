package domain;

import java.io.Serializable;
import java.text.ParseException;

public class Event implements Serializable
{
	private String name;
	private String location;
	private TimeRange eventDuration;
	
	public Event(String pName, String pLocation, String pStartEvent, String pEndEvent) throws ParseException
	{
		this.name = pName;
		this.location = pLocation;
		this.eventDuration = getTimeRange(pStartEvent, pEndEvent);
	}
	
	public TimeRange getTimeRange(String pStartEvent, String pEndEvent) throws ParseException
	{
		TimeRange time = new TimeRange(pStartEvent, pEndEvent);
		return time;
	}

	
	//GETTERS and SETTERS of the attributes 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public TimeRange getEventDuration() {
		return eventDuration;
	}

	public void setEventDuration(TimeRange eventDuration) {
		this.eventDuration = eventDuration;
	}
	
	
	
}
