package ru.job4j.generics;

/**
 * Class interface.
 * @param <T> - type parameter
 * @author Ruzhev Alexander
 * @since 06.10.2017
 */
public interface Store<T extends Base> {
    /**
     * Add new object.
     *
     * @param model new object
     */
    void add(T model);

    /**
     * Edit object into base.
     *
     * @param model new object
     */
    void update(T model);

    /**
     * Delete object by id.
     *
     * @param id - the key.
     * @return true if deletion successfully, or false
     */
    boolean delete(String id);
}
