package ru.job4j.battlegame.units.orc;

import ru.job4j.battlegame.units.BaseRace;

/**
 * OrcRace.
 * @author Ruzhev Alexander
 * @since on 29.06.2017.
 */
public class OrcRace extends BaseRace {
    /**
     * Constructor.
     */
    public OrcRace() {
        super(new Shaman(), new Archer(), new Goblin());
    }
}
