package domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class TimeRange implements Serializable
{  
	private Date startEvent;
	private Date endEvent;
	
		
	public TimeRange(String pStartEvent, String pEndEvent) throws ParseException
	{
		this.startEvent = getStartEvent(pStartEvent);
		this.endEvent = getEndEvent(pEndEvent);
	}
	
	//Author: Esteban Coto
	//Created day: 02/18/2018 11:20
	//Last modification: 02/18/2018 11:20 by Esteban Coto
	//Description: Receives a string and is parse to Date formate
	public Date getStartEvent(String pStartEvent) throws ParseException
	{  
		startEvent = new SimpleDateFormat("dd/MM/yyyy").parse(pStartEvent); //do the parsing from a string to a Date   
		return startEvent;
	}
	
	//Author: Esteban Coto
	//Created day: 02/18/2018 11:20
	//Last modification: 02/18/2018 11:20 by Esteban Coto
	//Description: Receives a string and is parse to Date formate
	public Date getEndEvent(String pEndEvent) throws ParseException
	{  
		endEvent = new SimpleDateFormat("dd/MM/yyyy").parse(pEndEvent); //do the parsing from a string to a Date  
		return endEvent;
	}
	
	public Date getStart()
	{
		return startEvent;
	}
}  