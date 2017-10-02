package ru.job4j;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for Converter.
 *
 * @author Ruzhev Alexander
 * @since 02.10.2017
 */
public class ConverterTest {
    /**
     * Example test from the task.
     */
    @Test
    public void whenItHasTwoInnerIt() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Collections.singletonList(1).iterator(),
                Collections.singletonList(2).iterator()
        ).iterator();
        Iterator<Integer> convert = new Converter().convert(it);
        convert.next();
        int result = convert.next();
        assertThat(result, is(2));
    }

    /**
     * The test method for check work class, if iterator iterators is null.
     */
    @Test
    public void whenParameterIsNull() {
        Iterator<Integer> iterator = new Converter().convert(null);
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * The test method for check work class with three filling collections.
     */
    @Test
    public void whenAllCollectionsIsFill() {
        List<Integer> oneList = Arrays.asList(1, 2);
        List<Integer> twoList = Arrays.asList(11, 12);
        List<Integer> threeList = Arrays.asList(21, 22);
        Iterator<Integer> iterator = new Converter().convert(Arrays.asList(
                oneList.iterator(),
                twoList.iterator(),
                threeList.iterator()
        ).iterator());
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(11));
        assertThat(iterator.next(), is(12));
        assertThat(iterator.next(), is(21));
        assertThat(iterator.next(), is(22));
    }

    /**
     * The test method for check work class, if one collection is empty.
     */
    @Test
    public void whenOneCollectionIsEmpty() {
        List<Integer> oneList = Arrays.asList(1, 2, 3);
        List<Integer> twoList = Collections.emptyList();
        List<Integer> threeList = Arrays.asList(21, 22, 23);
        Iterator<Integer> iterator = new Converter().convert(Arrays.asList(
                oneList.iterator(),
                twoList.iterator(),
                threeList.iterator()
        ).iterator());
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(21));
        assertThat(iterator.next(), is(22));
        assertThat(iterator.next(), is(23));
    }

    /**
     * Test next() then NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextThenNoSuchElementException() {
        List<Integer> oneList = Collections.emptyList();
        Iterator<Integer> iterator = new Converter().convert(Collections.singletonList(oneList.iterator()).iterator());
        iterator.next();
    }
}

