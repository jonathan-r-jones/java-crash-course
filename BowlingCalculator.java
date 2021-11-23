public class BowlingCalculator {
  
  boolean currentFrameIsASpare;
  boolean currentFrameIsAStrike;
  boolean previousFrameWasASpare;
  boolean previousFrameWasAStrike;

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

  int score() {
    return totalScore;
  }

  int displayScore() {
    return displayScore;
  }

  public int frame(int frameNumber, int firstBall, int secondBall) {
    currentFrameIsAStrike = false;
    currentFrameIsASpare = false;
    if (firstBall == 10) {
      currentFrameIsAStrike = true;
      if (previousFrameWasAStrike) {
        totalScore += firstBall + secondBall;
      }
    } else if (firstBall + secondBall == 10) {
      currentFrameIsASpare = true;
    }
    if (previousFrameWasASpare) {
      totalScore += firstBall;
    }
    if (previousFrameWasAStrike) {
      totalScore += firstBall + secondBall;
    }
    previousFrameWasASpare = currentFrameIsASpare;
    previousFrameWasAStrike = currentFrameIsAStrike;
    totalScore += firstBall + secondBall;
    if (firstBall + secondBall == 10) {
      return toBeDeterminedScore; // -1
    } else {
      printFrame(frameNumber, totalScore);
      return totalScore;
    }
  }

  public void printFrame(int frameNumber, int totalScore) {
    System.out.println("Frame " + frameNumber + ": " + totalScore);
  }

}
