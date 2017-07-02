package ru.job4j.battlegame.units;

/**
 * BaseRace.
 * @author Ruzhev Alexander
 * @since  29.06.2017.
 */
public abstract class BaseRace {
    /**
     * Unite mage.
     */
    private AbstractUnit mage;
    /**
     * Unit archer.
     */
    private AbstractUnit archer;
    /**
     * Unit Warrior.
     */
    private AbstractUnit warrior;

    /**
     * Constructor.
     *
     * @param mage    unit mage
     * @param archer  unit archer
     * @param warrior unit warrior
     */
    public BaseRace(AbstractUnit mage, AbstractUnit archer, AbstractUnit warrior) {
        this.mage = mage;
        this.archer = archer;
        this.warrior = warrior;
    }

    /**
     * Getter for mage.
     *
     * @return mage
     */
    public AbstractUnit getMage() {
        return mage;
    }

    /**
     * Getter for archer.
     *
     * @return archer
     */
    public AbstractUnit getArcher() {
        return archer;
    }

    /**
     * Getter for warrior.
     *
     * @return warrior
     */
    public AbstractUnit getWarrior() {
        return warrior;
    }
}
