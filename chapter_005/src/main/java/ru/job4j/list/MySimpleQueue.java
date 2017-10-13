package ru.job4j.list;

/**
 * The class implements a queue on the basis of (first in, first out).
 *
 * @param <T> the type of elements in this queue
 * @author Ruzhev Alexander
 * @since 12.10.2017
 */
public class MySimpleQueue<T> extends MyAbstractQueue<T> {
    /**
     * Reference to the last element.
     */
    private Node<T> last;

    /**
     * Constructor.
     */
    MySimpleQueue() {
        super();
    }

    /**
     * The method adds a new object to the end of the queue.
     *
     * @param value of object.
     */
    public void push(T value) {
        Node<T> node = new Node<>(value, null);
        if (super.getFirst() == null) {
            super.setFirst(node);
            this.last = node;
        } else {
            this.last.setNext(node);
            this.last = node;
        }
        setSize(getSize() + 1);
    }
}
