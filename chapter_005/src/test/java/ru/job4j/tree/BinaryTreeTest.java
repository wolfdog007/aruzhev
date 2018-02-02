package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ruzhev Alexander
 * @since 01.02.2018
 */
public class BinaryTreeTest {
    /**
     * Test add().
     */
    @Test
    public void whenAddCheckCorrectWork() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertThat(tree.add(1), is(true));
        assertThat(tree.add(1), is(false));
        assertThat(tree.add(2), is(true));
        assertThat(tree.add(2), is(false));
        assertThat(tree.add(3), is(true));
        assertThat(tree.add(3), is(false));
        assertThat(tree.size(), is(3));
    }

    /**
     * The test method check correct work iterator for binary tree.
     */
    @Test
    public void whenCheckCorrectWorkIteratorForTree() {
        BinaryTree<Integer> tree = new BinaryTree<>(new Integer[]{1, 1, 5, null, 3, 4, 3, 10, 7, 2});
        Integer[] resultArray = {1, 2, 3, 4, 5, 7, 10};
        int index = 0;
        Iterator<Integer> iterator = tree.iterator();
        while (iterator.hasNext()) {
            assertThat(iterator.next(), is(resultArray[index++]));
        }
    }

    /**
     * The test method check throws exception is not correct work iterator.
     *
     * @throws Exception - throws NoSuchElementException if elements the end;
     */
    @Test(expected = NoSuchElementException.class)
    public void whenCheckIsNotCorrectWorkIteratorForTree() throws Exception {
        BinaryTree<Integer> tree = new BinaryTree<>();
        Iterator<Integer> iterator = tree.iterator();
        iterator.next();
    }

}