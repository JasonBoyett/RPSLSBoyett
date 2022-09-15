/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * Sept 10, 2022
 * macOS
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MainTest {

    @Test
    public void testMain() {

        String tester = "ROCK";
        assertEquals(true, Main.playerWins(tester, 3));
        assertEquals(true, Main.playerWins(tester, 4));
        assertEquals(false, Main.playerWins(tester, 1));
        assertEquals(false, Main.playerWins(tester, 2));
        assertEquals(false, Main.playerWins(tester, 5));

        String tester2 = "PApEr";// I capitalized random letters to make sure it wasn't case sensitive
        assertEquals(true, Main.playerWins(tester2, 5));
        assertEquals(true, Main.playerWins(tester2, 1));
        assertEquals(false, Main.playerWins(tester2, 3));
        assertEquals(false, Main.playerWins(tester2, 2));
        assertEquals(false, Main.playerWins(tester2, 4));

        String tester3 = "scIssors";// I capitalized random letters to make sure it wasn't case sensitive
        assertEquals(true, Main.playerWins(tester3, 2));
        assertEquals(true, Main.playerWins(tester3, 4));
        assertEquals(false, Main.playerWins(tester3, 1));
        assertEquals(false, Main.playerWins(tester3, 3));
        assertEquals(false, Main.playerWins(tester3, 5));

        String tester4 = "lizArd";// I capitalized random letters to make sure it wasn't case sensitive
        assertEquals(true, Main.playerWins(tester4, 5));
        assertEquals(true, Main.playerWins(tester4, 2));
        assertEquals(false, Main.playerWins(tester4, 1));
        assertEquals(false, Main.playerWins(tester4, 3));
        assertEquals(false, Main.playerWins(tester4, 4));

        String tester5 = "sPock";// I capitalized random letters to make sure it wasn't case sensitive
        assertEquals(true, Main.playerWins(tester5, 1));
        assertEquals(true, Main.playerWins(tester5, 3));
        assertEquals(false, Main.playerWins(tester5, 2));
        assertEquals(false, Main.playerWins(tester5, 4));
        assertEquals(false, Main.playerWins(tester5, 5));

    }

}
