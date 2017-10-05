package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The class Converter - convert iterator iterators to one iterator.
 *
 * @author Ruzhev Alexander
 * @since 02.10.2017
 */
public class Converter {
    /**
     * Convert iterator iterators to one iterator.
     *
     * @param it iterator iterators
     * @return one iterator
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> current = it != null ? it.next() : null;

            @Override
            public boolean hasNext() {
                return current != null && (current.hasNext() || it.hasNext());
            }

            @Override
            public Integer next() {
                while (!current.hasNext()) {
                    current = it.next();
                }
                if (!(current.hasNext() || it.hasNext())) {
                    throw new NoSuchElementException();
                }
                return current.next();
            }
        };
    }
}

