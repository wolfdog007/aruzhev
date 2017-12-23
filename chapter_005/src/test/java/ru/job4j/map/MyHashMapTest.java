package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for MyHashMap.
 *
 * @author Ruzhev Alexander
 * @since 16.12.2017
 */
public class MyHashMapTest {
    /**
     * Test for insert and get.
     */
    @Test
    public void whenInsertThenGet() {
        MyHashMap<String, Integer> hashMap = new MyHashMap<String, Integer>();

        hashMap.insert("A", 100);
        hashMap.insert("B", 200);
        hashMap.insert("C", 300);
        hashMap.insert("D", 400);
        hashMap.insert("E", 500);

        assertThat(100, is(hashMap.get("A")));
        assertThat(200, is(hashMap.get("B")));
        assertThat(300, is(hashMap.get("C")));
        assertThat(400, is(hashMap.get("D")));
        assertThat(500, is(hashMap.get("E")));
    }

    /**
     * Test for delete.
     */
    @Test
    public void whenDelete() {
        MyHashMap<String, Integer> hashMap = new MyHashMap<String, Integer>();

        hashMap.insert("A", 100);
        hashMap.insert("B", 200);
        hashMap.insert("C", 300);
        hashMap.insert("D", 400);
        hashMap.insert("E", 500);

        assertThat(true, is(hashMap.delete("A")));
        assertThat(null, is(hashMap.get("A")));
    }

    /**
     * Test for increase.
     */
    @Test
    public void whenIncrease() {
        MyHashMap<Integer, Integer> hashMap = new MyHashMap<Integer, Integer>();

        for (int i = 0; i < 100; i++) {
            hashMap.insert(i, i);
            assertThat(i, is(hashMap.get(i)));
        }
        assertThat(100, is(hashMap.getSize()));
    }

    /**
     * Test for iterator.
     */
    @Test
    public void whenIterator() {
        MyHashMap<String, Integer> hashMap = new MyHashMap<String, Integer>();
        hashMap.insert("A", 100);
        hashMap.insert("B", 200);
        hashMap.insert("C", 300);
        hashMap.insert("D", 400);
        hashMap.insert("E", 500);
        int x = 1;
        for (MyHashMap.Entry key : hashMap) {
            assertThat(100 * x++, is(key.getValue()));
        }
    }
}