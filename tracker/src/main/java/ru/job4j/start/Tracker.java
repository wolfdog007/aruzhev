package ru.job4j.start;

import ru.job4j.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Wrapper class for class Item.
 *
 * @author Ruzhev Alexander
 * @since 01.04.2017
 */
public class Tracker {
    /**
     * Array of items.
     */
    private List<Item> items = new ArrayList<>(10);
    /**
     * index of Item[] items.
     */
    private int position = 0;
    /**
     * object to generate id.
     */
    private static final Random RN = new Random();

    /**
     * Added new item.
     *
     * @param items - new item
     * @return - items
     */
    public Item add(Item items) {
        items.setId(generateId());
        this.items.add(position++, items);
        return items;
    }

    /**
     * Generate id for new item.3
     *
     * @return new id
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * replaces the selected element of the array items.
     *
     * @param items - changed item
     */
    public void update(Item items) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i) != null && this.items.get(i).getId().equals(items.getId())) {
                this.items.add(i, items);
                break;
            }
        }
    }

    /**
     * search by Id.
     *
     * @param id - unique key is String
     * @return result - the desired object
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Search by name.
     *
     * @param name - object field
     * @return result - the desired object
     */
    public Item findByName(String name) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Removes the object from the array.
     *
     * @param id - unique key
     */
    public void delete(String id) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i) != null && this.items.get(i).getId().equals(id)) {
                this.items.remove(i);
            }
        }
        position--;
    }

    /**
     * Returns all elements of array.
     *
     * @return - array items
     */
    public List<Item> getAll() {
        return this.items;
    }
}
