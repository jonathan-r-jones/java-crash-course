import java.lang.reflect.Constructor;

public class BowlingCalculator {
  
  boolean currentFrameIsASpare;
  boolean currentFrameIsAStrike;
  boolean previousFrameWasASpare;
  boolean previousFrameWasAStrike;

  int consecutiveStrikeCounter;
  int displayScore;
  int toBeDeterminedScore = -1;
  int totalScore;
  
  public static void main(String[] args) {
    BowlingCalculator game = new BowlingCalculator();
    game.frame(1, 9, 1);
    System.out.println("Score 1: " + game.score());
    game.frame(2, 10, 0);
    System.out.println("Score 2: " + game.score());
    game.frame(3, 3, 4);
    System.out.println("Score 3: " + game.score());
    game.score();
  }

  public BowlingCalculator() {
    System.out.println("\nNew Game *********************** ");
  }

  int score() {
    return totalScore;
  }

  int displayScore() {
    return displayScore;
  }

  public void frame(int frameNumber, int firstBall, int secondBall) {
    currentFrameIsASpare = false;
    currentFrameIsAStrike = false;
    totalScore += firstBall + secondBall;
    if (previousFrameWasAStrike && (firstBall + secondBall != 10)) {
      if (consecutiveStrikeCounter == 2) {
        printFrame(frameNumber - 2, totalScore);
        totalScore += 10;
        totalScore += firstBall + secondBall;
        printFrame(frameNumber - 1, totalScore);
      }
      if (consecutiveStrikeCounter == 3) {
        totalScore += 20;
        printFrame(frameNumber - 2, totalScore);
        totalScore += 10;
        totalScore += firstBall + secondBall;
        printFrame(frameNumber - 1, totalScore);
      }
      totalScore += firstBall + secondBall;
      printFrame(frameNumber, totalScore);
    }
    if (firstBall == 10) {
      consecutiveStrikeCounter++;
      currentFrameIsAStrike = true;
    } else {
      consecutiveStrikeCounter = 0;
    }
    if (firstBall != 10 && (firstBall + secondBall == 10)) {
      currentFrameIsASpare = true;
    }
    // Simplest case; no marks to account for.
    if (!previousFrameWasASpare && !previousFrameWasAStrike && (firstBall + secondBall != 10)){
      printFrame(frameNumber, totalScore);
    }
    if (previousFrameWasASpare) {
      totalScore += firstBall;
      printFrame(frameNumber - 1, totalScore);
    }
    if (consecutiveStrikeCounter == 3) {
      printFrame(frameNumber - 2, totalScore);
    }
    previousFrameWasASpare = currentFrameIsASpare;
    previousFrameWasAStrike = currentFrameIsAStrike;
  }

  public void printFrame(int frameNumber, int totalScore) {
    System.out.println("Frame " + frameNumber + ": " + totalScore);
  }

}
