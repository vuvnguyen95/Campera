package src;

import java.util.ArrayList;
import java.util.UUID;

public class Counselors {
    
    private static Counselors counselors;
    private static ArrayList<Counselor> counselorList = new ArrayList<>();

    private Counselors()
    {
        counselorList = DataLoader.loadCounselors();
    }

    /** 
     * get instance method creates a counselor variable 
     * @return Counselors
     */
    public static Counselors getInstance()
    {
        if(counselors == null)
            counselors = new Counselors();
        return counselors;
    }

    
    /** 
     * grabs set counselor from arraylist
     * @return ArrayList<Counselor>
     */
    public ArrayList<Counselor> getCounselors()
    {
        return counselorList;
    }

    
    /** 
     * identifies counselor based on username
     * @param username
     * @return boolean
     */
    public boolean haveCounselor(String username)
    {
        for(Counselor counselor : counselorList)
        {
            if(counselor.getUsername().equals(username))
                return true;
        }
        return false;
    }

    /**
     * Passes a username and password. Searches the counselor list for that
     * username and checks if the password parameter matches the expected value
     * @param username
     * @param password
     * @return the boolean for if the passwords match
     */
    public boolean checkPassword(String username, String password)
    {
        Counselor counselor = findByUser(username);
        return counselor.getPassword().equals(password);
    }

    /**
     * searches the counselor list for the passed id
     * @param id
     * @return the found counselor
     */
    public static Counselor findByID(UUID id)
    {
        for(Counselor counselor : counselorList)
        {
            if(counselor.getID() == id)
                return counselor;
        }
        return null;
    }
    
    /** 
     * adds counselor to counselorList
     * @param counselor
     * @return boolean
     */
    public boolean addCounselor(Counselor counselor)
    {
        if(haveCounselor(counselor.getUsername()))
            return false;
        counselorList.add(counselor);
        save();
        return true;
    }

    /**
     * searches the counselor list for the passed user
     * @param username
     * @return the found counselor
     */
    public static Counselor findByUser(String username)
    {
        for(Counselor counselor : counselorList)
        {
            if(counselor.getUsername().equals(username))
                return counselor;
        }
        return null;
    }
    public boolean boolFindByUser(String username)
    {
        for(Counselor counselor : counselorList)
        {
            if(counselor.getUsername().equals(username))
                return true;
        }
        return false;
    }

    /**
     * saves the counselor list to a json file
     */
    public void save()
    {
        DataWriter.saveCounselors();
    }

    /**
     * searches a passed counselor list for the id.
     * Similar to the findByID method above, however this would be the used if
     * we wanted to find a counselor in a smaller list, making the process faster
     * @param counselors
     * @param id
     * @return the found counselor
     */
    public static Counselor findByID(ArrayList<Counselor> counselors, UUID id)
    {
        for(Counselor counselor : counselors)
        {
            if(counselor.getID() == id)
                return counselor;
        }
        return null;
    }

}
