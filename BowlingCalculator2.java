public class BowlingCalculator2 {
  
  boolean previousFrameWasASpare;
  boolean previousFrameWasAStrike;

  int consecutiveStrikeCounter;
  int column = 6;
  int row = 11;
  int[][] scores = new int[row][column];

  public static void main(String[] args) {
    BowlingCalculator2 game = new BowlingCalculator2();
    game.frame(1, 1, 0); // 1
    game.printScores();
  }

  int score(int framesBowled) {
    return scores[framesBowled][4];
  }

  public void frame(int frameNumber, int firstBall, int secondBall) {
    int frameBallTotal = firstBall + secondBall;

    scores[frameNumber][1] = frameNumber;
    scores[frameNumber][2] = firstBall;
    scores[frameNumber][3] = secondBall;

    // Previous 2 frames were strikes.
    if (scores[frameNumber - 1][2] == 10 && scores[frameNumber - 2][2] == 10) {
      scores[frameNumber - 2][4] += frameBallTotal;
      scores[frameNumber - 1][4] += frameBallTotal;
    }

    // Previous frame was a spare.
    if ((scores[frameNumber - 1][2] + scores[frameNumber - 1][3] == 10) && (scores[frameNumber - 1][2] != 10)) {
      scores[frameNumber - 1][4] += firstBall;
    }

    // Previous frame was a strike.
    if (scores[frameNumber - 1][2] == 10) {
      scores[frameNumber - 1][4] += frameBallTotal;
    }

    // Tenth frame special case.
    if (frameNumber == 10) {
      // scores[frameNumber - 1][4] += frameBallTotal;
      // scores[frameNumber - 1][4] += frameBallTotal;
    }

    scores[frameNumber][4] = scores[frameNumber - 1][4] + frameBallTotal;
  }

  public void printFrame(int frameNumber) {
    String markSymbol = "-";
    if ((scores[frameNumber][2] + scores[frameNumber][3] == 10) && (scores[frameNumber][2] != 10)) {
      markSymbol = "/";
    }
    if (scores[frameNumber][2] == 10) {
      markSymbol = "x";
    }
    System.out.println("Frame " + frameNumber + ": " + markSymbol + ' ' + scores[frameNumber][2] + ", "
        + scores[frameNumber][3] + " = " + scores[frameNumber][4]);
  }

  public void printScores() {
    for (int i = 1; i <= 10; i++) {
      printFrame(i);
    }
  }

  // Special case for the tenth frame.
  public void tenthFrame(int frameNumber, int firstBall, int secondBall, int thirdBall) {
    int frameBallTotal = firstBall + secondBall + thirdBall;

    scores[frameNumber][1] = frameNumber;
    scores[frameNumber][2] = firstBall;
    scores[frameNumber][3] = secondBall;
    scores[frameNumber][5] = thirdBall;

    // Previous 2 frames were strikes.
    if (scores[frameNumber - 1][2] == 10 && scores[frameNumber - 2][2] == 10) {
      scores[frameNumber - 2][4] += firstBall;
      scores[frameNumber - 1][4] += firstBall;
    }

    // Previous frame was a spare.
    if ((scores[frameNumber - 1][2] + scores[frameNumber - 1][3] == 10) && (scores[frameNumber - 1][2] != 10)) {
      scores[frameNumber - 1][4] += firstBall;
    }

    // Previous frame was a strike.
    if (scores[frameNumber - 1][2] == 10) {
      scores[frameNumber - 1][4] += firstBall + secondBall;
    }

    scores[frameNumber][4] = scores[frameNumber - 1][4] + frameBallTotal;
  }

}
