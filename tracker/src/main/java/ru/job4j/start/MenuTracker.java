package ru.job4j.start;

import ru.job4j.models.Item;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Class menu for tracker.
 *
 * @author Ruzhev Alexander
 * @since 20.04.2017
 */
public class MenuTracker {
    /**
     * Object of Input.
     */
    private Input input;
    /**
     * Object of tracker.
     */
    private Tracker tracker;
    /**
     * The user action field.
     */
    private List<UserAction> userAction = new ArrayList<>();
    /**
     * the position of the object in menu.
     */
    private int position = 0;

    /**
     * Constructor.
     *
     * @param input   input from user
     * @param tracker object of Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * The list of actions.
     */
    public void fillAction() {
        this.userAction.add(position++, new AddItem("Add the new item."));
        this.userAction.add(position++, new ShowItems("Show all items."));
        this.userAction.add(position++, new EditItem("Edit the item."));
        this.userAction.add(position++, new DeleteItem("Delete the item."));
        this.userAction.add(position++, new FindById("Find by id the item."));
        this.userAction.add(position++, new FindByName("Find by name the item."));
    }

    /**
     * add new menu item.
     *
     * @param action menu item
     */
    public void addAction(UserAction action) {
        this.userAction.add(position++, action);
    }

    /**
     * Creates a range of possible answers.
     *
     * @return range of possible answers
     */
    public int[] getAllUserAction() {
        int[] allUA = new int[userAction.size()];
        for (int index = 0; index < userAction.size(); index++) {
            allUA[index] = userAction.get(index).key();
        }
        return allUA;
    }

    /**
     * The implementation of the selected key.
     *
     * @param key the user's choice
     */
    public void select(int key) {
        this.userAction.get(key).execute(this.input, this.tracker);
    }

    /**
     * Print menu.
     */
    public void show() {
        for (UserAction action : this.userAction
                ) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Print task.
     *
     * @param item object of item.
     */
    public static void showTask(Item item) {
        String curStringDate = new SimpleDateFormat("dd.MM.yyyy hh:mm").format(item.getCreated());
        System.out.printf("Id          - %s%s", item.getId(), System.lineSeparator());
        System.out.printf("Name        - %s%s", item.getName(), System.lineSeparator());
        System.out.printf("Description - %s%s", item.getDesc(), System.lineSeparator());
        System.out.printf("Created     - %s%s", curStringDate, System.lineSeparator());
        System.out.println("-----------------------------");
    }

    /**
     * Add the new item.
     */
    private class AddItem extends BaseAction {
        /**
         * Constructor.
         *
         * @param name - BaseAction name
         */
        AddItem(String name) {
            super(name, 0);
        }

        /**
         * Execute add the new item.
         *
         * @param input   data input interface
         * @param tracker base class
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Input the task name: ");
            String desc = input.ask("Input the task description: ");
            long created = System.currentTimeMillis();
            tracker.add(new Item(name, desc, created));
        }
    }

    /**
     * Show all items.
     */
    private static class ShowItems extends BaseAction {
        /**
         * Constructor.
         *
         * @param name - BaseAction name
         */
        ShowItems(String name) {
            super(name, 1);
        }

        /**
         * Execute show all items.
         *
         * @param input   data input interface
         * @param tracker base class
         */
        public void execute(Input input, Tracker tracker) {
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
    }

    /**
     * Edit the item.
     */
    class EditItem extends BaseAction {
        /**
         * Constructor.
         *
         * @param name - BaseAction name
         */
        EditItem(String name) {
            super(name, 2);
        }

        /**
         * execute edit the item.
         *
         * @param input   data input interface
         * @param tracker base class
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Input the task id: ");
            String name = input.ask("Input the task name: ");
            String desc = input.ask("Input the task description: ");
            long created = System.currentTimeMillis();
            Item item = new Item(name, desc, created);
            item.setId(id);
            tracker.update(item);
        }
    }

    /**
     * Delete the item.
     */
    private class DeleteItem extends BaseAction {
        /**
         * Constructor.
         *
         * @param name - BaseAction name
         */
        DeleteItem(String name) {
            super(name, 3);
        }

        /**
         * Execute delete the item.
         *
         * @param input   data input interface
         * @param tracker base class
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Input the task id: ");
            if (tracker.findById(id) != null) {
                tracker.delete(id);
            } else {
                System.out.println("This id not present");
            }
        }
    }

    /**
     * Find by id the item.
     */
    private class FindById extends BaseAction {
        /**
         * Constructor.
         *
         * @param name - BaseAction name
         */
        FindById(String name) {
            super(name, 4);
        }

        /**
         * execute find by id the item.
         *
         * @param input   data input interface
         * @param tracker base class
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Input the task id: ");
            if (tracker.findById(id) != null) {
                Item foundItem = tracker.findById(id);
                showTask(foundItem);
            } else {
                System.out.println("This id not present");
            }
        }
    }

    /**
     * Find by name the item.
     */
    private class FindByName extends BaseAction {
        /**
         * Constructor.
         *
         * @param name - BaseAction name
         */
        FindByName(String name) {
            super(name, 5);
        }

        /**
         * Execute find by name the item.
         *
         * @param input   data input interface
         * @param tracker base class
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Input the task name: ");
            if (tracker.findByName(name) != null) {
                Item foundItem = tracker.findByName(name);
                showTask(foundItem);
            } else {
                System.out.println("This name not present");
            }
        }
    }
}
