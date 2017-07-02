package ru.job4j.battlegame.units.human;

import org.junit.Test;
import ru.job4j.battlegame.units.orc.Shaman;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class check work Warrior.
 *
 * @author Ruzhev Alexander
 * @since 30.06.2017.
 */
public class WarriorTest {
    /**
     * Check work firstAction.
     */
    @Test
    public void whenFirstAction() {
        Warrior warrior = new Warrior();
        Shaman shaman = new Shaman();
        warrior.firstAction(shaman);
        assertThat(82.0, is(shaman.getHealthPoints()));
    }
    /**
     * Check work secondAction.
     */
    @Test
    public void whenSecondAction() {
        Warrior warrior = new Warrior();
        Shaman shaman = new Shaman();
        warrior.secondAction(shaman);
        assertThat(82.0, is(shaman.getHealthPoints()));
    }
}
