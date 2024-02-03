package src;

import java.util.ArrayList;
import java.util.UUID;

public class Schedule {
    
    private UUID id;
    protected ArrayList<Activity> activities = new ArrayList<>();
    protected String day;
    protected Cabin cabin;

    public Schedule(ArrayList<Activity> activities, String day, Cabin cabin)
    {
        this.id = UUID.randomUUID();
        this.activities = activities;
        this.day = day;
        this.cabin = cabin;
    }
    
    /**
     * Schedule Constructor with UUID
     * @param id
     * @param activities
     * @param day
     * @param cabin
     */

    public Schedule(UUID id, ArrayList<Activity> activities, String day, Cabin cabin)
    {
        this.id = id;
        this.activities = activities;
        this.day = day;
        this.cabin = cabin;
    }

    /**
     * Getter method for id
     * @return id
     */
    public UUID getID()
    {
        return this.id;
    }

    /**
     * Getter method for schedule activities
     * @return activity list
     */
    public ArrayList<Activity> getActivities()
    {
        return this.activities;
    }

    /**
     * Getter method for schedule day
     * @return day
     */
    public String getDay()
    {
        return this.day;
    }

    /**
     * getter method for schedule cabin
     * @return cabin
     */
    public Cabin getCabin()
    {
        return this.cabin;
    }

    /**
     * Formats the schedule data into a string
     */
    public String toString()
    {
        String s = getDay() + "\n" + "8:00\t Breakfast\n9:00\t" + getActivities().get(0).toString() + "\n11:00\t" +
            getActivities().get(1).toString() + "\n1:00\t Lunch\n2:00\t" + getActivities().get(2).toString() +
            "\n4:00\t" + getActivities().get(3).toString() + "\n6:00\tDinner\n8:00\tCampwide Night Activity\n10:00\tLights Out";
        return s;  
    }
}
