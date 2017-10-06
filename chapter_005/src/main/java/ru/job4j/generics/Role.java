package ru.job4j.generics;

/**
 * Class contains the role for the user.
 * @author Ruzhev Alexander
 * @since 06.10.2017
 */
public class Role extends Base {
    /**
     * The role for user.
     */
    private String role;

    /**
     * Constructor.
     * @param id for user
     * @param role for user
     */
     Role(String id, String role) {
        super(id);
        this.role = role;
    }

    /**
     * Getter for role.
     * @return user role
     */
    public String getRole() {
        return role;
    }
}
