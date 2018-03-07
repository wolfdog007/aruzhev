package ru.job4j.orderbook;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class stores and processes applications.
 * @author Ruzhev Alexander
 * @since 13.02.2018
 */
public class MyBook {
    /**
     * For orders is type bid.
     */
    private Map<Float, TreeMap<Integer, Order>> bid = new TreeMap<>(new Comparator<Float>() {
        @Override
        public int compare(Float o1, Float o2) {
            return o2.compareTo(o1);
        }
    });
    /**
     * For orders is type ask.
     */
    private Map<Float, TreeMap<Integer, Order>> ask = new TreeMap<>(new Comparator<Float>() {
        @Override
        public int compare(Float o1, Float o2) {
            return o1.compareTo(o2);
        }
    });

    /**
     * Add new order.
     * @param order  - order
     * @return true if add ok.
     */
    public boolean add(Order order) {
        boolean result = false;
        if (order != null && order.getType() == Order.Type.ADD) {
            result = addAction(Order.Action.ASK == order.getAction() ? this.ask : this.bid, order);
            trade(Order.Action.ASK != order.getAction() ? this.ask : this.bid, order);
        }
        if (order != null && order.getType() == Order.Type.DELETE) {
            result = deleteAction(order);
        }
        return result;
    }

    /**
     * Trading transaction.
     * @param map is bid or ask
     * @param order - order
     */
    private void trade(Map<Float, TreeMap<Integer, Order>> map, Order order) {
        Order flagOder = null;
        for (Map.Entry<Float, TreeMap<Integer, Order>> entry : map.entrySet()) {
            if (order.getAction() == Order.Action.ASK ? entry.getKey() >= order.getPrice() : entry.getKey() <= order.getPrice()) {
                for (Map.Entry<Integer, Order> orders : entry.getValue().entrySet()) {
                    if (orders.getValue().getVolume() >= order.getVolume()) {
                        orders.setValue(new Order(orders.getValue().getId(), orders.getValue().getBook(), orders.getValue().getType(), orders.getValue().getAction(), orders.getValue().getPrice(), orders.getValue().getVolume() - order.getVolume()));
                        deleteAction(order);
                        cleanByVolume(order.getAction() != Order.Action.ASK ? this.ask : this.bid, orders.getValue().getPrice());

                        break;
                    } else {
                        order = new Order(order.getId(), order.getBook(), order.getType(), order.getAction(), order.getPrice(), order.getVolume() - orders.getValue().getVolume());
                        deleteAction(order.getAction() == Order.Action.ASK ? this.ask : this.bid, order);
                        addAction(Order.Action.ASK == order.getAction() ? this.ask : this.bid, order);
                        flagOder = orders.getValue();
                    }
                }
            }
        }
        if (flagOder != null) {
            deleteAction(flagOder);
        }
    }

    /**
     * adds an application to the required list.
     * @param map is bid or ask
     * @param order order
     * @return true if add is ok
     */
    private boolean addAction(Map<Float, TreeMap<Integer, Order>> map, Order order) {
        boolean result = false;
        if (!checkID(order)) {
            if (!map.containsKey(order.getPrice())) {
                map.put(order.getPrice(), new TreeMap<>());
            }
            TreeMap<Integer, Order> tree = map.get(order.getPrice());
            if (!tree.containsKey(order.getId())) {
                tree.put(order.getId(), order);
                result = true;
            }
        }
        return result;
    }

    /**
     * Check id.
     * @param order order
     * @return true if id already contains
     */
    private boolean checkID(Order order) {
        boolean result = false;
        for (Map.Entry<Float, TreeMap<Integer, Order>> entry : this.ask.entrySet()) {
            if (entry.getValue().containsKey(order.getId())) {
                result = true;
                break;
            }
        }
        if (!result) {
            for (Map.Entry<Float, TreeMap<Integer, Order>> entry : this.bid.entrySet()) {
                if (entry.getValue().containsKey(order.getId())) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Delete order.
     * @param order - order
     * @return true if order is deleting
     */
    private boolean deleteAction(Order order) {
        boolean result = false;
        Order temp;
        for (Map.Entry<Float, TreeMap<Integer, Order>> entry : this.ask.entrySet()) {
            temp = entry.getValue().remove(order.getId());
            if (temp != null) {
                cleanByVolume(order.getAction() == Order.Action.ASK ? this.ask : this.bid, order.getPrice());
                result = true;
                break;
            }
        }
        if (!result) {
            for (Map.Entry<Float, TreeMap<Integer, Order>> entry : this.bid.entrySet()) {
                temp = entry.getValue().remove(order.getId());
                if (temp != null) {
                    cleanByVolume(order.getAction() == Order.Action.ASK ? this.ask : this.bid, order.getPrice());
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Delete order.
     * @param map is bid or ask
     * @param order - order
     * @return true if order is deleting
     */
    private boolean deleteAction(Map<Float, TreeMap<Integer, Order>> map, Order order) {
        boolean result = false;
        for (Map.Entry<Float, TreeMap<Integer, Order>> entry : map.entrySet()) {
            Order temp = entry.getValue().remove(order.getId());
            if (result = temp != null) {
                cleanByVolume(map, order.getPrice());
                break;
            }
        }
        return result;
    }

    /**
     * Removes the price if the quantity is 0.
     * @param map is bid or ask
     * @param price - price
     */
    private void cleanByVolume(Map<Float, TreeMap<Integer, Order>> map, Float price) {
        int volume = 0;
        TreeMap<Integer, Order> tree = map.get(price);
        if (tree != null) {
            for (Map.Entry<Integer, Order> orders : tree.entrySet()) {
                volume += orders.getValue().getVolume();
            }
            if (volume == 0) {
                map.remove(price);
            }
        }
    }

    /**
     * Print to screen.
     */
    public void print() {
        int volume = 0;
        System.out.println("bid    | price   | ask   ");
        for (Map.Entry<Float, TreeMap<Integer, Order>> entry : this.ask.entrySet()) {
            String price = String.format("%.2f", entry.getKey());
            for (Map.Entry<Integer, Order> order : entry.getValue().entrySet()) {
                volume += order.getValue().getVolume();
            }
            System.out.println(String.format("         %s      %s", price, volume));
            volume = 0;
        }
        for (Map.Entry<Float, TreeMap<Integer, Order>> entry : this.bid.entrySet()) {
            String price = String.format("%.2f", entry.getKey());
            for (Map.Entry<Integer, Order> order : entry.getValue().entrySet()) {
                volume += order.getValue().getVolume();
            }
            System.out.println(String.format("%s       %s", volume, price));
            volume = 0;
        }
    }
}