package src;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

 /**
     * The Data Loader class is used to insert, update, delete, and export large amounts of data
     * based on inputs and requirments for Campera
     * @return
     */
public class DataLoader extends DataConstants{
   
    
     /** 
     * Load Activities method 
     * JSON Parser reads and writes  while the JSON Array stores entires/data
     * for loop: JSONObject, id, title, and description 
     * add activites called here
     * @return ArrayList<Activity>
     */
   
    public static ArrayList<Activity> loadActivities()
    {
        ArrayList<Activity> activities = new ArrayList<Activity>();

        try
        {
            FileReader reader = new FileReader(ACTIVITIES_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray activitiesJSON = (JSONArray)parser.parse(reader);

            if(activitiesJSON != null)
            {
                for(int i = 0; i < activitiesJSON.size(); i++)
                {
                    JSONObject activityJSON = (JSONObject)activitiesJSON.get(i);
                    UUID id = UUID.fromString((String)activityJSON.get(ID));
                    String title = (String)activityJSON.get(ACTIVITY_TITLE);
                    String description = (String)activityJSON.get(DESCRIPTION);

                    activities.add(new Activity(id, title, description));
                }
            }
            return activities;
        } catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    
    /** 
     * Load Cabins Method
     * JSON Parser reads and writes while the JSON Array stores entires/data
     * loops through cabins for store specific params
     * @return ArrayList<Cabin>
     */
    //TODO FIX
    public static ArrayList<Cabin> loadCabins()
    {
        ArrayList<Cabin> cabins = new ArrayList<Cabin>();
        
        try
        {
            FileReader reader = new FileReader(CABINS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray cabinsJSON = (JSONArray)parser.parse(reader);
            
            if(cabinsJSON != null)
            {
                for(int i = 0; i < cabinsJSON.size(); i++)
                {
                    JSONObject cabinJSON = (JSONObject)cabinsJSON.get(i);
                    UUID id = UUID.fromString((String)cabinJSON.get(ID));
                    String name = (String)cabinJSON.get(CABIN_NAME);
                    long beds = (long)cabinJSON.get(CABIN_BEDS);

                    JSONArray camperArray = (JSONArray)cabinJSON.get(CAMPER_IDS);
                    ArrayList<Camper> camperList = new ArrayList<Camper>();
                    if(camperArray != null)
                    {
                        ArrayList<UUID> camperIDS = new ArrayList<UUID>();
                        Campers campers = Campers.getInstance();
                        for(int j = 0; i < camperArray.size(); j++)
                            camperIDS.add(UUID.fromString((String)camperArray.get(j)));
                        for(UUID camperID : camperIDS)
                            camperList.add(campers.findByID(camperID));
                    }
                    
                    JSONArray counselorArray = (JSONArray)cabinJSON.get(COUNSELOR_IDS);
                    ArrayList<Counselor> counselorList = new ArrayList<Counselor>();
                    if(counselorArray != null)
                    {
                        ArrayList<UUID> counselorIDS = new ArrayList<UUID>();
                        Counselors counselors = Counselors.getInstance();
                        for(int j = 0; i < camperArray.size(); j++)
                            counselorIDS.add(UUID.fromString((String)counselorArray.get(j)));
                        for(UUID counselorID : counselorIDS)
                            counselorList.add(counselors.findByID(counselorID));
                    }
                    
                    Cabin cabin = new Cabin(id, name, (int)beds);
                    cabin.setCampers(camperList);
                    cabin.setCounselors(counselorList);
                    cabins.add(cabin);
                }
            }

            return cabins;
        } catch(Exception e)
        { 
            e.printStackTrace();
        }
        return null;
    }


    public static ArrayList<Schedule> loadSchedules() {

        ArrayList<Schedule> schedules = new ArrayList<Schedule>();
        Cabins cabins = Cabins.getInstance();
        Activities activities = Activities.getInstance();

        try {
            FileReader reader = new FileReader(SCHEDULES_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray schedulesJSON = (JSONArray)new JSONParser().parse(reader);

            if(schedulesJSON != null)
            {
                for(int i = 0; i < schedulesJSON.size(); i++) {
                    JSONObject scheduleJSON = (JSONObject)schedulesJSON.get(i);
                    UUID id = UUID.fromString((String)scheduleJSON.get(ID));
                    String day = (String)scheduleJSON.get(DAY);
                    UUID cabinID = UUID.fromString((String)scheduleJSON.get(CABIN_ID));

                    Cabin cabin = cabins.findByID(cabinID);

                    Map actMap = ((Map)scheduleJSON.get(ACTIVITIES));
                    Iterator<Map.Entry> actITR = actMap.entrySet().iterator();
                    ArrayList<UUID> activityIDS = new ArrayList<UUID>();
                    ArrayList<Activity> activityList = new ArrayList<Activity>();
                    while(actITR.hasNext())
                    {
                        Map.Entry pair = actITR.next();
                        activityIDS.add(UUID.fromString((String)pair.getValue()));
                    }

                    for(UUID actID : activityIDS)
                        activityList.add(activities.findByID(actID));
                    
                    schedules.add(new Schedule(id, activityList, day, cabin));
                }
            }

            return schedules;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    // Counselors
    
    /** 
     * Load Counselors method
     * Loops thorugh JSON Object to write and store all params specific to counselor
     * counselor.add function made here
     * @return ArrayList<Counselor>
     */
  
    public static ArrayList<Counselor> loadCounselors() {
        ArrayList<Counselor> counselors = new ArrayList<Counselor>();

        try {
            FileReader reader = new FileReader(COUNSELORS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray counselorsJSON = (JSONArray)parser.parse(reader);

            if(counselorsJSON != null)
            {
                for (int i = 0; i < counselorsJSON.size(); i++) {
                    JSONObject counselorJSON = (JSONObject)counselorsJSON.get(i);
                    String username = (String)counselorJSON.get(USERNAME);
                    String password = (String)counselorJSON.get(PASSWORD);
                    String email = (String)counselorJSON.get(EMAIL);
                    String biography = (String)counselorJSON.get(BIOGRAPHY);
                    String hometown = (String)counselorJSON.get(HOMETOWN);
                    String firstName = (String)counselorJSON.get(FIRST_NAME);
                    String lastName = (String)counselorJSON.get(LAST_NAME);
                    String gender = (String)counselorJSON.get(GENDER);
                    UUID id = UUID.fromString((String)counselorJSON.get(ID));
                    String birthdate = (String)counselorJSON.get(BIRTHDATE);
                    
                    Map docMap = ((Map)counselorJSON.get(DOCTOR));
                    Contact doctor = new Contact((String)docMap.get(PHONE), (String)docMap.get(FIRST_NAME), (String)docMap.get(LAST_NAME), (String)docMap.get(ADDRESS));

                    ArrayList<Contact> contacts = new ArrayList<Contact>();
                    JSONArray contactArray = (JSONArray)counselorJSON.get(CONTACTS);
                    if(contactArray != null)
                    {
                        for(int j = 0; j < contactArray.size(); j++)
                        {
                            JSONObject contactJSON = (JSONObject)contactArray.get(i);
                            Contact contact = new Contact((String)contactJSON.get(PHONE), (String)contactJSON.get(FIRST_NAME), (String)contactJSON.get(LAST_NAME), (String)contactJSON.get(ADDRESS));
                            contacts.add(contact);
                        }
                    }
                    counselors.add(new Counselor(id, username, password, email, firstName, lastName, biography, birthdate, hometown, gender, contacts, doctor));
                }
            }
            return counselors;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    
    /** 
     * Load Camps Method
     * includes director and cabin arraylist
     * Writes and loads start/end date and director by ID
     * @return ArrayList<Camp>
     */
   
    public static ArrayList<Camp> loadCamps() {
        ArrayList<Camp> camps = new ArrayList<Camp>();
        Directors directors = Directors.getInstance();
        Cabins cabins = Cabins.getInstance();
        Campers campers = Campers.getInstance();
        Counselors counselors = Counselors.getInstance();

        try {
            FileReader reader = new FileReader(CAMPS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray campsJSON = (JSONArray)parser.parse(reader);

            if(campsJSON != null)
            {
                for (int i = 0; i < campsJSON.size(); i++) {
                    JSONObject campJSON = (JSONObject)campsJSON.get(i);

                    UUID id = UUID.fromString((String)campJSON.get(ID));
                    UUID directorID = UUID.fromString((String)campJSON.get(DIRECTOR_ID));
                    Director director = directors.findByID(directorID);
                    String startDate = (String)campJSON.get(START_DATE);
                    String endDate = (String)campJSON.get(END_DATE);
                    String theme = (String)campJSON.get(THEME);
                    String description = (String)campJSON.get(DESCRIPTION);

                    JSONArray cabinArray = (JSONArray)campJSON.get(CABIN_ID);
                    ArrayList<Cabin> cabinList = new ArrayList<Cabin>();
                    if(cabinArray != null)
                    {
                        ArrayList<UUID> cabinIDS = new ArrayList<UUID>();
                        for(int j = 0; j < cabinArray.size(); j++)
                            cabinIDS.add(UUID.fromString((String)cabinArray.get(j)));
                        for(UUID cabinID : cabinIDS)
                            cabinList.add(cabins.findByID(cabinID));
                    }
                    
                    JSONArray camperArray = (JSONArray)campJSON.get(CAMPER_IDS);
                    ArrayList<Camper> camperList = new ArrayList<Camper>();
                    if(camperArray != null)
                    {
                        ArrayList<UUID> camperIDS = new ArrayList<UUID>();
                        for(int k = 0; k < camperArray.size(); k++)
                            camperIDS.add(UUID.fromString((String)camperArray.get(k)));
                        for(UUID camperID : camperIDS)
                            camperList.add(campers.findByID(camperID));
                    }
                    
                    JSONArray counselorArray = (JSONArray)campJSON.get(COUNSELOR_IDS);
                    ArrayList<Counselor> counselorList = new ArrayList<Counselor>();
                    if(counselorArray != null)
                    {
                        ArrayList<UUID> counselorIDS = new ArrayList<UUID>();
                        for(int l = 0; l < counselorArray.size(); l++)
                            counselorIDS.add(UUID.fromString((String)counselorArray.get(l)));
                        for(UUID counselorID : counselorIDS)
                            counselorList.add(counselors.findByID(counselorID));
                    }
                    
                    Camp camp = new Camp(id, cabinList, director, startDate, endDate, theme, description);
                    camp.setCounselors(counselorList);
                    camp.setCampers(camperList);
                    camps.add(camp);
                }
            }
            return camps;
        }
        catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }

    /** 
     * Load Registrations Method
     * Parse and store id, camperid, and campid with price of camp
     * registrations.add function made here
     * @return ArrayList<Registration>
     */

    public static ArrayList<Registration> loadRegistrations()
    {
        ArrayList<Registration> registrations = new ArrayList<Registration>();

        try
        {
            FileReader reader = new FileReader(REGISTRATION_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray registrationsJSON = (JSONArray)parser.parse(reader);

            if(registrationsJSON != null)
            {
                for(int i = 0; i < registrationsJSON.size(); i++)
                {
                    JSONObject registrationJSON = (JSONObject)registrationsJSON.get(i);
                    UUID id = UUID.fromString((String)registrationJSON.get(ID));
                    UUID camperID = UUID.fromString((String)registrationJSON.get(CAMPER_ID));
                    UUID campID = UUID.fromString((String)registrationJSON.get(CAMP_ID));
                    double price = (double)registrationJSON.get(PRICE);

                    registrations.add(new Registration(id, campID, camperID, price));
                }
            }
            return registrations;
        } catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }


    /** 
     * Load Guardians Method
     * Writes and stores all params regarding guardians
     * This is how the signup for the camp exists
     * guardians.add fucntion created
     * @return ArrayList<Guardian>
     */
    public static ArrayList<Guardian> loadGuardians()
    {
        ArrayList<Guardian> guardians = new ArrayList<Guardian>();
        Registrations registrations = Registrations.getInstance();

        try
        {
            FileReader reader = new FileReader(GUARDIANS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray guardiansJSON = (JSONArray)parser.parse(reader);

            if(guardiansJSON != null)
            {
                for(int i = 0; i < guardiansJSON.size(); i++)
                {
                    JSONObject guardianJSON = (JSONObject)guardiansJSON.get(i);
                    UUID id = UUID.fromString((String)guardianJSON.get(ID));
                    String username = (String)guardianJSON.get(USERNAME);
                    String password = (String)guardianJSON.get(PASSWORD);
                    String email = (String)guardianJSON.get(EMAIL);
                    String firstName = (String)guardianJSON.get(FIRST_NAME);
                    String lastName = (String)guardianJSON.get(LAST_NAME);
                    Guardian guardian = new Guardian(id, username, password, email, firstName, lastName);

                    JSONArray registrationArray = (JSONArray)guardianJSON.get(REGISTRATIONS);
                    ArrayList<UUID> registrationIDS = new ArrayList<UUID>();
                    ArrayList<Registration> registrationList = new ArrayList<Registration>();
                    if(registrationArray != null)
                    {
                        for(int j = 0; j < registrationArray.size(); j++)
                            registrationIDS.add(UUID.fromString((String)registrationArray.get(i)));
                        for(UUID regID : registrationIDS)
                            registrationList.add(registrations.findByID(regID));
                        for(Registration reg : registrationList)
                            guardian.addRegistration(reg);
                    }
                    guardians.add(guardian);
                }
            return guardians;
            } 
        } catch (Exception e)   {
            e.printStackTrace();
        }
        return null;
    }

    
    /** 
     * Load Directors Method
     * Writes and stores director params (similar to guardians)
     * directors.add created
     * @return ArrayList<Director>
     */

    public static ArrayList<Director> loadDirectors()
    {
        ArrayList<Director> directors = new ArrayList<Director>();

        try
        {
            FileReader reader = new FileReader(DIRECTOR_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray directorsJSON = (JSONArray)parser.parse(reader);
            if(directorsJSON != null)
            {
                for(int i = 0; i < directorsJSON.size(); i++)
                {
                    JSONObject directorJSON = (JSONObject)directorsJSON.get(i);
                    UUID id = UUID.fromString((String)directorJSON.get(ID));
                    String username = (String)directorJSON.get(USERNAME);
                    String password = (String)directorJSON.get(PASSWORD);
                    String email = (String)directorJSON.get(EMAIL);
                    String firstName = (String)directorJSON.get(FIRST_NAME);
                    String lastName = (String)directorJSON.get(LAST_NAME);
                    String biography = (String)directorJSON.get(BIOGRAPHY);
                    directors.add(new Director(id, username, password, email, firstName, lastName, biography));
                }
            }
            return directors;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    
    /** 
     * Load Campers Method
     * Stores and creates id, name, gender, age, and address of campers
     * @return ArrayList<Camper>
     */
    
    public static ArrayList<Camper> loadCampers()
    {
        ArrayList<Camper> campers = new ArrayList<Camper>();

        try
        {
            FileReader reader = new FileReader(CAMPERS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray campersJSON = (JSONArray)parser.parse(reader);
            if(campersJSON != null)
            {
                for(int i = 0; i < campersJSON.size(); i++)
                {
                    JSONObject camperJSON = (JSONObject)campersJSON.get(i);
                    UUID id = UUID.fromString((String)camperJSON.get(ID));
                    String firstName = (String)camperJSON.get(FIRST_NAME);
                    String lastName = (String)camperJSON.get(LAST_NAME);
                    String gender = (String)camperJSON.get(GENDER);
                    String birthdate = (String)camperJSON.get(BIRTHDATE);
                    String address = (String)camperJSON.get(ADDRESS);

                    JSONArray allergies = (JSONArray)camperJSON.get(ALLERGIES);
                    ArrayList<String> allergyList = new ArrayList<String>();
                    if(allergies != null)
                    {
                        for(int k = 0 ; k < allergies.size(); k++)
                            allergyList.add((String)allergies.get(k));
                    }                
                    Map docMap = ((Map)camperJSON.get(DOCTOR));
                    Contact doctor = new Contact((String)docMap.get(PHONE), (String)docMap.get(FIRST_NAME), (String)docMap.get(LAST_NAME), (String)docMap.get(ADDRESS));

                    ArrayList<Contact> contacts = new ArrayList<Contact>();
                    JSONArray contactArray = (JSONArray)camperJSON.get(CONTACTS);
                    if(contactArray != null)
                    {
                        for(int j = 0; j < contactArray.size(); j++)
                        {
                            JSONObject contactJSON = (JSONObject)contactArray.get(i);
                            Contact contact = new Contact((String)contactJSON.get(PHONE), (String)contactJSON.get(FIRST_NAME), (String)contactJSON.get(LAST_NAME), (String)contactJSON.get(ADDRESS));
                            contacts.add(contact);
                        }
                    }                        
                    campers.add(new Camper(id, birthdate, gender, firstName, lastName, address, allergyList, contacts, doctor));
                }
            }
            return campers;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}