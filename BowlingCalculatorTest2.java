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
  void easyAs2(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 1, 0);
    assertEquals(1, game.score(1));
  }

  @Test
  void easyAs123(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 1, 0);
    game.frame(2, 2, 0);
    assertEquals(3, game.score(2));
  }

  @Test
  void easyAs123Again(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 1, 0);
    game.frame(2, 2, 0);
    game.frame(3, 3, 0);
    assertEquals(6, game.score(3));
  }

  @Test
  void fourRows(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 1, 1);
    game.frame(2, 3, 4);
    game.frame(3, 5, 4);
    game.frame(4, 7, 2);
    assertEquals(27, game.score(4));
  }

  @Test
  void firstFrameSpare(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 1, 9);
    game.frame(2, 1, 0);
    game.printScores();
    assertEquals(12, game.score(2));
  }

  @Test
  void firstFrameStrike(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 10, 0);
    game.frame(2, 1, 2);
    game.printScores();
    assertEquals(16, game.score(2));
  }

  @Test
  void twoSpares(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 1, 9); // 12
    game.frame(2, 2, 8); // 28
    game.frame(3, 6, 3); // 37
    game.printScores();
    assertEquals(37, game.score(3));
  }

  @Test
  void twoStrikes(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 10, 0); // 29
    game.frame(2, 10, 0); // 48
    game.frame(3, 6, 3); // 57
    game.printScores();
    assertEquals(57, game.score(3));
  }

  @Test
  void threeStrikes(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 10, 0); // 30
    game.frame(2, 10, 0); // 58
    game.frame(3, 10, 0); // 76
    game.frame(4, 8, 0); // 84
    game.printScores();
    assertEquals(84, game.score(4));
  }

  @Test
  void fourStrikes(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 10, 0); // 30
    game.frame(2, 10, 0); // 60
    game.frame(3, 10, 0); // 87
    game.frame(4, 10, 0); // 104
    game.frame(5, 7, 0); // 111
    game.printScores();
    assertEquals(111, game.score(5));
  }

  @Test
  void gutterStrikes(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 10, 0); // 20
    game.frame(2, 10, 0); // 30
    game.frame(3, 0, 0); // 30
    game.frame(4, 10, 0); // 47
    game.frame(5, 7, 0); // 54
    game.printScores();
    assertEquals(54, game.score(5));
  }

  @Test
  void nineStrikes(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 10, 0); // 30
    game.frame(2, 10, 0); // 60
    game.frame(3, 10, 0); // 90
    game.frame(4, 10, 0); // 120
    game.frame(5, 10, 0); // 150
    game.frame(6, 10, 0); // 180
    game.frame(7, 10, 0); // 210
    game.frame(8, 10, 0); // 239
    game.frame(9, 10, 0); // 258
    game.frame(10, 9, 0); // 267
    game.printScores();
    assertEquals(267, game.score(10));
  }

  @Test
  void perfectGame(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 10, 0); // 30
    game.frame(2, 10, 0); // 60
    game.frame(3, 10, 0); // 90
    game.frame(4, 10, 0); // 120
    game.frame(5, 10, 0); // 150
    game.frame(6, 10, 0); // 180
    game.frame(7, 10, 0); // 210
    game.frame(8, 10, 0); // 240
    game.frame(9, 10, 0); // 270
    game.tenthFrame(10, 10, 10, 10); // 300
    game.printScores();
    assertEquals(300, game.score(10));
  }

  @Test
  void almostPerfectGame(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 10, 0); // 30
    game.frame(2, 10, 0); // 60
    game.frame(3, 10, 0); // 90
    game.frame(4, 10, 0); // 120
    game.frame(5, 10, 0); // 150
    game.frame(6, 10, 0); // 180
    game.frame(7, 10, 0); // 210
    game.frame(8, 10, 0); // 240
    game.frame(9, 10, 0); // 270
    game.tenthFrame(10, 10, 10, 9); // 300
    game.printScores();
    assertEquals(299, game.score(10));
  }

  @Test
  void random(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 10, 0); // 30
    game.frame(2, 10, 0); // 60
    game.frame(3, 10, 0); // 90
    game.frame(4, 10, 0); // 120
    game.frame(5, 10, 0); // 149
    game.frame(6, 10, 0); // 168
    game.frame(7, 0, 9); // 177
    game.frame(8, 0, 9); // 186
    game.frame(9, 0, 5); // 191
    game.tenthFrame(10, 1, 2, 0); // 194
    game.printScores();
    assertEquals(194, game.score(10));
  }

  @Test
  void twoSeventeen(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 10, 0); // 30
    game.frame(2, 10, 0); // 60
    game.frame(3, 10, 0); // 90
    game.frame(4, 10, 0); // 120
    game.frame(5, 10, 0); // 149
    game.frame(6, 10, 0); // 168
    game.frame(7, 0, 9); // 177
    game.frame(8, 0, 10); // 192
    game.frame(9, 5, 4); // 201
    game.tenthFrame(10, 8, 2, 6); // 217
    game.printScores();
    assertEquals(217, game.score(10));
  }

  @Test
  void oneSixtyNine(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    //String input = "9/-/XX627/8/X9-9/9";
    game.frame(1, 9, 1); // 10
    game.frame(2, 0, 10); // 30
    game.frame(3, 10, 0); // 58
    game.frame(4, 10, 0); // 76
    game.frame(5, 6, 2); // 84
    game.frame(6, 7, 3); // 102
    game.frame(7, 8, 2); // 122
    game.frame(8, 10, 0); // 141
    game.frame(9, 9, 0); // 150
    game.tenthFrame(10, 9, 1, 9); // 169
    game.printScores();
    assertEquals(169, game.score(10));
  }

  @Test
  void oneSixtySomething2(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    // String input = "9/-/XX627/8/X9-9/X";
    game.frame(1, 9, 1); // 10
    game.frame(2, 0, 10); // 30
    game.frame(3, 10, 0); // 56
    game.frame(4, 10, 0); // 74
    game.frame(5, 6, 2); // 82
    game.frame(6, 7, 3); // 102
    game.frame(7, 8, 2); // 122
    game.frame(8, 10, 0); // 141
    game.frame(9, 9, 0); // 150
    game.tenthFrame(10, 9, 1, 8); // 170
    game.printScores();
    assertEquals(168, game.score(10));
  }

  @Test
  void lastOne(TestInfo testInfo) {
    System.out.println("\n* " + testInfo.getDisplayName());
    game.frame(1, 0, 0); // 10
    game.frame(2, 0, 0); // 30
    game.frame(3, 0, 0); // 56
    game.frame(4, 0, 0); // 74
    game.frame(5, 0, 0); // 82
    game.frame(6, 0, 0); // 102
    game.frame(7, 0, 0); // 122
    game.frame(8, 0, 0); // 141
    game.frame(9, 0, 0); // 150
    game.tenthFrame(10, 0, 0, 1); // 170
    game.printScores();
    assertEquals(1, game.score(10));
  }

}
