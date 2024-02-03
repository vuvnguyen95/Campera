package src;

import java.util.ArrayList;
import java.util.UUID;

public class Activities {
    private static Activities activities;


    private static ArrayList<Activity> activityList = new ArrayList<>();


    private Activities() {
        activityList = DataLoader.loadActivities();
    }

    /**
    * Store Activities in ArrayList
    * @return activities
    */
    public static Activities getInstance() {
        if(activities == null)
            activities = new Activities();

        return activities;
    }

    /**
     * Get Activities Method
     * @return ArrayList<Activity>
     */
    public ArrayList<Activity> getActivities()
    {
        return activityList;
    }

    /**
     * Searches through the activity list and check if the name of each activity matches
     * the parameter
     * @param activityName
     * @return return the boolean value of wheter the name exists or not
     */
    public boolean haveActivity(String activityName)
    {
        for(Activity activity : activityList)
        {
            if(activity.getName().equals(activityName))
                return true;
        }
        return false;
    }


    /**
     * Add Activity Method
     * @param activity
     * @return boolean
     */
    public boolean addActivity(Activity activity)
    {
        if(haveActivity(activity.getName()))
            return false;
        activityList.add(activity);
        save();
        return true;
    }
    /**
     * runs the method in the DataWriter class.
     */
    public void save()
    {
        DataWriter.saveActivities();
    }

    /**
     * takes the parameter and searches through the
     * acitvity list and returns the activity with
     * that id
     * @param id
     * @return the found Activity
     */
    public static Activity findByID(UUID id)
    {
        for(Activity activity : activityList)
        {
            if(activity.getID() == id)
                return activity;
        }
        return null;
    }
}
