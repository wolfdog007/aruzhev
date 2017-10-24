package ru.job4j.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *The class implements a host-based array.
 * @param <E> the type of elements in this queue
 * @author Ruzhev Alexander
 * @since 23.10.2017
 */
public class MySimpleSet<E> implements Iterable<E> {
    /**
     * Array of objects.
     */
    private Object[] objects;
    /**
     * The pointer array.
     */
    private int index = 0;
    /**
     * An empty constructor.
     */
    MySimpleSet() {
        this.objects = new Object[10];
    }

    /**
     * Constructor whit parameter.
     *
     * @param size Size to array
     */
    MySimpleSet(int size) {
        this.objects = new Object[size];
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param value element to be appended to this list
     */
    public void add(E value) {
        if (!duplicateCheck(value)) {
            if (objects.length <= this.index + 1) {
                addCapacity();
            }
            objects[index++] = value;
        }
    }

    /**
     * the method takes the value at index.
     *
     * @param index index in array.
     * @return object of array
     */
    public E get(int index) {
        rangeCheck(index);
        return (E) this.objects[index];
    }

    /**
     * Removes the element at index.
     *
     * @param index position in the array
     */
    public void delete(int index) {
        rangeCheck(index);
        System.arraycopy(this.objects, index + 1, this.objects, index, this.index - index - 1);
        this.objects[--this.index] = null;
    }

    /**
     * removes an element by value.
     *
     * @param value by element
     * @return true if the item was deleted or false if not
     */
    public boolean delete(E value) {
        boolean result = true;
        int foundIndex = getIndex(value);
        if (foundIndex >= 0) {
            delete(foundIndex);
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Returns the index of the first occurrence of the specified element.
     *
     * @param value The search item
     * @return Returns the element index or -1 if not found
     */
    public int getIndex(E value) {
        int result = -1;
        for (int i = 0; i < this.index; i++) {
            if (this.objects[i].equals(value)) {
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * extends the array.
     */
    private void addCapacity() {
        this.objects = Arrays.copyOf(this.objects, (this.objects.length * 3) / 2 + 1);
    }

    /**
     * Checks whether the incoming object in the container.
     * @param value incoming object
     * @return true if such an object contains in the container, false if not
     */
    private boolean duplicateCheck(E value) {
        boolean result = false;
        for (int i = 0; i < this.index; i++) {
            if (value.equals(objects[i])) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Checks if the given index is in range.
     *
     * @param index position in array
     */
    private void rangeCheck(int index) {
        if (index > this.index || index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index: %s, Size: %s", index, this.index));
        }
    }

    /**
     * The method return iterator.
     *
     * @return iterator for class;
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * Position in array.
             */
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < index;
            }

            @Override
            public E next() {
                if (position >= index) {
                    throw new NoSuchElementException();
                }
                return (E) objects[position++];
            }
        };
    }
}