package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author Ruzhev Alexander
 * @since 15.07.2017
 */
public class TestingPerformanceTest {
    /**
     * Create new testingPerformance.
     */
    TestingPerformance testingPerformance = new TestingPerformance();

    /**
     * Completing the collection of 1000000 elements and the deletion time from the start of a collection of 500 items.
     */
    @Test
    public void whenArrayList() {
        System.out.println("arrayList");
        ArrayList<String> arrayList = new ArrayList<String>();
        System.out.println(testingPerformance.add(arrayList, 1000000));
        System.out.println(testingPerformance.delete(arrayList, 500));
        System.out.println("++++++++++++++++++++++++");
    }

    /**
     * Completing the collection of 1000000 elements and the deletion time from the start of a collection of 500 items.
     */
    @Test
    public void whenArrayListParameter() {
        System.out.println("arrayListParam");
        ArrayList<String> arrayList = new ArrayList<String>(1000000);
        System.out.println(testingPerformance.add(arrayList, 1000000));
        System.out.println(testingPerformance.delete(arrayList, 500));
        System.out.println("++++++++++++++++++++++++");
    }

    /**
     * Completing the collection of 1000000 elements and the deletion time from the start of a collection of 500 items.
     */
    @Test
    public void whenLinkedList() {
        System.out.println("linkedList");
        LinkedList<String> linkedList = new LinkedList<String>();
        System.out.println(testingPerformance.add(linkedList, 1000000));
        System.out.println(testingPerformance.delete(linkedList, 500));
        System.out.println("++++++++++++++++++++++++");
    }

    /**
     * Completing the collection of 1000000 elements and the deletion time from the start of a collection of 500 items.
     */
    @Test
    public void whenTreeSet() {
        System.out.println("treeSet");
        TreeSet<String> treeSet = new TreeSet<String>();
        System.out.println(testingPerformance.add(treeSet, 1000000));
        System.out.println(testingPerformance.delete(treeSet, 500));
        System.out.println("++++++++++++++++++++++++");
    }
}
