package library;

/**
 * Created by dnnxl on 21/2/2018.
 */

public interface IConstant
{
    public static final String CREATE_TABLE_EVENT = "CREATE TABLE " + ""+"Event"+" ("+"Name"+" " +
            "TEXT, "+"Place"+" TEXT,"+"Start_Day"+" TEXT, End_Day TEXT)";

    public static final String TABLE_EVENT = "Event";

    public static final String NAME_EVENT_TABLE = "Name";

    public static final String PLACE_EVENT_TABLE = "Place";

    public static final String START_DAY_EVENT_TABLE = "Start_Day";

    public static final String END_DAY_EVENT_TABLE = "End_Day";

    public static final String DATABASE_NAME = "bd_Event";

    public static final String CREATE_TABLE_USER = "CREATE TABLE " + "" + "User" + " (" + "Name" + " " +
            "TEXT, " + "Username" + " TEXT," + "Password" + " TEXT)";

    public static final String TABLE_USER = "User";

    public static final String USER_DATABASE = "User_db";

    public static final String NAME_USER_TABLE = "Name";

    public static final String USERNAME_USER_TABLE = "Username";

    public static final String PASSWORD_USER_TABLE = "Password";

    public static final String NOTHING = "";
}
