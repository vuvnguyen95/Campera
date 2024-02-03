package src;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ActivitiesTest {

    private Activities activities = Activities.getInstance();
	private ArrayList<Activity> activityList = activities.getActivities();

	@BeforeEach
	public void setup() {
		activityList.clear();
		activityList.add(new Activity("basketball", "play to 21!"));
		activityList.add(new Activity("hiking", "Find a new trail"));
		DataWriter.saveActivities();
	}

	@AfterEach
	public void tearDown() {
		activities.getInstance().getActivities().clear();
		DataWriter.saveActivities();
	}

    @Test
    public void haveActivityFirstInput() {
        boolean hasBasketball = activities.haveActivity("basketball");
        assertTrue(hasBasketball);
    }

    @Test
    public void haveActivityLastInput() {
        boolean hasHiking = activities.haveActivity("hiking");
        assertTrue(hasHiking);
    }

    @Test
    public void hasActivityInvalid() {
        boolean hasCamping = activities.haveActivity("camping");
        assertFalse(hasCamping);
    }

    @Test
    public void hasActivityEmpty() {
        boolean hasEmpty = activities.haveActivity("");
        assertFalse(hasEmpty);
    }

    @Test
    public void hasActivityNull() {
        boolean hasNull = activities.haveActivity(null);
        assertFalse(hasNull);
    }

}
