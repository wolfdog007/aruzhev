package ru.job4j.orderbook;

import org.junit.Test;

/**
 * Test for MyOrderBook.
 *
 * @author Ruzhev Alexander
 * @since 01.03.2018
 */
public class MyOrderBookTest {
    /**
     * Test for print.
     */
    @Test
    public void print() {
        MyOrderBook base = new MyOrderBook();
        base.add(new Order(1, "Gaz", Order.Type.ADD, Order.Action.BID, 1, 11));
        base.add(new Order(2, "Gaz", Order.Type.ADD, Order.Action.BID, 1, 12));
        base.add(new Order(3, "Maz", Order.Type.ADD, Order.Action.BID, 2, 10));
        base.add(new Order(4, "Maz", Order.Type.ADD, Order.Action.BID, 1, 15));
        base.add(new Order(5, "TaZ", Order.Type.ADD, Order.Action.BID, 2, 13));

        base.add(new Order(6, "Gaz", Order.Type.ADD, Order.Action.ASK, 1, 10));
        base.add(new Order(7, "Gaz", Order.Type.ADD, Order.Action.ASK, 1, 10));
        base.add(new Order(8, "Gaz", Order.Type.ADD, Order.Action.ASK, 1, 4));
        base.add(new Order(9, "Gaz", Order.Type.ADD, Order.Action.BID, 1, 7));
        base.add(new Order(8, "Maz", Order.Type.ADD, Order.Action.ASK, 4, 10));
        base.add(new Order(9, "Maz", Order.Type.ADD, Order.Action.ASK, 3, 10));
        base.add(new Order(10, "TaZ", Order.Type.ADD, Order.Action.ASK, 4, 10));

        base.add(new Order(11, "Gaz", Order.Type.ADD, Order.Action.ASK, 1, 10));
        base.add(new Order(12, "Gaz", Order.Type.ADD, Order.Action.ASK, 1, 10));
        base.add(new Order(13, "Maz", Order.Type.ADD, Order.Action.ASK, 4, 10));
        base.add(new Order(14, "TaZ", Order.Type.ADD, Order.Action.ASK, 4, 10));

        base.add(new Order(15, "TaZ", Order.Type.ADD, Order.Action.BID, 3, 13));
        base.add(new Order(16, "TaZ", Order.Type.ADD, Order.Action.BID, 5, 13));

        base.print();
    }
}