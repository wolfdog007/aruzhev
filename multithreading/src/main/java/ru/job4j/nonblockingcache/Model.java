package ru.job4j.nonblockingcache;

/**
 * @author Ruzhev Alexander
 * @since 24.05.2018
 */
public class Model {
    /**
     * The version of object.
     */
    private int version;
    /**
     * The name of object.
     */
    private String name;

    /**
     * Constructor.
     *
     * @param name - object name
     */
    public Model(String name) {
        this.version = new Object().hashCode();
        this.name = name;
    }

    /**
     * Getter for version.
     *
     * @return - version
     */
    public int getVersion() {
        return version;
    }

    /**
     * Getter for name.
     *
     * @return - name.
     */
    public String getName() {
        return name;
    }

    /**
     * Update version.
     */
    public void updateVersion() {
        this.version++;
    }

    /**
     * Setter for name.
     *
     * @param name - object name
     */
    public void setName(String name) {
        this.name = name;
    }
}
