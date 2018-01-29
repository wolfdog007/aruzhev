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

    /**
     * The test method check, when tree is not binary (have children > 2).
     *
     * @throws Exception - check any errors;
     */
    @Test
    public void whenTreeIsNotBinary() throws Exception {
        Tree<String> tree = new Tree<>("1");
        tree.add("1", "2");
        tree.add("1", "3");
        tree.add("1", "7");
        tree.add("2", "4");
        tree.add("3", "5");
        tree.add("4", "6");
        assertThat(tree.isBinary(), is(false));
    }

    /**
     * The test method check, when tree is binary (have children < 3).
     *
     * @throws Exception - check any errors;
     */
    @Test
    public void whenTreeIsBinary() throws Exception {
        Tree<String> tree = new Tree<>("1");
        tree.add("1", "2");
        tree.add("1", "3");
        tree.add("2", "4");
        tree.add("3", "5");
        tree.add("4", "6");
        assertThat(tree.isBinary(), is(true));
    }

    /**
     * The test method check, when tree is not binary (have children > 2).
     */
    @Test
    public void shouldReturnFalse() {
        Tree<Integer> tree = new Tree<>(50);
        tree.add(50, 70);
        tree.add(50, 80);
        tree.add(70, 90);
        tree.add(70, 100);
        tree.add(90, 110);
        tree.add(90, 120);
        tree.add(100, 180);
        tree.add(100, 190);
        tree.add(100, 290);
        tree.add(180, 200);
        tree.add(180, 210);
        tree.add(190, 211);
        tree.add(190, 215);
        tree.add(190, 217);
        assertThat(tree.isBinary(), is(false));
    }
}