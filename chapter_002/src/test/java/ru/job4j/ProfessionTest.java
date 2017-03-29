package ru.job4j;

import java.util.Date;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class Profession.
 *
 * @author Ruzhev Alexander
 * @since 29.03.2017
 */
public class ProfessionTest {
    /**
     * test on getName.
     */
    @Test
    public void whenGetName() {
        Date date = new Date(2000, 9, 1);
        Profession profession = new Profession("Ivanov", 30, date, "surgeon");
        assertThat("Ivanov", is(profession.getName()));
    }

    /**
     * test on setName.
     */
    @Test
    public void whenSetName() {
        Date date = new Date(2000, 9, 1);
        Profession profession = new Profession("Ivanov", 30, date, "surgeon");
        profession.setName("Petrov");
        assertThat("Petrov", is(profession.getName()));
    }
    /**
     * test on getAge.
     */
    @Test
    public void whenGetAge() {
        Date date = new Date(2000, 9, 1);
        Profession profession = new Profession("Ivanov", 30, date, "surgeon");
        assertThat(30, is(profession.getAge()));
    }
    /**
     * test on setAge.
     */
    @Test
    public void whenSetAge() {
        Date date = new Date(2000, 9, 1);
        Profession profession = new Profession("Ivanov", 30, date, "surgeon");
        profession.setAge(25);
        assertThat(25, is(profession.getAge()));
    }
    /**
     * test on getEmployed.
     */
    @Test
    public void whenGetEmployed() {
        Date date = new Date(2000, 9, 1);
        Profession profession = new Profession("Ivanov", 30, date, "surgeon");
        assertThat(date, is(profession.getEmployed()));
    }
    /**
     * test on SetEmployed.
     */
    @Test
    public void whenSetEmployed() {
        Date date = new Date(2000, 9, 1);
        Profession profession = new Profession("Ivanov", 30, date, "surgeon");
        Date newDate = new Date(2001, 10, 5);
        profession.setEmployed(newDate);
        assertThat(newDate, is(profession.getEmployed()));
    }
    /**
     * test on getProfession.
     */
    @Test
    public void whenGetProfession() {
        Date date = new Date(2000, 9, 1);
        Profession profession = new Profession("Ivanov", 30, date, "surgeon");
        assertThat("surgeon", is(profession.getProfession()));
    }
    /**
     * test on setProfession.
     */
    @Test
    public void whenSetProfession() {
        Date date = new Date(2000, 9, 1);
        Profession profession = new Profession("Ivanov", 30, date, "surgeon");
        profession.setProfession("therapist");
        assertThat("therapist", is(profession.getProfession()));
    }

}
