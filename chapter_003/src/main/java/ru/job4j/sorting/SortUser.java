package ru.job4j.sorting;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Sorting users.
 *
 * @author Ruzhev Alexander
 * @since 02.08.2017
 */
public class SortUser {
    /**
     * Fields contains a comparator for sortNameLength.
     */
    private Comparator compareLength = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            return o1.getName().length() - o2.getName().length();
        }
    };
    /**
     * Fields contains a comparator for sortByAllFields.
     */
    private Comparator compareAllFields = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            final int compareAll = o1.getName().length() - o2.getName().length();
            return compareAll == 0 ? o1.compareTo(o2) : compareAll;
        }
    };

    /**
     * Method Sorts the list of users by age and returns it to TreeSet.
     *
     * @param userList a list of users.
     * @return sorting list users
     */
    public Set<User> sort(List<User> userList) {
        Set<User> userThreeSet = new TreeSet<>();
        for (User user : userList) {
            userThreeSet.add(user);
        }
        return userThreeSet;
    }

    /**
     * Method Sorts the list of users by name length.
     *
     * @param userList a list of users
     * @return sorting list users
     */
    public List<User> sortNameLength(List<User> userList) {
        userList.sort(compareLength);
        return userList;
    }

    /**
     * Method Sorts the list of users by name length and age.
     *
     * @param userList a list of users
     * @return sorting list users
     */
    public List<User> sortByAllFields(List<User> userList) {
        userList.sort(compareAllFields);
        return userList;
    }
}
