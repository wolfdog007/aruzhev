package ru.job4j.list;

/**
 * The class implements a queue on the basis of (last in, first out).
 *
 * @param <T> the type of elements in this queue
 * @author Ruzhev Alexander
 * @since 12.10.2017
 */
public class MySimpleStack<T> extends MyAbstractQueue<T> {
    /**
     * Constructor.
     */
    MySimpleStack() {
        super();
    }

    /**
     * The method adds a new object to the top of the queue.
     *
     * @param value of object.
     */
    public void push(T value) {
        super.setFirst(new Node<>(value, super.getFirst()));
        setSize(getSize() + 1);
    }
}
