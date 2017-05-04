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
     * Constructor.
     *
     * @param name - BaseAction name
     */
    public BaseAction(String name) {
        this.name = name;
    }

    /**
     * The key request from the user.
     *
     * @return the action to be performed
     */
    public abstract int key();

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
