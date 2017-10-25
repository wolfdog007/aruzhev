package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Set implemented in the linked list.
 * @param <E> the type of elements in this collection
 * @author Ruzhev Alexander
 * @since 25.10.2017
 */
public class MySimpleLinkedSet<E> implements Iterable<E> {
    /**
     * The number of elements.
     */
    private int size;
    /**
     * Reference to the first element.
     */
    private Node<E> first;
    /**
     * Reference to the last element.
     */
    private Node<E> last;

    /**
     * Constructs an empty list.
     */
    MySimpleLinkedSet() {
        this.size = 0;
    }

    /**
     * Getter for size.
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param value element to be appended to this list
     */
    public void add(E value) {
        Node<E> node = new Node<E>(this.last, value, null);
        if (this.first == null) {
            this.first = node;
            this.last = node;
            size++;
        } else {
            if (!duplicateCheck(value)) {
                this.last.next = node;
                this.last = node;
                size++;
            }
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index of the element to return
     * @return the element at the specified position in this list
     */
    public E get(int index) {
        if (this.first == null || index >= size) {
            throw new NoSuchElementException();
        }
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.item;
    }

    /**
     * Checks whether the incoming object in the container.
     *
     * @param value incoming object
     * @return true if such an object contains in the container, false if not
     */
    private boolean duplicateCheck(E value) {
        boolean result = false;
        for (Node<E> i = first; i != null; i = i.next) {
            if (i.item.equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * The inner class for storing values and references.
     *
     * @param <E> the type of elements in this collection
     */
    private static class Node<E> {
        /**
         * The stored object.
         */
        private E item;
        /**
         * Link to next element.
         */
        private Node<E> next;
        /**
         * Link to previous element.
         */
        private Node<E> prev;

        /**
         * Constructor.
         *
         * @param prev    previous element
         * @param element the stored object.
         * @param next    next element.
         */
        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Returns an iterator over elements of type {@code E}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * Position in array.
             */
            private Node<E> position = first;

            @Override
            public boolean hasNext() {
                return this.position != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = position.item;
                this.position = this.position.next;
                return result;
            }
        };
    }
}
