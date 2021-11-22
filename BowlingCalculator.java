public class BowlingCalculator {
  
  boolean currentBallIsASpare;
  boolean currentBallIsAStrike;
  boolean previousBallWasASpare;
  boolean previousBallWasAStrike;

  int displayScore;
  int toBeDeterminedScore = -1;
  int totalScore;
  
  int score() {
    return totalScore;
  }

  int displayScore() {
    return displayScore;
  }

  public int frame(int frameNumber, int firstBall, int secondBall) {
    if (firstBall + secondBall == 10) {
      if (firstBall == 10) {
        currentBallIsAStrike = true;
      } else {
        currentBallIsASpare = true;
      }
      totalScore += firstBall + secondBall;
      displayScore = -1;
      return displayScore;
    }
    if (previousBallWasASpare) {
      totalScore += firstBall;
    }
    if (previousBallWasAStrike) {
      totalScore += firstBall + secondBall;
    }
    totalScore += firstBall + secondBall;
    previousBallWasASpare = currentBallIsASpare;
    previousBallWasAStrike = currentBallIsAStrike;
    return totalScore;
  }

}
