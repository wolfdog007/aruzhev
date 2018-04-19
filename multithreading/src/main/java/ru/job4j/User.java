package ru.job4j;

/**
 * The class User - model for storage.
 *
 * @author Ruzhev Alexander
 * @since 13.04.2018
 */
public class User {
    /**
     * user id.
     */
    private int id;
    /**
     * user amount.
     */
    private int amount;

    /**
     * Construcnor.
     *
     * @param id     - user id
     * @param amount - user amount
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Getter for id.
     *
     * @return - id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for amount.
     *
     * @return - amount
     */
    public int getAmount() {
        return amount;
    }
}
