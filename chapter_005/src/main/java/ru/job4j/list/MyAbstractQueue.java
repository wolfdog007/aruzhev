package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * Abstract class for queue.
 * @param <T> the type of elements in this queue
 * @author Ruzhev Alexander
 * @since 13.10.2017
 */
abstract class MyAbstractQueue<T> {
    /**
     * The size of queue.
     */
    private int size;
    /**
     * Reference to the first element.
     */
    private Node<T> first;

    /**
     * Constructor.
     */
    MyAbstractQueue() {
        this.size = 0;
    }

    /**
     * Setter for size.
     *
     * @param size the size of queue
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Getter for first.
     *
     * @return reference to the first element
     */
    public Node<T> getFirst() {
        return first;
    }

    /**
     * Setter for first.
     *
     * @param first reference to the first element
     */
    public void setFirst(Node<T> first) {
        this.first = first;
    }

    /**
     * The method adds a new object to the top of the queue.
     *
     * @param value of object.
     */
    abstract void push(T value);

    /**
     * The method returns a object from the top of the queue and remove it.
     *
     * @return value of object.
     */
    T poll() {
        if (this.first == null) {
            throw new NoSuchElementException();
        }
        T result = this.first.item;
        this.first = this.first.next;
        size--;
        return result;
    }

    /**
     * Getter for size.
     *
     * @return the size of queue
     */
    int getSize() {
        return this.size;
    }

    /**
     * The inner class for storing values and references.
     *
     * @param <T> the type of elements in this collection
     */
    static class Node<T> {
        /**
         * The stored object.
         */
        private T item;
        /**
         * Link to next element.
         */
        private Node<T> next;

        /**
         * Constructor.
         *
         * @param element the stored object.
         * @param next    next element.
         */
        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }

        /**
         * Setter for next.
         * @param next Link to next element
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
