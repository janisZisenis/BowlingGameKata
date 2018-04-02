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
    void freshInstance__rollOnlyGutters__theScoreShouldBeZero() {
        roll20Gutters();

        assertScoreIs(0);
    }

    @Test
    void freshInstance__rollOnlyOnes__theScoreShouldBeZero() {
        roll20Ones();

        assertScoreIs(20);
    }

    private void roll20Ones() {
        rollMany(1, 20);
    }


    private void roll20Gutters() {
        rollMany(0, 20);
    }

    private void rollMany(int pins, int times) {
        for (int i = 0; i < times; i++)
            sut.roll(pins);
    }


    private void assertScoreIs(int expected) {
        int actual = sut.score();
        String errorMessage = "The score should be " + expected + ", instead it is " + actual + "!";
        assertEquals(expected, actual, errorMessage);
    }


}
