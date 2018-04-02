public class BowlingGame {

    int rolledPins = 0;

    int[] rolls = new int[21];
    int currentRoll = 0;

    public void roll(int pins) {
        rolledPins += pins;
        rolls[currentRoll] = pins;
        currentRoll++;
    }

    public int score() {
        int score = 0;

        int frameIndex = 0;
        for(int frame = 0; frame < 10; frame++) {
            if(isSpare(frameIndex)) {
                score += 10 + rolls[frameIndex + 2];
            }
            else {
                score += rolls[frameIndex] + rolls[frameIndex + 1];
            }
            frameIndex += 2;
        }


        return score;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex+1] == 10;
    }


}
