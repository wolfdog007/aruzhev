package ru.job4j;

import java.util.Date;

/**
 * class MedicalDoctor extends Profession.
 *
 * @author Ruzhev Alexander
 * @since 29.03.2017
 */
public class MedicalDoctor extends Profession {
    /**
     * Constructor extends Profession.
     * @param name - name
     * @param age - age
     * @param employed - date employed
     * @param profession - profession teacher
     */
    public MedicalDoctor(String name, int age, Date employed, String profession) {
        super(name, age, employed, profession);
    }

    /**
     * diagnose.
     * @param patient - object Engineer
     * @return result diagnose and patient name
     */
    public String diagnose(Engineer patient) {
        return "the result of the diagnosis" + patient.getName();
    }

    /**
     * heal patient.
     * @param patient - object Engineer
     */
    public void heal(Engineer patient) {
        System.out.printf("the patient recovered %s", patient.getName());
    }

    /**
     * Write history.
     * @param patient - object Engineer
     * @return Medical hisory and patient name
     */
    public String writeMedicalHistory(Engineer patient) {
        return "Medical history" + patient.getName();
    }
}
