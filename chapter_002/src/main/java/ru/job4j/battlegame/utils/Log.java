package ru.job4j.battlegame.utils;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Log.
 *
 * @author Ruzhev Alexander
 * @since 02.07.2017
 */
public class Log {
    /**
     * Description for history console.
     */
    private static String msg;

    /**
     * print no console and save description msg.
     *
     * @param text - desc
     */
    public static void printInfo(String text) {
        msg = msg + text;
        System.out.printf(text);
    }

    /**
     * Write msg to file.
     */
    public static void writeLog() {
        System.out.print(msg);
        try (FileWriter writer = new FileWriter("log.txt", false)) {
            writer.write(msg);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
