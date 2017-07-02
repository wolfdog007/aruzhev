package ru.job4j.battlegame.units.orc;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class check work Goblin.
 *
 * @author Ruzhev Alexander
 * @since 30.06.2017.
 */
public class GoblinTest {
    /**
     * Check work firstAction.
     */
    @Test
    public void whenFirstAction() {
        Goblin goblin = new Goblin();
        Shaman shaman = new Shaman();
        goblin.firstAction(shaman);
        assertThat(80.0, is(shaman.getHealthPoints()));
    }
    /**
     * Check work secondAction.
     */
    @Test
    public void whenSecondAction() {
        Goblin goblin = new Goblin();
        Shaman shaman = new Shaman();
        goblin.secondAction(shaman);
        assertThat(80.0, is(shaman.getHealthPoints()));
    }
}
