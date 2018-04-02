public class BowlingGame {

    int[] rolls = new int[21];
    int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;

        int frameIndex = 0;
        for(int frame = 0; frame < 10; frame++) {
            if(isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex++);
            } else if(isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += pinsInFrame(frameIndex);
                frameIndex += 2;
            }

        }

        return score;
    }

    private int pinsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex+1] == 10;
    }


}
