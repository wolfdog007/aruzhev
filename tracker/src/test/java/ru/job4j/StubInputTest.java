package ru.job4j;

import org.junit.Test;
import ru.job4j.models.Item;
import ru.job4j.start.Input;
import ru.job4j.start.StartUI;
import ru.job4j.start.StubInput;
import ru.job4j.start.Tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class check work Tracker by emulation of user input.
 *
 * @author Ruzhev Alexander
 * @since 17.04.2017
 */
public class StubInputTest {
    /**
     * Check work Add new Item.
     */
    @Test
    public void whenAddNewItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(tracker, input).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
        assertThat(tracker.getAll()[0].getDesc(), is("desc"));
    }

    /**
     * Check work show all items.
     */
    @Test
    public void whenShowAllItems() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        tracker.add(item2);
        new StartUI(tracker, new StubInput(new String[]{"1", "y"}));
        Item[] arrayTest = {item, item2};
        assertThat(arrayTest, is(tracker.getAll()));
    }

    /**
     * Check work edit item.
     */
    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(tracker, input).init();
        input = new StubInput(new String[]{"2", tracker.getAll()[0].getId(), "changed name", "changed desc", "y"});
        new StartUI(tracker, input).init();
        assertThat(tracker.getAll()[0].getName(), is("changed name"));
        assertThat(tracker.getAll()[0].getDesc(), is("changed desc"));
    }

    /**
     * Check work delete item.
     */
    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "name1", "desc1", "n", "0", "name2", "decs2", "y"});
        new StartUI(tracker, input).init();
        input = new StubInput(new String[]{"3", tracker.getAll()[0].getId(), "y"});
        new StartUI(tracker, input).init();
        assertThat(tracker.getAll()[0].getName(), is("name2"));
    }

    /**
     * Check work find item by Id.
     */
    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "name1", "desc1", "n", "0", "name2", "decs2", "y"});
        new StartUI(tracker, input).init();
        input = new StubInput(new String[]{"4", tracker.getAll()[1].getId(), "y"});
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new StartUI(tracker, input).init();
        String curStringDate = new SimpleDateFormat("dd.MM.yyyy hh:mm").format(tracker.getAll()[1].getCreated());
        assertThat(out.toString(), is(String.format("0. Add the new item." + System.lineSeparator()
                + "1. Show all items." + System.lineSeparator()
                + "2. Edit the item." + System.lineSeparator()
                + "3. Delete the item." + System.lineSeparator()
                + "4. Find by id the item." + System.lineSeparator()
                + "5. Find by name the item." + System.lineSeparator()
                + "6. Exit." + System.lineSeparator()
                + "Id          - %s" + System.lineSeparator() + "Name        - name2"
                + System.lineSeparator() + "Description - decs2" + System.lineSeparator()
                + "Created     - %s" + System.lineSeparator()
                + "-----------------------------" + System.lineSeparator(), tracker.getAll()[1].getId(), curStringDate)));
    }

    /**
     * Check work find item by name.
     */
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "name1", "desc1", "n", "0", "name2", "decs2", "y"});
        new StartUI(tracker, input).init();
        input = new StubInput(new String[]{"5", tracker.getAll()[1].getName(), "y"});
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new StartUI(tracker, input).init();
        String curStringDate = new SimpleDateFormat("dd.MM.yyyy hh:mm").format(tracker.getAll()[1].getCreated());
        assertThat(out.toString(), is(String.format("0. Add the new item." + System.lineSeparator()
                + "1. Show all items." + System.lineSeparator()
                + "2. Edit the item." + System.lineSeparator()
                + "3. Delete the item." + System.lineSeparator()
                + "4. Find by id the item." + System.lineSeparator()
                + "5. Find by name the item." + System.lineSeparator()
                + "6. Exit." + System.lineSeparator()
                + "Id          - %s" + System.lineSeparator()
                + "Name        - name2" + System.lineSeparator()
                + "Description - decs2" + System.lineSeparator()
                + "Created     - %s" + System.lineSeparator()
                + "-----------------------------" + System.lineSeparator(), tracker.getAll()[1].getId(), curStringDate)));
    }
}
