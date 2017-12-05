package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for UserTest.
 *
 * @author Ruzhev Alexander
 * @since 30.11.2017
 */
public class UserTest {
    /**
     * The test method for check result output.
     */
    @Test
    public void whenCheckOutputResult() {
        GregorianCalendar date = new GregorianCalendar(1983, 3, 15);
        User user1 = new User("Alexandr", 0, date);
        User user2 = new User("Alexandr", 0, date);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "one");
        map.put(user2, "two");
        System.out.print(map);
        //  assertThat(user1.hashCode(), is(user2.hashCode()));
        assertThat(user1.equals(user2), is(true));
        assertThat(user1.getName().equals(user2.getName()), is(true));
        assertThat(user1.getChildren() == user2.getChildren(), is(true));
        assertThat(user1.getBirthday().equals(user2.getBirthday()), is(true));
    }
}