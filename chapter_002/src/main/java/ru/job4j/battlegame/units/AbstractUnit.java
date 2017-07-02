package ru.job4j.battlegame.units;

import ru.job4j.battlegame.Squad;
import ru.job4j.battlegame.utils.Log;

/**
 * AbstractUnit.
 *
 * @author Ruzhev Alexander
 * @since 24.06.2017.
 */
public abstract class AbstractUnit {
    /**
     * Name.
     */
    private String name;
    /**
     * Heal points.
     */
    private double healthPoints = 100;
    /**
     * the state of alive or dead.
     */
    private boolean live = true;
    /**
     * State of disease.
     */
    private int disease = 1;
    /**
     * State of improved.
     */
    private boolean improved = false;

    /**
     * Constructor.
     *
     * @param name - unit name
     */
    public AbstractUnit(String name) {
        this.name = name;
    }

    /**
     * First attack.
     *
     * @param unit attacked unit
     */
    public abstract void firstAction(AbstractUnit unit);

    /**
     * Second attack.
     *
     * @param unit attacked unit
     */
    public abstract void secondAction(AbstractUnit unit);

    /**
     * Getter to healthPoints.
     *
     * @return healthPoints
     */
    public double getHealthPoints() {
        return healthPoints;
    }

    /**
     * The method reduces the healthPoints and check for death.
     *
     * @param damage - the amount of damage
     */
    public void toDamage(double damage) {
        this.healthPoints -= damage;
        if (this.healthPoints <= 0) {
            this.live = false;
            Log.printInfo(String.format("%s - is dead%s", name, System.lineSeparator()));
        }
    }

    /**
     * Manages the state of the disease.
     */
    public void toDisease() {
        if (disease == 1) {
            disease = 2;
            Log.printInfo(String.format("%s cursed attack -50%s", name, System.lineSeparator()));
        } else {
            Log.printInfo(String.format("%s curse is broken%s", name, System.lineSeparator()));
            disease = 1;
        }
    }

    /**
     * Getter for improved field.
     *
     * @return improved
     */
    public boolean getImproved() {
        return improved;
    }

    /**
     * Setter for improved field.
     *
     * @param improved true or false
     */
    public void setImproved(boolean improved) {
        this.improved = improved;
    }

    /**
     * Print action to console.
     *
     * @param objAction  - aim
     * @param realDamage - calculated damage
     * @param actionName - description
     */
    public void printToConsole(AbstractUnit objAction, double realDamage, String actionName) {
        Log.printInfo(String.format("%s(%s) %s %s(%s) damage - %s%s", this.getName(), this.getHealthPoints(), actionName, objAction.getName(), objAction.getHealthPoints(), realDamage, System.lineSeparator()));
    }

    /**
     * Print action to console.
     *
     * @param objAction  - aim
     * @param actionName - description
     */
    public void printToConsole(AbstractUnit objAction, String actionName) {
        Log.printInfo(String.format("%s(%s) %s %s(%s)%s", this.getName(), this.getHealthPoints(), actionName, objAction.getName(), objAction.getHealthPoints(), System.lineSeparator()));
    }

    /**
     * Create clone.
     *
     * @return - new unit
     */
    public abstract AbstractUnit clone();

    /**
     * Getter for disease.
     *
     * @return disease
     */
    public int getDisease() {
        return disease;
    }

    /**
     * Getter for name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Select random action.
     *
     * @param ally  - ally squad.
     * @param enemy - enemy squad
     */
    public abstract void randomAction(Squad ally, Squad enemy);

}
