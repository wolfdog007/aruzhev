package ru.job4j.list;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ruzhev Alexander
 * @since 09.10.2017
 */
public class MyLinkedListTest {
    /**
     * Test for add and get.
     */
    @Test
    public void whenAddThenGet() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i <= 999; i++) {
            list.add(i + 1);
            assertThat(i + 1, is(list.get(i)));
        }
    }

    /**
     * Test get then NoSuchElementException.
     *
     * @throws NoSuchElementException when next element not found.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenGetThenNoSuchElementException() throws NoSuchElementException {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.get(0);
    }

    /**
     * Test for iterator.
     */
    @Test
    public void whenIterator() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
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