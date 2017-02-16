package ru.job4j;

/**
 * Class Triangle.
 *
 * @author Ruzhev Alexander
 * @since 16.02.2017
 */
public class Triangle {
    /**
     * @param a an object of class Point
     */
    private Point a;
    /**
     * @param b an object of class Point
     */
    private Point b;
    /**
     * @param c an object of class Point
     */
    private Point c;

    /**
     * Getter for a.
     *
     * @return a
     */
    public Point getA() {
        return this.a;
    }

    /**
     * Getter for b.
     *
     * @return b
     */
    public Point getB() {
        return this.b;
    }

    /**
     * Getter for c.
     *
     * @return c
     */
    public Point getC() {
        return this.c;
    }

    /**
     * Designer.
     *
     * @param a an object of class Point
     * @param b an object of class Point
     * @param c an object of class Point
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Return the distance between two points.
     *
     * @param ab distance between points a and b
     * @param ac distance between points a and c
     * @param bc distance between points b and c
     * @return Triangle will be constructed? boolean
     */
    private boolean checkIsTriangle(double ab, double ac, double bc) {
        return (ab + ac > bc) && (ab + bc > ac) && (ac + bc > ab);
    }

    /**
     * Return the getTriangleArea of a triangle if construct triangle is possible. Else returns -1.
     *
     * @return result
     */
    public double getTriangleArea() {
        double result = -1;
        double ab = a.distanceTo(b);
        double bc = b.distanceTo(c);
        double ac = a.distanceTo(c);
        if (checkIsTriangle(ab, bc, ac)) {
            double properiter = (ab + ac + bc) / 2;
            result = Math.sqrt(properiter * (properiter - ab) * (properiter - ac) * (properiter - bc));
        }
        return result;
    }
}