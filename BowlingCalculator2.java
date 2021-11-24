public class BowlingCalculator2 {
  
  boolean currentFrameIsASpare;
  boolean currentFrameIsAStrike;
  boolean previousFrameWasASpare;
  boolean previousFrameWasAStrike;

  int consecutiveStrikeCounter;
  int totalScore;
  int column = 5;
  int row = 11;
  int[][] scores = new int[row][column];

  public static void main(String[] args) {
    BowlingCalculator2 game = new BowlingCalculator2();
    game.frame(1, 1, 0); // 1
  }

  int score() {
    return totalScore;
  }

  public void frame(int frameNumber, int firstBall, int secondBall) {
    currentFrameIsASpare = false;
    currentFrameIsAStrike = false;
    totalScore += firstBall + secondBall;
    scores[frameNumber][1] = frameNumber;
    scores[frameNumber][2] = firstBall;
    scores[frameNumber][3] = secondBall;
    scores[frameNumber][4] = totalScore;
    printFrame(frameNumber);
  }

  public void printFrame(int frameNumber) {
    String markSymbol = "-";
    System.out.println("Frame " + frameNumber + ": " + markSymbol + ' ' + scores[frameNumber][2] + ", " + scores[frameNumber][3] + " = " + scores[frameNumber][4]);
  }

}
