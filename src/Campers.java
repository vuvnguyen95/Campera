package src;

import java.util.ArrayList;
import java.util.UUID;

public class Campers {

    private static Campers campers;
    private static ArrayList<Camper> camperList = new ArrayList<>();

    private Campers()
    {
        camperList = DataLoader.loadCampers();
    }

    public static Campers getInstance()
    {
        if(campers == null)
            campers = new Campers();

        return campers;
    }

    /**
     * Getter method for the list of campers in the system
     * @return the campers from the json
     */
    public ArrayList<Camper> getCampers()
    {
        return camperList;
    }

    /**
     * have Camper method identifies a camper based on first/last name and birthdate
     * @param firstName
     * @param lastName
     * @param birthdate
     * @return boolean
     */
    public boolean haveCamper(String firstName, String lastName, String birthdate)
    {
        for(Camper camper : camperList)
        {
            if(camper.getFirstName().equals(firstName) && camper.getLastName().equals(lastName) && camper.getBirthdate().equals(birthdate))
                return true;
        }
        return false;
    }


    /**
     * Adds the given camper to camperList
     * @param camper
     * @return boolean
     */
    public boolean addCamper(Camper camper)
    {
        if(haveCamper(camper.getFirstName(), camper.getLastName(), camper.getBirthdate()))
            return false;
        camperList.add(camper);
        save();
        return true;
    }

    /**
     * Works through the list of campers and returns
     * the camper with the matching ID.
     * @param id
     * @return
     */
    public static Camper findByID(UUID id)
    {
        for(Camper camper : camperList)
        {
            if(camper.getID() == id)
                return camper;
        }
        return null;
    }

    /**
     * saves the list of campers to the json file
     */
    public void save()
    {
        DataWriter.saveCampers();
    }
}
