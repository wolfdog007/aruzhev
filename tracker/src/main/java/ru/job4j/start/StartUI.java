package ru.job4j.start;


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
     * object of Tracker.
     */
    private Tracker tracker;
    /**
     * Main menu array.
     */
    private String[] arrayMenuItems;

    /**
     * Constructor.
     *
     * @param tracker object of Tracker
     * @param input   object of Input
     */
    public StartUI(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }

    /**
     * Main method - start program.
     *
     * @param args - array of String.
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUI(new Tracker(), input).init();
    }

    /**
     * Main menu.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillAction();
        UserAction exitByTracker = new BaseAction("Exit.") {
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
        };

        menu.addAction(exitByTracker);
        do {
            menu.show();
            menu.select(input.ask("select:", menu.getAllUserAction()));
        } while (!"y".equals(this.input.ask("Exit (y):")));
    }
}
