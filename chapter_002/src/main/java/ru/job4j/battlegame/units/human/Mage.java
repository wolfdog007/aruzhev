package ru.job4j.battlegame.units.human;

import ru.job4j.battlegame.Squad;
import ru.job4j.battlegame.units.AbstractUnit;


import java.util.Random;

/**
 * Mage.
 *
 * @author Ruzhev Alexander
 * @since on 24.06.2017.
 */
public class Mage extends AbstractUnit {
    /**
     * Name.
     */
    private static final String NAME = "human mage";
    /**
     * Damage in magic.
     */
    private double damage = 4;

    /**
     * Constructor.
     */
    public Mage() {
        super(NAME);
    }

    /**
     * First spell - improved units.
     *
     * @param unit improved unit
     */
    @Override
    public void firstAction(AbstractUnit unit) {
        printToConsole(unit, "cast improvement");
        unit.setImproved(true);
    }

    /**
     * Second - magic attack.
     *
     * @param unit attacked unit
     */
    @Override
    public void secondAction(AbstractUnit unit) {
        double realDamage = getImproved() ? damage * 1.5 / getDisease() : damage / getDisease();
        printToConsole(unit, realDamage, "attacks with magic");
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
            if (lightSquad.getNormalIndex() > 0) {
                AbstractUnit objAction = lightSquad.getNormalUnits()[random.nextInt(lightSquad.getNormalIndex())];
                firstAction(objAction);
            } else {
                System.out.println("spell break");
            }
        } else {
            AbstractUnit objAction = darkSquad.getSquad()[random.nextInt(darkSquad.getSquad().length)];
            secondAction(objAction);
        }
    }

    /**
     * Create new clone mage.
     *
     * @return new clone
     */
    @Override
    public AbstractUnit clone() {
        return new Mage();
    }


}
