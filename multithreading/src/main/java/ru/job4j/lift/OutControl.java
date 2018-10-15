package ru.job4j.lift;

/**
 * @author Ruzhev Alexander
 * @since 10.09.2018
 */
public class OutControl implements Control {
    /**
     * Call to the floor.
     */
    private final int level;
    /**
     * Elevator.
     */
    private final Elevator elevator;

    /**
     * Constructor.
     * @param level - call to the floor.
     * @param elevator - elevator
     */
    public OutControl(int level, Elevator elevator) {
        this.level = level;
        this.elevator = elevator;
    }

    @Override
    public void call() {
        System.out.println("вызов на этаж " + this.level);
        this.elevator.add(level);
    }
}
