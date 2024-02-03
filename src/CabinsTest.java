package src;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabinsTest {
  private Cabins cabins = Cabins.getInstance();
  private ArrayList<Cabin> cabinList = cabins.getCabins();

  @BeforeEach
  public void setUp() {
    cabinList.clear();
    cabinList.add(new Cabin("Cabin 1", 10));
    cabinList.add(new Cabin("Cabin 2", 8));
    //(name, beds)
    DataWriter.saveCabins();

  }

  @AfterEach
  public void tearDown() {
    cabins.getInstance().getCabins().clear();
    DataWriter.saveCabins();

  }

  @Test
  public void haveCabinFirstInput() {
    boolean hasCabin1 = cabins.haveCabin("Cabin 1");
    assertTrue(hasCabin1);
  }

  @Test
  public void haveCabinsLastInput() {
    boolean hasCabin2 = cabins.haveCabin("Cabin 2");
    assertTrue(hasCabin2);
  }

  @Test
  public void hasCabinInvalid() {
    boolean hasCabin3 = cabins.haveCabin("Cabin 3");
    assertFalse(hasCabin3);
  }

  @Test
  public void hasCabinEmpty() {
    boolean hasEmpty = cabins.haveCabin("");
    assertFalse(hasEmpty);
  }

  @Test
  public void hasCabinNull() {
    boolean hasNull = cabins.haveCabin(null);
    assertFalse(hasNull);
  }

}
