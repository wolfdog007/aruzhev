package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test for ParallelSearch.
 *
 * @author Ruzhev Alexander
 * @since 23.05.2018
 */
public class ParallelSearchTest {
    /**
     * ParallelSearch test.
     */
    @Test
    public void whenProgramIsWorkThenOk() {
        List<String> extx = new ArrayList<>();
        extx.add("java");
        extx.add("txt");
        String root = "c:/";
        String text = "constructor";
        ParallelSearch parallelSearch = new ParallelSearch(root, text, extx);
        parallelSearch.init();
        parallelSearch.result().forEach((System.out::println));
    }

}