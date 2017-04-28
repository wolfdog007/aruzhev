package ru.job4j.start;

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
     *
     * @param answers array of answers.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * User acnion.
     *
     * @param question - question for users
     * @return the current action
     */
    public String ask(String question) {
        return answers[position++];
    }

    /**
     * Validate question.
     * @param question - question for users
     * @param range - the range of answers
     * @return UnsupportedOperationException
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}
