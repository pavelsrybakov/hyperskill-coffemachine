package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {

        printState();
        System.out.println("Write action (buy, fill, take):");
        String action = scanner.next();
        if (action.equals("buy")) {
            buyCoffee();
        }
        if (action.equals("fill")) {
            fillCoffee();
        }
        if (action.equals("take")) {
            takeMoney();
        }
        printState();

    }

    private static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private static void fillCoffee() {
        System.out.println("Write how many ml of water you want to add:");
        water = water + scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk = milk + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans = beans + scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups = cups + scanner.nextInt();
    }

    private static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int sortOfCoffee = scanner.nextInt();
        if (sortOfCoffee == 1) {
            water -= 250;
            beans -= 16;
            cups -=1;
            money += 4;
        }
        if (sortOfCoffee == 2) {
            water -= 350;
            milk -= 75;
            beans -= 20;
            cups -=1;
            money += 7;
        }
        if (sortOfCoffee == 3) {
            water -= 200;
            milk -= 100;
            beans -= 12;
            cups -=1;
            money += 6;
        }
    }

    public static void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }
}
