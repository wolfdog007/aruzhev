package ru.job4j.generics;

import java.util.Arrays;

/**
 * A simple wrapper over an array.
 *
 * @param <T> The type of container.
 * @author Ruzhev Alexander
 * @since 03.10.2017
 */
public class SimpleArray<T> {
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
    SimpleArray() {
        this.objects = new Object[10];
    }

    /**
     * Constructor whit parameter.
     *
     * @param size Size to array
     */
    SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param value element to be appended to this list
     */
    public void add(T value) {
        if (objects.length <= this.index + 1) {
            addCapacity();
        }
        objects[index++] = value;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index index at which the specified element is to be inserted
     * @param value element to be inserted
     */
    public void add(int index, T value) {
        rangeCheck(index);
        if (objects.length < this.index + 1) {
            addCapacity();
        }
        System.arraycopy(this.objects, index, this.objects, index + 1, this.index - index);
        this.objects[index] = value;
        this.index++;
    }

    /**
     * the method takes the value at index.
     *
     * @param index index in array.
     * @return object of array
     */
    public T get(int index) {
        rangeCheck(index);
        return (T) this.objects[index];
    }

    /**
     * Returns the index of the first occurrence of the specified element.
     *
     * @param value The search item
     * @return Returns the element index or -1 if not found
     */
    public int getIndex(T value) {
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
     * Method update element in array.
     *
     * @param index index in array.
     * @param value the new value of the element
     */
    public void update(int index, T value) {
        rangeCheck(index);
        this.objects[index] = value;
    }

    /**
     * Method update element in array.
     *
     * @param valueInSimpleArray the value of a modifiable element
     * @param value              the new value of the element
     * @return true if ok or false if not ok
     */
    public boolean update(T valueInSimpleArray, T value) {
        boolean result = true;
        int foundIndex = getIndex(valueInSimpleArray);
        if (foundIndex >= 0) {
            this.objects[foundIndex] = value;
        } else {
            result = false;
        }
        return result;
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
    public boolean delete(T value) {
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
     * extends the array.
     */
    private void addCapacity() {
        this.objects = Arrays.copyOf(this.objects, (this.objects.length * 3) / 2 + 1);
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
}
