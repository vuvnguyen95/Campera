package src;

import java.util.ArrayList;

public class User {
    
    protected String username; 
    protected String password; 
    protected String email; 
    protected String firstName;
    protected String lastName; 
    protected int userType;

    /**
     * User Constructor 
     * @param username
     * @param password
     * @param email
     * @param firstName
     * @param lastName
     * @param userType
     */

    public User(String username, String password, String email, String firstName, String lastName, int userType) {
        this.username = username; 
        this.password = password; 
        this.email = email; 
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }

    /**
     * Getter method for username
     * @return username
     */
    public String getUsername()
    {
        return this.username;
    }

    /**
     * Getter method for password
     * @return password
     */
    public String getPassword()
    {
        return this.password;
    }

    /**
     * getter method for email
     * @return email
     */
    public String getEmail()
    {
        return this.email;
    }

    /**
     * getter method for first name
     * @return first name
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * getter method for last name
     * @return last name
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * getter method for user type
     * @return user type
     */
    public int getUserType()
    {
        return this.userType;
    }

    /**
     * getter method for name
     * @return name
     */
    public String getName()
    {
        return getFirstName() + " " + getLastName();
    }
}
