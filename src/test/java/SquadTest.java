import models.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class SquadTest {
    @Test
    public void instantiatesSquadCorrectly_true() {
        Hero hero = new Hero("Eric", 26, "Super Coder", "Patience");
        Squad squad = new Squad("Vikings", "Defeat spartans");
        assertEquals(true, squad instanceof Squad);
    }

    @Test
    public void succesFullyGetsHero_true() {
        Hero hero = new Hero("Eric", 26, "Super Codeer", "Patience");
        Squad squad = new Squad("Vikings", "Defeat spartans");
        assertEquals(true, squad.getHeroes());
    }

    @Test
    public void checksIfSquadCanAddHeroes_true() {
        Hero eric = new Hero("Eric", 26, "Super Coder", "Patience");
        Hero brian = new Hero("Brian", 27, "Pilot", "Never broke");
        Squad avengers = new Squad("Avengers", "Defeat Spartans");
        avengers.setHeroes(eric);
        avengers.setHeroes(brian);
        assertEquals(true, avengers.getHeroes().contains(eric));
    }

    @Test
    public void checksIfSquadIsLimitedToAMaxOf5Heroes_true() {
        Hero eric = new Hero("Eric", 26, "Super Coder", "Patience");
        Hero brian = new Hero("Brian", 27, "Pilot", "Never broke");
        Hero jeff = new Hero("Jeff", 28, "Android Engineer", "Never broke");
        Hero nic = new Hero("Nic", 24, "Web Developer", "Never broke");
        Hero shirquile = new Hero("Shirquile", 28, "Freelancer", "Never broke");
        Hero goliath = new Hero("Goliath", 128, "Beast", "Never broke");

        Squad avengers = new Squad("Avengers", "Defeat Spartans");
        avengers.setHeroes(eric);
        avengers.setHeroes(brian);
        avengers.setHeroes(jeff);
        avengers.setHeroes(nic);
        avengers.setHeroes(shirquile);
//        avengers.setHeroes(goliath);
        assertEquals(true, avengers.checkForMaximumMembers());
    }

    @Test
    public void checksIfHeroAppearsInOnlyOneSquadAtATime_true() {
        Hero eric = new Hero("Eric", 26, "Super Coder", "Patience");
        Hero brian = new Hero("Brian", 27, "Pilot", "Never broke");

        Squad avengers = new Squad("Avengers", "Defeat Spartans");
        Squad justiceLeague = new Squad("Justice League", "Fight Crime");
        avengers.setHeroes(eric);
        justiceLeague.setHeroes(eric);
        avengers.setHeroes(brian);
        assertEquals(false, avengers.doesHeroExist(brian));
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() {
        Squad avengers = new Squad("Avengers", "Defeat Spartans");
        assertEquals(false, avengers.getPublished());
    }

    @Test
    public void getId_squadInstantiatesWithAnID_1() throws Exception {
        Squad.clearAllPosts();
        Squad avengers = new Squad("Avengers", "Defeat Spartans");
        Squad justiceLeague = new Squad("Justice League", "Fight Crime");
        assertEquals(2, Squad.findById(justiceLeague.getId()).getId());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception{
        Squad avengers = new Squad("Avengers", "Defeat Spartans");
        assertEquals(LocalDateTime.now().getDayOfWeek(), avengers.getCreatedAt().getDayOfWeek());
    }
}
