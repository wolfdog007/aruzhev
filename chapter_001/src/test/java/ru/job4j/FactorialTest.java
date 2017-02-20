package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class FactorialTest check work class Factorial.
 *
 * @author Ruzhev Alexander
 * @since 20.02.2017
 */
public class FactorialTest {
    /**
     * Test on Factorial.getFactorial.
     */
    @Test
    public void whenGetFactorial() {
        Factorial factorial = new Factorial();
        assertThat(120, is(factorial.getFactorial(5)));
    }
}
