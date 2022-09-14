import static org.junit.Assert.assertEquals;

import java.beans.Transient;

import org.junit.Test;

public class MainTest {

    @Test
    public void test1() {
        assertEquals(true, Main.playerWins("rock", 3));
    }

}
