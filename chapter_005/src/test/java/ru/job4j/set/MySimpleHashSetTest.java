package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for MyHashSet.
 *
 * @author Ruzhev Alexander
 * @since 03.11.2017
 */
public class MySimpleHashSetTest {
    /**
     * Test for add and get.
     */
    @Test
    public void whenAddThenGet() {
        MyHashSet<String> list = new MyHashSet<>();

        list.add("A");
        list.add("B");
        list.remove("B");
        list.add("C");
        list.add("D");
        list.remove("A");
        list.add("E");
        list.add("F");
        list.add("J");
        list.add("K");
        list.remove("J");
        list.add("L");
        list.add("M");
        list.add("N");
        list.add("O");
        list.remove("L");
        list.add("P");
        list.add("Q");
        list.add("R");
        list.remove("Q");
        list.add("S");

        assertThat("P", is(list.get(0)));
        assertThat("R", is(list.get(1)));
        assertThat("C", is(list.get(2)));
        assertThat("S", is(list.get(3)));
        assertThat("D", is(list.get(4)));
        assertThat("E", is(list.get(5)));
        assertThat("F", is(list.get(6)));
        assertThat("K", is(list.get(7)));
        assertThat("M", is(list.get(8)));
        assertThat("N", is(list.get(9)));
        assertThat("O", is(list.get(10)));
    }

    /**
     * Test contains.
     */
    @Test
    public void whenContains() {
        MyHashSet<String> list = new MyHashSet<>();
        list.add("A");
        list.add("B");
        assertThat(true, is(list.contains("A")));
        assertThat(true, is(list.contains("B")));
        assertThat(false, is(list.contains("C")));
    }

    /**
     * Test remove.
     */
    @Test
    public void whenRemove() {
        MyHashSet<String> list = new MyHashSet<>();
        list.add("A");
        list.add("B");
        list.add("C");
        assertThat(3, is(list.getSize()));
        assertThat(true, is(list.remove("B")));
        assertThat(false, is(list.contains("B")));
        assertThat(2, is(list.getSize()));
        assertThat(false, is(list.remove("B")));
    }

}