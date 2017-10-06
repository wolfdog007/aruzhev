package ru.job4j.generics;

/**
 * Abstract class for store, extends by UserStore and RoleStore.
 *
 * @param <T> - type parameter
 * @author Ruzhev Alexander
 * @since 06.10.2017
 */
public abstract class AbstractStore<T extends Base> implements Store {
    /**
     * The list on the base array for type Base and him extends.
     */
    private SimpleArray<Base> base = new SimpleArray<>();

    /**
     * Add new user.
     *
     * @param model new user
     */
    @Override
    public void add(Base model) {
        base.add(model);
    }

    /**
     * Edit object into base or add new user.
     *
     * @param model new user
     */
    @Override
    public void update(Base model) {
        Base oldUser = getById(model.getId());
        if (oldUser == null) {
            add(model);
        } else {
            base.update(oldUser, model);
        }
    }

    /**
     * Delete object by ip.
     *
     * @param id - the key.
     * @return true if deletion successfully, or false
     */
    @Override
    public boolean delete(String id) {
        return base.delete(getById(id));
    }

    /**
     * Get user by id.
     *
     * @param id the key.
     * @return the user if this id found or null if not.
     */
    private Base getById(String id) {
        Base result = null;
        for (Base b : base) {
            if (b.getId().equals(id)) {
                result = b;
            }
        }
        return result;
    }

    /**
     * The method return SimpleArray base for the test.
     *
     * @return SimpleArray base
     */
    public SimpleArray<Base> getBase() {
        return this.base;
    }
}
