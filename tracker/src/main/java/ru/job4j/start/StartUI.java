package ru.job4j.start;

import ru.job4j.models.Item;

/**
 * Class StartUI.
 *
 * @author Ruzhev Alexander
 * @since 05.04.2017
 */
public class StartUI {
    /**
     * object of Input.
     */
    private Input input;
    /**
     * Main menu array.
     */
    private String[] arrayMenuItems;

    /**
     * Constructor.
     *
     * @param input object of Input.
     */
    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Main method - start program.
     *
     * @param args - array of String.
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }

    /**
     * Main menu.
     */
    public void init() {
        Tracker tracker = new Tracker();
        String answer = "no answer";
        this.arrayMenuItems = new String[]{"Add new Item", "Show all items", "Edit item", "Delete item", "Find item by Id", "Find items by name", "Exit Program"};
        do {
            showMenu(this.arrayMenuItems);
            answer = input.ask("enter the selected: ");
            if (answer.equals("0")) {
                add(tracker);
            }
            if (answer.equals("1")) {
                getAll(tracker);
            }
            if (answer.equals("2")) {
                editItemMenu(tracker);
            }
            if (answer.equals("3")) {
                delete(tracker);
            }
            if (answer.equals("4")) {
                String id = input.ask("Input the task id: ");
                if (tracker.findById(id) != null) {
                    Item foundItem = tracker.findById(id);
                    showTask(foundItem);
                } else {
                    System.out.println("This id not present");
                }
            }
            if (answer.equals("5")) {
                String name = input.ask("Input the task name: ");
                if (tracker.findByName(name) != null) {
                    Item foundItem = tracker.findByName(name);
                    showTask(foundItem);
                } else {
                    System.out.println("This name not present");
                }
            }
        } while (!answer.equals("6"));
    }

    /**
     * Output the elements of menu.
     *
     * @param arrayMenuItems - the array of menu items
     */
    public void showMenu(String[] arrayMenuItems) {
        for (int index = 0; index < arrayMenuItems.length; index++) {
            System.out.printf("%s - %s%s", index, arrayMenuItems[index], System.lineSeparator());
        }
    }

    /**
     * Add new item.
     *
     * @param tracker - object of Tracker
     */
    public void add(Tracker tracker) {
        String name = input.ask("Input the task name: ");
        String desc = input.ask("Input the task description: ");
        long created = System.currentTimeMillis();
        tracker.add(new Item(name, desc, created));
    }

    /**
     * Output the elements of tracker.
     *
     * @param tracker - object of Tracker
     */
    public void getAll(Tracker tracker) {
        int count = 0;
        for (Item item : tracker.getAll()) {
            if (item != null) {
                showTask(item);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("The task list is empty");
        }
    }

    /**
     * the output of the content object.
     *
     * @param item - contains information about the request
     */
    public void showTask(Item item) {
        System.out.println("-----------------------------");
        System.out.printf("Id          - %s%s", item.getId(), System.lineSeparator());
        System.out.printf("Name        - %s%s", item.getName(), System.lineSeparator());
        System.out.printf("Description - %s%s", item.getDesc(), System.lineSeparator());
        System.out.printf("Created     - %s%s", item.getCreated(), System.lineSeparator());
        System.out.println("-----------------------------");
    }

    /**
     * Edit item menu.
     *
     * @param tracker - object of Tracker
     */
    public void editItemMenu(Tracker tracker) {
        String answer = "no answer";
        String[] upDateMenu = new String[]{"Update by id", "Show all items", "Return to main menu"};
        do {
            showMenu(upDateMenu);
            answer = input.ask("enter the selected: ");
            if (answer.equals("0")) {
                String id = input.ask("Input the task id: ");
                Item changeItem = tracker.findById(id);
                if (tracker.findById(id) != null) {
                    showTask(changeItem);
                    tracker.update(update(changeItem));
                    break;
                } else {
                    System.out.println("This id not present");
                }
            }
            if (answer.equals("1")) {
                getAll(tracker);
            }
        } while (!answer.equals("2"));
    }

    /**
     * Changes the selected task.
     *
     * @param item - contains information about the request
     * @return update item
     */
    public Item update(Item item) {
        String answer = "no answer";
        String[] upDateMenu = new String[]{"Change name", "Change description", "Return to main menu"};
        do {
            showMenu(upDateMenu);
            answer = input.ask("enter the selected: ");
            if (answer.equals("0")) {
                String name = input.ask("Input the new task name: ");
                item.setName(name);
            }
            if (answer.equals("1")) {
                String desc = input.ask("Input the new task description: ");
                item.setDesc(desc);
            }
        } while (!answer.equals("2"));
        return item;
    }

    /**
     * Delete the selected task.
     *
     * @param tracker - object of Tracker
     */
    public void delete(Tracker tracker) {
        String answer = "no answer";
        String[] upDateMenu = new String[]{"Delete by id", "Show all items", "Return to main menu"};
        do {
            showMenu(upDateMenu);
            answer = input.ask("enter the selected: ");
            if (answer.equals("0")) {
                String id = input.ask("Input the task id: ");
                if (tracker.findById(id) != null) {
                    tracker.delete(id);
                } else {
                    System.out.println("This id not present");
                }
            }
            if (answer.equals("1")) {
                getAll(tracker);
            }
        } while (!answer.equals("2"));
    }
}
