package ru.job4j.sorting;

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
}
