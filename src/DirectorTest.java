package src;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DirectorTest {


    @BeforeClass
	public static void oneTimeSetup() {
		
	}
	
	@AfterClass
	public static void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public static void setup() {
		//runs before each test
	}
	
	@AfterEach
	public static void tearDown() {
		//runs after each test
	}

    @Test
    public void checkPasswordCorrect(){
		Directors directors = Directors.getInstance(); 
		Director sam = new Director(UUID.randomUUID(), "samsam", "1234", "ssamuels@campera.com", "Samantha", "Samuels", "Camp Director of 12 years and loving every moment.");
        directors.addDirector(sam); 
		boolean passCheck = directors.checkPassword("samsam", "1234");
		assertEquals(true, passCheck);
	}

	@Test 
	public void checkPasswordWrong(){
		Directors directors = Directors.getInstance(); 
		Director sam = new Director(UUID.randomUUID(), "samsam", "1234", "ssamuels@campera.com", "Samantha", "Samuels", "Camp Director of 12 years and loving every moment.");
        directors.addDirector(sam); 
		boolean passCheck = directors.checkPassword("samsam", "hacker4life");
		assertEquals(false, passCheck);
	}
}
