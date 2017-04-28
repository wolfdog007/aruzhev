package ru.job4j.start;

import ru.job4j.models.Item;

import java.text.SimpleDateFormat;

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
    private UserAction[] userAction = new UserAction[7];

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
        this.userAction[0] = new AddItem();
        this.userAction[1] = new ShowItems();
        this.userAction[2] = new EditItem();
        this.userAction[3] = new DeleteItem();
        this.userAction[4] = new FindById();
        this.userAction[5] = new FindByName();
        this.userAction[6] = new ExitByTracker();
    }

    /**
     * Creates a range of possible answers.
     * @return range of possible answers
     */
    public int[] getAllUserAction() {
        int[] allUA = new int[userAction.length];
        for (int index = 0; index < userAction.length; index++) {
            allUA[index] = userAction[index].key();
        }
        return allUA;
    }

    /**
     * The implementation of the selected key.
     *
     * @param key the user's choice
     */
    public void select(int key) {
        this.userAction[key].execute(this.input, this.tracker);
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
    private class AddItem implements UserAction {
        /**
         * @return unique key tasks
         */
        public int key() {
            return 0;
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

        /**
         * Description of the action.
         *
         * @return the key and Description of the action.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    /**
     * Show all items.
     */
    private static class ShowItems implements UserAction {
        /**
         * @return unique key tasks
         */
        public int key() {
            return 1;
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

        /**
         * Description of the action.
         *
         * @return the key and Description of the action.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }

    /**
     * Edit the item.
     */
    class EditItem implements UserAction {
        /**
         * @return unique key tasks
         */
        public int key() {
            return 2;
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

        /**
         * Description of the action.
         *
         * @return the key and Description of the action.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Edit the item.");
        }
    }

    /**
     * Delete the item.
     */
    private class DeleteItem implements UserAction {
        /**
         * @return unique key tasks
         */
        public int key() {
            return 3;
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

        /**
         * Description of the action.
         *
         * @return the key and Description of the action.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete the item.");
        }
    }

    /**
     * Find by id the item.
     */
    private class FindById implements UserAction {
        /**
         * @return unique key tasks
         */
        public int key() {
            return 4;
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

        /**
         * Description of the action.
         *
         * @return the key and Description of the action.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find by id the item.");
        }
    }

    /**
     * Find by name the item.
     */
    private class FindByName implements UserAction {
        /**
         * @return unique key tasks
         */
        public int key() {
            return 5;
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

        /**
         * Description of the action.
         *
         * @return the key and Description of the action.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find by name the item.");
        }
    }

    /**
     * Exit from Tracker.
     */
    private class ExitByTracker implements UserAction {
        /**
         * @return unique key tasks
         */
        public int key() {
            return 6;
        }

        /**
         * @param input   data input interface
         * @param tracker base class
         */
        public void execute(Input input, Tracker tracker) {
            System.out.println("Really exit?");
        }

        /**
         * Description of the action.
         *
         * @return the key and Description of the action.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Exit.");
        }
    }
}
