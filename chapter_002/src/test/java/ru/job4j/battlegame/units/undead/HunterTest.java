package ru.job4j.battlegame.units.undead;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test class check work Hunter.
 *
 * @author Ruzhev Alexander
 * @since 30.06.2017.
 */
public class HunterTest {
    /**
     * Check work firstAction.
     */
    @Test
    public void whenFirstAction() {
        Hunter hunter = new Hunter();
        Zombies zombies = new Zombies();
        hunter.firstAction(zombies);
        assertThat(96.0, is(zombies.getHealthPoints()));
    }
    /**
     * Check work secondAction.
     */
    @Test
    public void whenSecondAction() {
        Hunter hunter = new Hunter();
        Zombies zombies = new Zombies();
        hunter.secondAction(zombies);
        assertThat(98.0, is(zombies.getHealthPoints()));
    }
}
