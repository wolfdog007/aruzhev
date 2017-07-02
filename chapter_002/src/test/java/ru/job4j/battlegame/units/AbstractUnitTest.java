package ru.job4j.battlegame.units;

import org.junit.Test;
import ru.job4j.battlegame.units.elf.Warrior;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class check work AbstractUnit.
 *
 * @author Ruzhev Alexander
 * @since on 30.06.2017.
 */
public class AbstractUnitTest {
    /**
     * Check work toDamage.
     */
    @Test
    public void whenToDamage() {
        AbstractUnit unit = new Warrior();
        unit.toDamage(20);
        assertThat(80.0, is(unit.getHealthPoints()));
    }

    /**
     * Check work toDisease.
     */
    @Test
    public void whenToDisease() {
        AbstractUnit unit = new Warrior();
        assertThat(1, is(unit.getDisease()));
        unit.toDisease();
        assertThat(2, is(unit.getDisease()));
        unit.toDisease();
        assertThat(1, is(unit.getDisease()));
    }
}
