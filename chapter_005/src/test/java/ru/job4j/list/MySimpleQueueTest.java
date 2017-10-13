package ru.job4j.list;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MySimpleQueue Test.
 *
 * @author Ruzhev Alexander
 * @since 13.10.2017
 */
public class MySimpleQueueTest {
    /**
     * Test for push and poll.
     */
    @Test
    public void push() {
        MyAbstractQueue<Integer> simpleQueue = new MySimpleQueue<>();

        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);

        assertThat(3, is(simpleQueue.getSize()));

        assertThat(1, is(simpleQueue.poll()));
        assertThat(2, is(simpleQueue.poll()));
        assertThat(3, is(simpleQueue.poll()));

        assertThat(0, is(simpleQueue.getSize()));
    }

    /**
     * Test for NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenPollThenNoSuchElementException() {
        MyAbstractQueue<Integer> simpleStack = new MySimpleQueue<>();
        simpleStack.poll();
    }
}