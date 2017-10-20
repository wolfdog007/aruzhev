package ru.job4j.list;

/**
 * This class defines a cyclic linked list.
 *
 * @param <T> the type of elements in this queue
 * @author Ruzhev Alexander
 * @since 20.10.2017
 */
public class CycleCheck<T> {
    /**
     * The method return true if list is cyclic.
     *
     * @param first - first object in list
     * @return true if list is cyclic
     */
    boolean hasCycle(Node first) {
        boolean result = false;
        Node node = first;
        Node countNode = first;
        while (countNode.next != null) {
            if (countNode.next == node) {
                result = true;
                break;
            }
            if (node == countNode) {
                countNode = countNode.next;
                node = first;
            } else {
                node = node.next;
            }
        }
        return result;
    }

    /**
     * /**
     * The inner class for storing values and references.
     *
     * @param <T> the type of elements in this collection
     */
    static class Node<T> {
        /**
         * The stored object.
         */
        private T value;
        /**
         * Link to next element.
         */
        private Node<T> next;

        /**
         * Constructor.
         *
         * @param value the stored object.
         * @param next  next element.
         */
        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        /**
         * Setter for next.
         *
         * @param next Link to next element
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
