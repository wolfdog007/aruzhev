package ru.job4j.battlegame.units.orc;

import ru.job4j.battlegame.Squad;
import ru.job4j.battlegame.units.AbstractUnit;

import java.util.Random;

/**
 * Goblin.
 * @author Ruzhev Alexander
 * @since on 24.06.2017.
 */
public class Goblin extends AbstractUnit {
    /**
     * Name.
     */
    private static final String NAME = "orc goblin";
    /**
     * Melee damage.
     */
    private double damage = 20;

    /**
     * Constructor.
     */
    public Goblin() {
        super(NAME);
    }

    /**
     *  First attack.
     * @param unit attacked unit
     */
    @Override
    public void firstAction(AbstractUnit unit) {
        double realDamage = getImproved() ? damage * 1.5 / getDisease() : damage / getDisease();
        printToConsole(unit, realDamage, "Attacks with a club");
        unit.toDamage(realDamage);
        if (getDisease() != 1) {
            toDisease();
        }
    }

    /**
     * Second attack - jump to first attack.
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
     * Create new clone goblin.
     * @return new clone
     */
    @Override
    public AbstractUnit clone() {
        return new Goblin();
    }
}
