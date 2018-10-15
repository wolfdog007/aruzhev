package ru.job4j.lift;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;


/**
 * @author Ruzhev Alexander
 * @since 18.07.2018
 */
@ThreadSafe
public class Elevator {
    /**
     * Number of floors.
     */
    private final int countFloor;
    /**
     * Level height.
     */
    private final double height;
    /**
     * Lift speed.
     */
    private final double speedMove;
    /**
     * Open/close door time.
     */
    private final int doorTime;
    /**
     * Current level.
     */
    private int currentLevel = 1;
    /**
     * List of calls when the elevator is moving up.
     */
    @GuardedBy("itself")
    private final SortedSet<Integer> up = new TreeSet<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });
    /**
     * List of calls when the elevator is moving down.
     */
    @GuardedBy("itself")
    private final SortedSet<Integer> down = new TreeSet<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    /**
     * Constructor.
     * @param countFloor - numder of floors.
     * @param height - level height.
     * @param speedMove - lift speed.
     * @param doorTime - open door time.
     */
    public Elevator(int countFloor, double height, double speedMove, int doorTime) {
        this.countFloor = countFloor;
        this.height = height;
        this.speedMove = speedMove;
        this.doorTime = doorTime;
    }

    /**
     * Getter for countFloor.
     * @return count floor
     */
    public int getCountFloor() {
        return countFloor;
    }

    /**
     * Getter for height.
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Getter for speedMove.
     * @return speedMove
     */
    public double getSpeedMove() {
        return speedMove;
    }

    /**
     * Getter for doorTime.
     * @return doorTime
     */
    public int getDoorTime() {
        return doorTime;
    }

    /**
     * Getter for currentLevel.
     * @return currentLevel
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Setter for currentLevel.
     * @param currentLevel new level.
     */
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    /**
     * Adds a new request.
     * @param level - Call level
     */
    public void add(int level) {
        if (level > currentLevel) {
            synchronized (this.up) {
                this.up.add(level);
            }
        } else {
            synchronized (this.down) {
                this.down.add(level);
            }
        }
    }

    /**
     * Adds a new request with direction.
     * @param level - call level
     * @param direct - moving direction. >0 - up, <0 - down
     */
    public void add(int level, int direct) {
        if (direct > 0) {
            synchronized (this.up) {
                this.up.add(level);
                this.up.notifyAll();
            }
        } else {
            synchronized (this.down) {
                this.down.add(level);
                this.down.notifyAll();
            }
        }
    }

    /**
     * Up list is empty.
     * @return true or false.
     */
    public boolean upIsEmpty() {
        synchronized (this.up) {
            return this.up.isEmpty();
        }
    }

    /**
     * Down list is empty.
     * @return true or false
     */
    public boolean downIsEmpty() {
        synchronized (this.down) {
            return this.down.isEmpty();
        }
    }

    /**
     * get request when lift direction is up.
     * @return - first call into up list
     * @throws InterruptedException interrupted exception
     */
    public int getUp() throws InterruptedException {
        synchronized (this.up) {
            while (this.up.isEmpty()) {
                this.up.wait();
            }
            return this.up.first();
        }
    }
    /**
     * get request when lift direction is down.
     * @return - first call into down list
     * @throws InterruptedException interrupted exception
     */
    public int getDown() throws InterruptedException {
        synchronized (this.down) {
            while (this.down.isEmpty()) {
                this.down.wait();
            }
            return this.down.first();
        }
    }

    /**
     * Delete request when elevator reached the goal.
     * @param target - lift position
     * @param direct - moving direction
     */
    public void delete(int target, int direct) {
        if (direct > 0 && !upIsEmpty()) {
            synchronized (this.up) {
                this.up.remove(target);
                this.up.notifyAll();
            }
        }
        if (direct < 0 && !downIsEmpty()) {
            synchronized (this.down) {
                this.down.remove(target);
                this.down.notifyAll();
            }
        }
    }
}
