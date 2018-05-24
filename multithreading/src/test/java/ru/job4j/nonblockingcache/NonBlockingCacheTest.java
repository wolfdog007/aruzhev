package ru.job4j.nonblockingcache;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ruzhev Alexander
 * @since 24.05.2018
 */
public class NonBlockingCacheTest {
    /**
     * The method for check work add new element by key and value to collection.
     *
     * @throws Exception - check any errors;
     */
    @Test
    public void whenAdd() throws Exception {
        NonBlockingCache<Integer, Model> base = new NonBlockingCache<>();

        assertThat(base.add(1, new Model("1")), is(true));
        assertThat(base.add(1, new Model("2")), is(false));
        assertThat(base.add(2, new Model("2")), is(true));
    }

    /**
     * The method for check work delete element by key to collection.
     *
     * @throws Exception - check any errors;
     */
    @Test
    public void whenDelete() throws Exception {
        NonBlockingCache<Integer, Model> base = new NonBlockingCache<>();

        base.add(1, new Model("1"));
        base.add(2, new Model("2"));
        base.add(3, new Model("3"));

        assertThat(base.delete(1), is(true));
        assertThat(base.delete(2), is(true));
        assertThat(base.delete(4), is(false));
    }

    /**
     * The method for check correct work method`s update.
     *
     * @throws Exception - check any errors;
     */
    @Test
    public void whenCorrectUpdate() throws Exception {
        NonBlockingCache<Integer, Model> base = new NonBlockingCache<>();
        Model first = new Model("first");
        Model middle = new Model("middle");
        Model last = new Model("last");
        base.add(1, first);
        base.add(2, middle);
        base.add(3, last);
        middle.setName("second");
        base.update(2, middle);
    }

    /**
     * The method for check un correct work method`s update.
     *
     * @throws Exception - check any errors;
     */
    @Test(expected = OptimisticException.class)
    public void whenIncorrectUpdate() throws Exception {
        NonBlockingCache<Integer, Model> base = new NonBlockingCache<>();
        Model first = new Model("first");
        base.add(1, first);
        base.update(1, new Model("first"));
    }

    /**
     * Test on 20 threads.
     *
     * @throws Exception - any exceptions
     */
    @Test
    public void whenThreadsUpdate() throws Exception {
        NonBlockingCache<Integer, Model> base = new NonBlockingCache<>();
        Model first = new Model("first");
        base.add(1, first);
        int vers = first.getVersion();
        System.out.println(first.getVersion());

        for (int i = 0; i < 20; i++) {
            int finalI = i;
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 20; j++) {
                        first.setName("name" + finalI + "" + j);
                        base.update(1, first);
                    }
                }
            }.start();
        }
        Thread.currentThread().sleep(1000);
        assertThat(first.getVersion() - vers, is(400));
    }
}
