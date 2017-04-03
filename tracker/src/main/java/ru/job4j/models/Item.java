package ru.job4j.models;

/**
 * Class Item contains information about the request.
 *
 * @author Ruzhev Alexander
 * @since 01.04.2017
 */
public class Item {
    /**
     * id - unique key is String.
     */
    private String id;
    /**
     * name String.
     */
    private String name;
    /**
     * desc - description is String.
     */
    private String desc;
    /**
     * created - created date is long.
     */
    private long created;
    /**
     * array of comments.
     */
    private String[] comments;

    /**
     * Constructor.
     *
     * @param name - name
     * @param desc - description
     * @param created - created date
     */
    public Item(String name, String desc, Long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    /**
     * getter name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getter desc.
     * @return desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * getter created.
     * @return created
     */
    public long getCreated() {
        return created;
    }

    /**
     * getter id.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * setter name.
     * @param name is String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter desc.
     * @param desc is String
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * setter created.
     * @param created is long
     */
    public void setCreated(long created) {
        this.created = created;
    }

    /**
     * setter id.
     * @param id is String
     */
    public void setId(String id) {
        this.id = id;
    }
}
