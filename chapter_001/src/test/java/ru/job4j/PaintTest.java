package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class PaintTest check work class Paint.
 *
 * @author Ruzhev Alexander
 * @since 20.02.2017
 */
public class PaintTest {
    /**
     * Test on Paint.piramid.
     */
    @Test
    public void whenPiramid() {
        Paint paint = new Paint();
        assertThat("    ^"
                + System.lineSeparator() + "   ^^^"
                + System.lineSeparator() + "  ^^^^^"
                + System.lineSeparator() + " ^^^^^^^"
                + System.lineSeparator() + "^^^^^^^^^"
                + System.lineSeparator(), is(paint.piramid(5)));
    }
}
