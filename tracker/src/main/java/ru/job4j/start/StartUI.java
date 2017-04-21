package ru.job4j.start;


/**
 * Class StartUI.
 *
 * @author Ruzhev Alexander
 * @since 05.04.2017
 */
public class StartUI {
    // int[] range = new int[]{0,1,2,3,4,5};
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
        do {
            menu.show();
            // int key = Integer.valueOf(input.ask("Select: "));
            menu.select(input.ask("select:", menu.getAllUserAction()));
        } while (!"y".equals(this.input.ask("Exit (y):")));
    }
}
