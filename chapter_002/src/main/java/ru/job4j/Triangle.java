package ru.job4j;

/**
 * Draw shape triangle.
 *
 * @author Ruzhev Alexander
 * @since 17.04.2017
 */
public class Triangle implements Shape {
    /**
     * Creates a triangle.
     * @param height - height of shape
     * @return string
     */
    public String pic(int height) {
        StringBuilder sB = new StringBuilder();
        for (int level = 0; level < height; level++) {
            for (int i = 1; i < height - level; i++) {
                sB.append(" ");
            }
            for (int i = 0; i <= level << 1; i++) {
                sB.append("^");
            }
            sB.append(System.lineSeparator());
        }
        return sB.toString();
    }
}
