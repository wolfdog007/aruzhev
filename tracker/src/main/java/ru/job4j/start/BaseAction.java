package ru.job4j.start;

/**
 * Created by wolfdog on 03.05.2017.
 */
public abstract class BaseAction implements UserAction {
    /**
     * BaseAction name.
     */
    private String name;
    /**
     * key operation.
     */
    private int key;

    /**
     * /**
     * Constructor.
     *
     * @param name - BaseAction name
     * @param key - key operation
     */
    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }

    /**
     * The key request from the user.
     *
     * @return the action to be performed
     */
    public int key() {
        return this.key;
    }

    /**
     * The method takes the selected action.
     *
     * @param input   data input interface
     * @param tracker base class
     */
    public abstract void execute(Input input, Tracker tracker);

    /**
     * @return information on the work method
     */
    public String info() {
        return String.format("%s. %s", key(), this.name);
    }
}
