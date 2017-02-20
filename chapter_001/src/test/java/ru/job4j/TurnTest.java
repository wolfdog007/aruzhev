package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class TurnTest check work class Turn.
 *
 * @author Ruzhev Alexander
 * @since 20.02.2017
 */
public class TurnTest {
    /**
     * Test on Turn.back.
     */
    @Test
    public void whenBack() {
        Turn turn = new Turn();
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arrayTest = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertThat(arrayTest, is(turn.back(array)));
    }
}
