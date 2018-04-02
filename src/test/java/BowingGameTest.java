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
    public void freshInstance__throw20Gutters__theScoreShouldBeZero() {
        throwOnlyGutters();

        assertScoreIs(0);
    }

    private void throwOnlyGutters() {
        for (int i = 0; i < 20; i++)
            sut.roll(0);    }


    private void assertScoreIs(int expected) {
        int actual = sut.score();
        String errorMessage = "The score should be " + expected + ", instead it is " + actual + "!";
        assertEquals(expected, actual, errorMessage);
    }


}
