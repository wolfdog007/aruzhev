package ru.job4j.lift;

/**
 * @author Ruzhev Alexander
 * @since 03.08.2018
 */
public class Engine extends Thread {
    /**
     * Elevator current position.
     */
    private int position;
    /**
     * Elevator.
     */
    private Elevator elevator;
    /**
     * Direction.
     */
    private int direction = 1;

    /**
     * Constructor.
     *
     * @param elevator - elevator.
     */
    public Engine(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void run() {
        System.out.println("Start.");
        this.position = elevator.getCurrentLevel();
        int target = 0;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                if (direction > 0) {
                    if (elevator.upIsEmpty()) {
                        direction = -1;
                    } else {
                        target = elevator.getUp();
                    }
                }

                if (direction < 0) {
                    if (elevator.downIsEmpty()) {
                        direction = 1;
                    } else {
                        target = elevator.getDown();
                    }
                }
                if (target > 0 && target == position) {
                    elevator.delete(target, direction);
                    target = -1;
                    parkingLift();
                } else {

                    if (target > 0) {
                        move(target - this.position);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stop.");
    }

    /**
     * Parking lift.
     * @throws InterruptedException interrupted exception
     */
    private void parkingLift() throws InterruptedException {
        System.out.println("двери лифта открываются...");
        Thread.sleep(this.elevator.getDoorTime());
        System.out.println("двери лифта открыты.");
        System.out.println("погрузка/выгрузка...");
        Thread.sleep(1000);
        System.out.println("двери лифта закрываются...");
        Thread.sleep(this.elevator.getDoorTime());
        System.out.println("двери лифта закрыты.");
    }

    /**
     * Move to next level.
     *
     * @param direct - moving direction.
     * @throws InterruptedException interrupted exception
     */
    private void move(int direct) throws InterruptedException {
        System.out.println(direct);
        this.direction = direct / Math.abs(direct);
        System.out.println("движение на след. этаж " + direction);
        Thread.sleep((long) (elevator.getHeight() * elevator.getSpeedMove()));
        this.position += direction;
        System.out.println("лифт на этаже:" + this.position);
        elevator.setCurrentLevel(this.position);

    }
}

