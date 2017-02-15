package ru.job4j;

/**
 * Class Max returns the maximum number of two.
 *
 * @author Ruzhev Alexander
 * @since 15.02.2017
 */
class Max {
	/**
     * Returns maximum number.
     *
	 * @param first  first number
     * @param second second number
     * @return result max number
     */
	public int getMaxNumber(int first, int second) {
		return first < second ? second : first;
	}
}