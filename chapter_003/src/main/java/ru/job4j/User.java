package ru.job4j;

/**
 * Contains info for user.
 *
 * @author Ruzhev Alexander
 * @since 26.07.2017
 */
public class User {
    /**
     * User id.
     */
    private int id;
    /**
     * User name.
     */
    private String name;
    /**
     * User city.
     */
    private String city;

    /**
     * Constructor.
     *
     * @param id   is int
     * @param name is String
     * @param city is String
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Getter for user id.
     *
     * @return user id
     */
    public int getId() {
        return id;
    }
}
