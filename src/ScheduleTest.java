package src;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ScheduleTest {
    private Schedules sch = Schedules.getInstance();
    private ArrayList<Schedule> schList = sch.getSchedules();
    private Activities activities = Activities.getInstance();
    private ArrayList<Activity> actList = activities.getActivities();
    private Cabins cab = Cabins.getInstance();
    private ArrayList<Cabin> cabList = cab.getCabins();
    private Camps camps = Camps.getInstance();
    private ArrayList<Camp> camp = camps.getCamps();
	
    @BeforeEach
    public void setup(){
        activities.getInstance().getActivities().clear();
        cab.getInstance().getCabins().clear();
        cabList.add(new Cabin("Cab1", 5));
        cabList.add(new Cabin("Cab2", 6));
        actList.add(new Activity("1", "cat"));
        actList.add(new Activity("2", "dog"));
        actList.add(new Activity("3", "mew"));
        actList.add(new Activity("4", "gau"));
        actList.add(new Activity("5", "ccc"));
        DataWriter.saveActivities();
        DataWriter.saveCabins();
    }

    @AfterEach
    public void teardown(){
		activities.getInstance().getActivities().clear();
		cab.getInstance().getCabins().clear();
        DataWriter.saveActivities();
        DataWriter.saveCabins();
	}

    @Test
    public void testCreateSchedule(){
        sch.addSchedule(new Schedule(actList, "01/01/2022", cabList.get(0)));
        assert(sch.getSchedules().get(0).getActivities().equals(actList));
    }

    @Test
    public void testRandomSchedule(){  

        sch.generateSchedule(cabList, actList, "01/01/2022");
        Activity controllAct = sch.getSchedules().get(0).getActivities().get(0);
        Activity testAct = sch.getSchedules().get(1).getActivities().get(0);
        assertFalse(controllAct.equals(testAct));
    }

    @Test
    public void testGenerateSchedule(){
        camp.get(0).generateSchedules();
    }



    
}   
