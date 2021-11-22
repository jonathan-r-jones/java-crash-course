import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class BowlingGameScoreTest {
  private BowlingGameScore game;

  @BeforeEach
  void setUp() {
    game = new BowlingGameScore();
  }

  @Test
  void game_no_pins_get_hit() {
    rollMany(0, 20);

    assertEquals(0, game.score());
  }

  @Test
  void game_just_1_pin_get_hit() {
    rollMany(1, 20);

    assertEquals(20, game.score());
  }

  @Test
  void game_with_1_spare() {
    rollSpare();
    game.roll(3);
    rollMany(0, 17);

    assertEquals(16, game.score());
  }

  @Test
  void game_with_1_strike() {
    game.roll(10);
    game.roll(3);
    game.roll(4);
    rollMany(0, 16);

    assertEquals(24, game.score());
  }

  @Test
  void game_of_strikes() {
    rollMany(10, 12);

    assertEquals(300, game.score());
  }

  @Test
  void knockdown_nine_and_miss_ten_times() {

    int firstRollPinsKnockedDown = 9;
    int secondRollPinsKnockedDown = 0;
    int repeatTimes = 10;
    rollPair(repeatTimes, firstRollPinsKnockedDown, secondRollPinsKnockedDown);

    assertEquals(90, game.score());
  }

  @Test
  void knockdown_five_and_spare_ten_times_and_fice() {
    rollPair(10, 5, 5);
    game.roll(5);

    assertEquals(150, game.score());
  }

  private void rollPair(int repeatTimes, int firstRollPinsKnockedDown, int secondRollPinsKnockedDown) {
    for (int i = 0; i < repeatTimes; i++) {
      game.roll(firstRollPinsKnockedDown);
      game.roll(secondRollPinsKnockedDown);
    }
  }

  private void rollSpare() {
    game.roll(5);
    game.roll(5);
  }

  private void rollMany(int pins, int times) {
    for (int i = 0; i < times; i++) {
      game.roll(pins);
    }
  }
}