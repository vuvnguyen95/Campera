package src;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampersTest {
  private static final ArrayList<Contact> contacts = null;
  private static final ArrayList<String> allergies = null;
  private static final Contact pediatrician = null;
  private Campers campers = Campers.getInstance();
  private ArrayList<Camper> camperList = campers.getCampers();

  @BeforeEach
  public void setUp() {
    camperList.clear();
    // ArrayList<String> allergies;
    camperList
        .add(new Camper("01/05/2006", "Male", "Nutella", "Davis", "1234 Road", allergies, contacts, pediatrician));
    // Camper camper = new Camper(birthdate, gender, firstName, lastName, address,
    // allergies, contacts, doctor);
    camperList
        .add(new Camper("11/08/2007", "Female", "Joanne", "Smith", "1345 Street", allergies, contacts, pediatrician));
    DataWriter.saveCampers();

  }

  @AfterEach
  public void tearDown() {
    campers.getInstance().getCampers().clear();
    DataWriter.saveCampers();

  }

  @Test
  public void haveCamperFirstInput() {
    boolean hasNutella = campers.haveCamper("Nutella", "Davis", "01/05/2006");
    assertTrue(hasNutella);
  }

  @Test
  public void haveCamperLastInput() {
    boolean hasJoanne = campers.haveCamper("Joanne", "Smith", "11/08/2007");
    assertTrue(hasJoanne);
  }

  @Test
  public void hasCamperInvalid() {
    boolean hasJimmy = campers.haveCamper("Jimmy", "Neutron", "02/10/2004");
    assertFalse(hasJimmy);
  }

  @Test
  public void hasCamperEmpty() {
    boolean hasEmpty = campers.haveCamper("", "", "");
    assertFalse(hasEmpty);
  }

  @Test
  public void hasCamperNull() {
    boolean hasNull = campers.haveCamper(null, null, null);
    assertFalse(hasNull);
  }

}
