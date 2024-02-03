package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class CampTest {

    
    @Test
    public void testDateConversion()
    {
        ArrayList<Cabin> cabins = new ArrayList<Cabin>();
        cabins.add(new Cabin("Cabin 1", 6));
        cabins.add(new Cabin("Cabin 2", 12));
        cabins.add(new Cabin("Cabin 3", 11));
        cabins.add(new Cabin("Cabin 4", 3));
        Director director = new Director("direcot", "dpass", "director@email.com", "First", "Last", "bio");
        Camp camp = new Camp(cabins, director, "01/20/2022", "01/24/2022", "Christmas", "Happy Holidays");
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("01/20/2022"); expectedList.add("01/21/2022"); expectedList.add("01/22/2022"); expectedList.add("01/23/2022"); expectedList.add("01/24/2022");
        ArrayList<String> actualList = camp.getDates();
        Object[] expected = expectedList.toArray();
        Object[] actual = actualList.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDateInclusiveLeft()
    {
        ArrayList<Cabin> cabins = new ArrayList<Cabin>();
        cabins.add(new Cabin("Cabin 1", 6));
        cabins.add(new Cabin("Cabin 2", 12));
        cabins.add(new Cabin("Cabin 3", 11));
        cabins.add(new Cabin("Cabin 4", 3));
        Director director = new Director("direcot", "dpass", "director@email.com", "First", "Last", "bio");
        Camp camp = new Camp(cabins, director, "01/20/2022", "01/24/2022", "Christmas", "Happy Holidays");
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("01/20/2022"); expectedList.add("01/21/2022"); expectedList.add("01/22/2022"); expectedList.add("01/23/2022"); expectedList.add("01/24/2022");
        ArrayList<String> actualList = camp.getDates();
        Object[] expected = expectedList.toArray();
        Object[] actual = actualList.toArray();
        assertEquals(expected[0], actual[0]);
    }

    @Test
    public void testCabinNaming()
    {
        ArrayList<Cabin> cabins = new ArrayList<Cabin>();
        Director director = new Director("director", "dpass", "email", "first", "last", "bio");
        Camp camp = new Camp(cabins, director, "01/20/2022", "01/24/2022", "Christmas", "Happy Holidays");
        camp.createCabins();
        int i = 1;
        for(Cabin cabin : camp.getCabins())
        {
            assertEquals(cabin.getName(), "Christmas Cabin " + i);
            i++;
        }
    }
}
