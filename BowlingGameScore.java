class BowlingGameScore {

  private int[] pinsKnockedDown = new int[21];
  private int currentRoll = 0;

  void roll(int pinsKnockedDown) {
    this.pinsKnockedDown[currentRoll++] = pinsKnockedDown;
  }

  int score() {
    int totalScore = 0;
    int rollNumber = 0;

    for (int frameNumber = 0; frameNumber < 10; frameNumber++) {
      int frameScore;

      if (isSpare(rollNumber)) {
        frameScore = 10 + getSpareBonus(rollNumber);
        rollNumber += 2;

      } else if (isStrike(pinsKnockedDown[rollNumber])) {
        frameScore = 10 + getStrikeBonus(rollNumber);
        rollNumber++;

      } else {
        frameScore = pinsKnockedDown[rollNumber] + pinsKnockedDown[rollNumber + 1];
        rollNumber += 2;
      }

      totalScore += frameScore;
    }

    return totalScore;
  }

  private int getStrikeBonus(int roll) {
    return pinsKnockedDown[roll + 1] + pinsKnockedDown[roll + 2];
  }

  private boolean isStrike(int roll) {
    return roll == 10;
  }

  private int getSpareBonus(int roll) {
    return pinsKnockedDown[roll + 2];
  }

  private boolean isSpare(int roll) {
    return pinsKnockedDown[roll] + pinsKnockedDown[roll + 1] == 10;
  }
}