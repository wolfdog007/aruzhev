package ru.job4j.sorting;

/**
 * @author Ruzhev Alexander
 * @since 02.08.2017
 */
public class User implements Comparable {
    /**
     * User name.
     */
    private String name;
    /**
     * User age.
     */
    private int age;

    /**
     * Constructor.
     *
     * @param name user name
     * @param age  user age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Getter for age.
     * @return age.
     */
    public int getAge() {
        return age;
    }

    /**
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        return this.age - user.getAge();
    }
}
