package ru.job4j.battlegame.units.orc;

import ru.job4j.battlegame.Squad;
import ru.job4j.battlegame.units.AbstractUnit;

import java.util.Random;

/**
 * Shaman.
 *
 * @author Ruzhev Alexander
 * @since on  24.06.2017.
 */
public class Shaman extends AbstractUnit {
    /**
     * Name.
     */
    private static final String NAME = "orc shaman";

    /**
     * Constructor.
     */
    public Shaman() {
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
     * Second spell - relieves improve.
     *
     * @param unit - relieves improved unit
     */
    @Override
    public void secondAction(AbstractUnit unit) {
        printToConsole(unit, "relieves improve");
        unit.setImproved(false);

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
            if (darkSquad.getImprovedIndex() > 0) {
                AbstractUnit objAction = darkSquad.getImprovedUnits()[random.nextInt(darkSquad.getImprovedIndex())];
                secondAction(objAction);
            }
        }
    }

    /**
     * Create new clone shaman.
     *
     * @return new clone
     */
    @Override
    public AbstractUnit clone() {
        return new Shaman();
    }
}
