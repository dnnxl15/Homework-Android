package domain;

import java.io.Serializable;

public class User extends Person implements Serializable
{
	private String password;
	private String nickName;
	
	public User(String pPassword, String pNickName, String pName, String pLastName)
	{
		super(pName, pLastName); //method that extends from person
		this.password = pPassword;
		this.nickName = pNickName;
	}
}
