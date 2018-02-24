package domain;

/**
 * Created by esteb on 22/2/2018.
 */

public class User extends Person
{
    private String username;
    private String password;
    private Calendar calendar;

    public User(String pName, String pUsername, String pPassword)
    {
        super(pName);
        this.username = pUsername;
        this.password = pPassword;
        calendar = new Calendar();
    }

    public Calendar getCalendar()
    {
        return calendar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
