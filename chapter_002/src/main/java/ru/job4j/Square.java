package ru.job4j;

/**
 * Draw shape square.
 *
 * @author Ruzhev Alexander
 * @since 17.04.2017
 */
public class Square implements Shape {
    /**
     * Creates a square.
     * @param height - height of shape
     * @return string
     */
    public String pic(int height) {
        StringBuilder line = new StringBuilder();
        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < height; i++) {
            line.append("*");
            if (i + 1 < height) {
                line.append(" ");
            }
        }
        for (int level = 0; level < height; level++) {
            sB.append(line);
            sB.append(System.lineSeparator());
        }
        return sB.toString();
    }
}