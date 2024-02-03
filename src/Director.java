package src;

import java.util.ArrayList;
import java.util.UUID;

public class Director extends User{

    public String biography;
    public UUID id;
    
    public Director(String username, String password, String email, String firstName, String lastName, String biography)
    {
        super(username, password, email, firstName, lastName, 1);
        this.biography = biography;
        this.id = UUID.randomUUID();
    }
   
    /**
     * Director Constructor
     * UUID added for JSON
     * @param id
     * @param username
     * @param password
     * @param email
     * @param firstName
     * @param lastName
     * @param biography
     */

    public Director(UUID id, String username, String password, String email, String firstName, String lastName, String biography)
    {
        super(username, password, email, firstName, lastName, 1);
        this.biography = biography;
        this.id = id;
    }
    
    /**
     * Get ID method
     * Determines type of user- director in this case
     * @return
     */

    public UUID getID()
    {
        return this.id;
    }

    public String toString()
    {
        return getFirstName() + " " + getLastName();
    }

    /**
     * Getter method for the Director's biography
     * @return the biography
     */
    public String getBiography()
    {
        return this.biography;
    }
    
    public void editSchedule() {
    }

    /** 
     * Director has access to edit cabin
     * @param cabin
     */
    
     public void editCabin(Cabin cabin) {
        
    }

    /** 
     * Director has access to view camp as well
     * @param camp
     * @return String
     */

    public String viewCamp(Camp camp) {
        return "Camp Info: " + camp; 
    }
}