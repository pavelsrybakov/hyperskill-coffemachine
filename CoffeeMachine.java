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
        System.out.println("Write how many ml of water the coffee machine has:");
        water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        int calculatedCups = calculateCoffee();
        if (cups == calculatedCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cups < calculatedCups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (calculatedCups - cups) + " more than that");
        } else {
            System.out.println("No, I can make only " + calculatedCups + " cup(s) of coffee");
        }

    }

    public static void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk +" ml of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public static void printCoffee() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    public static int calculateCoffee() {
        final int WATER = 200;
        final int MILK = 50;
        final int BEANS = 15;

        int minCupsWater = water / WATER;
        int minCupsMilk = milk / MILK;
        int minCupsBeans = beans / BEANS;

        if (minCupsWater <= minCupsBeans && minCupsWater <= minCupsMilk) {
            return minCupsWater;
        }

        if (minCupsMilk <= minCupsWater && minCupsMilk <= minCupsBeans) {
            return minCupsMilk;
        }

        if (minCupsBeans <= minCupsWater && minCupsBeans <= minCupsMilk) {
            return minCupsBeans;
        }
        return 0;
    }
}
