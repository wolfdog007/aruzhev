package ru.job4j;

import org.junit.Test;

/**
 * Test class.
 *
 * @author Ruzhev Alexander
 * @since 12.03.2018
 */
public class TextCounterTest {
    /**
     * Test for TextCounter.
     */
    @Test
    public void start() {
        new TextCounter("Создать программу, которая будет считать количество слов и пробелов в тексте. Здесь не надо использовать регулярные выражения. Просто в цикле перебрать символы.").start();
    }

}