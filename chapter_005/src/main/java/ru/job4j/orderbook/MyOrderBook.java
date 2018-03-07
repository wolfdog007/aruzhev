package ru.job4j.orderbook;

import java.util.Map;
import java.util.TreeMap;

/**
 * The class distributes orders for order books.
 *
 * @author Ruzhev Alexander
 * @since 19.02.2018
 */
public class MyOrderBook {
    /**
     * Contains oder books.
     */
    private Map<String, MyBook> bookMap = new TreeMap<>();

    /**
     * Add new order.
     *
     * @param order - order
     * @return true if add ok
     */
    public boolean add(Order order) {
        boolean result = false;
        if (this.bookMap.get(order.getBook()) != null) {
            this.bookMap.get(order.getBook()).add(order);
        } else {
            MyBook newBook = new MyBook();
            newBook.add(order);
            bookMap.put(order.getBook(), newBook);
        }
        return result;
    }

    /**
     * Print to screen.
     */
    public void print() {
        for (Map.Entry<String, MyBook> map : this.bookMap.entrySet()) {
            System.out.println(map.getKey());
            map.getValue().print();
            System.out.println("++++++++++++++++++++++");
        }
    }
}
