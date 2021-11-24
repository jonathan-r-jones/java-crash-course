import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class BowlingCalculatorTest {

  private BowlingCalculator game;

  @BeforeEach
  void setUp() {
    game = new BowlingCalculator();
  }

  @Test
  void gameScoreIsZero(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    assertEquals(0, game.score());
  }

  @Test
  void gameScoreIsThree(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 1, 2);
    assertEquals(3, game.score());
  }

  @Test
  void gameScoreIsToBeDetermined(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 1, 9);
    assertEquals(-1, game.toBeDeterminedScore);
  }

  @Test
  void gameScoreIsSeven(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 1, 2);
    game.frame(2, 2, 2);
    assertEquals(7, game.score());
  }

  @Test
  void spareInFirstFrame(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 1, 9);
    game.frame(2, 3, 4);
    assertEquals(20, game.score());
  }

  @Test
  void strikeInFirstFrame(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 10, 0); // 17
    game.frame(2, 3, 4); // 24
    assertEquals(24, game.score());
  }

  @Test
  void strikeSecondFrame(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 9, 0); // 9
    game.frame(2, 10, 0); // 27
    game.frame(3, 7, 1); // 35
    assertEquals(35, game.score());
  }

  @Test
  void spareThenStrike(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 9, 1); // 20
    game.frame(2, 10, 0);
    game.frame(3, 3, 4);
    assertEquals(44, game.score());
  }

  @Test
  void doubleStrike(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 10, 0); // 29
    game.frame(2, 10, 0); // 48
    game.frame(3, 9, 0); // 57
    assertEquals(57, game.score());
  }

  @Test
  void easyAs123(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 1, 0); // 1
    game.frame(2, 2, 0); // 3
    game.frame(3, 3, 0); // 6
    assertEquals(6, game.score());
  }

  @Test
  void turkey(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 10, 0); // 30
    game.frame(2, 10, 0); // 59
    game.frame(3, 10, 0); // 78
    game.frame(4, 9, 0); // 87
    assertEquals(87, game.score());
  }

  @Test
  void fourStrikes(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 10, 0); // 30
    game.frame(2, 10, 0); // 60
    game.frame(3, 10, 0); // 89
    game.frame(4, 10, 0); // 108
    game.frame(5, 9, 0); // 117
    assertEquals(117, game.score());
  }

  @Test
  void fiveStrikes(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 10, 0); // 30
    game.frame(2, 10, 0); // 60
    game.frame(3, 10, 0); // 90
    game.frame(4, 10, 0); // 119
    game.frame(5, 10, 0); // 138
    game.frame(6, 9, 0); // 147
    assertEquals(147, game.score());
  }

}
