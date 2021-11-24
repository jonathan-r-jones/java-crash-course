public class BowlingCalculator2 {
  
  boolean currentFrameIsASpare;
  boolean currentFrameIsAStrike;
  boolean previousFrameWasASpare;
  boolean previousFrameWasAStrike;

  int consecutiveStrikeCounter;
  int column = 5;
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
    currentFrameIsASpare = false;
    currentFrameIsAStrike = false;
    int frameBallTotal = firstBall + secondBall;
    if ((scores[frameNumber - 1][2] + scores[frameNumber - 1][3] == 10) && (scores[frameNumber - 1][2] != 10)) {
      previousFrameWasASpare = true;
    }
    scores[frameNumber][1] = frameNumber;
    scores[frameNumber][2] = firstBall;
    scores[frameNumber][3] = secondBall;
    if (previousFrameWasASpare) {
      scores[frameNumber - 1][4] += firstBall;
    }
    scores[frameNumber][4] = scores[frameNumber - 1][4] + frameBallTotal;
  }

  public void printFrame(int frameNumber) {
    String markSymbol = "-";
    if ((scores[frameNumber][2] + scores[frameNumber][3] == 10) && (scores[frameNumber][2] != 10)) {
      markSymbol = "/";
    }
    System.out.println("Frame " + frameNumber + ": " + markSymbol + ' ' + scores[frameNumber][2] + ", "
        + scores[frameNumber][3] + " = " + scores[frameNumber][4]);
  }

  public void printScores() {
    for (int i = 1; i <= 10; i++) {
      printFrame(i);
    }
  }

}
