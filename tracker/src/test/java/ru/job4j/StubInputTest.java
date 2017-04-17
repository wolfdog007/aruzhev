package ru.job4j;

import org.junit.Test;
import ru.job4j.models.Item;
import ru.job4j.start.Input;
import ru.job4j.start.StartUI;
import ru.job4j.start.Tracker;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
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
        new StartUI(tracker, new StubInput(new String[]{"1", "6"}));
        Item[] arrayTest = {item, item2};
        assertThat(arrayTest, is(tracker.getAll()));
    }

    /**
     * Check work edit item.
     */
    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(tracker, input).init();
        input = new StubInput(new String[]{"2", "0", tracker.getAll()[0].getId(), "0", "changed name", "1", "changed desc", "2", "6"});
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
        Input input = new StubInput(new String[]{"0", "name1", "desc1", "0", "name2", "decs2", "6"});
        new StartUI(tracker, input).init();
        input = new StubInput(new String[]{"3", "0", tracker.getAll()[0].getId(), "2", "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.getAll()[0].getName(), is("name2"));
    }

    /**
     * Check work find item by Id.
     */
    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "name1", "desc1", "0", "name2", "decs2", "6"});
        new StartUI(tracker, input).init();
        input = new StubInput(new String[]{"4", tracker.getAll()[1].getId(), "6"});
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new StartUI(tracker, input).init();
        assertThat(out.toString(), is("0 - Add new Item\r\n1 - Show all items\r\n2 - Edit item\r\n3 - Delete item\r\n4 - Find item by Id\r\n5 - Find items by name\r\n6 - Exit Program\r\n"
                + "-----------------------------\r\nId          - "
                + tracker.getAll()[1].getId() + "\r\nName        - name2\r\nDescription - decs2\r\nCreated     - "
                + tracker.getAll()[1].getCreated() + "\r\n"
                + "-----------------------------\r\n0 - Add new Item\r\n1 - Show all items\r\n2 - Edit item\r\n3 - Delete item\r\n4 - Find item by Id\r\n5 - Find items by name\r\n6 - Exit Program\r\n"));
    }

    /**
     * Check work find item by name.
     */
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "name1", "desc1", "0", "name2", "decs2", "6"});
        new StartUI(tracker, input).init();
        input = new StubInput(new String[]{"5", tracker.getAll()[1].getName(), "6"});
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new StartUI(tracker, input).init();
        assertThat(out.toString(), is("0 - Add new Item\r\n1 - Show all items\r\n2 - Edit item\r\n3 - Delete item\r\n4 - Find item by Id\r\n5 - Find items by name\r\n6 - Exit Program\r\n"
                + "-----------------------------\r\nId          - "
                + tracker.getAll()[1].getId() + "\r\nName        - name2\r\nDescription - decs2\r\nCreated     - "
                + tracker.getAll()[1].getCreated() + "\r\n"
                + "-----------------------------\r\n0 - Add new Item\r\n1 - Show all items\r\n2 - Edit item\r\n3 - Delete item\r\n4 - Find item by Id\r\n5 - Find items by name\r\n6 - Exit Program\r\n"));
    }
}
