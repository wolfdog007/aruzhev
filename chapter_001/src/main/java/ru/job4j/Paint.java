package ru.job4j;

/**
 * Class Paint - constuct Piramid in String.
 *
 * @author Ruzhev Alexander
 * @since 20.02.2017
 */
public class Paint {
    /**
     * Returns string containing the pyramid.
     *
     * @param height - height piramid
     * @return String - piramidStrBldr.toString
     */
    public String piramid(int height) {
        StringBuilder piramidStrBldr = new StringBuilder();
        for (int level = 0; level < height; level++) {
            for (int i = 1; i < height - level; i++) {
                piramidStrBldr.append(" ");
            }
            for (int i = 0; i <= level << 1; i++) {
                piramidStrBldr.append("^");
            }
            piramidStrBldr.append(System.lineSeparator());
        }
        return piramidStrBldr.toString();
    }
}
