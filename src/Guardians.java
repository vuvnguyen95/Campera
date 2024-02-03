package src;

import java.util.ArrayList;
import java.util.UUID;

public class Guardians {
    
    private static Guardians guardians;
    private static ArrayList<Guardian> guardianList = new ArrayList<>();

    private Guardians()
    {
        guardianList = DataLoader.loadGuardians();
    }

    public static Guardians getInstance()
    {
        if(guardians == null)
            guardians = new Guardians();
        return guardians;
    }

    /**
     * Getter method for the guardian list
     * @return the list of guardians
     */
    public ArrayList<Guardian> getGuardians()
    {
        return guardianList;
    }

    /**
     * Uses the same logic as the checkPassword() method in the
     * other singleton classes.
     * @param username
     * @param password
     * @return
     */
    public boolean checkPassword(String username, String password)
    {
        Guardian guardian = findByUser(username);
        return guardian.getPassword().equals(password);
    }

    /** 
     * Have Guardian Method
     * Identifies valid Guardian based on entry
     * @param username
     * @return boolean
     */
    public boolean haveGuardian(String username)
    {
        for(Guardian guardian : guardianList)
        {
            if(guardian.getUsername().equals(username))
                return true;
        }
        return false;
    }
    
    /** 
     * Add Guardian Method
     * Adds given guardian if valid
     * @param guardian
     * @return boolean
     */

    public boolean addGuardian(Guardian guardian) {
        if(haveGuardian(guardian.getUsername()))
            return false;
        guardianList.add(guardian);
        save();
        return true;
    }

    /**
     * writes the guardian list to the appropriate json file
     */
    public void save()
    {
        DataWriter.saveGuardians();
    }

    /**
     * Uses same logic as other singleton classes
     * @param username
     * @return found Guardian
     */
    public static Guardian findByUser(String username)
    {
        for(Guardian guardian : guardianList)
        {
            if(guardian.getUsername().equals(username))
                return guardian;
        }
        return null;
    }

    public boolean boolFindByUser(String username)
    {
        for(Guardian guardian : guardianList)
        {
            if(guardian.getUsername().equals(username))
                return true;
        }
        return false;
    }
}
