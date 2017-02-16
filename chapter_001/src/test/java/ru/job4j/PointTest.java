package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class PointTest check work class Point.
 *
 * @author Ruzhev Alexander
 * @since 16.02.2017
 */
public class PointTest {
    /**
     * Test distance between points two points.
     */
    @Test
    public void distanceToTest() {
        Point point = new Point(0, 0);
        assertThat(5.0, is(point.distanceTo(new Point(0, 5))));
    }
}
