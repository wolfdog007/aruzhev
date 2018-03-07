package ru.job4j.orderbook;

/**
 * This class contains trade order attributes.
 *
 * @author Ruzhev Alexander
 * @since 07.02.2018
 */
public class Order {
    /**
     * Type - add or delete.
     */
    enum Type {
        /**
         * Is add.
         */
        ADD,
        /**
         * is delete.
         */
        DELETE;
    }

    /**
     * Action - bid or ask.
     */
    enum Action {
        /**
         * is bid.
         */
        BID,
        /**
         * is ask.
         */
        ASK;
    }

    /**
     * Order id.
     */
    private int id;
    /**
     * Book name.
     */
    private String book;
    /**
     * Order type.
     */
    private Type type;
    /**
     * Order action.
     */
    private Action action;
    /**
     * order price.
     */
    private float price;
    /**
     * order volume.
     */
    private int volume;

    /**
     * Constructor.
     *
     * @param id     order id
     * @param book   name of book
     * @param type   order type
     * @param action order action
     * @param price  order price
     * @param volume order volume
     */
    public Order(int id, String book, Type type, Action action, float price, int volume) {
        this.id = id;
        this.book = book;
        this.type = type;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

    /**
     * Getter for id.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for book.
     *
     * @return book
     */
    public String getBook() {
        return book;
    }

    /**
     * Getter for type.
     *
     * @return type
     */
    public Type getType() {
        return type;
    }

    /**
     * Getter for Action.
     *
     * @return action
     */
    public Action getAction() {
        return action;
    }

    /**
     * Getter for price.
     *
     * @return price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Getter for volume.
     *
     * @return volume
     */
    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return String.format("%.2f@%d = %s", this.price, this.volume, this.action);
    }

}

