package ru.job4j.battlegame.units.orc;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class check work Archer.
 *
 * @author Ruzhev Alexander
 * @since 30.06.2017.
 */
public class ArcherTest {
    /**
     * Check work firstAction.
     */
    @Test
    public void whenFirstAction() {
        Archer archer = new Archer();
        Shaman shaman = new Shaman();
        archer.firstAction(shaman);
        assertThat(97.0, is(shaman.getHealthPoints()));
    }
    /**
     * Check work secondAction.
     */
    @Test
    public void whenSerondtAction() {
        Archer archer = new Archer();
        Shaman shaman = new Shaman();
        archer.secondAction(shaman);
        assertThat(98.0, is(shaman.getHealthPoints()));
    }
}
