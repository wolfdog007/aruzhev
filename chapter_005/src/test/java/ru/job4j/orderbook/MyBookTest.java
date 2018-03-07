package ru.job4j.orderbook;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for MyBook.
 *
 * @author Ruzhev Alexander
 * @since 07.03.2018
 */
public class MyBookTest {
    /**
     * When add is true.
     */
    @Test
    public void whenAddIsTrue() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        MyBook myBook = new MyBook();
        assertThat(true, is(myBook.add(new Order(1, "Gaz", Order.Type.ADD, Order.Action.BID, 1, 1))));
        myBook.print();
        assertThat("bid    | price   | ask   " + System.lineSeparator() + "1       1,00" + System.lineSeparator(), is(out.toString()));
    }

    /**
     * When add is false.
     */
    @Test
    public void whenAddIsFalse() {
        MyBook myBook = new MyBook();
        assertThat(true, is(myBook.add(new Order(1, "Gaz", Order.Type.ADD, Order.Action.BID, 1, 1))));
        assertThat(false, is(myBook.add(new Order(1, "Gaza", Order.Type.ADD, Order.Action.ASK, 10, 10))));
    }

    /**
     * When delete is false.
     */
    @Test
    public void whenDeleteIsFalse() {
        MyBook myBook = new MyBook();
        assertThat(false, is(myBook.add(new Order(1, "Gaz", Order.Type.DELETE, Order.Action.BID, 1, 1))));
    }

    /**
     * When delete is true.
     */
    @Test
    public void whenDeleteIsTrue() {
        MyBook myBook = new MyBook();
        assertThat(true, is(myBook.add(new Order(1, "Gaz", Order.Type.ADD, Order.Action.BID, 1, 1))));
        assertThat(true, is(myBook.add(new Order(1, "", Order.Type.DELETE, null, 0, 0))));
    }

    /**
     * When Trade is confirm.
     */
    @Test
    public void whenTradeIsConfirm() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        MyBook myBook = new MyBook();
        assertThat(true, is(myBook.add(new Order(1, "Gaz", Order.Type.ADD, Order.Action.BID, 2, 100))));
        assertThat(true, is(myBook.add(new Order(2, "Gaz", Order.Type.ADD, Order.Action.ASK, 1, 100))));
        myBook.print();
        assertThat("bid    | price   | ask   " + System.lineSeparator(), is(out.toString()));
    }

    /**
     * When trade is not confirm.
     */
    @Test
    public void whenTradeIsNotConfirm() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        MyBook myBook = new MyBook();
        assertThat(true, is(myBook.add(new Order(1, "Gaz", Order.Type.ADD, Order.Action.BID, 2, 100))));
        assertThat(true, is(myBook.add(new Order(2, "Gaz", Order.Type.ADD, Order.Action.ASK, 3, 100))));
        myBook.print();
        assertThat("bid    | price   | ask   "
                + System.lineSeparator() + "         3,00      100"
                + System.lineSeparator() + "100       2,00"
                + System.lineSeparator(), is(out.toString()));
    }
}