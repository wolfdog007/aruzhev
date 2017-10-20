package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.list.CycleCheck.Node;

/**
 * Test class for CycleCheck.
 *
 * @author Ruzhev Alexander
 * @since 20.10.2017
 */
public class CycleCheckTest {
    /**
     * When hasCycle Then false.
     */
    @Test
    public void whenHasCycleThenFalse() {
        Node<Integer> node1 = new Node<Integer>(1, null);
        Node<Integer> node2 = new Node<Integer>(2, null);
        Node<Integer> node3 = new Node<Integer>(3, null);
        Node<Integer> node4 = new Node<Integer>(4, null);
        Node<Integer> node5 = new Node<Integer>(5, null);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        CycleCheck<Integer> cycleCheck = new CycleCheck<>();
        assertThat(false, is(cycleCheck.hasCycle(node1)));

    }

    /**
     * When hasCycle Then true.
     */
    @Test
    public void whenHasCycleThenTrue() {
        Node<Integer> node1 = new Node<Integer>(1, null);
        Node<Integer> node2 = new Node<Integer>(2, null);
        Node<Integer> node3 = new Node<Integer>(3, null);
        Node<Integer> node4 = new Node<Integer>(4, null);
        Node<Integer> node5 = new Node<Integer>(5, null);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node1);
        CycleCheck<Integer> cycleCheck = new CycleCheck<>();
        assertThat(true, is(cycleCheck.hasCycle(node1)));
        node5.setNext(null);
        node4.setNext(node2);
        assertThat(true, is(cycleCheck.hasCycle(node1)));
    }

}