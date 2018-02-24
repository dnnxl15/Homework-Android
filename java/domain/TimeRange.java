package domain;

import library.IConstant;
/**
 * Created by dnnxl on 22/2/2018.
 */

public class TimeRange implements IConstant
{
    private String startDay;
    private String endDay;

    /**
     * Method constructor
     * Author: Danny Xie Li
     * Description: Method constructor.
     * Last modification: 22/02/18
     */
    public TimeRange()
    {
        startDay = NOTHING;
        endDay = NOTHING;
    }

    /**
     * Method constructor
     * Author: Danny Xie Li
     * Description: Method constructor.
     * Last modification: 22/02/18
     */
    public TimeRange(String pStartDay, String pEndDay)
    {
        startDay = pStartDay;
        endDay = pEndDay;
    }

    /**
     * Method getter and setter
     * Author: Danny Xie Li
     * Description: Method getter and setter.
     * Last modification: 22/02/18
     */
    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    @Override
    public String toString()
    {
        return "Start day " + startDay + " end day " + endDay;
    }
}
