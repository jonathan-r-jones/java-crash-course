import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class LongestCommonPrefixTest {

  private LongestCommonPrefix longestCommonPrefix;

  @BeforeEach
  void setUp() {
    longestCommonPrefix = new LongestCommonPrefix();
  }

  @Test
  void test1(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    String[] stringArray = new String[] { "flower","flow","flight" };
    assertEquals(longestCommonPrefix.longestCommonPrefix(stringArray), "fl");
  }

}