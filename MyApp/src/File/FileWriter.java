package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import domain.Event;
import domain.User;

public class FileWriter 
{
	//Author: Esteban Coto
	//Created day: 02/18/2018 11:20
	//Last modification: 02/18/2018 12:20 by Esteban Coto
	//Description: Save event in the file
	public void saveEvent(Event pEvent) throws FileNotFoundException, ClassNotFoundException
	{
		FileReader file = new FileReader();
		ArrayList<Event> eventList = new ArrayList<Event>();
		eventList = file.auxiliarReaderEvent(); //do a call to charge the file
		System.out.println(eventList.size());	
		eventList.add(pEvent);
		System.out.println(eventList.size());
	    
		try
		{
			FileOutputStream fileE = new FileOutputStream("Event.ser"); //This line is to create the file or use an existing one
		    ObjectOutputStream objectE = new ObjectOutputStream(fileE);//Ithis implements the method writeObject
		    objectE.writeObject(eventList); //Here the object is write on the file
		    objectE.close(); //This line close the file
		    fileE.close();
		}
		catch(FileNotFoundException e){
		    e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//Author: Esteban Coto
	//Created day: 02/18/2018 19:30
	//Last modification: 02/18/2018 19:35 by Esteban Coto
	//Description: Save the users in the file
	public void saveUser(User pUser) throws FileNotFoundException, ClassNotFoundException
	{
		FileReader file = new FileReader();
		ArrayList<User> userList = new ArrayList<User>();
		userList = file.auxiliarReaderUser(); //do a call to charge the file
		System.out.println(userList.size());	
		userList.add(pUser);
		System.out.println(userList.size());
	    
		try
		{
			FileOutputStream fileE = new FileOutputStream("User.ser"); //This line is to create the file or use an existing one
		    ObjectOutputStream objectE = new ObjectOutputStream(fileE);//Ithis implements the method writeObject
		    objectE.writeObject(userList); //Here the object is write on the file
		    objectE.close(); //This line close the file
		    fileE.close();
		}
		catch(FileNotFoundException e){
		    e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
