package ru.job4j.set;

/**
 * The class implements a host-based hash tables.
 *
 * @param <E> the type of elements in this queue
 * @author Ruzhev Alexander
 * @since 09.11.2017
 */
public class MyHashSet<E> {
    /**
     * The number of elements.
     */
    private int size;
    /**
     * Size whit bucket.
     */
    private int bucketSize = 16;
    /**
     * Hash array.
     */
    private Node[] list = new Node[bucketSize];
    /**
     * A pointer to the last node.
     */
    private Node<E> node;

    /**
     * Constructor.
     */
    MyHashSet() {
        this.size = 0;
    }

    /**
     * Constructor.
     *
     * @param bucketSize - size whit bucket.
     */
    public MyHashSet(int bucketSize) {
        this.size = 0;
        this.list = new Node[bucketSize];
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * @return false or true
     */
    public boolean add(E e) {
        boolean result = false;
        if (bucketSize * 0.75 <= size) {
            increase();
        }
        int index = Math.abs(e.hashCode() % bucketSize);
        if (!contains(e)) {
            if (this.list[index] == null) {
                this.list[index] = new Node<E>(null, e, null);
            } else {
                node.next = new Node<E>(node, e, null);
            }
            size++;
            result = true;
        }
        return result;
    }

    /**
     * increasing the size of the array.
     */
    private void increase() {
        Node<E>[] temp = list;
        int oldSize = size;
        int count = 0;
        Node<E> altNode;
        int oldBucketSize = bucketSize;
        this.bucketSize = size * 2;
        this.list = new Node[this.bucketSize];
        size = 0;
        int i = 0;
        while (i < oldBucketSize || count < oldSize) {
            if (temp[i] != null) {
                add(temp[i].item);
                count++;
                altNode = temp[i].next;
                while (altNode != null) {
                    add(altNode.item);
                    count++;
                    altNode = altNode.next;
                }
            }
            i++;
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index of the element to return
     * @return the element at the specified position in this list
     */
    public E get(int index) {
        Node<E> altNode = list[0];
        int count = 0;
        int i = 0;
        while (i < bucketSize) {
            if (list[i] != null) {
                altNode = list[i];
                while (altNode != null) {
                    count++;
                    if (count > index) {
                        break;
                    }
                    altNode = altNode.next;
                }
                if (count > index) {
                    break;
                }
            }
            i++;
        }
        return altNode.item;
    }

    /**
     * Returns true if this set contains the specified element.
     *
     * @param e element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    public boolean contains(E e) {
        boolean result = false;
        int index = Math.abs(e.hashCode() % bucketSize);
        this.node = this.list[index];
        if (this.list[index] != null) {
            do {
                if (node.item.equals(e)) {
                    result = true;
                    break;
                }
                this.node = this.node.next == null ? this.node : this.node.next;
            } while (node.next != null);
        }
        return result;
    }

    /**
     * Remove an item from the list.
     *
     * @param e item for remove.
     * @return true or false
     */
    public boolean remove(E e) {
        boolean result = false;
        int index = Math.abs(e.hashCode() % bucketSize);
        if (contains(e)) {
            result = true;
            if (node.prev == null) {
                this.list[index] = node.next;
            } else {
                node.prev.next = node.next;
            }
            this.node = this.node.next;
            size--;
        }
        return result;
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
     * Reference to the last element.
     */
    /**
     * /**
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
        private Node next;
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
