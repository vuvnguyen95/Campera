package src;

import java.util.ArrayList;
import java.util.UUID;

public class Guardian extends User{

    protected UUID id;
    protected ArrayList<Registration> registrations = new ArrayList<>();

    public Guardian(String username, String password, String email, String firstName, String lastName)
    {
        super(username, password, email, firstName, lastName, 2);
        this.id = UUID.randomUUID();
    }
    
    /**
     * Guardian Constructor with UUID
     * @param id
     * @param username
     * @param password
     * @param email
     * @param firstName
     * @param lastName
     */

    public Guardian(UUID id, String username, String password, String email, String firstName, String lastName)
    {
        super(username, password, email, firstName, lastName, 2);
        this.id = id;
    }

    /** 
     * Add Registration Method
     * @param registration
     */

    public void addRegistration(Registration registration)
    {
        registrations.add(registration);
    }

    /**
     * returns the userType attribute
     */
    public int getUserType() {
        return this.userType;
    }

    /**
     * Getter method for the id
     * @return the id
     */
    public UUID getID()
    {
        return this.id;
    }

    /**
     * Searches through the guardian's registrations and returns
     * the camper from the camperID attribute. NOTE: this method will
     * only return unique campers to make for cleaner UI.
     * @return
     */
    public ArrayList<Camper> getCampers()
    {
        Campers campers = Campers.getInstance();
        ArrayList<Camper> camperList = new ArrayList<Camper>();
        for(Registration reg : getRegistrations())
        {
            UUID camperID = reg.getCamperID();
            Camper camper = campers.findByID(camperID);
            if(camperList.contains(camper))
                continue;
            else
                camperList.add(camper);
        }
        return camperList;
    }

    /**
     * Getter method for the registrations
     * @return the list of registrations
     */
    public ArrayList<Registration> getRegistrations()
    {
        return this.registrations;
    }
}