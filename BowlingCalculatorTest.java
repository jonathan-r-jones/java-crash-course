import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class BowlingCalculatorTest {

  private BowlingCalculator game;

  @BeforeEach
  void setUp() {
    game = new BowlingCalculator();
  }

  @Test
  void gameScoreIsZero() {
    assertEquals(0, game.score());
  }

  @Test
  void gameScoreIsThree() {
    game.frame(1, 1, 2);
    assertEquals(3, game.score());
  }

  @Test
  void gameScoreIsToBeDetermined() {
    game.frame(1, 1, 9);
    assertEquals(-1, game.toBeDeterminedScore);
  }

  @Test
  void gameScoreIsSeven() {
    game.frame(1, 1, 2);
    game.frame(2, 2, 2);
    assertEquals(7, game.score());
  }

  @Test
  void spareInFirstFrame() {
    game.frame(1, 1, 9);
    game.frame(2, 3, 4);
    assertEquals(20, game.score());
  }

  @Test
  void strikeInFirstFrame() {
    game.frame(1, 10, 0); // 17
    game.frame(2, 3, 4); // 24
    assertEquals(24, game.score());
  }

  @Test
  void strikeSecondFrame() {
    game.frame(1, 9, 0);
    game.frame(2, 10, 0);
    game.frame(2, 3, 4);
    assertEquals(33, game.score());
  }

  @Test
  void spareThenStrike() {
    game.frame(1, 9, 1);
    //System.out.println("Score 1: " + game.score());
    game.frame(2, 10, 0);
    //System.out.println("Score 2: " + game.score());
    game.frame(3, 3, 4);
    //System.out.println("Score 3: " + game.score());
    assertEquals(44, game.score());
  }

  @Test
  void doubleStrike() {
    game.frame(1, 10, 0); // 29
    game.frame(2, 10, 0); // 48
    game.frame(3, 9, 0); // 57
    assertEquals(57, game.score());
  }

  @Test
  void turkey() {
    game.frame(1, 10, 0); // 30
    game.frame(2, 10, 0); // 59
    game.frame(3, 10, 0); // 78
    game.frame(4, 9, 0); // 87
    assertEquals(87, game.score());
  }

}
