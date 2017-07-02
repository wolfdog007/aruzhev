package ru.job4j.battlegame.units.human;

import org.junit.Test;
import ru.job4j.battlegame.units.orc.Shaman;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class check work Crossbowman.
 *
 * @author Ruzhev Alexander
 * @since 30.06.2017.
 */
public class CrossbowmanTest {
    /**
     * Check work firstAction.
     */
    @Test
    public void whenFirstAction() {
        Crossbowman crossbowman = new Crossbowman();
        Shaman shaman = new Shaman();
        crossbowman.firstAction(shaman);
        assertThat(95.0, is(shaman.getHealthPoints()));
    }

    /**
     * Check work secondAction.
     */
    @Test
    public void whenSerondAction() {
        Crossbowman crossbowman = new Crossbowman();
        Shaman shaman = new Shaman();
        crossbowman.secondAction(shaman);
        assertThat(97.0, is(shaman.getHealthPoints()));
    }
}
