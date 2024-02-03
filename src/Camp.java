package src;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * NOTE: The Camp class refers to each Camp session. One session equals one Camp object
 */
public class Camp {

    public ArrayList<Cabin> cabins = new ArrayList<>();
    public ArrayList<Camper> campers = new ArrayList<>();
    public ArrayList<Counselor> counselors = new ArrayList<>();
    public Director director;
    public String startDate;
    public String endDate;
    public String theme;
    private UUID id;
    public String description;

    public Camp(ArrayList<Cabin> cabins, Director director, String startDate, String endDate, String theme, String description)
    {
        this.id = UUID.randomUUID();
        this.cabins = cabins;
        this.director = director;
        this.startDate = startDate;
        this.endDate = endDate;
        this.theme = theme;
        this.description = description;
    }

    public Camp(UUID id, ArrayList<Cabin> cabins, Director director, String startDate, String endDate, String theme, String description)
    {
        this.id = id;
        this.cabins = cabins;
        this.director = director;
        this.startDate = startDate;
        this.endDate = endDate;
        this.theme = theme;
        this.description = description;
    }

    
    /** 
     * gets UUID for director
     * @return UUID
     */
    public UUID getID()
    {
        return this.id;
    }

    
     /** 
     * Gets number of cabins from stored cabin array list
     * @return ArrayList<Cabin>
     */
    public ArrayList<Cabin> getCabins()
    {
        return this.cabins;
    }

    /**
     * Getter method for the campers in the camp
     * @return the list of campers registered
     */
    public ArrayList<Camper> getCampers()
    {
        return this.campers;
    }

    /**
     * Getter method for the counselors in the camp
     * @return the list of counselors working
     */
    public ArrayList<Counselor> getCounselors()
    {
        return this.counselors;
    }

    /**
     * Setter method for cabins attribute
     * @param cabins
     */
    public void setCabins(ArrayList<Cabin> cabins)
    {
        this.cabins = cabins;
    }

    /**
     * Setter method for campers attribute
     * @param campers
     */
    public void setCampers(ArrayList<Camper> campers)
    {
        this.campers = campers;
    }

    public void createCabins()
    {
        ArrayList<Cabin> cabins = new ArrayList<Cabin>();
        int index = 1;
        for(int i = 7; i < 18; i += 2)
        {
            Cabin cabin = new Cabin(getTheme() + " Cabin " + index, 20);
            cabin.setAges(i, i + 1);
            cabins.add(cabin);
            index++;
        }
        setCabins(cabins);
    }

    /**
     * Setter method for the counselors attribute
     * @param counselors
     */
    public void setCounselors(ArrayList<Counselor> counselors)
    {
        this.counselors = counselors;
    }

    /** 
     * Grabs director which allows specific permissions
     * @return Director
     */
    public Director getDirector()
    {
        return this.director;
    }

    
    /** 
     * Determines start date for camp
     * @return String
     */
    public String getStartDate()
    {
        return this.startDate;
    }

    
    /** 
     * determines end date for camp
     * @return String
     */
    public String getEndDate()
    {
        return this.endDate;
    }

    /**
     * Getter method for the description of the camp
     */
    public String getDescription()
    {
        return this.description;
    }

    /** 
     * Outputs theme and description of camp
     * @return String
     */
    public String toString(){
        String s = getStartDate() + " - " + getEndDate() + "\n";
        s = s + getTheme() + "\n";
        s = s + getDescription() + "\n";
        return s;
    }

    /**
     * Getter method for the theme of the camp session
     */
    public String getTheme()
    {
        return this.theme;
    }

    /**
     * using the start and end date, this method parses those strings
     * and turns them into Date objects. The method then returns an inclusive list of all
     * the dates in the range.
     * @return list of dates
     */
    public ArrayList<String> getDates()
    {
        ArrayList<String> days = new ArrayList<String>();
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date start = sdf.parse(getStartDate());
            Date end = sdf.parse(getEndDate());
            
            ArrayList<Date> dates = new ArrayList<Date>();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(start);

            while(calendar.getTime().before(end))
            {
                Date day = calendar.getTime();
                dates.add(day);
                calendar.add(Calendar.DATE, 1);
            }

            for(Date date : dates)
                days.add(sdf.format(date));

            return days;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Method generates schedules for each cabin in the camp
     */
    public void generateSchedules()
    {
        Schedules schedules = Schedules.getInstance();
        Activities activities = Activities.getInstance();
        ArrayList<Cabin> cabins = getCabins();

        for(String day : getDates())
            schedules.generateSchedule(cabins, activities.getActivities(), day);
    }

    /**
     * Adds the camper to the camper list
     * @param camper
     */
    public void addCamper(Camper camper)
    {
        this.campers.add(camper);
    }

    /**
     * Adds the counselor to the counselor list.
     * @param counselor
     */
    public void addCounselor(Counselor counselor)
    {
        this.counselors.add(counselor);
    }
}
