package src;

import java.util.ArrayList;
import java.util.UUID;

public class Registrations {
    private static Registrations registrations;
    private static ArrayList<Registration> registrationList = new ArrayList<>();

    private Registrations()
    {
        registrationList = DataLoader.loadRegistrations();    
    }

    public static Registrations getInstance()
    {
        if(registrations == null)
            registrations = new Registrations();
        
        return registrations;
    }
    
    /** 
     * Get Registrations Method
     * Grabs registration from entry
     * @return ArrayList<Registration>
     */

    public ArrayList<Registration> getRegistrations()
    {
        return registrationList;
    }

    /** 
     * Add Registration method
     * Add registration to registration List stored in dataloader
     * @param registration
     */
    public void addRegistration(Registration registration)
    {
        registrationList.add(registration);
        save();
    }

    public void save()
    {
        DataWriter.saveRegistrations();
    }

    /**
     * Uses the same logic as the other singleton classes
     * @param id
     * @return the found registration
     */
    public static Registration findByID(UUID id)
    {
        for(Registration registration : registrationList)
        {
            if(registration.getID() == id)
                return registration;
        }
        return null;
    }
}
