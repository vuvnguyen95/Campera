package src;

import java.util.ArrayList;
import java.util.UUID;

public class Directors {
    private static Directors directors;
    private static ArrayList<Director> directorList;

    private Directors()
    {
        directorList = DataLoader.loadDirectors();
    }

    public static Directors getInstance()
    {
        if(directors == null)
            directors = new Directors();
        
        return directors;
    }

    public void save(){
        DataWriter.saveDirectors();
    }

    /**
     * Getter method for the list of Directors
     * @return the list of Directors
     */
    public ArrayList<Director> getDirectors()
    {
        return directorList;
    }

    /**
     * Passes a username and password. Searches the directorList for the
     * director with the matching username. Then compares the passed password
     * with the expected password
     * @param username
     * @param password
     * @return true if the password's match
     */
    public boolean checkPassword(String username, String password)
    {
        Director director = findByUser(username);
        return director.getPassword().equals(password);
    }

    /** 
     * Have Director Method
     * Checks to identify director is desired user
     * @param firstName
     * @param lastName
     * @return boolean
     */
    public boolean haveDirector(String firstName, String lastName)
    {
        for(Director director : directorList)
        {
            if(director.getFirstName().equalsIgnoreCase(firstName) && director.getLastName().equalsIgnoreCase(lastName))
                return true;
        }
        return false;
    }

    /** 
     * Add Director Method
     * if have director is true, then adds to directorList
     * @param director
     * @return boolean
     */

    public boolean addDirector(Director director)
    {
        if(haveDirector(director.getFirstName(), director.getLastName()))
            return false;
        directorList.add(director);
        save();
        return true;
    }

    /** 
     * Find by ID Method
     * searches director arraylist by Id and returns director usertype if valid uuid
     * @param directors
     * @param id
     * @return Director
     */
    public static Director findByID(UUID id)
    {
        for(Director director : directorList)
        {
            if(director.getID() == id)
                return director;
        }
        return null;
    }

    /**
     * Searches the directorList for the director with the matching username
     * @param username
     * @return the found director
     */
    public static Director findByUser(String username)
    {
        for(Director director : directorList)
        {
            if(director.getUsername().equals(username))
                return director;
        }
        return null;
    }

    public boolean boolFindByUser(String username){
        for(Director director : directorList)
        {
            if(director.getUsername().equals(username))
                return true;
        }
        return false;
    }
}