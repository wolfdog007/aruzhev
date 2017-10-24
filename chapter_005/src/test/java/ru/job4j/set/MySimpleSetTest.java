package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for MySimpleSet.
 * @author Ruzhev Alexander
 * @since 23.10.2017
 */
public class MySimpleSetTest {
    /**
     * Test for add and get.
     */
    @Test
    public void whenAddThenGet() {
        MySimpleSet<Integer> arrayI = new MySimpleSet<>();
        MySimpleSet<String> arrayS = new MySimpleSet<>();
        arrayI.add(1);
        arrayI.add(2);
        arrayS.add("A");
        arrayS.add("B");
        assertThat(1, is(arrayI.get(0)));
        assertThat(2, is(arrayI.get(1)));
        assertThat("A", is(arrayS.get(0)));
        assertThat("B", is(arrayS.get(1)));
    }

    /**
     * Test for add duplicates.
     */
    @Test
    public void whenAddDuplicatesThenGet() {
        MySimpleSet<String> arrayS = new MySimpleSet<>();
        arrayS.add("A");
        arrayS.add("A");
        arrayS.add("A");
        arrayS.add("B");
        arrayS.add("B");
        assertThat("A", is(arrayS.get(0)));
        assertThat("B", is(arrayS.get(1)));
    }

    /**
     * Test for Increase Container.
     */
    @Test
    public void whenAddThenIncreaseContainer() {
        MySimpleSet<Integer> array = new MySimpleSet<>(0);
        for (int i = 0; i <= 999; i++) {
            array.add(i + 1);
            assertThat(i + 1, is(array.get(i)));
        }
    }
    /**
     * Test for iterator.
     */
    @Test
    public void whenIterator() {
        MySimpleSet<Integer> array = new MySimpleSet<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        Iterator iterator = array.iterator();
        int b = 0;
        for (Integer i : array) {
            assertThat(i, is(array.get(b++)));
        }
        assertThat(1, is(iterator.next()));
        assertThat(2, is(iterator.next()));
        assertThat(3, is(iterator.next()));
        assertThat(4, is(iterator.next()));
        assertThat(5, is(iterator.next()));
        assertThat(false, is(iterator.hasNext()));
    }
    /**
     * Test IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetFromIndexThenIndexOutOfBoundsException() {
        MySimpleSet<String> array = new MySimpleSet<>();
        array.add("a");
        array.add("b");
        array.get(3);
    }
}