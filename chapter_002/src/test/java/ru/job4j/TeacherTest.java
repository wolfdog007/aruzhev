package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class Teacher.
 *
 * @author Ruzhev Alexander
 * @since 29.03.2017
 */
public class TeacherTest {
    /**
     * test on teach medicalDoctor.
     */
    @Test
    public void whenTeachMD() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Date date = new Date(2000, 9, 1);
        Teacher teacher = new Teacher("Ivanov", 25, date, "Systems");
        MedicalDoctor student = new MedicalDoctor("Petrov", 30, date, "therapist");
        teacher.teach(student);
        assertThat(out.toString(), is(String.format("Teacher Ivanov teaches medical doctor Petrov")));
    }

    /**
     * test on teach engineer.
     */
    @Test
    public void whenTeachEngineer() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Date date = new Date(2000, 9, 1);
        Teacher teacher = new Teacher("Ivanov", 25, date, "Systems");
        Engineer student = new Engineer("Petrov", 30, date, "therapist");
        teacher.teach(student);
        assertThat(out.toString(), is(String.format("Teacher Ivanov teaches engineer Petrov")));
    }

    /**
     * test on testJob.
     */
    @Test
    public void whenTestJob() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Date date = new Date(2000, 9, 1);
        Teacher teacher = new Teacher("Ivanov", 25, date, "Systems");
        teacher.testJob();
        assertThat(out.toString(), is(String.format("Teacher Ivanov checks the work of the group")));
    }

    /**
     * test on toGiveHomeWork.
     */
    @Test
    public void whenToGiveHomework() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Date date = new Date(2000, 9, 1);
        Teacher teacher = new Teacher("Ivanov", 25, date, "Systems");
        teacher.toGiveHomework();
        assertThat(out.toString(), is(String.format("Teacher Ivanov gives homework group")));
    }
}
