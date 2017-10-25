package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ruzhev Alexander
 * @since 25.10.2017
 */
public class MySimpleLinkedSetTest {
    /**
     * Test for add and get.
     */
    @Test
    public void whenAddThenGet() {
        MySimpleLinkedSet<Integer> arrayI = new MySimpleLinkedSet<>();
        MySimpleLinkedSet<String> arrayS = new MySimpleLinkedSet<>();
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
        MySimpleLinkedSet<String> arrayS = new MySimpleLinkedSet<>();
        arrayS.add("A");
        arrayS.add("A");
        arrayS.add("A");
        arrayS.add("B");
        arrayS.add("B");
        assertThat("A", is(arrayS.get(0)));
        assertThat("B", is(arrayS.get(1)));
        assertThat(2, is(arrayS.getSize()));
    }

    /**
     * Test for iterator.
     */
    @Test
    public void whenIterator() {
        MySimpleLinkedSet<Integer> list = new MySimpleLinkedSet<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int b = 0;
        for (Integer i : list) {
            assertThat(i, is(list.get(b++)));
        }
    }

}