package ru.job4j.lift;

/**
 * @author Ruzhev Alexander
 * @since 10.09.2018
 */
public class Start {
    /**
     * The method is point enter program.
     * @param args  - parameters work program
     */
    public static void main(String[] args) {
        int push = 1;
//        Elevator elevator = new Elevator(
//                Integer.parseInt(args[0]),
//                Double.parseDouble(args[1]),
//                Double.parseDouble(args[2]),
//                Integer.parseInt(args[3])
//        );
        Elevator elevator = new Elevator(5, 3, 1000, 100);
        Input input = new Input();
        Engine engine = new Engine(elevator);
        OutControl[] outControl = new OutControl[elevator.getCountFloor()];
        InControl inControl = new InControl(elevator, input);
        for (int i = 0; i < outControl.length; i++) {
            outControl[i] = new OutControl(i + 1, elevator);
        }
        engine.start();
        while (push >= 0) {
            System.out.println("выбор этажа или 0 для входа в лифт. Любое отрицательное - выход.");
            push = input.ask(elevator.getCountFloor(), 1);
            if (push == 0) {
                inControl.call();
            }
            if (push > 0) {
                outControl[push - 1].call();
            }
        }
        engine.interrupt();
    }
}
