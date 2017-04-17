package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class check work triangle.
 *
 * @author Ruzhev Alexander
 * @since 17.04.2017
 */
public class TriangleTest {
    /**
     * check work paint.draw triangle.
     */
    @Test
    public void whenDrawTriangle() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Paint paint = new Paint(new Triangle());
        System.setOut(new PrintStream(out));
        paint.draw(5);
        assertThat(out.toString(), is("    ^"
                + System.lineSeparator() + "   ^^^"
                + System.lineSeparator() + "  ^^^^^" + System.lineSeparator()
                + " ^^^^^^^" + System.lineSeparator()
                + "^^^^^^^^^" + System.lineSeparator()));
    }
}
