package domain;

import java.util.ArrayList;

/**
 * Created by dnnxl on 22/2/2018.
 */

public class Day {

    private ArrayList<Event> listEvent;

    /**
     * Method constructor
     * Author: Danny Xie Li
     * Description: Method constructor.
     * Last modification: 22/02/18
     */
    public Day()
    {
        listEvent = new ArrayList<Event>();
    }

    /**
     * Method constructor
     * Author: Danny Xie Li
     * Description: Method constructor.
     * Last modification: 22/02/18
     */
    public Day(ArrayList<Event> pListEvent)
    {
        listEvent = pListEvent;
    }

    /**
     * Method getter and setter
     * Author: Danny Xie Li
     * Description: Method getter and setter .
     * Last modification: 22/02/18
     */
    public ArrayList<Event> getListEvent() {
        return listEvent;
    }

    public void setListEvent(ArrayList<Event> listEvent) {
        this.listEvent = listEvent;
    }

    /**
     * Method delete event
     * Author: Danny Xie Li
     * Description: Method delete event from the arraylist.
     * Last modification: 22/02/18
     */
    public void deleteEvent(Event pEvent) {
        for (int counter = 0; counter < listEvent.size(); counter++) {
            Event temporalEvent = listEvent.get(counter);
            if (temporalEvent.getName().equals(pEvent.getName())) {
                listEvent.remove(listEvent.get(counter));
            } else {
                continue;
            }
        }
    }

    /**
     * Method add event
     * Author: Danny Xie Li
     * Description: Method add event from the arraylist.
     * Last modification: 22/02/18
     */
    public void addEvent(Event pEvent) {
        listEvent.add(pEvent);
    }

    /**
     * Method search event
     * Author: Danny Xie Li
     * Description: Method search event from the arraylist and return an event object.
     * Last modification: 22/02/18
     */
    public Event searchEvent(Event pEvent) {
        for (int counter = 0; counter < listEvent.size(); counter++) {
            Event temporalEvent = listEvent.get(counter);
            if (temporalEvent.getName().equals(pEvent.getName())) {
                return temporalEvent;
            } else {
                continue;
            }
        }
        return null;
    }
}