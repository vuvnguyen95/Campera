package src;

public class Contact {
    private String phone;
    private String firstName;
    private String lastName;
    private String address;

    public Contact(String phone, String firstName, String lastName, String address) {
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    /**
     * Getter method for phone attribute
     * @return phone number
     */
    public String getPhone()
    {
        return this.phone;
    }

    
    /** 
     * Gets first name
     * @return String
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    
    /** 
     * Gets last name
     * @return String
     */
    public String getLastName()
    {
        return this.lastName;
    }

    
    /** 
     * Gets address 
     * @return String
     */
    public String getAddress()
    {
        return this.address;
    }

    /**
     * returns the contact's info
     */
    public String toString()
    {
        return getFirstName() + " " + getLastName() + "\n" + getPhone() + "\n" + getAddress();
    }
}
