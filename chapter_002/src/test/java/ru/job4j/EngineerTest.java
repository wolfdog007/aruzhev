package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class Engineer.
 *
 * @author Ruzhev Alexander
 * @since 29.03.2017
 */
public class EngineerTest {
    /**
     * Test on RepairerEquipment.
     */
    @Test
    public void whenRepairerEquipment() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Date date = new Date(2000, 9, 1);
        Engineer engineer = new Engineer("Ivanov", 25, date, "Systems");
        MedicalDoctor client = new MedicalDoctor("Petrov", 30, date, "therapist");
        engineer.repairerEquipment(client);
        assertThat(out.toString(), is(String.format("the engineer Ivanov equipment repaired for Petrov")));
    }

    /**
     * test on mplementationProject.
     */
    @Test
    public void whenImplementationProject() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Date date = new Date(2000, 9, 1);
        Engineer engineer = new Engineer("Ivanov", 25, date, "Systems");
        engineer.implementationProject();
        assertThat(out.toString(), is(String.format("Ivanov implementation project")));
    }

    /**
     * test on SupportProject.
     */
    @Test
    public void whenSupportProject() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Date date = new Date(2000, 9, 1);
        Engineer engineer = new Engineer("Ivanov", 25, date, "Systems");
        engineer.supportProject();
        assertThat(out.toString(), is(String.format("Ivanov support project")));
    }
}
