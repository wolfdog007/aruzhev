package ru.job4j.battlegame.units.elf;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class check work Mage.
 *
 * @author Ruzhev Alexander
 * @since 30.06.2017.
 */
public class MageTest {
    /**
     * Check work firstAction.
     */
    @Test
    public void whenFirstAction() {
        Archer archer = new Archer();
        Mage mage = new Mage();
        mage.firstAction(archer);
        assertThat(true, is(archer.getImproved()));
    }

    /**
     * Check work secondAction.
     */
    @Test
    public void whenSerondtAction() {
        Archer archer = new Archer();
        Mage mage = new Mage();
        mage.secondAction(archer);
        assertThat(90.0, is(archer.getHealthPoints()));
    }
}
