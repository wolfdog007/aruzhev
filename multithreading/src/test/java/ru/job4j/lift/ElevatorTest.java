package ru.job4j.lift;

import org.junit.Test;

/**
 * @author Ruzhev Alexander
 * @since 03.08.2018
 */
public class ElevatorTest {
    /**
     * Test add.
     * @throws Exception any exception.
     */
    @Test
    public void add() throws Exception {
        Elevator elevator = new Elevator(5, 3, 300, 10);
        Engine engine = new Engine(elevator);
        engine.start();
        elevator.add(3);
        elevator.add(1);
        elevator.add(5);
        elevator.add(4);
        Thread.sleep(4000);
        elevator.add(5);
        elevator.add(2);
        elevator.add(5);
        Thread.sleep(10000);
        elevator.add(5);
        Thread.sleep(2000);
        engine.interrupt();
        engine.join();
    }
}