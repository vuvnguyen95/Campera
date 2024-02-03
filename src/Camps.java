package src;

import java.util.ArrayList;
import java.util.UUID;

public class Camps {
    
    private static Camps camps;
    private static ArrayList<Camp> campList = new ArrayList<>();

    private Camps()
    {
        campList = DataLoader.loadCamps();
    }

    public static Camps getInstance()
    {
        if(camps == null)
            camps = new Camps();
        
        return camps;
    }

    /**
     * Getter method for the list of camps
     * @return the list of camps
     */
    public ArrayList<Camp> getCamps()
    {
        return campList;
    }

    
    /** 
     * Identifies camp based on when it starts and ends
     * @param start
     * @param end
     * @return boolean
     */
    public boolean haveCamp(String start, String end)
    {
        for(Camp camp : campList)
        {
            if(camp.getStartDate().equals(start) && camp.getEndDate().equals(end))
                return true;
        }
        return false;
    }
    /** 
     * Adds the given camp to campList
     * @param camp
     * @return boolean
     */
    public boolean addCamp(Camp camp)
    {
        if(haveCamp(camp.getStartDate(), camp.getEndDate()))
            return false;
        campList.add(camp);
        save();
        return true;
    }
    /**
     * Saves camp to dataWriter
     */
    public void save()
    {
        DataWriter.saveCamps();
    }

    /**
     * searches the camp list for the camp that matches the id
     * @param camps
     * @param id
     * @return the matching camp
     */
    public static Camp getByID(UUID id)
    {
        for(Camp camp : campList)
        {
            if(camp.getID() == id)
                return camp;
        }
        return null;
    }

    public Camp findByTheme(String theme)
    {
        for(Camp camp : campList)
        {
            if(camp.getTheme().equalsIgnoreCase(theme))
                return camp;
        }
        return null;
    }
}
