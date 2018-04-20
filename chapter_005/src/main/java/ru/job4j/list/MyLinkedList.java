package ru.job4j.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The linked list implementation.
 *
 * @param <E> the type of elements in this collection
 * @author Ruzhev Alexander
 * @since 07.10.2017
 */
@ThreadSafe
public class MyLinkedList<E> implements Iterable<E> {
    /**
     * The number of elements.
     */
    @GuardedBy("this")
    private int size;
    /**
     * Reference to the first element.
     */
    @GuardedBy("this")
    private Node<E> first;
    /**
     * Reference to the last element.
     */
    @GuardedBy("this")
    private Node<E> last;

    /**
     * Constructs an empty list.
     */
    MyLinkedList() {
        this.size = 0;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param value element to be appended to this list
     */
    public void add(E value) {
        synchronized (this) {
            Node<E> node = new Node<E>(this.last, value, null);
            if (this.first == null) {
                this.first = node;
                this.last = node;
            } else {
                this.last.next = node;
                this.last = node;
            }
            size++;
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index of the element to return
     * @return the element at the specified position in this list
     */
    public E get(int index) {
        synchronized (this) {
            if (this.first == null || index >= size) {
                throw new NoSuchElementException();
            }
            Node<E> result = this.first;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
            return result.item;
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
}
