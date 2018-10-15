package ru.job4j.lift;

import java.util.Scanner;

/**
 * @author Ruzhev Alexander
 * @since 10.09.2018
 */
public class Input {
    /**
     * The object work with console.
     */
    private Scanner scan = new Scanner(System.in);

    /**
     * The method read console and return value type int.
     *
     * @param max - maximum floors
     * @param min - min floors
     * @return - value type int
     */
    public int ask(int max, int min) {
        int result = Integer.parseInt(this.scan.nextLine().trim());
        if (result > max) {
            throw new IncorrectFloorException("Error: Incorrect range");
        }
        return result;
    }
}
