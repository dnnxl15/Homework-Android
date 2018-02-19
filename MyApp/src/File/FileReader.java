package File;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import domain.Event;
import domain.User;

public class FileReader 
{
	//Author: Esteban Coto
	//Created day: 02/18/2018 12:30
	//Last modification: 02/18/2018 16:40 by Esteban Coto
	//Description: Return a arrayList with the events
	public ArrayList<Event> auxiliarReaderEvent() throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<Event> eventList = null;
		try
		{
			FileInputStream fileIS = new FileInputStream("Event.ser"); //open the file
			ObjectInputStream objectIS = new ObjectInputStream(fileIS); //read the file
			eventList = (ArrayList<Event>) objectIS.readObject(); //The method readObject() take the reader object
			objectIS.close(); 
			fileIS.close();
		}catch(FileNotFoundException e){
		  e.printStackTrace();
		}catch(IOException e){
		  e.printStackTrace();
		}
		return eventList;
	}
	
	//Author: Esteban Coto
	//Created day: 02/18/2018 16:40
	//Last modification: 02/18/2018 16:40 by Esteban Coto
	//Description: Return an arrayList with the events
	public ArrayList<Event> readEvent() throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<Event> eventList = null;
		try
		{
			FileInputStream fileIS = new FileInputStream("Event.ser"); //open the file
			ObjectInputStream objectIS = new ObjectInputStream(fileIS); //read the file
			eventList = (ArrayList<Event>) objectIS.readObject(); //The method readObject() take the reader object
			objectIS.close(); 
			fileIS.close();
		}catch(FileNotFoundException e){
		  e.printStackTrace();
		}catch(IOException e){
		  e.printStackTrace();
		}
		return eventList;
	}
	
	//Author: Esteban Coto
	//Created day: 02/18/2018 19:20
	//Last modification: 02/18/2018 19:30 by Esteban Coto
	//Description: Return an arrayList with the users
	public ArrayList<User> auxiliarReaderUser() throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<User> userList = null;
		try
		{
			FileInputStream fileIS = new FileInputStream("User.ser"); //open the file
			ObjectInputStream objectIS = new ObjectInputStream(fileIS); //read the file
			userList = (ArrayList<User>) objectIS.readObject(); //The method readObject() take the reader object
			objectIS.close(); 
			fileIS.close();
		}catch(FileNotFoundException e){
		  e.printStackTrace();
		}catch(IOException e){
		  e.printStackTrace();
		}
		return userList;
	}
	
	//Author: Esteban Coto
	//Created day: 02/18/2018 19:30
	//Last modification: 02/18/2018 19:30 by Esteban Coto
	//Description: Return an arrayList with the users
	public ArrayList<User> readUser() throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<User> userList = null;
		try
		{
			FileInputStream fileIS = new FileInputStream("User.ser"); //open the file
			ObjectInputStream objectIS = new ObjectInputStream(fileIS); //read the file
			userList = (ArrayList<User>) objectIS.readObject(); //The method readObject() take the reader object
			objectIS.close(); 
			fileIS.close();
		}catch(FileNotFoundException e){
		  e.printStackTrace();
		}catch(IOException e){
		  e.printStackTrace();
		}
		return userList;
	}
}
