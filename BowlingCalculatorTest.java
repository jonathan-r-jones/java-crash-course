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
    assertEquals(-1, game.displayScore);
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
    assertEquals(21, game.score());
  }

}
