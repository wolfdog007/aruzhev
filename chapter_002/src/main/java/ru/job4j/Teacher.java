package ru.job4j;

import java.util.Date;

/**
 * class Teacher extends Profession.
 *
 * @author Ruzhev Alexander
 * @since 29.03.2017
 */
public class Teacher extends Profession {
    /**
     * Constructor extends Profession.
     *
     * @param name       - name
     * @param age        - age
     * @param employed   - date employed
     * @param profession - profession teacher
     */
    public Teacher(String name, int age, Date employed, String profession) {
        super(name, age, employed, profession);
    }

    /**
     * teach the student.
     *
     * @param student - object Engineer
     */
    public void teach(Engineer student) {
        System.out.printf("Teacher %s teaches engineer %s", this.getName(), student.getName());
    }

    /**
     * teach the student.
     *
     * @param student - object MedicalDoctor
     */
    public void teach(MedicalDoctor student) {
        System.out.printf("Teacher %s teaches medical doctor %s", this.getName(), student.getName());
    }

    /**
     * test job.
     */
    public void testJob() {
        System.out.printf("Teacher %s checks the work of the group", this.getName());
    }

    /**
     * give homework.
     */
    public void toGiveHomework() {
        System.out.printf("Teacher %s gives homework group", this.getName());
    }
}
