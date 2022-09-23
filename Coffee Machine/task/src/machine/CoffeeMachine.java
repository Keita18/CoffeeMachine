package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int numOfCup = sc.nextInt();
        System.out.printf("For %d cups of coffee you will need: %n", numOfCup);
        System.out.println(numOfCup * 200 + " ml of water\n"
                + numOfCup*50 +" ml of milk\n" + numOfCup*15 + " g of coffee beans" );
    }
}
