package ru.job4j;

import java.util.HashMap;
import java.util.List;

/**
 * Converts the list of users to HashMap<Integer, User>.
 *
 * @author Ruzhev Alexander
 * @since 26.07.2017
 */
public class UserConvert {
    /**
     * Converts the list of users to HashMap<Integer, User>.
     *
     * @param list - list of users
     * @return HashMap<Integer, User>
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hashMap = new HashMap<>();
        for (User user : list) {
            hashMap.put(user.getId(), user);
        }
        return hashMap;
    }
}
