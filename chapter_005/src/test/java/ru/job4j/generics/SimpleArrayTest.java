package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Test class for SimpleArray.
 *
 * @author Ruzhev Alexander
 * @since 03.10.2017
 */
public class SimpleArrayTest {
    /**
     * Test add and get.
     */
    @Test
    public void whenAddThenGet() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("a");
        array.add("b");
        assertThat("a", is(array.get(0)));
        assertThat("b", is(array.get(1)));
    }

    /**
     * Test add at index.
     */
    @Test
    public void addFromIndexThenGet() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("a");
        array.add("b");
        array.add(1, "c");
        assertThat("a", is(array.get(0)));
        assertThat("c", is(array.get(1)));
        assertThat("b", is(array.get(2)));
    }

    /**
     * Test array extend.
     */
    @Test
    public void addThenExtends() {
        SimpleArray<String> array = new SimpleArray<>(2);
        array.add("a");
        array.add("b");
        array.add("c");
        assertThat("a", is(array.get(0)));
        assertThat("b", is(array.get(1)));
        assertThat("c", is(array.get(2)));
    }

    /**
     * Test IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetFromIndexThenIndexOutOfBoundsException() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("a");
        array.add("b");
        array.get(3);
    }

    /**
     * Test getIndex.
     */
    @Test
    public void getIndex() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("a");
        array.add("b");
        array.add(1, "c");
        assertThat(0, is(array.getIndex("a")));
        assertThat(1, is(array.getIndex("c")));
        assertThat(2, is(array.getIndex("b")));
    }

    /**
     * Test update at index.
     */
    @Test
    public void whenUpdateFromIndex() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("a");
        array.add("b");
        array.update(0, "c");
        assertThat("c", is(array.get(0)));
    }

    /**
     * Test update at value is true.
     */
    @Test
    public void whenUpdateFromValueThenTrue() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("a");
        array.add("b");
        boolean result = array.update("b", "c");
        assertThat("c", is(array.get(1)));
        assertThat(true, is(result));
    }
    /**
     * Test update at value is false.
     */
    @Test
    public void whenUpdateFromValueThenFalse() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("a");
        array.add("b");
        assertThat(false, is(array.update("c", "e")));
    }

    /**
     * Test delete at index.
     */
    @Test
    public void whenDeleteFromIndex() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("a");
        array.add("b");
        array.delete(0);
        assertThat("b", is(array.get(0)));
        assertThat(null, is(array.get(1)));
    }

    /**
     * Test delete at value.
     */
    @Test
    public void whenDeleteFromValue() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("a");
        array.add("b");
        array.delete("a");
        assertThat("b", is(array.get(0)));
    }
}