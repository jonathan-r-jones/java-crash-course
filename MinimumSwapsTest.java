import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class MinimumSwapsTest {

  private MinimumSwaps minimumSwaps;

  @BeforeEach
  void setUp() {
    minimumSwaps = new MinimumSwaps();
  }

  @Test
  void test1(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    int[] intArray = new int[] { 1, 0, 1, 0, 1 };
    assertEquals(minimumSwaps.minSwaps(intArray), 1);
  }

  @Test
  void test2(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    int[] intArray = new int[] { 0, 0, 0, 1, 0 };
    assertEquals(minimumSwaps.minSwaps(intArray), 0);
  }

  @Test
  void test3(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    int[] intArray = new int[] { 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1 };
    assertEquals(minimumSwaps.minSwaps(intArray), 3);
  }

}
