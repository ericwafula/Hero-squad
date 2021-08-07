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
        Hero superHero = new Hero("Eric", 26, "Super Coder", "My Patienceq");
        Hero secondSuperHero = new Hero("Ilham", 21, "Super Wifie", "Patience");
        assertEquals(true, Hero.getAll().contains(superHero));
        assertEquals(true, Hero.getAll().contains(secondSuperHero));
    }

    @Test
    public void getId_heroInstantiatesWithAnID_1() throws Exception {
        Hero superHero = new Hero("Eric", 26, "Super Coder", "My Patienceq");
        Hero secondSuperHero = new Hero("Ilham", 21, "Super Wifie", "Patience");
        assertEquals(2, Hero.findById(secondSuperHero.getId()).getId());
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() {
        Hero eric = new Hero("Eric", 26, "Super Coder", "My Patienceq");
        assertEquals(false, eric.getPublished());
    }
}
