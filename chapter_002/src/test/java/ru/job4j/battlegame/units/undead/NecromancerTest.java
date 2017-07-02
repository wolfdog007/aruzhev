package ru.job4j.battlegame.units.undead;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class check work Necromancer.
 *
 * @author Ruzhev Alexander
 * @since 30.06.2017.
 */
public class NecromancerTest {
    /**
     * Check work firstAction.
     */
    @Test
    public void whenFirstAction() {
        Hunter hunter = new Hunter();
        Necromancer necromancer = new Necromancer();
        necromancer.firstAction(hunter);
        assertThat(2, is(hunter.getDisease()));
    }
    /**
     * Check work secondAction.
     */
    @Test
    public void whenSecondAction() {
        Hunter hunter = new Hunter();
        Necromancer necromancer = new Necromancer();
        necromancer.secondAction(hunter);
        assertThat(95.0, is(hunter.getHealthPoints()));
    }
}
