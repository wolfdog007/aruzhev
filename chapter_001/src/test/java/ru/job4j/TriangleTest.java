package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class TriangleTest check work class Triangle.
 *
 * @author Ruzhev Alexander
 * @since 16.02.2017
 */
public class TriangleTest {
    /**
     * Test for triangle area.
     */
    @Test
    public void whenGetTriangleAreaTest() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(2, 4), new Point(5, 1));
        String result = String.format("%.1f", triangle.getTriangleArea());
        assertThat(String.format("%.1f", 9.0), is(String.format("%.1f", triangle.getTriangleArea())));
    }

    /**
     * Test when the triangle does not work.
     */
    @Test
    public void whenNotGetTriangleAreaTest() {
        Triangle triangle = new Triangle(new Point(1, 2), new Point(3, 4), new Point(5, 6));
        String result = String.format("%.1f", triangle.getTriangleArea());
        assertThat(String.format("%.1f", -1.0), is(String.format("%.1f", triangle.getTriangleArea())));
    }


}
