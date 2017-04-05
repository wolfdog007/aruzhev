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
     * @param question - question for users
     * @return answer
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
