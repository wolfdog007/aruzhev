package ru.job4j.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for SortUser.
 *
 * @author Ruzhev Alexander
 * @since 02.08.2017
 */
public class SortUserTest {
    /**
     * Check work sort.
     */
    @Test
    public void whenSort() {
        User user1 = new User("user1", 50);
        User user2 = new User("user2", 20);
        User user3 = new User("user3", 30);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        Set<User> userSet = new SortUser().sort(userList);
        User[] expectedResult = userSet.toArray(new User[userSet.size()]);

        User[] trueResult = {user2, user3, user1};

        assertThat(trueResult, is(expectedResult));
    }

    /**
     * check work sortNameLength.
     */
    @Test
    public void whenSortNameLength() {
        User user1 = new User("111", 50);
        User user2 = new User("2", 20);
        User user3 = new User("33", 30);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        User[] expectedResult = new SortUser().sortNameLength(userList).toArray(new User[userList.size()]);
        User[] trueResult = {user2, user3, user1};

        assertThat(trueResult, is(expectedResult));
    }

    /**
     * check work sortByAllFields.
     */
    @Test
    public void whenSortByAllFields() {
        User user1 = new User("111", 50);
        User user2 = new User("222", 20);
        User user3 = new User("33", 10);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        User[] expectedResult = new SortUser().sortByAllFields(userList).toArray(new User[userList.size()]);
        User[] trueResult = {user3, user2, user1};

        assertThat(trueResult, is(expectedResult));
    }

}
