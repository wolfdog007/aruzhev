package ru.job4j.list;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MySimpleStack Test.
 *
 * @author Ruzhev Alexander
 * @since 13.10.2017
 */
public class MySimpleStackTest {
    /**
     * Test for push and poll.
     */
    @Test
    public void whenPushThenPoll() {
        MySimpleStack<Integer> simpleStack = new MySimpleStack<>();

        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);

        assertThat(3, is(simpleStack.getSize()));

        assertThat(3, is(simpleStack.poll()));
        assertThat(2, is(simpleStack.poll()));
        assertThat(1, is(simpleStack.poll()));

        assertThat(0, is(simpleStack.getSize()));
    }

    /**
     * Test for NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenPollThenNoSuchElementException() {
        MySimpleStack<Integer> simpleStack = new MySimpleStack<>();
        simpleStack.poll();
    }

}