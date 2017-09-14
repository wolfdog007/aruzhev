package ru.job4j.map4bank;

/**
 * Class model Account.
 *
 * @author Ruzhev Alexander
 * @since 22.08.2017
 */
public class Account {
    /**
     * Amount of money.
     */
    private double value;
    /**
     * Requisites account number.
     */
    private long requisites;

    /**
     * Constructor.
     *
     * @param value      - Amount of money
     * @param requisites - account number
     */
    public Account(double value, long requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Getter for value.
     * @return value
     */
    public double getValue() {
        return value;
    }

    /**
     * Getter for requisites.
     * @return requisites
     */
    public double getRequisites() {
        return requisites;
    }

    /**
     * Setter for value.
     * @param value amount of money
     */
    public void setValue(double value) {
        this.value = value;
    }
}
