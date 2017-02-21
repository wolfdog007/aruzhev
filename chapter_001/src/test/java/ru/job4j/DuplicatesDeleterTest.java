package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class DuplicatesDeleterTest check work class DuplicatesDeleterTest.
 *
 * @author Ruzhev Alexander
 * @since 21.02.2017
 */
public class DuplicatesDeleterTest {
    /**
     * Test on DuplicatesDeleter.removeDuplicates.
     */
    @Test
    public void whenRemoveDuplicates() {
        DuplicatesDeleter duplicatesDeleter = new DuplicatesDeleter();
        String[] array = {"1", "1", "2", "2", "3", "3"};
        String[] arrayTest = {"1", "2", "3"};
        assertThat(arrayTest, is(duplicatesDeleter.removeDuplicates(array)));
    }
}
