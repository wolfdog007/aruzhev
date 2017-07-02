package ru.job4j.battlegame.units.elf;

import ru.job4j.battlegame.units.BaseRace;

/**
 * ElvenRace.
 *
 * @author Ruzhev Alexander
 * @since on 29.06.2017.
 */
public class ElvenRace extends BaseRace {
    /**
     * Constructor.
     */
    public ElvenRace() {
        super(new Mage(), new Archer(), new Warrior());
    }
}
