package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class SubStringTest check work class SubString.
 *
 * @author Ruzhev Alexander
 * @since 15.03.2017
 */
public class SubStringTest {
    /**
     * Test on SubString.contains is true.
     */
    @Test
    public void whenContainsIsTrue() {
        SubString subString = new SubString();
        String origin = "in vino veritas";
        String sub = "vino";
        assertThat(true, is(subString.contains(origin, sub)));
    }

    /**
     * Test on SubString.contains is false.
     */
    @Test
    public void whenContainsIsFalse() {
        SubString subString = new SubString();
        String origin = "in vino veritas";
        String sub = "venom";
        assertThat(false, is(subString.contains(origin, sub)));
    }

}
