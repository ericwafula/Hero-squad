import models.*;
import junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
//    check to see if an object is correctly created

    @Test
    public void heroObjectIsCorrectlyCreated_true() {
        Hero superHero = new Hero("Eric", 26, "Super Coder", "My GirlFriend");
        assertEquals(true, superHero instanceof Hero);
    }
}
