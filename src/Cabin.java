package src;

import java.util.ArrayList;
import java.util.UUID;

public class Cabin {
    
    /**
     * Cabin Class stores campers, counselors in array list
     * Base constructors, second constructor also has user id as a param
     * @param campers
     * @param counselors
     * @param name
     * @param beds
     * @param id
     */
    public ArrayList<Camper> campers = new ArrayList<Camper>();
    public ArrayList<Counselor> counselors = new ArrayList<Counselor>();
    public ArrayList<Schedule> schedules = new ArrayList<Schedule>();
    public String name;
    public int beds;
    public int minAge;
    public int maxAge;
    private UUID id;

    public Cabin(String name, int beds) 
    {
        this.name = name;
        this.beds = beds;
        this.id = UUID.randomUUID();
    }

    public Cabin(UUID id, String name, int beds)
    {
        this.id = id;
        this.name = name;
        this.beds = beds;
    }

    /**
     * Getter method for the ID attribute
     * @return id
     */
    public UUID getID()
    {
        return this.id;
    }

    /**
     * Getter method for the name attribute
     * @return name
     */
    public String getName()
    {
        return this.name;
    }

    
    /** 
     * Get number of beds for each cabin 
     * @return int
     */
    public int getBeds()
    {
        return this.beds;
    }

    /**
     * Getter method for max age in the cabin
     * @return age
     */
    public int getMaxAge()
    {
        return this.maxAge;
    }

    /**
     * Getter method for min age in the cabin
     * @return age
     */
    public int getMinAge()
    {
        return this.minAge;
    }

    /**
     * Setter method for age boundaries in the cabin
     * @param min
     * @param max
     */
    public void setAges(int min, int max)
    {
        this.minAge = min;
        this.maxAge = max;
    }

    /** 
     * Gets campers from stored array list for cabin 
     * this is cabin specific
     * @return ArrayList<Camper>
     */
    public ArrayList<Camper> getCampers()
    {
        return this.campers;
    }

    
    /** 
     * gets counselors from stored array list for cabin 
     * cabin specific (dynamic)
     * @return ArrayList<Counselor>
     */
    public ArrayList<Counselor> getCounselors()
    {
        return this.counselors;
    }
    
    /**
     * Getter method for the schedules the cabin has
     * @return the list of schedules
     */
    public ArrayList<Schedule> getSchedules()
    {
        return this.schedules;
    }

    /**
     * Setter method for the counselor list in a cabin
     * @param counselors
     */
    public void setCounselors(ArrayList<Counselor> counselors)
    {
        this.counselors = counselors;
    }

    /**
     * Setter method for the campers in a cabin
     * @param campers
     */
    public void setCampers(ArrayList<Camper> campers)
    {
        this.campers = campers;
    }

    /**
     * Adds the camper to the existing camper list
     * @param camper
     */
    public void addCamper(Camper camper)
    {
        this.campers.add(camper);
    }

    /**
     * adds the counselor to the existing counselor list
     * @param counselor
     */
    public void addCounselor(Counselor counselor)
    {
        this.counselors.add(counselor);
    }

    /**
     * adds the schedule to the existing schedule list
     * @param schedule
     */
    public void addSchedule(Schedule schedule)
    {
        this.schedules.add(schedule);
    }

    /**
     * returns a detailed report of critical camper data
     * such as allergies and contacts
     * @return
     */
    public String getCamperData()
    {
        String data = "";
        for(Camper camper : getCampers())
            data = data + camper.getInfo() + "\n  \n";
        return data;
    }

    /**
     * returns a list of counslelors and campers in the cabin
     */
    public String toString()
    {
        String s = getName() + "\n" + "Counselors:" + "\n";
        for(Counselor counselor : getCounselors())
            s = s + counselor.toString() + "\n";
        s = s + "Campers:" + "\n";
        for(Camper camper : getCampers())
            s = s + camper.getName() + "\t" + camper.getAge() + "\n";
        return s;
    }

    /**
     * returns the cabin's schedule
     */
    public String schedulesString()
    {
        String schedules = "";
        for(Schedule schedule : getSchedules())
            schedules = schedules + schedule.toString() + "\n \n";
        return schedules;
    }
}
