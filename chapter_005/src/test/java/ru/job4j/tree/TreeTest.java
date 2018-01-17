package ru.job4j.tree;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TreeTest {

    /**
     * The test method check correct return count values to tree.
     */
    @Test
    public void whenCheckCorrectReturnSizeTree() {
        Tree<String> tree = new Tree<>("1");
        tree.add("1", null);
        tree.add("1", "2");
        tree.add("1", "2");
        tree.add(null, null);
        tree.add(null, "4");
        System.out.println(tree);
        tree.toArray(new String[0]);
        assertThat(tree.size(), is(2));
    }

    /**
     * Test method findBy, when true.
     */
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));
    }

    /**
     * Test method findBy, when false.
     */
    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(tree.findBy(7).isPresent(), is(false));
    }
}