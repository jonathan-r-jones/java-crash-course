import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class IntegerToRomanTest {

  private IntegerToRoman romanNumeral;

  @BeforeEach
  void setUp() {
    romanNumeral = new IntegerToRoman();
  }

  @Test
  void testI(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    assertEquals(romanNumeral.Build(1), "I");
  }

  @Test
  void testIII(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    assertEquals(romanNumeral.Build(3), "III");
  }

  @Test
  void test58(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    assertEquals(romanNumeral.Build(58), "LVIII");
  }

  @Test
  void test1994(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    assertEquals(romanNumeral.Build(1994), "MCMXCIV");
  }

}
