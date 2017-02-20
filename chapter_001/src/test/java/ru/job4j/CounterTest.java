package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class CounterTest check work class Counter.
 *
 * @author Ruzhev Alexander
 * @since 20.02.2017
 */
public class CounterTest {
    /**
     * Test on Counter.add.
     */
    @Test
    public void whenAdd() {
        Counter counter = new Counter();
        assertThat(30, is(counter.add(1, 10)));
    }
}
