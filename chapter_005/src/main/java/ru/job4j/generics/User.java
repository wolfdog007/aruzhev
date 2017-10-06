package ru.job4j.generics;

/**
 * Class contains the name for the user.
 * @author Ruzhev Alexander
 * @since 06.10.2017
 */
public class User extends Base {
    /**
     * User name.
     */
    private String name;

    /**
     * Constructor.
     * @param id for user
     * @param name user name
     */
    User(String id, String name) {
        super(id);
        this.name = name;
    }

    /**
     * Getter for name.
     * @return user name
     */
    public String getName() {
        return name;
    }
}
