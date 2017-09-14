package ru.job4j.map4bank;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Test  class for user.
 *
 * @author Ruzhev Alexander
 * @since 12.09.2017
 */
public class UserTest {
    /**
     * Test for equals.
     */
    @Test
    public void whenEquals() {
        User user1 = new User("Alexander", "4009858755");
        User user2 = new User("Alexand", "4009858755");
        User user3 = new User("Alexander", "4009858788");
        assertThat(true, is(user1.equals(user2)));
        assertThat(false, is(user1.equals(user3)));
    }

    /**
     * test for hashCode.
     */
    @Test
    public void whenHashCode() {
        User user1 = new User("Alexander", "4009858755");
        User user2 = new User("Alexander", "4009858755");
        assertThat(user1.hashCode(), is(user2.hashCode()));
    }

}