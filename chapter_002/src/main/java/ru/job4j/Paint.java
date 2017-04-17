package ru.job4j;

/**
 * Draw shape.
 *
 * @author Ruzhev Alexander
 * @since 17.04.2017
 */
public class Paint {
    /**
     * Stores figure.
     */
    private Shape shape;

    /**
     * Constructor.
     * @param shape - the selected figure
     */
    public Paint(Shape shape) {
        this.shape = shape;
    }

    /**
     * Draw the selected figure.
     * @param height - height of shape
     */
    public void draw(int height) {
        System.out.print(shape.pic(height));
    }
}
