package ru.job4j.battlegame.units.human;

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
        Mage mage = new Mage();
        Crossbowman crossbowman = new Crossbowman();
        mage.firstAction(crossbowman);
        assertThat(true, is(crossbowman.getImproved()));
    }
    /**
     * Check work secondAction.
     */
    @Test
    public void whenSerondtAction() {
        Crossbowman crossbowman = new Crossbowman();
        Mage mage = new Mage();
        mage.secondAction(crossbowman);
        assertThat(96.0, is(crossbowman.getHealthPoints()));
    }
}
