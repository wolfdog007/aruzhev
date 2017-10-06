package ru.job4j.generics;

/**
 * Class contains id.
 * @author Ruzhev Alexander
 * @since 06.10.2017
 */
public abstract class Base {
    /**
     * Id for user.
     */
    private String id;

    /**
     * Constructor.
     * @param id for user
     */
    Base(String id) {
        this.id = id;
    }

    /**
     * Getter for id.
     * @return id
     */
    String getId() {
        return id;
    }

    /**
     * Setter for id.
     * @param id new id for user
     */
    public void setId(String id) {
        this.id = id;
    }
}
