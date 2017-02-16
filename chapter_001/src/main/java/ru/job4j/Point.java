package ru.job4j;

/**
 * Class Point.
 *
 * @author Ruzhev Alexander
 * @since 16.02.2017
 */
public class Point {
    /**
     * @param x a point of coordinates
     */
    private double x;
    /**
     * @param y a point of coordinates
     */
    private double y;

    /**
     * Getter for x.
     *
     * @return x
     */
    public double getX() {
        return this.x;
    }

    /**
     * Getter for y.
     *
     * @return y
     */
    public double getY() {
        return this.y;
    }

    /**
     * Designer.
     *
     * @param x a point of coordinates
     * @param y a point of coordinates
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Return the distance between two points.
     *
     * @param point an object of class Point
     * @return the distance between two points
     */
    public double distanceTo(Point point) {
        return Math.sqrt(Math.pow(this.x - point.getX(), 2) + Math.pow(this.y - point.getY(), 2));
    }
}
