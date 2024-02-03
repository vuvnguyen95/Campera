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

public class GuardianTest {
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
		Guardians guardians = Guardians.getInstance(); 
        Guardian davis = new Guardian(UUID.randomUUID(), "ldavis", "1234", "ldavis@gmail.com", "Levaeh", "Davis");
        guardians.addGuardian(davis);
		boolean passCheck = guardians.checkPassword("ldavis", "1234");
		assertEquals(true, passCheck);
	}

	@Test 
	public void checkPasswordWrong(){
		Guardians guardians = Guardians.getInstance(); 
        Guardian davis = new Guardian(UUID.randomUUID(), "ldavis", "1234", "ldavis@gmail.com", "Levaeh", "Davis");
        guardians.addGuardian(davis);
		boolean passCheck = guardians.checkPassword("ldavis", "hacker4life");
		assertEquals(false, passCheck);
	}
}
