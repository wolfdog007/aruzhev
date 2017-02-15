package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Ruzhev Alexander
 * @version $Id$
 * @since 0.1
 */

public class CalculatorTest {
    /**
     * Test add 2 + 2 = 4.
     */
    @Test
    public void whenAdd() {
        Calculator calc = new Calculator();
        calc.add(2.0, 2.0);
        assertThat(4.0, is(calc.getResult()));
    }

    /**
     * Test substruction 8 - 4 = 4.
     */
    @Test
    public void whenSubstruct() {
        Calculator calc = new Calculator();
        calc.substruct(8.0, 4.0);
        assertThat(4.0, is(calc.getResult()));
    }

    /**
     * Test div 6 / 2 = 3.
     */
    @Test
    public void whenDiv() {
        Calculator calc = new Calculator();
        calc.div(6.0, 2.0);
        assertThat(3.0, is(calc.getResult()));
    }

    /**
     * Test multiple 2 * 3 = 6.
     */
    @Test
    public void whenMultiple() {
        Calculator calc = new Calculator();
        calc.multiple(2.0, 3.0);
        assertThat(6.0, is(calc.getResult()));
    }
}