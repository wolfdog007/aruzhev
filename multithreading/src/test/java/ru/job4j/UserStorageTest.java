package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for UserStorage.
 *
 * @author Ruzhev Alexander
 * @since 19.04.2018
 */
public class UserStorageTest {
    /**
     * When add.
     *
     * @throws Exception - any exceptions
     */
    @Test
    public void whenAddThenTrue() throws Exception {
        User user1 = new User(1, 100);
        User user2 = new User(2, 100);
        UserStorage userStorage = new UserStorage();

        assertThat(userStorage.add(user1), is(true));
        assertThat(userStorage.add(user2), is(true));
    }

    /**
     * When update.
     *
     * @throws Exception - any exceptions
     */
    @Test
    public void whenUpdate() throws Exception {
        User user1 = new User(1, 100);
        User user2 = new User(2, 100);
        UserStorage userStorage = new UserStorage();
        userStorage.add(user1);
        userStorage.add(user2);

        assertThat(userStorage.update(new User(1, 300)), is(true));
        assertThat(userStorage.update(new User(3, 300)), is(false));
    }

    /**
     * When delete.
     *
     * @throws Exception - any exceptions
     */
    @Test
    public void whenDelete() throws Exception {
        User user1 = new User(1, 100);
        User user2 = new User(2, 100);
        UserStorage userStorage = new UserStorage();
        userStorage.add(user1);
        userStorage.add(user2);

        assertThat(userStorage.delete(user1), is(true));
        assertThat(userStorage.delete(new User(3, 300)), is(false));
    }

    /**
     * When transfer.
     *
     * @throws Exception any exception
     */
    @Test
    public void whenTransfer() throws Exception {
        User user1 = new User(1, 100);
        User user2 = new User(2, 100);
        UserStorage userStorage = new UserStorage();
        userStorage.add(user1);
        userStorage.add(user2);

        assertThat(userStorage.transfer(1, 2, 50), is(true));
        assertThat(userStorage.transfer(1, 2, 100), is(false));
        assertThat(userStorage.transfer(2, 3, 100), is(false));

        assertThat(userStorage.get(1).getAmount(), is(50));
        assertThat(userStorage.get(2).getAmount(), is(150));
    }

}