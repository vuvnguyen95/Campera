package src;

import java.util.ArrayList;
import java.util.Collections;

public class Schedules {
    private static Schedules schedules;
    private static ArrayList<Schedule> scheduleList = new ArrayList<>();

    private Schedules()
    {
        scheduleList = DataLoader.loadSchedules();
    }

    public static Schedules getInstance()
    {
        if(schedules == null)
            schedules = new Schedules();
        
        return schedules;
    }

    public ArrayList<Schedule> getSchedules()
    {
        return scheduleList;
    }

    public void save()
    {
      DataWriter.saveSchedules();  
    }

    public void addSchedule(Schedule schedule)
    {
        scheduleList.add(schedule);
    }

    /**
     * Generate Schedules Method
     * Randomly Generates Schedules based on cabin and activites
     * Cannot have same cabin doing same activity
     * Uses an arraylist for activities and shuffle function to ensure no repeats
     * @param cabins
     * @param activities
     * @param day
     */
    public void generateSchedule(ArrayList<Cabin> cabins, ArrayList<Activity> activities, String date){
        ArrayList<Activity> activitiesTemp = activities;
        ArrayList<Activity> cabinActList = new ArrayList<>();
        Collections.shuffle(activitiesTemp);
            for(Cabin cabin : cabins){
                for(int i = 0; i<5;i++){
                    cabinActList.add(activitiesTemp.get(i));
                }
                activitiesTemp.add(0, activitiesTemp.get(activitiesTemp.size()-1));
                activitiesTemp.remove(activitiesTemp.size()-1);
                Schedule schedule = new Schedule(cabinActList, date, cabin);
                addSchedule(schedule);
                cabin.addSchedule(schedule);
            }
            save();
    }
/**
    public void generateSchedules(ArrayList<Cabin> cabins, ArrayList<Activity> activities, String day)
    {
        boolean valid = false;
        while(!valid)
        {
            ArrayList<Activity> actList1 = activities;
            ArrayList<Activity> actList2 = activities;
            ArrayList<Activity> actList3 = activities;
            ArrayList<Activity> actList4 = activities;

            for(Cabin cabin : cabins)
            {
                ArrayList<Activity> temp = new ArrayList<Activity>();

                Collections.shuffle(actList1);
                temp.add(actList1.get(0));
                actList1.remove(0);

                Collections.shuffle(actList2);
                temp.add(actList2.get(0));
                actList2.remove(0);

                Collections.shuffle(actList3);
                temp.add(actList3.get(0));
                actList3.remove(0);

                Collections.shuffle(actList4);
                temp.add(actList4.get(0));
                actList4.remove(0);

                Schedule schedule = new Schedule(temp, day, cabin);
                cabin.addSchedule(schedule);
                addSchedule(schedule);
            }
        }
        save();
    }*/


    

}


