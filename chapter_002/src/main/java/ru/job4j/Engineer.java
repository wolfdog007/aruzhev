package ru.job4j;

import java.util.Date;

/**
 * class Engineer extends Profession.
 *
 * @author Ruzhev Alexander
 * @since 29.03.2017
 */
public class Engineer extends Profession {
    /**
     * Constructor extends Profession.
     *
     * @param name       - name
     * @param age        - age
     * @param employed   - date employed
     * @param profession - profession teacher
     */
    public Engineer(String name, int age, Date employed, String profession) {
        super(name, age, employed, profession);
    }

    /**
     * repair client equipment.
     *
     * @param client - MedicalDoctor
     */
    public void repairerEquipment(MedicalDoctor client) {
        System.out.printf("the engineer %s equipment repaired for %s", this.getName(), client.getName());
    }

    /**
     * implementation project.
     */
    public void implementationProject() {
        System.out.printf("%s implementation project", this.getName());
    }

    /**
     * support project.
     */
    public void supportProject() {
        System.out.printf("%s support project", this.getName());
    }
}
