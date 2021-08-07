import models.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void instantiatesSquadCorrectly_true() {
        Hero hero = new Hero("Eric", 26, "Super Coder", "Patience");
        Squad squad = new Squad(hero, "Vikings", "Defeat spartans");
        assertEquals(true, squad instanceof Squad);
    }
}
