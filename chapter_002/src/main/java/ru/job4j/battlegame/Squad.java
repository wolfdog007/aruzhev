package ru.job4j.battlegame;

import ru.job4j.battlegame.exception.UnitNotFoundException;
import ru.job4j.battlegame.units.AbstractUnit;
import ru.job4j.battlegame.utils.Log;

import java.util.Random;

/**
 * Squad.
 *
 * @author Ruzhev Alexander
 * @since 24.06.2017.
 */
public class Squad {
    /**
     * Normal group.
     */
    private AbstractUnit[] normalUnits = new AbstractUnit[8];
    /**
     * Improved group.
     */
    private AbstractUnit[] improvedUnits = new AbstractUnit[8];
    /**
     * Normal group index.
     */
    private int normalIndex = 0;
    /**
     * Improved group index.
     */
    private int improvedIndex = 0;

    /**
     * Method searches the selected unit in improved group and return index.
     *
     * @param unit - chosen unit
     * @return - unit index
     */
    public int getImprovedIndex(AbstractUnit unit) {
        int index;
        boolean flag = true;
        for (index = 0; index < improvedIndex; index++) {
            if (improvedUnits[index].equals(unit)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            throw new UnitNotFoundException("Unit not found in improved class");
        }
        return index;
    }

    /**
     * Method searches the selected unit in normal group and return index.
     *
     * @param unit - chosen unit
     * @return - unit index
     */
    public int getNormalIndex(AbstractUnit unit) {
        int index;
        boolean flag = true;
        for (index = 0; index < normalIndex; index++) {
            if (normalUnits[index].equals(unit)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            throw new UnitNotFoundException("Unit not found in normal class");
        }
        return index;
    }

    /**
     * Method add the selected unit in improved group.
     *
     * @param unit chosen unit.
     */
    public void addImproved(AbstractUnit unit) {
        if (improvedIndex < 8) {
            improvedUnits[improvedIndex++] = unit;
            unit.setImproved(true);
        } else {
            Log.printInfo(String.format("list of improved units full%s", System.lineSeparator()));
        }
    }

    /**
     * Method add the selected unit in normal group.
     *
     * @param unit chosen unit.
     */
    public void addNormal(AbstractUnit unit) {
        if (normalIndex < 8) {
            normalUnits[normalIndex++] = unit;
            unit.setImproved(false);
        } else {
            Log.printInfo(String.format("list of normal units full%s", System.lineSeparator()));
        }
    }

    /**
     * Method delete the selected unit out improved group.
     *
     * @param unit chosen unit.
     */
    private void deleteNormal(AbstractUnit unit) {
        if (normalIndex > 0) {
            int index = getNormalIndex(unit);
            System.arraycopy(normalUnits, index + 1, normalUnits, index, normalUnits.length - index - 1);
            normalIndex--;
        } else {
            Log.printInfo(String.format("no normal units%s", System.lineSeparator()));
        }
    }

    /**
     * Method delete the selected unit out normal group.
     *
     * @param unit chosen unit.
     */
    private void deleteImproved(AbstractUnit unit) {
        if (improvedIndex > 0) {
            int index = getImprovedIndex(unit);
            System.arraycopy(improvedUnits, index + 1, improvedUnits, index, improvedUnits.length - index - 1);
            improvedIndex--;
        } else {
            Log.printInfo(String.format("no improved units%s", System.lineSeparator()));
        }
    }

    /**
     * Method delete the dead unit.
     */
    private void deleteDead() {
        for (int index = 0; index < improvedIndex; index++) {
            if (improvedUnits[index].getHealthPoints() <= 0) {
                deleteImproved(improvedUnits[index]);
            }
        }
        for (int index = 0; index < normalIndex; index++) {
            if (normalUnits[index].getHealthPoints() <= 0) {
                deleteNormal(normalUnits[index]);
            }
        }
    }

    /**
     * Check squad live.
     *
     * @return true or false
     */
    public boolean checkSquadLive() {
        boolean flag = true;
        if (normalIndex == 0 && improvedIndex == 0) {
            flag = false;
        }
        return flag;
    }

    /**
     * Replace unit to normal group.
     *
     * @param unit - chosen unit
     */
    public void toNormal(AbstractUnit unit) {
        int index = getImprovedIndex(unit);
        addNormal(improvedUnits[index]);
        deleteImproved(improvedUnits[index]);
    }

    /**
     * Replace unit to improved group.
     *
     * @param unit - chosen unit
     */
    public void toImproved(AbstractUnit unit) {
        int index = getNormalIndex(unit);
        addImproved(normalUnits[index]);
        deleteNormal(normalUnits[index]);
    }

    /**
     * return all units.
     *
     * @return all units array
     */
    public AbstractUnit[] getSquad() {
        int length = normalIndex + improvedIndex;
        AbstractUnit[] allUnits = new AbstractUnit[length];
        for (int i = 0; i < improvedIndex; i++) {
            allUnits[i] = improvedUnits[i];
        }
        for (int i = 0; i < normalIndex; i++) {
            allUnits[i + improvedIndex] = normalUnits[i];
        }
        return allUnits;
    }

    /**
     * Getter for normal units array.
     *
     * @return normal units array
     */
    public AbstractUnit[] getNormalUnits() {
        return normalUnits;
    }

    /**
     * Getter for improved units array.
     *
     * @return improved units array
     */
    public AbstractUnit[] getImprovedUnits() {
        return improvedUnits;
    }

    /**
     * Search improved units.
     */
    private void checkImproved() {
        for (int index = 0; index < normalIndex; index++) {
            if (normalUnits[index].getImproved()) {
                toImproved(normalUnits[index]);
            }
        }
        for (int index = 0; index < improvedIndex; index++) {
            if (!improvedUnits[index].getImproved()) {
                toNormal(improvedUnits[index]);
            }
        }
    }

    /**
     * Select random unit, improved group is first.
     *
     * @param squad - enemy squad
     */
    public void goToRandomUnit(Squad squad) {
        Random random = new Random();
        checkImproved();
        if (improvedIndex > 0) {
            int rndIndex = random.nextInt(improvedIndex);
            Log.printInfo(String.format("improved attack%s", System.lineSeparator()));
            improvedUnits[rndIndex].randomAction(this, squad);
            toNormal(improvedUnits[rndIndex]);
            squad.deleteDead();
        } else {
            Log.printInfo(String.format("normal attack%s", System.lineSeparator()));
            normalUnits[random.nextInt(normalIndex)].randomAction(this, squad);
            squad.deleteDead();
        }
    }

    /**
     * Getter for normalIndex.
     *
     * @return normalIndex
     */
    public int getNormalIndex() {
        return normalIndex;
    }

    /**
     * Getter for improvedIndex.
     *
     * @return improvedIndex
     */
    public int getImprovedIndex() {
        return improvedIndex;
    }
}
