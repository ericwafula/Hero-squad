import models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
//    check to see if an object is correctly created
    @Before
    public void tearDown(){
        Hero.clearAllHeroes();
    }

    @Test
    public void heroObjectIsCorrectlyCreated_true() {
        Hero superHero = new Hero("Eric", 26, "Super Coder", "Patience");
        assertEquals(true, superHero instanceof Hero);
    }

    @Test
    public void allHeroesContainsAllHeroes_true() {
        Hero superHero = new Hero("Eric", 26, "Super Coder", "My Patience");
        Hero secondSuperHero = new Hero("Ilham", 21, "Super Wifie", "Patience");
        assertEquals(true, Hero.getAll().contains(superHero));
        assertEquals(true, Hero.getAll().contains(secondSuperHero));
    }
}
