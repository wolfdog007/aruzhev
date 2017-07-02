package ru.job4j.battlegame.units.undead;

import ru.job4j.battlegame.units.BaseRace;

/**
 * UndeadRace.
 * @author Ruzhev Alexander
 * @since on 29.06.2017.
 */
public class UndeadRace extends BaseRace {
    /**
     * Constructor.
     */
    public UndeadRace() {
        super(new Necromancer(), new Hunter(), new Zombies());
    }
}
