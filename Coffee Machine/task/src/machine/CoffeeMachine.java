package machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeMachine {
    private static final int[] state = new int[]{400, 540, 120, 9, 550};
    private static DataState machineState;
    private static String currentState = "initial";
    private static int stateProcess;

    public CoffeeMachine() {
        machineState = new DataState(400, 540, 120, 9, 550);
        start();
    }

    private void start() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    private void tab() {
        System.out.println();
    }

    void process(String action) {
        if (currentState.equals("initial")) {
            switch (action) {
                case "buy":

                    break;
                case "fill":
                    currentState = action;
                    stateProcess = 0;
                    tab();
                    fill("0", 5);
                    break;
                case "take":
                    tab();
                    take();
                    tab();
                    start();
                    break;
                case "remaining":
                    tab();
                    remaining();
                    tab();
                    start();
                    break;
                case "exit":
                    System.exit(1);
                    break;
            }
        } else if (currentState.equals("fill")) {
            fill(action, stateProcess);
            stateProcess++;
            if (stateProcess == 4) {
                currentState = "initial";
                stateProcess = 0;
                tab();
                start();
            }
        }
    }

    private void fill(String action, int stateProcess) {
        var quantity = 0;
        try {
            quantity = Integer.parseInt(action);
        } catch (Exception e) {
            throw new IllegalArgumentException("Filling process accept only integer");
        }
        switch (stateProcess) {
            case 0:
                machineState.water += quantity;
                state[stateProcess] += quantity;
                System.out.println("Write how many ml of milk you want to add:");
                break;
            case 1:
                machineState.milk += quantity;
                state[stateProcess] += quantity;
                System.out.println("Write how many grams of coffee beans you want to add:");
                break;
            case 2:
                machineState.coffeeBeans += quantity;
                state[stateProcess] += quantity;
                System.out.println("Write how many disposable cups you want to add:");
                break;
            case 3:
                machineState.cups += quantity;
                state[stateProcess] += quantity;
                break;
            default:
                System.out.println("Write how many ml of water you want to add:");
                break;
        }
    }

    private void take() {
        System.out.println("I gave you $" + CoffeeMachine.state[4]);
        System.out.println("MS--- I gave you $" + machineState.money);
        machineState.money = 0;
        CoffeeMachine.state[4] = 0;
    }

    private void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(
                CoffeeMachine.state[0] + " ml of water\n"
                        + CoffeeMachine.state[1] + " ml of milk\n"
                        + CoffeeMachine.state[2] + " g of coffee beans\n"
                        + CoffeeMachine.state[3] + " disposable cups\n$"
                        + CoffeeMachine.state[4] + " of money");

        System.out.println(
                machineState.water + " ml of water\n"
                        + machineState.milk + " ml of milk\n"
                        + machineState.coffeeBeans + " g of coffee beans\n"
                        + machineState.cups + " disposable cups\n$"
                        + machineState.money + " of money");
    }

/*    private void printMissingR(int supply, boolean miss) {
        String[] supplies = {"water", "milk", "coffee beans", "cups"};
        if (miss) {
            System.out.println("Sorry, not enough " + supplies[supply] + "!\n");

        } else System.out.println("I have enough resources, making you a coffee!\n");
    }*/

    /*
        private Map<String, Integer> initResources(int water, int milk, int coffeeBeans, int cups, int money) {
            Map<String, Integer> resources = new HashMap<>();
            resources.put("water", water);
            resources.put("milk", milk);
            resources.put("coffee beans", coffeeBeans);
            resources.put("cups", cups);
            resources.put("money", money);
            return resources;
        }
    */
    private static class DataState {
        int water;
        int milk;
        int coffeeBeans;
        int cups;
        int money;

        public DataState(int water, int milk, int coffeeBeans, int cups, int money) {
            this.water = water;
            this.milk = milk;
            this.coffeeBeans = coffeeBeans;
            this.cups = cups;
            this.money = money;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (true) {
            var execute = scanner.next();
            coffeeMachine.process(execute);
        }

    }

    /**/

    /*    private void run() {
        int[] state = new int[]{400, 540, 120, 9, 550};

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    int cup = state[3] - 1;
                    if (cup > 0) {
                        buy(state, scanner);
                    } else printMissingR(3, true);
                    break;
                case "fill":
                    fill(state, scanner);
                    break;
                case "take":
                    take(state);
                    break;
                case "remaining":
                    printState(state);
                    break;
                case "exit":
                    exit = true;
                    break;
            }
        }
    }
*/
}