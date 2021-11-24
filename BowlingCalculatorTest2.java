import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class BowlingCalculatorTest2 {

  private BowlingCalculator2 game;

  @BeforeEach
  void setUp() {
    game = new BowlingCalculator2();
  }

  @Test
  void gameScoreIsZero(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    assertEquals(0, game.score());
  }

  @Test
  void easyAs1(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 1, 0);
    assertEquals(1, game.score());
  }

  @Test
  void easyAs2(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 2, 0);
    assertEquals(2, game.score());
  }

  @Test
  void easyAs123(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 1, 0);
    game.frame(2, 2, 0);
    assertEquals(3, game.score());
  }

  @Test
  void easyAs123Again(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 1, 0);
    game.frame(2, 2, 0);
    game.frame(3, 3, 0);
    assertEquals(6, game.score());
  }

  @Test
  void fourRows(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 1, 1);
    game.frame(2, 3, 4);
    game.frame(3, 5, 4);
    game.frame(4, 7, 2);
    assertEquals(27, game.score());
  }

}
