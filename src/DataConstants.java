package src;

public abstract class DataConstants {
    
    /**
     * JSON Data Constants
     */
    
     //for activities.json
    protected static final String ACTIVITIES_FILE_NAME = "src/json/activities.json";
    protected static final String ACTIVITY_TITLE = "title";
    protected static final String DESCRIPTION = "description";

    //for cabins.json
    protected static final String CABINS_FILE_NAME = "src/json/cabins.json";
    protected static final String CABIN_NAME = "name";
    protected static final String CAMPER_IDS = "camperIDS";
    protected static final String COUNSELOR_IDS = "counselorIDS";
    protected static final String SCHEDULE_IDS = "scheduleIDS";
    protected static final String CABIN_BEDS = "beds";

    //for campers.json
    protected static final String CAMPERS_FILE_NAME = "src/json/campers.json";
    protected static final String BIRTHDATE = "birthdate";
    protected static final String GENDER = "gender";
    protected static final String FIRST_NAME = "firstName";
    protected static final String LAST_NAME = "lastName";
    protected static final String GUARDIAN_ID = "guardianID";
    protected static final String REGISTRATION_ID = "registrationID";
    protected static final String ALLERGIES = "allergies";
    protected static final String CONTACTS = "contacts";
    protected static final String PHONE = "phone";
    protected static final String ADDRESS = "address";
    protected static final String DOCTOR = "doctor";
    
    //for camps.json
    protected static final String CAMPS_FILE_NAME = "src/json/camps.json";
    protected static final String DIRECTOR_ID = "directorID";
    protected static final String START_DATE = "startDate";
    protected static final String END_DATE = "endDate";
    protected static final String CABIN_IDS = "cabinIDS";
    protected static final String THEME = "theme";

    //for counselors.json
    protected static final String COUNSELORS_FILE_NAME = "src/json/counselors.json";
    protected static final String BIOGRAPHY = "biography";
    protected static final String HOMETOWN = "hometown";

    //for schedules.json
    protected static final String CABIN_ID = "cabinID";
    protected static final String DAY = "day";
    protected static final String TIME = "time";

    //for registrations.json
    protected static final String REGISTRATION_FILE_NAME = "src/json/registrations.json";
    protected static final String CAMPER_ID = "camperID";
    protected static final String CAMP_ID = "campID";
    protected static final String PRICE = "price";

    //for the user json files and other general constants
    protected static final String ID = "id";
    protected static final String USER_ID = "userID";
    protected static final String USERNAME = "username";
    protected static final String PASSWORD = "password";
    protected static final String EMAIL = "email";
    protected static final String USER_TYPE = "userType";
    protected static final String REGISTRATIONS = "registrations";
    protected static final String GUARDIANS_FILE_NAME = "src/json/guardians.json";
    protected static final String DIRECTOR_FILE_NAME = "src/json/directors.json";
    protected static final String ACTIVITIES = "activities";
    protected static final String SCHEDULES_FILE_NAME = "src/json/schedules.json";
}
