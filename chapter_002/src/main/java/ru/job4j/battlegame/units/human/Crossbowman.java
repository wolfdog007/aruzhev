package ru.job4j.battlegame.units.human;

import ru.job4j.battlegame.Squad;
import ru.job4j.battlegame.units.AbstractUnit;

import java.util.Random;

/**
 * CrossBowman.
 *
 * @author Ruzhev Alexander
 * @since on  24.06.2017.
 */
public class Crossbowman extends AbstractUnit {
    /**
     * Name.
     */
    private static final String NAME = "human crossbow";
    /**
     * Melee damage.
     */
    private double damage = 3;
    /**
     * Range Damage.
     */
    private double rangeDamage = 5;

    /**
     * Constructor.
     */
    public Crossbowman() {
        super(NAME);
    }

    /**
     * First - range attack.
     *
     * @param unit attacked unit
     */
    @Override
    public void firstAction(AbstractUnit unit) {
        double realDamage = getImproved() ? rangeDamage * 1.5 / getDisease() : rangeDamage / getDisease();
        printToConsole(unit, realDamage, "attack with crossbow");
        unit.toDamage(realDamage);
        if (getDisease() != 1) {
            toDisease();
        }
    }

    /**
     * Second - melee attack.
     *
     * @param unit attacked unit
     */
    @Override
    public void secondAction(AbstractUnit unit) {
        double realDamage = getImproved() ? damage * 1.5 / getDisease() : damage / getDisease();
        printToConsole(unit, realDamage, "attacks");
        unit.toDamage(realDamage);
        if (getDisease() != 1) {
            toDisease();
        }
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
     * Create new clone crossbowman.
     *
     * @return new clone
     */
    @Override
    public AbstractUnit clone() {
        return new Crossbowman();
    }
}
