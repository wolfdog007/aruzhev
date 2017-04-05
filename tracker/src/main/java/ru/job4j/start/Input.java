package ru.job4j.start;

/**
 * Interface.
 *
 * @author Ruzhev Alexander
 * @since 05.04.2017
 */
public interface Input {
    /**
     * Input answer.
     * @param question - question for users
     * @return answer
     */
    String ask(String question);
}

