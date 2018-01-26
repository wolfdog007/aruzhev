package ru.job4j.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * The class Tree - use for storage value to tree.
 *
 * @param <E> This describes my type parameter. Type for key;
 * @author Ruzhev Alexander
 * @since 16.01.2018
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * The head tree.
     */
    private Node<E> root;
    /**
     * The count value to tree.
     */
    private int size;

    /**
     * The constructor for class Tree. Create head tree with value.
     *
     * @param value - value head;
     */
    Tree(E value) {
        this.root = new Node<>(value);
        this.size++;
    }

    /**
     * The method return count values to tree.
     *
     * @return - count values to tree;
     */
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = parent != null && child != null && parent.compareTo(child) != 0;
        if (result) {
            if (this.root != null) {
                Optional<Node<E>> optional = findBy(parent);
                if (result = optional.isPresent()) {
                    Optional<Node<E>> optChild = findBy(child);
                    if (result = !optChild.isPresent()) {
                        optional.get().leaves().add(new Node<>(child));
                        this.size++;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Node<E> findNode = find(this.root, value, null);
        return findNode == null ? Optional.empty() : Optional.of(findNode);
    }

    /**
     * The method searches the element in the collection.
     *
     * @param root  root
     * @param value value.
     * @param find  - new root.
     * @return found element.
     */
    private Node<E> find(Node<E> root, E value, Node<E> find) {
        if (root != null && find == null) {
            if (root.getRoot().compareTo(value) == 0) {
                find = root;
            } else {
                for (Node<E> node : root.leaves()) {
                    find = find(node, value, find);
                }
            }
        }
        return find;
    }

    @Override
    public Iterator<E> iterator() {
        return treeToList(this.root, new ArrayList<>()).iterator();
    }

    /**
     * Return Tree as List.
     *
     * @param root - root
     * @param list - ArrayList
     * @return list
     */
    private List<E> treeToList(Node<E> root, List<E> list) {
        if (root != null) {
            for (Node<E> node : root.leaves()) {
                list = treeToList(node, list);
            }
            list.add(root.getRoot());
        }
        return list;
    }

    @Override
    public String toString() {
        return treeToList(this.root, new ArrayList<>()).toString();
    }

    /**
     * Return Tree as array.
     *
     * @param array - array
     * @return array
     */
    E[] toArray(E[] array) {
        return treeToList(this.root, new ArrayList<>()).toArray(array);
    }

    /**
     * The method check tree is binary or not.
     *
     * @return true - children < 3; false - children > 2;
     */
    public boolean isBinary() {
        return checkIsBinary(root, true);
    }

    /**
     * The recurse method for check is binary tree or not.
     *
     * @param head   - head tree;
     * @param result - var for return result;
     * @return - true - is binary; false - is not binary;
     */
    private boolean checkIsBinary(Node<E> head, boolean result) {
        if (head != null && (result = head.leaves().size() <= 2)) {
            for (Node<E> element : head.leaves()) {
                result = checkIsBinary(element, result);
            }
        }
        return result;
    }
}


/**
 * The inner class Node - model element.
 *
 * @param <E> This describes my type parameter. Type for key;
 */
class Node<E> {
    /**
     * The list children.
     */
    private final List<Node<E>> children;
    /**
     * The var - value.
     */
    private final E value;

    /**
     * Constructor.
     *
     * @param value - value
     */
    Node(final E value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    /**
     * Getter for children.
     *
     * @return children
     */
    List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Getter for value.
     *
     * @return value.
     */
    E getRoot() {
        return this.value;
    }
}
