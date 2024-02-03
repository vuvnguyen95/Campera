package src;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataWriterTest {

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
    public void writingZeroActivities()
    {
        activityList= DataLoader.loadActivities();
        assertEquals(0, activityList.size());
    }

    @Test
    public void writingOneActivity()
    {
        activityList.add(new Activity("gaga ball", "beat the other cabins"));
        DataWriter.saveActivities();
        assertEquals("gaga ball", DataLoader.loadActivities().get(0).getName());
    }

    @Test
    public void writingMulptipleActivities()
    {
        activityList.add(new Activity("gaga ball", "beat the other cabins"));
        activityList.add(new Activity("basketball", "a good game of horse"));
        DataWriter.saveActivities();
        assertEquals("basketball", DataLoader.loadActivities().get(1).getName());
    }

    @Test
    public void writingZeroCabins()
    {
        cabinList = DataLoader.loadCabins();
        assertEquals(0, cabinList.size());
    }

    @Test
    public void writingZeroCamps()
    {
        campList = DataLoader.loadCamps();
    }
}
