package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CamperTest {
    
    @Test
    public void testGetAge()
    {
        ArrayList<String> allergies = new ArrayList<String>();
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        Contact doctor = new Contact("1234", "first", "last", "fake address");
        Camper camper = new Camper("07/08/2003", "Male", "Adams", "Keefer", "225 Holly Branch Place", allergies, contacts, doctor);
        int expected = 19;
        int actual = camper.getAge();
        assertEquals(expected, actual);
    }
}
