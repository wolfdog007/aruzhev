package ru.job4j.start;

import java.util.Scanner;

/**
 * interface implementation.
 *
 * @author Ruzhev Alexander
 * @since 05.04.2017
 */
public class ConsoleInput implements Input {
    /**
     * The "standard" input stream.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Ask for users.
     *
     * @param question - question for users
     * @return answer
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Ask for user and validate range.
     * @param question - question for users
     * @param range - the range of answers
     * @return answer
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
