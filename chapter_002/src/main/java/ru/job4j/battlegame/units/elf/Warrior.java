package ru.job4j.battlegame.units.elf;

import ru.job4j.battlegame.Squad;
import ru.job4j.battlegame.units.AbstractUnit;

import java.util.Random;

/**
 * Warrior.
 *
 * @author Ruzhev Alexander
 * @since on 24.06.2017.
 */
public class Warrior extends AbstractUnit {
    /**
     * Name.
     */
    private static final String NAME = "elven warrior";
    /**
     * Damage.
     */
    private double damage = 15;

    /**
     * Constructor.
     */
    public Warrior() {
        super(NAME);
    }

    /**
     * First attack.
     *
     * @param unit attacked unit
     */
    @Override
    public void firstAction(AbstractUnit unit) {
        double realDamage = getImproved() ? damage * 1.5 / getDisease() : damage / getDisease();
        printToConsole(unit, realDamage, "Attacks with a sword");
        unit.toDamage(realDamage);
        if (getDisease() != 1) {
            toDisease();
        }
    }

    /**
     * Second attack - jump to first attack.
     *
     * @param unit attacked unit
     */
    @Override
    public void secondAction(AbstractUnit unit) {
        firstAction(unit);
    }

    /**
     * Select random action.
     *
     * @param lightSquad - ally squad
     * @param darkSquad  - enemy squad
     */
    @Override
    public void randomAction(Squad lightSquad, Squad darkSquad) {
        Random random = new Random();
        if (random.nextInt(50) < 25) {
            AbstractUnit objAction = darkSquad.getSquad()[random.nextInt(darkSquad.getSquad().length)];
            firstAction(objAction);
        } else {
            AbstractUnit objAction = darkSquad.getSquad()[random.nextInt(darkSquad.getSquad().length)];
            secondAction(objAction);
        }
    }

    /**
     * Create new clone warrior.
     *
     * @return new clone
     */
    @Override
    public AbstractUnit clone() {
        return new Warrior();
    }
}
