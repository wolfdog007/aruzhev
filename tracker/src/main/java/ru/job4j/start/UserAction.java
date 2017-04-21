package ru.job4j.start;

/**
 * Interface for menu tracker.
 *
 * @author Ruzhev Alexander
 * @since 19.04.2017
 */
public interface UserAction {
    /**
     * The key request from the user.
     *
     * @return the action to be performed
     */
    int key();

    /**
     * The method takes the selected action.
     *
     * @param input   data input interface
     * @param tracker base class
     */
    void execute(Input input, Tracker tracker);

    /**
     * @return information on the work method
     */
    String info();
}
