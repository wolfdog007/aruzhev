package ru.job4j.map4bank;

/**
 * Class contains user model.
 *
 * @author Ruzhev Alexander
 * @since 22.08.2017
 */
public class User {
    /**
     * User name.
     */
    private String name;
    /**
     * User passport.
     */
    private String passport;

    /**
     * Constructor.
     *
     * @param name     - user name.
     * @param passport - user passport.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        Boolean result = false;
        if (!(o == null || getClass() != o.getClass())) {
            User user = (User) o;
            result = passport.equals(user.passport);
        }
        return result;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result += (name == null ? 0 : name.hashCode());
        result += (passport == null ? 0 : passport.hashCode());
        return result;
    }
}
