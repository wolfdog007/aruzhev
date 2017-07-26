package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Ruzhev Alexander
 * @since 26.07.2017
 */
public class UserConvertTest {
    /**
     * Test for UserConvert.process.
     */
    @Test
    public void whenProcess() {
        User user1 = new User(123, "Artem", "City1");
        User user2 = new User(456, "Ivan", "City2");
        User user3 = new User(789, "Sergey", "City3");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        HashMap<Integer, User> expectedHashMap = new HashMap<>();
        expectedHashMap.put(user1.getId(), user1);
        expectedHashMap.put(user2.getId(), user2);
        expectedHashMap.put(user3.getId(), user3);

        UserConvert convert = new UserConvert();
        assertThat(expectedHashMap, is(convert.process(list)));
    }
}
