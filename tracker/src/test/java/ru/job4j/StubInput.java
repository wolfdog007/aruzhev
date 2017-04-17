package ru.job4j;

import ru.job4j.start.Input;

/**
 * Implements stub class with users input.
 *
 * @author Ruzhev Alexander
 * @since 17.04.2017
 */
public class StubInput implements Input {
    /**
     * Array of user answers.
     */
    private String[] answers;
    /**
     * Counter in array answers.
     */
    private int position = 0;

    /**
     * Constructor.
     * @param answers array of answers.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * User acnion.
     * @param question - question for users
     * @return the current action
     */
    public String ask(String question) {
        return answers[position++];
    }
}
