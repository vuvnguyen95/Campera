package src;

import java.util.ArrayList;
import java.util.UUID;

public class Counselor extends User{
    private UUID id;
    public String biography;
    public String birthdate;
    public String hometown;
    public String gender;
    protected ArrayList<Contact> contacts = new ArrayList<Contact>();
    protected Contact pediatrician;

    public Counselor(String username, String password, String email, String firstName, String lastName, String biography, String birthdate, String hometown, 
    String gender, ArrayList<Contact> contacts, Contact pediatrician) {
        super(username, password, email, firstName, lastName, 3);
        this.id = UUID.randomUUID();
        this.biography = biography; 
        this.birthdate = birthdate; 
        this.hometown = hometown; 
        this.gender = gender; 
        this.contacts = contacts; 
        this.pediatrician = pediatrician; 
    }
    /**
     * Added UUID as param for JSON
     * @param id
     * @param username
     * @param password
     * @param email
     * @param firstName
     * @param lastName
     * @param biography
     * @param birthdate
     * @param hometown
     * @param gender
     * @param contacts
     * @param pediatrician
     */
    public Counselor(UUID id, String username, String password, String email, String firstName, String lastName, String biography, String birthdate,
            String hometown, String gender, ArrayList<Contact> contacts, Contact pediatrician)
    {
        super(username, password, email, firstName, lastName, 3);
        this.id = id;
        this.biography = biography;
        this.birthdate = birthdate;
        this.hometown = hometown;
        this.gender = gender;
        this.contacts = contacts;
        this.pediatrician = pediatrician;
    }

    
    /** 
     * gets UUID 
     * @return UUID
     */
    public UUID getID() 
    {
        return this.id;
    }

    
    /** 
     * gets biography of counselors
     * @return String
     */
    public String getBiography() 
    {
        return this.biography;
    }

    
    /** 
     * gets birthdate and sets to birthdate variable
     * @return String
     */
    public String getBirthdate()
    {
        return this.birthdate;
    }

    
    /** 
     * Gets hometown of campers and counselors
     * @return String
     */
    public String getHometown()
    {
        return this.hometown;
    }

    
    /** 
     * Gets gender 
     * @return String
     */
    public String getGender()
    {
        return this.gender;
    }

    
    /** 
     * Gets contact from stored array list
     * @return ArrayList<Contact>
     */
    public ArrayList<Contact> getContacts()
    {
        return this.contacts;
    }

    
    /** 
     * gets pediatrician contact 
     * @return Contact
     */
    public Contact getPediatrician()
    {
        return this.pediatrician;
    }

    
    /** 
     * Gets the user type to set certain counselor permissions
     * @return int
     */
    public int getUserType()
    {
        return this.userType;
    }

    /**
     * Getter method for the name of the counselor
     */
    public String getName()
    {
        return getFirstName() + " " + getLastName();
    }

    /**
     * passes a list of cabins and searches for the cabin the counselor is in
     * once that cabin is found, it's schedule is saved to a .txt file
     * @param cabins
     */
    public void printSchedule(ArrayList<Cabin> cabins)
    {
        Writer writer = new Writer();
        for(Cabin cabin : cabins)
        {
            if(cabin.getCounselors().contains(this))
            {
                writer.writeToFile(cabin.getName() + "_schedules", cabin.schedulesString());
                break;
            }
        }
    }

    /**
     * Similar to the method above, except the method saves
     * the cabin's roster to a .txt file
     * @param cabins
     */
    public void printCabinOverview(ArrayList<Cabin> cabins)
    {
        Writer writer = new Writer();
        for(Cabin cabin : cabins)
        {
            if(cabin.getCounselors().contains(this))
            {
                writer.writeToFile(cabin.getName() + "_roster", cabin.toString());
                break;
            }
        }
    }

    /**
     * Similar to the above two methods, except the method 
     * saves the important data of each camper in the cabin to a
     * .txt file
     * @param cabins
     */
    public void printCamperReport(ArrayList<Cabin> cabins)
    {
        Writer writer = new Writer();
        for(Cabin cabin : cabins)
        {
            if(cabin.getCounselors().contains(this))
            {
                writer.writeToFile(cabin.getName() + "_report", cabin.getCamperData());
                break;
            }
        }
    }
}