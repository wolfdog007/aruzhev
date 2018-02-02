package ru.job4j.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The class Tree - use for storage value to tree.
 *
 * @param <E> This describes my type parameter. Type for key;
 * @author Ruzhev Alexander
 * @since 01.02.2018
 */
public class BinaryTree<E extends Comparable<E>> implements Iterable<E> {
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
     * @param values - array values;
     */
    public BinaryTree(E[] values) {
        addAll(values);
    }

    /**
     * The default constructor for class BinaryTree.
     */
    public BinaryTree() {
    }

    /**
     * The method return count values to tree.
     *
     * @return - count values to tree;
     */
    public int size() {
        return this.size;
    }

    /**
     * The method check tree is empty or is not empty.
     *
     * @return true - tree is empty; false - tree is not empty;
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * The method add array values to binary tree.
     *
     * @param values - array values;
     */
    public void addAll(E[] values) {
        if (values != null) {
            for (E value : values) {
                add(value);
            }
        }
    }

    /**
     * The method add new value to binary tree.
     *
     * @param value - value;
     * @return true - is add; false - is not add;
     */
    public boolean add(E value) {
        boolean result = value != null;
        if (result) {
            Node<E> temp = getPlace(this.root, value);
            if (result = temp != null) {
                temp.parent = value;
                this.size++;
            } else if (result = isEmpty()) {
                this.root = new Node<>(value);
                this.size++;
            }
        }
        return result;
    }

    /**
     * The recurse method for get link Node by value.
     *
     * @param parent - parent
     * @param value  - vlue
     * @return link Node or null, if is not searching;
     */
    private Node<E> getPlace(Node<E> parent, E value) {
        if (parent != null && parent.parent != null) {
            if (parent.parent.compareTo(value) > 0) {
                if (parent.left == null) {
                    parent.left = new Node<>();
                }
                parent = getPlace(parent.left, value);
            } else if (parent.parent.compareTo(value) < 0) {
                if (parent.right == null) {
                    parent.right = new Node<>();
                }
                parent = getPlace(parent.right, value);
            } else {
                parent = null;
            }
        }
        return parent;
    }

    /**
     * The recurse method convert tree to list.
     *
     * @param root - heads tree;
     * @param list - list with value tree;
     * @return - list values;
     */
    private List<E> getListToTree(Node<E> root, List<E> list) {
        if (root != null) {
            list = getListToTree(root.left, list);
            list.add(root.parent);
            list = getListToTree(root.right, list);
        }
        return list;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return getListToTree(this.root, new ArrayList<E>()).iterator();
    }

    @Override
    public String toString() {
        return getListToTree(this.root, new ArrayList<>()).toString();
    }

    /**
     * The inner class Node - model element.
     *
     * @param <E> This describes my type parameter. Type for key;
     */
    private class Node<E> {
        /**
         * The var - value.
         */
        private E parent;

        /**
         * The link to min element.
         */
        private Node<E> left;

        /**
         * The link to max element.
         */
        private Node<E> right;

        /**
         * The constructor for inner class Node.
         *
         * @param parent - value;
         */
        Node(E parent) {
            this.parent = parent;
        }

        /**
         * constructor without parameters.
         */
        Node() {
        }

        @Override
        public String toString() {
            return this.parent != null ? parent.toString() : "null";
        }
    }
}
