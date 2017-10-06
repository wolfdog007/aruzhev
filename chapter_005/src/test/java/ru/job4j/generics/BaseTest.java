package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;

/**
 * Test class for store.
 *
 * @author Ruzhev Alexander
 * @since 06.10.2017
 */
public class BaseTest {
    /**
     * Test add.
     */
    @Test
    public void whenAdd() {
        AbstractStore userBase = new UserStore();
        AbstractStore roleBase = new RoleStore();
        Base userOne = new User("1001", "Alexander");
        Base roleOne = new Role("1001", "Student");
        userBase.add(userOne);
        roleBase.add(roleOne);
        assertThat(userBase.getBase().get(0), is(userOne));
        assertThat(roleBase.getBase().get(0), is(roleOne));
    }

    /**
     * Test when update the object change.
     */
    @Test
    public void whenUpdateThenChange() {
        AbstractStore userBase = new UserStore();
        AbstractStore roleBase = new RoleStore();
        Base userOne = new User("1001", "Alexander");
        Base roleOne = new Role("1001", "Student");
        Base userTwo = new User("1001", "Petr");
        Base roleTwo = new Role("1001", "Mentor");
        userBase.add(userOne);
        roleBase.add(roleOne);
        userBase.update(userTwo);
        roleBase.update(roleTwo);
        assertThat(userBase.getBase().get(0), is(userTwo));
        assertThat(roleBase.getBase().get(0), is(roleTwo));
    }

    /**
     * Test when update then add new object.
     */
    @Test
    public void whenUpdateThenAddNew() {
        AbstractStore userBase = new UserStore();
        AbstractStore roleBase = new RoleStore();
        Base userOne = new User("1001", "Alexander");
        Base roleOne = new Role("1001", "Student");
        Base userTwo = new User("1002", "Petr");
        Base roleTwo = new Role("1002", "Mentor");
        userBase.add(userOne);
        roleBase.add(roleOne);
        userBase.update(userTwo);
        roleBase.update(roleTwo);
        assertThat(userBase.getBase().get(1), is(userTwo));
        assertThat(roleBase.getBase().get(1), is(roleTwo));
    }

    /**
     * Test when delete then true.
     */
    @Test
    public void whenDeleteThenTrue() {
        AbstractStore userBase = new UserStore();
        AbstractStore roleBase = new RoleStore();
        Base userOne = new User("1001", "Alexander");
        Base roleOne = new Role("1001", "Student");
        Base userTwo = new User("1002", "Petr");
        Base roleTwo = new Role("1002", "Mentor");
        userBase.add(userOne);
        roleBase.add(roleOne);
        userBase.add(userTwo);
        roleBase.add(roleTwo);
        assertThat(true, is(userBase.delete("1001")));
        assertThat(true, is(roleBase.delete("1001")));
        assertThat(userBase.getBase().get(0), is(userTwo));
        assertThat(roleBase.getBase().get(0), is(roleTwo));
    }

    /**
     * Test when delete then false.
     */
    @Test
    public void whenDeleteThenFalse() {
        AbstractStore userBase = new UserStore();
        AbstractStore roleBase = new RoleStore();
        Base userOne = new User("1001", "Alexander");
        Base roleOne = new Role("1001", "Student");
        userBase.add(userOne);
        roleBase.add(roleOne);
        assertThat(false, is(userBase.delete("1002")));
        assertThat(false, is(roleBase.delete("1002")));
        assertThat(userBase.getBase().get(0), is(userOne));
        assertThat(roleBase.getBase().get(0), is(roleOne));
    }
}
