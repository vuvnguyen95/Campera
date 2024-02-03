package src;

import java.util.ArrayList;
import java.util.UUID;

public class Cabins {
    private static Cabins cabins;
    private static ArrayList<Cabin> cabinList = new ArrayList<>();

    private Cabins()
    {
        cabinList = DataLoader.loadCabins();
    }


    /**
     * getInstance method
     * creates new cabin
     * @return Cabins
     */
    public static Cabins getInstance()
    {
        if(cabins == null)
            cabins = new Cabins();
        return cabins;
    }


    /**
     * Gets number of cabins from stored cabin array list
     * @return ArrayList<Cabin>
     */
    public ArrayList<Cabin> getCabins()
    {
        return cabinList;
    }


    /**
     * have cabin method identifies if a cabins name = the instance
     * @param cabinName
     * @return boolean
     */
    public boolean haveCabin(String cabinName)
    {
        for(Cabin cabin : cabinList)
        {
            if(cabin.getName().equals(cabinName))
                return true;
        }
        return false;
    }

    /**
     * creates a cabin in the instance there is not one
     * @param cabin
     * @return boolean
     */
    public boolean addCabin(Cabin cabin)
    {
        if(haveCabin(cabin.getName()))
            return false;
        cabinList.add(cabin);
        save();
        return true;
    }

    /**
     * saves the current cabin list to the json file
     */
    public void save()
    {
        DataWriter.saveCabins();
    }

    /**
     * Using the id parameter, searches the cabin list
     * and returns the cabin with the matching id
     * @param id
     * @return the found cabin
     */
    public static Cabin findByID(UUID id)
    {
        for(Cabin cabin : cabinList)
        {
            if(cabin.getID() == id)
                return cabin;
        }
        return null;
    }

    /**
     * searches the cabin list for the appropriate age group
     * and adds the camper to that cabin.
     * @param camper
     * @param cabins
     */
    public void addCamper(Camper camper, ArrayList<Cabin> cabins)
    {
        for(Cabin cabin : cabins)
        {
            if(camper.getAge() == cabin.getMinAge() || camper.getAge() == cabin.getMaxAge())
                cabin.addCamper(camper);
        }
    }

    public Cabin findByName(String name)
    {
        for(Cabin cabin : cabinList)
        {
            if(cabin.getName().equalsIgnoreCase(name))
                return cabin;
        }
        return null;
    }
}
