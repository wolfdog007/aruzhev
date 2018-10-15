package ru.job4j.lift;

/**
 * @author Ruzhev Alexander
 * @since 10.09.2018
 */
public class InControl implements Control {
    /**
     * Elevator.
     */
    private final Elevator elevator;
    /**
     * Input.
     */
    private final Input input;

    /**
     * Constructor.
     * @param elevator - elevator
     * @param input - input
     */
    public InControl(Elevator elevator, Input input) {
        this.elevator = elevator;
        this.input = input;
    }

    @Override
    public void call() {
        System.out.println("вызов из кабины:");
        int push = input.ask(elevator.getCountFloor(), 1);
        elevator.add(push);
    }
}
