package ru.job4j.battlegame;

import org.junit.Test;
import ru.job4j.battlegame.exception.UnitNotFoundException;
import ru.job4j.battlegame.units.AbstractUnit;
import ru.job4j.battlegame.units.elf.Archer;
import ru.job4j.battlegame.units.elf.Mage;
import ru.job4j.battlegame.units.elf.Warrior;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class check work Squad.
 *
 * @author Ruzhev Alexander
 * @since 25.06.2017.
 */
public class SquadTest {
    /**
     * Check work getImprovedIndex.
     */
    @Test
    public void whenGetImprovedIndex() {
        Squad squad = new Squad();
        AbstractUnit unit0 = new Archer();
        AbstractUnit unit1 = new Archer();
        AbstractUnit unit2 = new Archer();
        AbstractUnit unit3 = new Archer();
        AbstractUnit unit4 = new Archer();
        squad.addImproved(unit0);
        squad.addImproved(unit1);
        squad.addImproved(unit2);
        squad.addImproved(unit3);
        squad.addImproved(unit4);
        assertThat(0, is(squad.getImprovedIndex(unit0)));
        assertThat(1, is(squad.getImprovedIndex(unit1)));
        assertThat(2, is(squad.getImprovedIndex(unit2)));
        assertThat(3, is(squad.getImprovedIndex(unit3)));
        assertThat(4, is(squad.getImprovedIndex(unit4)));
    }

    /**
     * Check work UnitNotFoundException.
     */
    @Test(expected = UnitNotFoundException.class)
    public void whenGetImprovedIndexThenUnitNotFoundException() {
        Squad squad = new Squad();
        AbstractUnit unit0 = new Archer();
        AbstractUnit unit1 = new Archer();
        AbstractUnit unit2 = new Archer();
        AbstractUnit unit3 = new Archer();
        AbstractUnit unit4 = new Archer();
        squad.addImproved(unit1);
        squad.addImproved(unit2);
        squad.addImproved(unit3);
        squad.addImproved(unit4);
        squad.getImprovedIndex(unit0);
    }

    /**
     * Check work getNormalIndex.
     */
    @Test
    public void whenGetNormalIndex() {
        Squad squad = new Squad();
        AbstractUnit unit0 = new Archer();
        AbstractUnit unit1 = new Archer();
        AbstractUnit unit2 = new Archer();
        AbstractUnit unit3 = new Archer();
        AbstractUnit unit4 = new Archer();
        squad.addNormal(unit0);
        squad.addNormal(unit1);
        squad.addNormal(unit2);
        squad.addNormal(unit3);
        squad.addNormal(unit4);
        assertThat(0, is(squad.getNormalIndex(unit0)));
        assertThat(1, is(squad.getNormalIndex(unit1)));
        assertThat(2, is(squad.getNormalIndex(unit2)));
        assertThat(3, is(squad.getNormalIndex(unit3)));
        assertThat(4, is(squad.getNormalIndex(unit4)));
    }

    /**
     * Check work UnitNotFoundException.
     */
    @Test(expected = UnitNotFoundException.class)
    public void whenGetNormalIndexThenUnitNotFoundException() {
        Squad squad = new Squad();
        AbstractUnit unit0 = new Archer();
        AbstractUnit unit1 = new Archer();
        AbstractUnit unit2 = new Archer();
        AbstractUnit unit3 = new Archer();
        AbstractUnit unit4 = new Archer();
        squad.addNormal(unit1);
        squad.addNormal(unit2);
        squad.addNormal(unit3);
        squad.addNormal(unit4);
        squad.getNormalIndex(unit0);
    }

    /**
     * Check work addImproved.
     */
    @Test
    public void whenAddImproved() {
        Squad squad = new Squad();
        AbstractUnit unit = new Mage();
        squad.addImproved(unit);
        assertThat(squad.getImprovedUnits()[0], is(unit));
        assertThat(true, is(unit.getImproved()));
    }

    /**
     * Check work addNormal.
     */
    @Test
    public void whenAddNormal() {
        Squad squad = new Squad();
        AbstractUnit unit = new Mage();
        squad.addNormal(unit);
        assertThat(squad.getNormalUnits()[0], is(unit));
    }

    /**
     * Check work checkSquadLive.
     */
    @Test
    public void whenCheckSquadLiveThenTrue() {
        Squad squad = new Squad();
        squad.addNormal(new Mage());
        assertThat(true, is(squad.checkSquadLive()));
    }

    /**
     * Check work checkSquadLive.
     */
    @Test
    public void whenCheckSquadLiveThenFalse() {
        Squad squad = new Squad();
        assertThat(false, is(squad.checkSquadLive()));
    }

    /**
     * Check work toNormal.
     */
    @Test
    public void whenToNormal() {
        Squad squad = new Squad();
        AbstractUnit unit = new Archer();
        squad.addImproved(new Warrior());
        squad.addImproved(unit);
        squad.addImproved(new Mage());
        squad.addImproved(new Archer());
        squad.toNormal(unit);
        assertThat(unit, is(squad.getNormalUnits()[0]));
        assertThat(null, is(squad.getImprovedUnits()[3]));
        assertThat(false, is(unit.getImproved()));
    }

    /**
     * Check work toImproved.
     */
    @Test
    public void whenToImproved() {
        Squad squad = new Squad();
        AbstractUnit unit = new Mage();
        squad.addNormal(new Mage());
        squad.addNormal(unit);
        squad.addNormal(new Mage());
        squad.toImproved(unit);
        assertThat(unit, is(squad.getImprovedUnits()[0]));
        assertThat(true, is(unit.getImproved()));
    }

    /**
     * Check work getSquad.
     */
    @Test
    public void whenGetSquad() {
        Squad squad = new Squad();
        AbstractUnit unit1 = new Mage();
        AbstractUnit unit2 = new Mage();
        AbstractUnit unit3 = new Mage();
        squad.addNormal(unit1);
        squad.addImproved(unit2);
        squad.addNormal(unit3);
        assertThat(unit2, is(squad.getSquad()[0]));
        assertThat(unit1, is(squad.getSquad()[1]));
        assertThat(unit3, is(squad.getSquad()[2]));
        assertThat(3, is(squad.getSquad().length));
    }

    /**
     * Check work getNormalUnits.
     */
    @Test
    public void whenGetNormalUnits() {
        Squad squad = new Squad();
        AbstractUnit unit1 = new Mage();
        AbstractUnit unit2 = new Mage();
        AbstractUnit unit3 = new Mage();
        squad.addNormal(unit1);
        squad.addImproved(unit2);
        squad.addNormal(unit3);
        assertThat(unit1, is(squad.getNormalUnits()[0]));
        assertThat(unit3, is(squad.getNormalUnits()[1]));
    }

    /**
     * Check work getImprovedUnits.
     */
    @Test
    public void whenGetImprovedUnits() {
        Squad squad = new Squad();
        AbstractUnit unit1 = new Mage();
        AbstractUnit unit2 = new Mage();
        AbstractUnit unit3 = new Mage();
        AbstractUnit unit4 = new Mage();
        squad.addNormal(unit1);
        squad.addImproved(unit2);
        squad.addNormal(unit3);
        squad.addImproved(unit4);
        assertThat(unit2, is(squad.getImprovedUnits()[0]));
        assertThat(unit4, is(squad.getImprovedUnits()[1]));
    }
}
