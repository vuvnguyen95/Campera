/**
 * Authors: Adams Keefer, Zach Abdulrahman
 * The purpose of this program is to write various lists of data into their appropriate json
 * files.
 * 
 * Each file utilises two methods in this class:
 *  1. The save*() method creates an instance of the appropriate singleton class.
 *      For example, the saveActivities() method instantiates from Activities.java. the list of
 *      objects is then pulled from that instance. A JSONArray is created and then each index in 
 *      the object list is iterated and the get*JSON() method is called on that object
 *  2. The get*JSON() method passes the adjunct object from the save*() method as its parameter.
 *      Each valuable piece of data from that object is then stored in a map with an identifies as
 *      it's key. That map, in this case a JSONObject is then returned and that object is added
 *      to the JSONArray from the save*() method.
 */

package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    // activites.json
    public static void saveActivities() {
        Activities activities = Activities.getInstance();
        ArrayList<Activity> activityList = activities.getActivities();
        JSONArray jsonActivities = new JSONArray();

        for (int i = 0; i < activityList.size(); i++) {
            jsonActivities.add(getActivitiesJSON(activityList.get(i)));
        }

        try (FileWriter file = new FileWriter(ACTIVITIES_FILE_NAME)) {
            file.write(jsonActivities.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getActivitiesJSON(Activity activity) {
        JSONObject activityDetails = new JSONObject();
        activityDetails.put(ID, activity.getID().toString());
        activityDetails.put(ACTIVITY_TITLE, activity.getName());
        activityDetails.put(DESCRIPTION, activity.getDescription());

        return activityDetails;
    }

    // campers.json
    public static void saveCampers() {
        Campers campers = Campers.getInstance();
        ArrayList<Camper> camperList = campers.getCampers();
        JSONArray jsonCampers = new JSONArray();

        for (int i = 0; i < camperList.size(); i++) {
            jsonCampers.add(getCampersJSON(camperList.get(i)));
        }

        try (FileWriter file = new FileWriter(CAMPERS_FILE_NAME)) {
            file.write(jsonCampers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getCampersJSON(Camper camper) {
        JSONObject camperDetails = new JSONObject();
        camperDetails.put(ID, camper.getID().toString());
        camperDetails.put(BIRTHDATE, camper.getBirthdate());
        camperDetails.put(GENDER, camper.getGender());
        camperDetails.put(FIRST_NAME, camper.getFirstName());
        camperDetails.put(LAST_NAME, camper.getLastName());

        JSONArray contactArray = new JSONArray();

        for(Contact contact : camper.getContacts())
        {
            Map<String, String> contactMap = new LinkedHashMap<String, String>(4);
            contactMap.put(PHONE, contact.getPhone());
            contactMap.put(FIRST_NAME, contact.getFirstName());
            contactMap.put(LAST_NAME, contact.getLastName());
            contactMap.put(ADDRESS, contact.getAddress());
            contactArray.add(contactMap);
        }

        camperDetails.put(CONTACTS, contactArray);

        Map<String, String> docMap = new LinkedHashMap<String, String>(4);
        docMap.put(PHONE, camper.getPediatrician().getPhone());
        docMap.put(FIRST_NAME, camper.getPediatrician().getFirstName());
        docMap.put(LAST_NAME, camper.getPediatrician().getLastName());
        docMap.put(ADDRESS, camper.getPediatrician().getAddress());
        camperDetails.put(DOCTOR, docMap);

        JSONArray allergyArray = new JSONArray();
        for(String allergy : camper.getAllergies())
            allergyArray.add(allergy);
        camperDetails.put(ALLERGIES, allergyArray);

        return camperDetails;
    }

    // counselors.json
    public static void saveCounselors() {
        Counselors counselors = Counselors.getInstance();
        ArrayList<Counselor> counselorList = counselors.getCounselors();
        JSONArray jsonCounselors = new JSONArray();

        for (int i = 0; i < counselorList.size(); i++) {
            jsonCounselors.add(getCounselorsJSON(counselorList.get(i)));
        }

        try (FileWriter file = new FileWriter(COUNSELORS_FILE_NAME)) {
            file.write(jsonCounselors.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getCounselorsJSON(Counselor counselor) {
        JSONObject counselorDetails = new JSONObject();
        counselorDetails.put(USERNAME, counselor.getUsername());
        counselorDetails.put(PASSWORD, counselor.getPassword());
        counselorDetails.put(EMAIL, counselor.getEmail());
        counselorDetails.put(BIOGRAPHY, counselor.getBiography());
        counselorDetails.put(HOMETOWN, counselor.getHometown());
        counselorDetails.put(ID, counselor.getID().toString());
        counselorDetails.put(BIRTHDATE, counselor.getBirthdate());
        counselorDetails.put(FIRST_NAME, counselor.getFirstName());
        counselorDetails.put(LAST_NAME, counselor.getLastName());
        counselorDetails.put(GENDER, counselor.getGender());
        
        JSONArray contactArray = new JSONArray();

        for(Contact contact : counselor.getContacts())
        {
            Map<String, String> contactMap = new LinkedHashMap<String, String>(4);
            contactMap.put(PHONE, contact.getPhone());
            contactMap.put(FIRST_NAME, contact.getFirstName());
            contactMap.put(LAST_NAME, contact.getLastName());
            contactMap.put(ADDRESS, contact.getAddress());
            contactArray.add(contactMap);
        }

        counselorDetails.put(CONTACTS, contactArray);

        Map<String, String> docMap = new LinkedHashMap<String, String>(4);
        docMap.put(PHONE, counselor.getPediatrician().getPhone());
        docMap.put(FIRST_NAME, counselor.getPediatrician().getFirstName());
        docMap.put(LAST_NAME, counselor.getPediatrician().getLastName());
        docMap.put(ADDRESS, counselor.getPediatrician().getAddress());
        counselorDetails.put(DOCTOR, docMap);

        return counselorDetails;
    }

    // camps.json
    public static void saveCamps() {
        Camps camps = Camps.getInstance();
        ArrayList<Camp> campList = camps.getCamps();
        JSONArray jsonCamps = new JSONArray();

        for (int i = 0; i < campList.size(); i++) {
            jsonCamps.add(getCampsJSON(campList.get(i)));
        }

        try (FileWriter file = new FileWriter(CAMPS_FILE_NAME)) {
            file.write(jsonCamps.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static JSONObject getCampsJSON(Camp camp) {
        JSONObject campDetails = new JSONObject();
        campDetails.put(ID, camp.getID().toString());
        campDetails.put(START_DATE, camp.getStartDate());
        campDetails.put(END_DATE, camp.getEndDate());
        campDetails.put(DIRECTOR_ID, camp.getDirector().getID().toString());
        campDetails.put(THEME, camp.getTheme());
        campDetails.put(DESCRIPTION, camp.getDescription());

        JSONArray cabinArray = new JSONArray();
        for(Cabin cabin : camp.getCabins())
            cabinArray.add(cabin.getID().toString());
        campDetails.put(CABIN_IDS, cabinArray);

        JSONArray camperArray = new JSONArray();
        for(Camper camper : camp.getCampers())
            camperArray.add(camper.getID().toString());
        campDetails.put(CAMPER_IDS, camperArray);

        JSONArray counselorArray = new JSONArray();
        for(Counselor counselor : camp.getCounselors())
            counselorArray.add(counselor.getID().toString());
        campDetails.put(COUNSELOR_IDS, counselorArray);

        return campDetails; 
    }

    // Cabins.json
    public static void saveCabins() {
        Cabins cabins = Cabins.getInstance();
        ArrayList<Cabin> cabinList = cabins.getCabins();
        JSONArray jsonCabins = new JSONArray();

        for (int i = 0; i < cabinList.size(); i++) {
            jsonCabins.add(getCabinsJSON(cabinList.get(i)));
        }

        try (FileWriter file = new FileWriter(CABINS_FILE_NAME)) {
            file.write(jsonCabins.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getCabinsJSON(Cabin cabin) {
        JSONObject cabinDetails = new JSONObject();
        cabinDetails.put(ID, cabin.getID().toString());
        cabinDetails.put(CABIN_NAME, cabin.getName());
        cabinDetails.put(CABIN_BEDS, cabin.getBeds());

        JSONArray camperArray = new JSONArray();
        for(Camper camper : cabin.getCampers())
            camperArray.add(camper.getID().toString());
        cabinDetails.put(CAMPER_IDS, camperArray);

        JSONArray counselorArray = new JSONArray();
        for(Counselor counselor : cabin.getCounselors())
            counselorArray.add(counselor.getID().toString());
        cabinDetails.put(COUNSELOR_IDS, counselorArray);

        return cabinDetails;
    }


    // Registrations.json
    public static void saveRegistrations() {
        Registrations registrations = Registrations.getInstance();
        ArrayList<Registration> registrationList = registrations.getRegistrations();
        JSONArray jsonRegistrations = new JSONArray();

        for (int i = 0; i < registrationList.size(); i++) {
            jsonRegistrations.add(getRegistrationsJSON(registrationList.get(i)));
        }

        try (FileWriter file = new FileWriter(REGISTRATION_FILE_NAME)) {
            file.write(jsonRegistrations.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getRegistrationsJSON(Registration registration) {
        JSONObject registrationDetails = new JSONObject();
        registrationDetails.put(ID, registration.getID().toString());
        registrationDetails.put(CAMPER_ID, registration.getCamperID());
        registrationDetails.put(CAMP_ID, registration.getCampID());
        registrationDetails.put(PRICE, registration.getPrice());
        return registrationDetails;
    }

    //guardians.json
    public static void saveGuardians()
    {
        Guardians guardians = Guardians.getInstance();
        ArrayList<Guardian> guardianList = guardians.getGuardians();
        JSONArray jsonGuardians = new JSONArray();

        for(int i = 0; i < guardianList.size(); i++)
        {
            jsonGuardians.add(getGuardiansJSON(guardianList.get(i)));
        }

        try (FileWriter file = new FileWriter(GUARDIANS_FILE_NAME))
        {
            file.write(jsonGuardians.toJSONString());
            file.flush();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static JSONObject getGuardiansJSON(Guardian guardian)
    {
        JSONObject guardianDetails = new JSONObject();
        guardianDetails.put(ID, guardian.getID().toString());
        guardianDetails.put(USERNAME, guardian.getUsername());
        guardianDetails.put(PASSWORD, guardian.getPassword());
        guardianDetails.put(EMAIL, guardian.getEmail());
        guardianDetails.put(FIRST_NAME, guardian.getFirstName());
        guardianDetails.put(LAST_NAME, guardian.getLastName());

        JSONArray registrationArray = new JSONArray();
        for(Registration registration : guardian.getRegistrations())
            registrationArray.add(registration.getID().toString());
        guardianDetails.put(REGISTRATION_ID, registrationArray);

        return guardianDetails;
    }

    //directors.json
    public static void saveDirectors()
    {
        Directors directors = Directors.getInstance();
        ArrayList<Director> directorList = directors.getDirectors();
        JSONArray jsonDirectors = new JSONArray();

        for(int i = 0; i < directorList.size(); i++)
        {
            jsonDirectors.add(getDirectorsJSON(directorList.get(i)));
        }

        try (FileWriter file = new FileWriter(DIRECTOR_FILE_NAME))
        {
            file.write(jsonDirectors.toJSONString());
            file.flush();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static JSONObject getDirectorsJSON(Director director)
    {
        JSONObject directorDetails = new JSONObject();
        directorDetails.put(ID, director.getID().toString());
        directorDetails.put(USERNAME, director.getUsername());
        directorDetails.put(PASSWORD, director.getPassword());
        directorDetails.put(EMAIL, director.getEmail());
        directorDetails.put(FIRST_NAME, director.getFirstName());
        directorDetails.put(LAST_NAME, director.getLastName());
        directorDetails.put(BIOGRAPHY, director.getBiography());

        return directorDetails;
    }

    //schedules.json
    public static void saveSchedules()
    {
        Schedules schedules = Schedules.getInstance();
        ArrayList<Schedule> scheduleList = schedules.getSchedules();
        JSONArray jsonSchedules = new JSONArray();

        for(int i = 0; i < scheduleList.size(); i++)
        {
            jsonSchedules.add(getSchedulesJSON(scheduleList.get(i)));
        }

        try (FileWriter file = new FileWriter(SCHEDULES_FILE_NAME))
        {
            file.write(jsonSchedules.toJSONString());
            file.flush();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static JSONObject getSchedulesJSON(Schedule schedule)
    {
        JSONObject scheduleDetails = new JSONObject();
        scheduleDetails.put(ID, schedule.getID().toString());
        scheduleDetails.put(CABIN_ID, schedule.getCabin().getID());
        scheduleDetails.put(DAY, schedule.getDay());

        Map activityMap = new LinkedHashMap(4);
        activityMap.put("9:00", schedule.getActivities().get(0).getID().toString());
        activityMap.put("11:00", schedule.getActivities().get(1).getID().toString());
        activityMap.put("2:00", schedule.getActivities().get(2).getID().toString());
        activityMap.put("4:00", schedule.getActivities().get(3).getID().toString());
        scheduleDetails.put(ACTIVITIES, activityMap);
        
        return scheduleDetails;
    }

}