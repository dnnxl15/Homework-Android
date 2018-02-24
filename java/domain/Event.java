package domain;

/**
 * Created by dnnxl on 22/2/2018.
 */
import library.IConstant;

public class Event implements IConstant
{
    private String name;
    private String place;
    private TimeRange timeRange;

    /**
     * Method constructor
     * Author: Danny Xie Li
     * Description: Method constructor.
     * Last modification: 22/02/18
     */
    public Event()
    {
        name = NOTHING;
        place = NOTHING;
        timeRange = null;
    }

    /**
     * Method constructor
     * Author: Danny Xie Li
     * Description: Method constructor.
     * Last modification: 22/02/18
     */
    public Event(String pName, String pPlace, TimeRange pTimeRange)
    {
        name = pName;
        place = pPlace;
        timeRange = pTimeRange;
    }

    /**
     * Methods getter and setters
     * Author: Danny Xie Li
     * Description: Methods getter and setters.
     * Last modification: 22/02/18
     */
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimeRange getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(TimeRange timeRange) {
        this.timeRange = timeRange;
    }

    public void addTimeRange(TimeRange pTimeRange)
    {
        timeRange = pTimeRange;
    }
}