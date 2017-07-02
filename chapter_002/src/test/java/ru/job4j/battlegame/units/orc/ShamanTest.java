package ru.job4j.battlegame.units.orc;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class check work Shaman.
 *
 * @author Ruzhev Alexander
 * @since 30.06.2017.
 */
public class ShamanTest {
    /**
     * Check work firstAction.
     */
    @Test
    public void whenFirstAction() {
        Archer archer = new Archer();
        Shaman shaman = new Shaman();
        shaman.firstAction(archer);
        assertThat(true, is(archer.getImproved()));
    }
    /**
     * Check work secondAction.
     */
    @Test
    public void whenSecondAction() {
        Archer archer = new Archer();
        Shaman shaman = new Shaman();
        shaman.firstAction(archer);
        assertThat(true, is(archer.getImproved()));
        shaman.secondAction(archer);
        assertThat(false, is(archer.getImproved()));
    }
}
