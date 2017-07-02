package ru.job4j.battlegame.units.human;

import ru.job4j.battlegame.units.BaseRace;

/**
 * HumanRace.
 * @author Ruzhev Alexander
 * @since on 29.06.2017.
 */
public class HumanRace extends BaseRace {
    /**
     * Constructor.
     */
    public HumanRace() {
        super(new Mage(), new Crossbowman(), new Warrior());
    }
}
