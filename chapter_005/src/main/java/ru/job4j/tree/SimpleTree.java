package ru.job4j.tree;

import java.util.Optional;

/**
 * The interface SimpleTree.
 * @param <E> This describes my type parameter. Type for key;
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     *
     * @param parent parent.
     * @param child  child.
     * @return true or false.
     */
    boolean add(E parent, E child);

    /**
     * The method searches the element in the collection.
     *
     * @param value value.
     * @return element in the collection.
     */
    Optional<Node<E>> findBy(E value);
}
