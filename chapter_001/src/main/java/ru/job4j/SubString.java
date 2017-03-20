package ru.job4j;

/**
 * Search of a substring in a string.
 *
 * @author Ruzhev Alexander
 * @since 15.03.2017
 */
public class SubString {
    /**
     * The method returns true if substring is contained in string.
     *
     * @param origin - location search
     * @param sub    - the object of the search
     * @return result - true or false
     */
    public boolean contains(String origin, String sub) {
        boolean result = false;
        char[] originChar = origin.toLowerCase().toCharArray();
        char[] subChar = sub.toLowerCase().toCharArray();
        for (int i = 0, j = 0; j < subChar.length && i < originChar.length; i++) {
            if (originChar[i] != subChar[j++]) {
                j = 0;
            }
            if (j == subChar.length) {
                result = true;
                break;
            }
        }
        return result;
    }
}
