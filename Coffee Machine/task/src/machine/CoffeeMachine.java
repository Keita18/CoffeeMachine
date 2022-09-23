package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = sc.nextInt() / 200;
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = sc.nextInt() / 50;
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee = sc.nextInt() / 15;
        System.out.println("Write how many cups of coffee you will need:");
        int numOfCup = sc.nextInt();
        int min = Math.min(water, milk);
        min = Math.min(min, coffee);
        if (min - numOfCup > 0) System.out.println("Yes, I can make that amount of coffee (and even "+(min - numOfCup)+" more than that)");
        if (min - numOfCup == 0) System.out.println("Yes, I can make that amount of coffee");
        if (min - numOfCup < 0) System.out.println("No, I can make only "+min+" cup(s) of coffee");
    }
}
