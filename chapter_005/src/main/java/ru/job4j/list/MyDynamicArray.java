package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Dynamic list based on an array with iterator.
 * @param <E> the type of elements in this collection
 * @author Ruzhev Alexander
 * @since 06.10.2017
 */
public class MyDynamicArray<E> implements Iterable<E> {
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * The array buffer into which the elements of the ArrayList are stored.
     */
    private Object[] container;
    /**
     * The size of the ArrayList (the number of elements it contains).
     */
    private int size = 0;

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    MyDynamicArray() {
        this.container = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param capacity the initial capacity of the list
     */
    MyDynamicArray(int capacity) {
        this.container = new Object[capacity];
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param value element to be appended to this list
     */
    public void add(E value) {
        if (size == container.length) {
            increaseContainer();
        }
        container[size++] = value;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index of the element to return
     * @return the element at the specified position in this list
     */
    public E get(int index) {
        return (E) this.container[index];
    }

    /**
     * Increases the capacity of the container.
     */
    private void increaseContainer() {
        this.container = Arrays.copyOf(this.container, this.container.length * 3 / 2 + 1);
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
            private int position;

            @Override
            public boolean hasNext() {
                return this.position < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[position++];
            }
        };
    }
}
