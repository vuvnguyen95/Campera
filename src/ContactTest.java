package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ContactTest {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    Contact contact = new Contact("1234", "first", "last", "address");

    @Test
    public void testGetPhone()
    {
        String expected = "1234";
        String actual = contact.getPhone();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFirstName()
    {
        String expected = "first";
        String actual = contact.getFirstName();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetLastName()
    {
        String expected = "last";
        String actual = contact.getLastName();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAddress()
    {
        String expected = "address";
        String actual = contact.getAddress();
        assertEquals(expected, actual);
    }
}
