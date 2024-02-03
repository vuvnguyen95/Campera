package src;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLoaderTest {
    private Activities activities = Activities.getInstance();
    private ArrayList<Activity> activityList = activities.getActivities();

    private Cabins cabins = Cabins.getInstance();
    private ArrayList<Cabin> cabinList = cabins.getCabins();

    private Campers campers = Campers.getInstance();
    private ArrayList<Camper> camperList = campers.getCampers();

    private Camps camps = Camps.getInstance();
    private ArrayList<Camp> campList = camps.getCamps();

    private Counselors counselors = Counselors.getInstance();
    private ArrayList<Counselor> counselorList = counselors.getCounselors();

    private Directors directors = Directors.getInstance();
    private ArrayList<Director> directorList = directors.getDirectors();

    private Guardians guardians = Guardians.getInstance();
    private ArrayList<Guardian> guardianList = guardians.getGuardians();

    private Registrations registrations = Registrations.getInstance();
    private ArrayList<Registration> registrationList = registrations.getRegistrations();

    private Schedules schedules = Schedules.getInstance();
    private ArrayList<Schedule> scheduleList = schedules.getSchedules();

    @BeforeEach
    public void setup()
    {
        Director director1 = new Director("direct1", "dpass", "email", "first", "last", "bio");
        Director director2 = new Director("direct2", "pass", "email", "first", "last", "bio");
        
        activityList.clear();
        activityList.add(new Activity("gaga ball", "beat the other cabins"));
        activityList.add(new Activity("basketball", "a good game of horse"));
        DataWriter.saveActivities();

        cabinList.clear();
        cabinList.add(new Cabin("Christmas Cabin 1", 12));
        cabinList.add(new Cabin("Cowboy Cabin 1", 10));
        DataWriter.saveCabins();

        ArrayList<Cabin> campCabinList = new ArrayList<Cabin>();
        Camp camp1 = new Camp(campCabinList, director1, "01/20/2022", "01/27/2022", "Christmas", "happy holidays");
        camp1.createCabins();

        ArrayList<Cabin> camp2CabinList = new ArrayList<Cabin>();
        Camp camp2 = new Camp(camp2CabinList, director2, "07/10/2016", "07/17/2016", "Sports", "our athletic week");
        camp2.createCabins();

        Guardian guardian = new Guardian("guardian1", "pass", "email", "first", "last");
        Guardian guardian2 = new Guardian("guardian2", "pass2", "email2", "first2", "last2");

        Contact doctor = new Contact("1234", "first", "last", "address");

        ArrayList<Contact> contacts = new ArrayList<Contact>();
        ArrayList<String> allergies = new ArrayList<String>();
        contacts.add(new Contact("1234", "kim", "keefer", "address"));
        contacts.add(new Contact("12345", "robbie", "keefer", "address"));
        allergies.add("peanuts");
        allergies.add("soy");

        Camper camper1 = new Camper("07/08/2003", "male", "adams", "keefer", "address", allergies, contacts, doctor);
        Camper camper2 = new Camper("03/25/2005", "female", "victoria", "keefer", "address", allergies, contacts, doctor);

        Counselor counselor1 = new Counselor("user", "pass", "email", "mark", "johnson", "bio", "02/14/2007", "greenville", "male", contacts, doctor);
        Counselor counselor2 = new Counselor("user2", "pass2", "email2", "tiffany", "marks", "bio", "01/25/1999", "birmingham", "female", contacts, doctor);

        camp1.addCamper(camper1);
        camp2.addCamper(camper2);
        camp1.addCounselor(counselor1);
        camp2.addCounselor(counselor2);

        registrationList.clear();
        Registration registration = new Registration(camp1.getID(), camper1.getID(), 234.56);
        Registration registration2 = new Registration(camp2.getID(), camper2.getID(), 124.42);
        guardian.addRegistration(registration);
        guardian2.addRegistration(registration2);
        registrationList.add(registration);
        registrationList.add(registration2);
        DataWriter.saveRegistrations();

        campList.clear();
        campList.add(camp1);
        campList.add(camp2);
        DataWriter.saveCamps();

        camperList.clear();
        camperList.add(camper1);
        camperList.add(camper2);
        DataWriter.saveCampers();

        guardianList.clear();
        guardianList.add(guardian);
        guardianList.add(guardian2);
        DataWriter.saveGuardians();

        directorList.clear();
        directorList.add(director1);
        directorList.add(director2);
        DataWriter.saveDirectors();

        counselorList.clear();
        counselorList.add(counselor1);
        counselorList.add(counselor2);
        DataWriter.saveCounselors();
    }

    @AfterEach
    public void tearDown()
    {
        Activities.getInstance().getActivities().clear();
        DataWriter.saveActivities();

        Cabins.getInstance().getCabins().clear();
        DataWriter.saveCabins();

        Campers.getInstance().getCampers().clear();
        DataWriter.saveCampers();

        Camps.getInstance().getCamps().clear();
        DataWriter.saveCamps();

        Counselors.getInstance().getCounselors().clear();
        DataWriter.saveCounselors();

        Directors.getInstance().getDirectors().clear();
        DataWriter.saveDirectors();

        Guardians.getInstance().getGuardians().clear();
        DataWriter.saveGuardians();

        Registrations.getInstance().getRegistrations().clear();
        DataWriter.saveRegistrations();
    }

    @Test
    public void testGetActivitiesSize()
    {
        activityList = DataLoader.loadActivities();
        assertEquals(2, activityList.size());
    }

    @Test
    public void testGetActivitiesSizeZero()
    {
        Activities.getInstance().getActivities().clear();
        DataWriter.saveActivities();
        assertEquals(0, activityList.size());
    }

    @Test
    public void testGetActivityName()
    {
        activityList = DataLoader.loadActivities();
        assertEquals("gaga ball", activityList.get(0).getName());
    }

    @Test
    public void testGetCabinsSize()
    {
        cabinList = DataLoader.loadCabins();
        assertEquals(2, cabinList.size());
    }

    @Test
    public void testGetCabinsSizeZero()
    {
        Cabins.getInstance().getCabins().clear();
        DataWriter.saveCabins();
        assertEquals(0, cabinList.size());
    }

    @Test
    public void testGetCabinName()
    {
        cabinList = DataLoader.loadCabins();
        assertEquals("Christmas Cabin 1", cabinList.get(0).getName());
    }

    @Test
    public void testGetCamperSize()
    {
        camperList = DataLoader.loadCampers();
        assertEquals(2, camperList.size());
    }

    @Test
    public void testGetCamperSizeZero()
    {
        Campers.getInstance().getCampers().clear();
        DataWriter.saveCampers();
        assertEquals(0, camperList.size());
    }

    @Test
    public void testGetCamperName()
    {
        camperList = DataLoader.loadCampers();
        assertEquals("adams keefer", camperList.get(0).getName());
    }

    @Test
    public void testGetAllergies()
    {
        camperList = DataLoader.loadCampers();
        assertTrue(camperList.get(0).getAllergies().contains("peanuts"));
    }

    @Test
    public void testGetDoctor()
    {
        camperList = DataLoader.loadCampers();
        assertEquals("first", camperList.get(0).getPediatrician().getFirstName());
    }

    @Test
    public void testGetCampSize()
    {
        campList = DataLoader.loadCamps();
        assertEquals(2, campList.size());
    }

    @Test
    public void testGetCampSizeZero()
    {
        Camps.getInstance().getCamps().clear();
        DataWriter.saveCamps();
        assertEquals(0, campList.size());
    }

    @Test
    public void testGetCampTheme()
    {
        campList = DataLoader.loadCamps();
        assertEquals("Christmas", campList.get(0).getTheme());
    }

    @Test
    public void testGetCampDescription()
    {
        campList = DataLoader.loadCamps();
        assertEquals("happy holidays", campList.get(0).getDescription());
    }
    
    @Test
    public void testGetCampCampers()
    {
        campList = DataLoader.loadCamps();
        assertTrue(campList.get(0).getCampers().size() != 0);
    }

    @Test
    public void testGetCounselorSize()
    {
        counselorList = DataLoader.loadCounselors();
        assertEquals(2, counselorList.size());
    }

    @Test
    public void testGetCounselorSizeZero()
    {
        Counselors.getInstance().getCounselors().clear();
        DataWriter.saveCounselors();
        assertEquals(0, counselorList.size());
    }

    @Test
    public void testGetCounselorUsername()
    {
        counselorList = DataLoader.loadCounselors();
        assertEquals("user", counselorList.get(0).getUsername());
    }

    @Test
    public void testGetDirectorSize()
    {
        directorList = DataLoader.loadDirectors();
        assertEquals(2, directorList.size());
    }

    @Test
    public void testGetDirectorSizeZero()
    {
        Directors.getInstance().getDirectors().clear();
        DataWriter.saveDirectors();
        assertEquals(0, directorList.size());
    }

    @Test
    public void testGetDirectorName()
    {
        directorList = DataLoader.loadDirectors();
        assertEquals("first", directorList.get(0).getFirstName());
    }

    @Test
    public void testGetGuardianSize()
    {
        guardianList = DataLoader.loadGuardians();
        assertEquals(2, guardianList.size());
    }

    @Test
    public void testGuardianSizeZero()
    {
        Guardians.getInstance().getGuardians().clear();
        DataWriter.saveGuardians();
        assertEquals(0, guardianList.size());
    }

    @Test
    public void testGetGuardianFirstName()
    {
        guardianList = DataLoader.loadGuardians();
        assertEquals("first", guardianList.get(0).getFirstName());
    }

    @Test
    public void testGetRegistrationSize()
    {
        registrationList = DataLoader.loadRegistrations();
        assertEquals(2, registrationList.size());
    }

    @Test
    public void testGetRegistrationSizeZero()
    {
        Registrations.getInstance().getRegistrations().clear();
        DataWriter.saveRegistrations();
        assertEquals(0, registrationList.size());
    }

    @Test
    public void testGetCamperID()
    {
        registrationList = DataLoader.loadRegistrations();
        assertTrue(registrationList.get(0).getCamperID() != null);
    }
}
