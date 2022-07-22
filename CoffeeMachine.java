package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    enum States {
        MAIN_MENU, BUYING, FILLING_WATER, FILLING_MILK, ADDING_BEANS, ADDING_CUPS
    }

    States state;

    public static void main(String[] args) {

        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.next();
        while (!action.equals("exit")) {
            if (action.equals("buy")) {
                buyCoffee();
            }
            if (action.equals("fill")) {
                fillCoffee();
            }
            if (action.equals("take")) {
                takeMoney();
            }
            if (action.equals("remaining")) {
                printState();
            }
            action = scanner.next();
        }
    }

    private void processInput(String input) {

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
        String sortOfCoffee = scanner.next();
        System.out.println(sortOfCoffee);
        if (checkResources(sortOfCoffee)) {
            switch (sortOfCoffee) {
                case "1" :
                    water -= 250;
                    beans -= 16;
                    cups -=1;
                    money += 4;
                    break;
                case "2" :
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups -=1;
                    money += 7;
                    break;
                case "3" :
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups -=1;
                    money += 6;
                    break;
                default:
  //                  System.out.println("Wrong input!");
            }
        }

            System.out.println("I have enough resources, making you a coffee!");
    }

    private static boolean checkResources(String sortOfCoffee) {
        int waterNeeded = 0;
        int beansNeeded = 0;
        int milkNeeded = 0;
        int cupsNeeded = 1;

        switch (sortOfCoffee) {
            case "1" :
                waterNeeded = 250;
                beansNeeded = 16;
                break;
            case "2" :
                waterNeeded = 350;
                milkNeeded = 75;
                beansNeeded = 20;
                break;
            case "3" :
                waterNeeded = 200;
                milkNeeded = 100;
                beansNeeded = 12;
                break;
            default:
                System.out.println("Wrong input!");
                return false;
        }

        if (waterNeeded > water) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milkNeeded > milk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (beansNeeded > beans) {
            System.out.println("Sorry, not enough beans!");
            return false;
        }
        if (cupsNeeded > cups) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        return true;
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
