package ru.job4j;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Map;
import java.util.TreeMap;

/**
 * The class UserStorage - use for storage users (accounts) to collections.
 *
 * @author Ruzhev Alexander
 * @since 13.04.2018
 */
@ThreadSafe
public class UserStorage {
    /**
     * Collection for storage users.
     */
    @GuardedBy("itself")
    private final Map<Integer, User> storage;

    /**
     * Constructor.
     */
    public UserStorage() {
        this.storage = new TreeMap<>();
    }

    /**
     * Add new user.
     *
     * @param user - user
     * @return - true, if user is add or false
     */
    public boolean add(User user) {
        boolean result = false;
        synchronized (this.storage) {
            if (user != null) {
                this.storage.put(user.getId(), user);
                result = true;
            }
        }
        return result;
    }

    /**
     * Update user.
     *
     * @param user user
     * @return - true, if user is update or false
     */
    public boolean update(User user) {
        boolean result = false;
        synchronized (this.storage) {
            if (user != null && this.storage.containsKey(user.getId())) {
                this.add(user);
                result = true;
            }
        }
        return result;
    }

    /**
     * Delete user.
     *
     * @param user - user
     * @return - true, if user is delete or false
     */
    public boolean delete(User user) {
        boolean result = false;
        synchronized (this.storage) {
            if (user != null && this.storage.containsKey(user.getId())) {
                this.storage.remove(user.getId());
                result = true;
            }
        }
        return result;
    }

    /**
     * Return user by id.
     *
     * @param id - id
     * @return user
     */
    public User get(int id) {
        synchronized (this.storage) {
            return this.storage.get(id);
        }
    }

    /**
     * The method transfer money between two users.
     *
     * @param fromId - the sender
     * @param toId   - the recipient
     * @param amount - how many cash
     * @return true, if user is add or false
     */
    public boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        synchronized (this.storage) {
            User sender = this.storage.get(fromId);
            User recipient = this.storage.get(toId);
            if (sender != null && recipient != null) {
                if (result = amount > 0 && sender.getAmount() >= amount) {
                    this.storage.put(fromId, new User(fromId, sender.getAmount() - amount));
                    this.storage.put(toId, new User(toId, recipient.getAmount() + amount));
                }
            }
        }
        return result;
    }
}
