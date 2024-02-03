package src;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;

public class Camper {

    private UUID id;
    public String birthdate;
    public String gender;
    public String firstName;
    public String lastName;
    protected String address;
    protected ArrayList<String> allergies = new ArrayList<String>();
    protected ArrayList<Contact> contacts = new ArrayList<Contact>();
    protected Contact pediatrician;
    public String notes;

    public Camper(String birthdate, String gender, String firstName, String lastName, String address, 
        ArrayList<String> allergies, ArrayList<Contact> contacts, Contact pediatrician) {
        this.birthdate = birthdate;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.allergies = allergies;
        this.contacts = contacts;
        this.pediatrician = pediatrician;
        this.id = UUID.randomUUID(); 
    }

    /**
     * Added UUID as a param for JSON object
     * @param id
     * @param birthdate
     * @param gender
     * @param firstName
     * @param lastName
     * @param address
     * @param guardian
     * @param allergies
     * @param contact
     * @param pediatrician
     */
    public Camper(UUID id, String birthdate, String gender, String firstName, String lastName, String address,
                    ArrayList<String> allergies, ArrayList<Contact> contacts, Contact pediatrician)
    {
        this.id = id;
        this.birthdate = birthdate;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.allergies = allergies;
        this.contacts = contacts;
        this.pediatrician = pediatrician;
        this.id = UUID.randomUUID();
    }

    
    /** 
     * Grabs First name from input
     * @return String
     */
    public String getFirstName() {
        return this.firstName; 
    }

    
    /** 
     * Grabs Last name from input
     * @return String
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * Getter method for the camper id
     * @return the camper's id
     */
    public UUID getID()
    {
        return this.id;
    }

    /**
     * Getter method for the camper's birthdate
     * @return the camper's birthdate
     */
    public String getBirthdate()
    {
        return this.birthdate;
    }

    /**
     * Getter method for the Gender of the camper
     * @return the camper's gender
     */
    public String getGender()
    {
        return this.gender;
    }

    /**
     * Getter method for the address of the camper
     * @return the camper's address
     */
    public String getAddress()
    {
        return this.address;
    }

    
    /** 
     * Allergies are stored in an array list
     * Can be viewed based on location of getAllergies method
     * @return ArrayList<String>
     */
    public ArrayList<String> getAllergies()
    {
        return this.allergies;
    }

    
    /** 
     * Gets contact info and stores in contact 
     * @return Contact
     */
    public ArrayList<Contact> getContacts()
    {
        return this.contacts;
    }

    
    /** 
     * Gets pediatrician contact information from input 
     * @return Contact
     */
    public Contact getPediatrician()
    {
        return this.pediatrician;
    }

    /**
     * Getter method for camper notes
     * @return the camper's notes
     */
    public String getNotes()
    {
        return this.notes;
    }

    
    /** 
     * Works the same for all set name methods
     * Sets inputted first name to stored name variable from getName method.
     * @param name
     */
    public void setFirstName(String name) {
        this.firstName = name; 
    }

    public void setLastName(String name){
        this.lastName = name;
    }

    /**
     * Setter method for the camper notes
     * using the string parameter
     * @param notes
     */
    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    /**
     * Blends the getFirstName() and getLastName()
     * methods to return the campers full name
     * @return
     */
    public String getName()
    {
        return getFirstName() + " " + getLastName();
    }

    /**
     * The camper's birthdate is converted to a date object
     * and then the age is returned.
     * @return
     */
    public int getAge()
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date birth = sdf.parse(getBirthdate());
            LocalDate birthday = new java.sql.Date(birth.getTime()).toLocalDate();
            LocalDate currentDate = LocalDate.now();
            return Period.between(birthday, currentDate).getYears();
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Returns a detailed view of the camper's important health info
     * including allergies and contacts
     * @return
     */
    public String getInfo()
    {
        String info = "Name\t" + getName() + "\n";
        info = info + "DOB\t" + getBirthdate() + "\n" + "Allergies:" + "\n";
        for(String allergy : getAllergies())
            info = info + allergy + ", ";
        info = info + "\n" + "Contacts:" + "\n";
        for(Contact contact : getContacts())
            info = info + contact.toString() + "\n";
        info = info + "Medical Notes:" + "\n" + getNotes();
        return info;
    }

}


