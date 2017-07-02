package ru.job4j.battlegame.units.elf;

import ru.job4j.battlegame.Squad;
import ru.job4j.battlegame.units.AbstractUnit;

import java.util.Random;

/**
 * Archer.
 *
 * @author Ruzhev Alexander
 * @since on 24.06.2017.
 */
public class Archer extends AbstractUnit {
    /**
     * Name.
     */
    private static final String NAME = "elven Archer";
    /**
     * Melee damage.
     */
    private double damage = 3;
    /**
     * Range damage.
     */
    private double rangeDamage = 7;

    /**
     * Constructor.
     */
    public Archer() {
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
        printToConsole(unit, realDamage, "shoots with bow");
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
        printToConsole(unit, realDamage, "Attacks the enemy");
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
     * Create new clone archer.
     *
     * @return new clone
     */
    @Override
    public AbstractUnit clone() {
        return new Archer();
    }
}
