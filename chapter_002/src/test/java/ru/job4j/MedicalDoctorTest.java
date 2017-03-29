package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

/**
 * Test class MedicalDoctor.
 *
 * @author Ruzhev Alexander
 * @since 29.03.2017
 */
public class MedicalDoctorTest {
    /**
     * test on diagnose.
     */
    @Test
    public void whenDiagnose() {
        Date date = new Date(2000, 9, 1);
        Engineer patient = new Engineer("Ivanov", 25, date, "Systems");
        MedicalDoctor medic = new MedicalDoctor("Petrov", 30, date, "therapist");
        assertThat("Dr.Petrov makes a diagnosis Ivanov", is(medic.diagnose(patient)));
    }

    /**
     * test on heal.
     */
    @Test
    public void whenHeal() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Date date = new Date(2000, 9, 1);
        Engineer patient = new Engineer("Ivanov", 25, date, "Systems");
        MedicalDoctor medic = new MedicalDoctor("Petrov", 30, date, "therapist");
        medic.heal(patient);
        assertThat(out.toString(), is(String.format("Dr.Petrov makes a heal Ivanov%s", System.lineSeparator())));
    }

    /**
     * test on WriteMedicalHistory.
     */
    @Test
    public void whenWriteMedicalHistory() {
        Date date = new Date(2000, 9, 1);
        Engineer patient = new Engineer("Ivanov", 25, date, "Systems");
        MedicalDoctor medic = new MedicalDoctor("Petrov", 30, date, "therapist");
        assertThat("Dr.Petrov make medical history for Ivanov", is(medic.writeMedicalHistory(patient)));
    }
}