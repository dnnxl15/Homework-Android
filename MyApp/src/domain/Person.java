package domain;

import java.io.Serializable;

public class Person implements Serializable
{
	private String name; //name of the person
	private String lastName; //last name of the person
	
	public Person (String pName, String pLastName)
	{
		this.name = pName;
		this.lastName = pLastName;
	}
}
