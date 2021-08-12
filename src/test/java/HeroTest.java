import models.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class HeroTest {
//    check to see if an object is correctly created
    @Before
    public void tearDown(){
        Hero.clearAllHeroes();
    }

    @Test
    public void heroObjectIsCorrectlyCreated_true() {
        Hero superHero = new Hero("Eric", 26, "Super Coder", "Patience", "ForexTraders");
        assertEquals(true, superHero instanceof Hero);
    }

    @Test
    public void allHeroesContainsAllHeroes_true() {
        Hero superHero = new Hero("Eric", 26, "Super Coder", "My Patience", "ForexTraders");
        Hero secondSuperHero = new Hero("Ilham", 21, "Super Wifie", "Patience", "Lawyers");
        assertEquals(true, Hero.getAll().contains(superHero));
        assertEquals(true, Hero.getAll().contains(secondSuperHero));
    }

    @Test
    public void getId_heroInstantiatesWithAnID_1() throws Exception {
        Hero superHero = new Hero("Eric", 26, "Super Coder", "My Patience", "ForexTraders");
        Hero secondSuperHero = new Hero("Ilham", 21, "Super Wifie", "Patience", "Lawyers");
        assertEquals(2, Hero.findById(secondSuperHero.getId()).getId());
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() {
        Hero eric = new Hero("Eric", 26, "Super Coder", "My Patience", "ForexTraders");
        assertEquals(false, eric.getPublished());
    }

    @Test
    public void delete_deleteASpecificHero() throws Exception{
        Hero eric = setUpNewHero();
        Hero ilham = new Hero("Ilham", 20, "Super wifie", "Patience", "Lawyers");
        eric.deleteHero();
        assertEquals(1, Hero.getAll().size());
        assertEquals(Hero.getAll().get(0).getId(), 2);
    }

    @Test
    public void updateChangesHeroContent() throws Exception {
        Hero hero = setUpNewHero();

        int formerId = hero.getId();
        String formerName = hero.getName();
        int formerAge = hero.getAge();
        String formerSpecialPower = hero.getSpecialPower();
        String formerWeakness = hero.getWeakness();

        hero.setName("Ilham");
        hero.setAge(20);
        hero.setSpecialPower("Kitchen");
        hero.setWeakness("Lazyness");

        assertEquals(formerId, hero.getId());
        assertNotEquals(formerName, hero.getName());
        assertNotEquals(formerAge, hero.getAge());
        assertNotEquals(formerSpecialPower, hero.getSpecialPower());
        assertNotEquals(formerWeakness, hero.getWeakness());
    }

    @Test
    public void squad_correctlyInstantiatesSquadObject(){
        Hero eric = setUpNewHero();
        Squad avengers = setUpNewSquad();
        assertEquals(true, avengers instanceof Squad);
    }

    @Test
    public void squad_ensuresHeroChoosesASquad(){
        Hero eric = setUpNewHero();
        Squad avengers = setUpNewSquad();
        boolean exists = false;
        for(Hero hero: avengers.getHeroes()){
            if (avengers.doesHeroExist(eric)){
                System.out.println(hero + "exists");
                exists = true;
            }
        }

        if(!exists){
            avengers.getHeroes().add(eric);
        }
        
        assertEquals(eric, avengers.getHeroes().get(0));
    }

    private Hero setUpNewHero(){
        return new Hero("Eric", 26, "Super Coder", "My Patience", "ForexTraders");
    }

    private Squad setUpNewSquad(){
        return new Squad("Avengers", "Defeat Thanos");
    }
}
