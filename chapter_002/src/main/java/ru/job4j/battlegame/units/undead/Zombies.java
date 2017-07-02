package ru.job4j.battlegame.units.undead;

import ru.job4j.battlegame.Squad;
import ru.job4j.battlegame.units.AbstractUnit;

import java.util.Random;

/**
 * Zombies.
 * @author Ruzhev Alexander
 * @since on 24.06.2017.
 */
public class Zombies extends AbstractUnit {
    /**
     * Zombie name.
     */
    private static final String NAME = "undead zombies";
    /**
     * Zombie damage.
     */
    private double damage = 18;

    /**
     * Constructor.
     */
    public Zombies() {
        super(NAME);
    }

    /**
     *  First attack.
     * @param unit attacked unit
     */
    @Override
    public void firstAction(AbstractUnit unit) {
        double realDamage = getImproved() ? damage * 1.5 / getDisease() : damage / getDisease();
        printToConsole(unit, realDamage, "attacks with spear");
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
     * @param lightSquad - ally squad
     * @param darkSquad - enemy squad
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
     * Create new clone zombies.
     *
     * @return new clone
     */
    @Override
    public AbstractUnit clone() {
        return new Zombies();
    }
}
