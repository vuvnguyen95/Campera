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

public class CounselorTest {
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
		Counselors counselors = Counselors.getInstance(); 
        Counselor kix = new Counselor("kixgon", "1234", "kix@gmail.com", "Kix", "Gonzalez", "Excited to be here!", "08/28/2001", "Smallville", "Male", contacts, pediatrician);
        counselors.addCounselor(kix); 
		boolean passCheck = counselors.checkPassword("ldavis", "1234");
		assertEquals(true, passCheck);
	}

	@Test 
	public void checkPasswordWrong(){
		Counselors counselors = Counselors.getInstance(); 
        Counselor kix = new Counselor("kixgon", "1234", "kix@gmail.com", "Kix", "Gonzalez", "Excited to be here!", "08/28/2001", "Smallville", "Male", contacts, pediatrician);
        counselors.addCounselor(kix); 
		boolean passCheck = counselors.checkPassword("ldavis", "hacker4life");
		assertEquals(false, passCheck);
	}
}
