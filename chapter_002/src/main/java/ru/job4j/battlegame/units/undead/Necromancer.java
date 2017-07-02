package ru.job4j.battlegame.units.undead;

import ru.job4j.battlegame.Squad;
import ru.job4j.battlegame.units.AbstractUnit;

import java.util.Random;

/**
 * Necromancer.
 *
 * @author Ruzhev Alexander
 * @since on 24.06.2017.
 */
public class Necromancer extends AbstractUnit {
    /**
     * Name.
     */
    private static final String NAME = "undead necromancer";
    /**
     * Damage in magic.
     */
    private double damage = 5;

    /**
     * Constructor.
     */
    public Necromancer() {
        super(NAME);
    }

    /**
     * First spell - curse.
     *
     * @param unit attacked unit
     */
    @Override
    public void firstAction(AbstractUnit unit) {
        System.out.printf("%s curse!%s", getName(), System.lineSeparator());
        unit.toDisease();
    }

    /**
     * Second attack - magic damage.
     *
     * @param unit attacked unit
     */
    @Override
    public void secondAction(AbstractUnit unit) {
        double realDamage = getImproved() ? damage * 1.5 / getDisease() : damage / getDisease();
        printToConsole(unit, realDamage, "magic attack");
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
     * Create new clone necromancer.
     *
     * @return new clone
     */
    @Override
    public AbstractUnit clone() {
        return new Necromancer();
    }
}
