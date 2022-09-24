package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
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

    static void buy(int[] state, Scanner sc) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = sc.next();
        int missingRes;

        switch (choice) {
            case "1":
                if (state[0] >= 250 && state[2] >= 16) {
                    state[0] = state[0] - 250;
                    state[2] = state[2] - 16;
                    state[4] = state[4] + 4;
                    state[3] = state[3] - 1;
                    printMissingR(9, false);
                } else {
                    missingRes = state[0] < 250 ? 0 : 2;
                    printMissingR(missingRes, true);
                }

                break;
            case "2":
                if (state[0] >= 350 && state[1] >= 75 && state[2] >= 20) {
                    state[0] = state[0] - 350;
                    state[1] = state[1] - 75;
                    state[2] = state[2] - 20;
                    state[4] = state[4] + 7;
                    state[3] = state[3] - 1;
                    printMissingR(9, false);
                } else {
                    if (state[0] >= 350) {
                        missingRes = state[1] < 75 ? 1 : 2;
                    } else missingRes = 0;
                    printMissingR(missingRes, true);
                }
                break;
            case "3":
                if (state[0] >= 200 && state[1] >= 100 && state[2] >= 12) {
                    state[0] = state[0] - 200;
                    state[1] = state[1] - 100;
                    state[2] = state[2] - 12;
                    state[4] = state[4] + 6;
                    state[3] = state[3] - 1;
                    printMissingR(9, false);
                } else {
                    if (state[0] >= 200) {
                        missingRes = state[1] < 100 ? 1 : 2;
                    } else missingRes = 0;
                    printMissingR(missingRes, true);
                }
                break;
            case "back":
                break;
            default:
                System.out.println("you must choose from 1 to 3");
        }
    }


    static void fill(int[] state, Scanner sc) {
        System.out.println("Write how many ml of water you want to add:");
        state[0] += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        state[1] += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        state[2] += sc.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        state[3] += sc.nextInt();
        System.out.println();
    }

    static void take(int[] state) {
        System.out.println("I gave you $" + state[4]);
        state[4] = 0;
        System.out.println();
    }

    static void printState(int[] state) {
        System.out.println("\nThe coffee machine has:");
        System.out.println(
                state[0] + " ml of water\n" + state[1] + " ml of milk\n"
                        + state[2] + " g of coffee beans\n" + state[3] + " disposable cups\n$"
                        + state[4] + " of money \n");
    }

    static void printMissingR(int supply, boolean miss) {
        String[] supplies = {"water", "milk", "coffee beans", "cups"};
        if (miss) {
            System.out.println("Sorry, not enough " + supplies[supply] + "!\n");

        } else System.out.println("I have enough resources, making you a coffee!\n");
    }

}
