public class BowlingGame {

    int rolledPins = 0;

    public void roll(int i) {
        rolledPins += i;
    }

    public int score() {
        return rolledPins;
    }
}
