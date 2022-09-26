package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static DataState coffeeMachineState;
    private static String currentState = "initial";
    private static int stateProcess;
    private static DataState espresso;
    private static DataState latte;
    private static DataState cappuccino;

    public CoffeeMachine() {
        coffeeMachineState = new DataState(400, 540, 120, 9, 550);
        espresso = new DataState(250, 0, 16, 1, 4);
        latte = new DataState(350, 75, 20, 1, 7);
        cappuccino = new DataState(200, 100, 12, 1, 6);
        start();
    }

    private void start() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    private void tab() {
        System.out.println();
    }

    void process(String action) {
        switch (currentState) {
            case "initial":
                switch (action) {
                    case "buy":
                        currentState = action;
                        tab();
                        System.out.println("What do you want to buy? 1 - espresso, " +
                                "2 - latte, 3 - cappuccino, back - to main menu:");

                        break;
                    case "fill":
                        currentState = action;
                        stateProcess = 0;
                        tab();
                        System.out.println("Write how many ml of water you want to add:");
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
                break;
            case "fill":
                fill(action, stateProcess);
                stateProcess++;
                if (stateProcess == 4) {
                    currentState = "initial";
                    stateProcess = 0;
                    tab();
                    start();
                }
                break;
            case "buy":
                switch (action) {
                    case "1":
                        buy(espresso);
                        break;
                    case "2":
                        buy(latte);
                        break;
                    case "3":
                        buy(cappuccino);
                        break;
                    case "back":
                        break;
                }
                currentState = "initial";
                tab();
                start();
                break;
        }
    }

    private void buy(DataState supply) {
        if (coffeeMachineState.water < supply.water) {
            System.out.println("Sorry, not enough water");
        } else if (coffeeMachineState.milk < supply.milk) {
            System.out.println("Sorry, not enough milk");
        } else if (coffeeMachineState.coffeeBeans < supply.coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans");
        } else if (coffeeMachineState.cups < supply.cups) {
            System.out.println("Sorry, not enough cups");
        } else {
            coffeeMachineState.water -= supply.water;
            coffeeMachineState.milk -= supply.milk;
            coffeeMachineState.coffeeBeans -= supply.coffeeBeans;
            coffeeMachineState.cups -= supply.cups;
            coffeeMachineState.money += supply.money;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    private void fill(String action, int stateProcess) {
        var quantity = toInt(action);

        switch (stateProcess) {
            case 0:
                coffeeMachineState.water += quantity;
                System.out.println("Write how many ml of milk you want to add:");
                break;
            case 1:
                coffeeMachineState.milk += quantity;
                System.out.println("Write how many grams of coffee beans you want to add:");
                break;
            case 2:
                coffeeMachineState.coffeeBeans += quantity;
                System.out.println("Write how many disposable cups you want to add:");
                break;
            case 3:
                coffeeMachineState.cups += quantity;
                break;
            default:
        }
    }

    private void take() {
        System.out.println("I gave you $" + coffeeMachineState.money);
        coffeeMachineState.money = 0;
    }

    private void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(
                coffeeMachineState.water + " ml of water\n"
                        + coffeeMachineState.milk + " ml of milk\n"
                        + coffeeMachineState.coffeeBeans + " g of coffee beans\n"
                        + coffeeMachineState.cups + " disposable cups\n$"
                        + coffeeMachineState.money + " of money");
    }

    private int toInt(String value) {
        var toInt = 0;
        try {
            toInt = Integer.parseInt(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Filling process accept only integer");
        }

        return toInt;
    }

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

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        CoffeeMachine coffeeMachine = new CoffeeMachine();
//        while (true) {
//            var execute = scanner.next();
//            coffeeMachine.process(execute);
//        }
//    }
}

class Main {

    public static enum ChargeLevel {

        FULL(4, "green"),
        HIGH(3, "green"),
        MEDIUM(2, "yellow"),
        LOW(1, "red");

        int sections;
        String color;

        ChargeLevel(int sections, String color) {
            this.sections = sections;
            this.color = color;
        }

        public int getSections() {
            return sections;
        }

        public String getColor() {
            return color;
        }
    }

    public static void main(String[] args) {
        ChargeLevel.LOW.color = "Yellow";
        System.out.println(ChargeLevel.LOW.color); // red
        System.out.println(ChargeLevel.LOW.getColor()); // red
    }
}

