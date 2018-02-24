package domain;

import java.util.ArrayList;

/**
 * Created by dnnxl on 23/2/2018.
 */

public class Calendar
{
    private ArrayList<Day> listDay;

    /**
     * Method constructor
     * Author: Danny Xie Li
     * Description: Method constructor.
     * Last modification: 22/02/18
     */
    public Calendar()
    {
        listDay = new ArrayList<Day>();
    }

    /**
     * Method constructor
     * Author: Danny Xie Li
     * Description: Method constructor.
     * Last modification: 22/02/18
     */
    public Calendar(ArrayList<Day> pListDay)
    {
        listDay = pListDay;
    }

    /**
     * Method getDays
     * Author: Danny Xie Li
     * Description: Method get all the days.
     * Last modification: 22/02/18
     */
    public ArrayList<Day> getDays()
    {
        return listDay;
    }
}
