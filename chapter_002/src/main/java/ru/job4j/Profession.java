package ru.job4j;

import java.util.Date;

/**
 * class Profession.
 *
 * @author Ruzhev Alexander
 * @since 29.03.2017
 */
public class Profession {
    /**
     * name.
     */
    private String name;
    /**
     * age.
     */
    private int age;
    /**
     * employed.
     */
    private Date employed;
    /**
     * profession.
     */
    private String profession;

    /**
     * Constructor.
     *
     * @param name       - name
     * @param age        - age
     * @param employed   - date employed
     * @param profession - profession teacher
     */
    public Profession(String name, int age, Date employed, String profession) {
        this.name = name;
        this.age = age;
        this.employed = employed;
        this.profession = profession;
    }

    /**
     * get name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * get age.
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * get Employed.
     *
     * @return Employed
     */
    public Date getEmployed() {
        return employed;
    }

    /**
     * get Profession.
     *
     * @return Profession
     */
    public String getProfession() {
        return profession;
    }

    /**
     * set name.
     *
     * @param name - name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set age.
     *
     * @param age - age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * set employed.
     *
     * @param employed - date
     */
    public void setEmployed(Date employed) {
        this.employed = employed;
    }

    /**
     * set profession.
     *
     * @param profession - class profession
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }
}

