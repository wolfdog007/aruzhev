package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class check work square.
 *
 * @author Ruzhev Alexander
 * @since 17.04.2017
 */
public class SquareTest {
    /**
     * check work paint.draw square.
     */
    @Test
    public void whenDrawSquare() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Paint paint = new Paint(new Square());
        System.setOut(new PrintStream(out));
        paint.draw(5);
        assertThat(out.toString(), is(("* * * * *" + System.lineSeparator() + "* * * * *" + System.lineSeparator() + "* * * * *" + System.lineSeparator() + "* * * * *" + System.lineSeparator() + "* * * * *" + System.lineSeparator())));

    }
}
