package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class MaxTest check work class Max.
 *
 * @author Ruzhev Alexander
 * @since 15.02.2017
 */
public class MaxTest {
    /**
     * Test on maximum number.
     */
    @Test
    public void getMaxNumberTest() {
        Max max = new Max();
        assertThat(15, is(max.getMaxNumber(15, 13)));
    }
}
