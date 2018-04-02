import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BowingGameTest {

    private BowlingGame sut;

    @BeforeEach
    public void setUp() {
        sut = new BowlingGame();
    }

    @Test
    void rolledOnlyGutters__theScoreShouldBeZero() {
        roll20Gutters();

        assertScoreIs(0);
    }

    @Test
    void rolledOnlyOnes__theScoreShouldBe20() {
        roll20Ones();

        assertScoreIs(20);
    }

    @Test
    void rolledOneSpareFollowedByAThreeAnd17Gutters__theScoreShouldBe16() {
        rollSpare();
        rollSingle(3);
        rollMany(17, 0);

        assertScoreIs(16);
    }

    @Test
    public void rolledOneStrikeFollowedByAThreeAndAFourAnd16Gutters__theScoreShouldBe24() {
        rollStrike();
        rollSingle(3);
        rollSingle(4);
        rollMany(16, 0);

        assertScoreIs(24);
    }

    private void rollStrike() {
        rollSingle(10);
    }


    private void roll20Gutters() {
        rollMany(20, 0);
    }

    private void roll20Ones() {
        rollMany(20, 1);
    }

    private void rollSpare() {
        rollSingle(7);
        rollSingle(3);
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++)
            rollSingle(pins);
    }

    private void rollSingle(int pins) {
        sut.roll(pins);
    }


    private void assertScoreIs(int expected) {
        int actual = sut.score();
        String errorMessage = "The score should be " + expected + ", instead it is " + actual + "!";
        assertEquals(expected, actual, errorMessage);
    }


}
