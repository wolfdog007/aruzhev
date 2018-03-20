package ru.job4j;

/**
 * Class output count spaces and words.
 *
 * @author Ruzhev Alexander
 * @since 12.03.2018
 */
public class TextCounter {
    /**
     * Offer to check.
     */
    private String offer;

    /**
     * Constructor.
     *
     * @param offer - Offer to check
     */
    TextCounter(String offer) {
        this.offer = offer;
    }

    /**
     * Start process.
     */
    public void start() {
        WordCounter wordCounter = new WordCounter(this.offer);
        SpaceCounter spaceCounter = new SpaceCounter(this.offer);
        wordCounter.start();
        spaceCounter.start();
        try {
            spaceCounter.join();
            wordCounter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * The inner class ThreadCountSpaces - thread for count spaces to offer.
 */
class SpaceCounter extends Thread {
    /**
     * Offer to check.
     */
    private String offer;

    /**
     * Constructor.
     *
     * @param offer - Offer to check
     */
    SpaceCounter(String offer) {
        this.offer = offer;
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i < this.offer.length(); i++) {
            if (this.offer.charAt(i) == ' ') {
                count++;
            }
        }
        System.out.println(String.format("Number of spaces in the text = %s", count));
    }
}

/**
 * The inner class ThreadCountWords - thread for count words to offer.
 */
class WordCounter extends Thread {
    /**
     * Offer to check.
     */
    private String offer;

    /**
     * Constructor.
     *
     * @param offer - Offer to check
     */
    WordCounter(String offer) {
        this.offer = offer;
    }

    @Override
    public void run() {
        boolean wordFlag = false;
        int count = 0;
        for (int i = 0; i < this.offer.length(); i++) {
            if (this.offer.charAt(i) == ' ') {
                if (wordFlag) {
                    count++;
                }
                wordFlag = false;
            } else {
                wordFlag = true;
            }
        }
        if (wordFlag) {
            count++;
        }
        System.out.println(String.format("Number of words in the text = %s", count));
    }
}