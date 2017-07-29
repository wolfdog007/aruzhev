package ru.job4j;

import org.junit.Test;
import ru.job4j.models.Item;
import ru.job4j.start.Tracker;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class TrackerTest check work class Tracker.
 *
 * @author Ruzhev Alexander
 * @since 02.04.2017
 */
public class TrackerTest {
    /**
     * Test Add.
     */
    @Test
    public void whenAdd() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    /**
     * test update.
     */
    @Test
    public void whenUpdate() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        item.setName("TASK2");
        assertThat(tracker.getAll().get(0), is(item));
    }

    /**
     * test findById.
     */
    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(item, is(tracker.findById(item.getId())));
    }

    /**
     * test findByName.
     */
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(item, is(tracker.findByName("test1")));
    }

    /**
     * test delete.
     */
    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        tracker.add(item2);
        tracker.delete(item.getId());
        assertThat(tracker.getAll().get(0), is(item2));
    }

    /**
     * test getAll.
     */
    @Test
    public void whenGetAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        tracker.add(item2);
        List<Item> arrayTest = new ArrayList<>();
        arrayTest.add(item);
        arrayTest.add(item2);
        assertThat(arrayTest, is(tracker.getAll()));
    }
}

