package ru.job4j.battlegame.units.undead;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class check work Zombies.
 *
 * @author Ruzhev Alexander
 * @since on 30.06.2017.
 */
public class ZombiesTest {
    /**
     * Check work firstAction.
     */
    @Test
    public void whenFirstAction() {
        Hunter hunter = new Hunter();
        Zombies zombies = new Zombies();
        zombies.firstAction(hunter);
        assertThat(82.0, is(hunter.getHealthPoints()));
    }

    /**
     * Check work secondAction.
     */
    @Test
    public void whenSecondAction() {
        Hunter hunter = new Hunter();
        Zombies zombies = new Zombies();
        zombies.secondAction(hunter);
        assertThat(82.0, is(hunter.getHealthPoints()));
    }
}
