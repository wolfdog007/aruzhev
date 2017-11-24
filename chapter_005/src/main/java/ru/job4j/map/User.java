package ru.job4j.map;

import java.util.Calendar;

/**
 * The class User - model for storage.
 *
 * @author Ruzhev Alexander
 * @since 24.11.2017
 */
public class User {
    /**
     * The user name.
     */
    private String name;
    /**
     * The count of children.
     */
    private int children;
    /**
     * The date of birth.
     */
    private Calendar birthday;

    /**
     * The constructor for class User.
     *
     * @param name     - name user
     * @param children - count children
     * @param birthday - date birthday
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
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
     * Setter for name.
     *
     * @param name - user name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for Children.
     *
     * @return children
     */
    public int getChildren() {
        return children;
    }

    /**
     * Setter for children.
     *
     * @param children count children
     */
    public void setChildren(int children) {
        this.children = children;
    }

    /**
     * Getter for birthday.
     *
     * @return birthday
     */
    public Calendar getBirthday() {
        return birthday;
    }

    /**
     * Setter for birthday.
     *
     * @param birthday - date birthday
     */
    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }
}
