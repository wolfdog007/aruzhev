package ru.job4j.start;

/**
 * Validate input extends ConsoleInput.
 *
 * @author Ruzhev Alexander
 * @since 21.04.2017
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Check valid values.
     * @param question - question for users
     * @param range - the range of answers
     * @return - response within acceptable value
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please, select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please, inter validate date again.");
            }
        } while (invalid);
        return value;
    }
}
