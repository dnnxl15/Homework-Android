package domain;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;

import File.FileWriter;

public class UserAdministrator implements Serializable
{
	private ArrayList<User> userList= new ArrayList<User>();

	//GETTERS and SETTERS for the attributes
	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	
	public void addUser(String pName, String pLastName, String pNickName, String pPassword) throws FileNotFoundException, ClassNotFoundException
	{
		User userInfo = new User(pName, pLastName, pNickName, pPassword);
		this.userList.add(userInfo);
		FileWriter savior = new FileWriter();
		savior.saveUser(userInfo);
	}
}
