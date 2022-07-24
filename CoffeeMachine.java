package machine;

import java.util.Scanner;

enum States {
    MAIN_MENU, BUYING, FILLING_WATER, FILLING_MILK, ADDING_BEANS, ADDING_CUPS
}

class CoffeeMachineDevice {
    int water;
    int milk;
    int beans;
    int cups;
    int money;
    States state;
    public CoffeeMachineDevice(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
        this.state = States.MAIN_MENU;
    }

    public void processInput (String input) {
        if (state == States.MAIN_MENU) {
            if (input.equals("buy")) {
                this.buy();
            }
            if (input.equals("fill")) {
                this.fill();
            }
            if (input.equals("take")) {
                this.takeMoney();
            }
            if (input.equals("remaining")) {
                this.printState();
            }
            return;
        }
        if (state == States.FILLING_WATER) {
            this.fillWater(input);
            return;
        }
        if (state == States.FILLING_MILK) {
            this.fillMilk(input);
            return;
        }
        if (state == States.ADDING_BEANS) {
            this.addBeans(input);
            return;
        }
        if (state == States.ADDING_CUPS) {
            this.addCups(input);
            return;
        }
        if (state == States.BUYING) {
            this.buyCoffee(input);
            return;
        }

    }

    private void takeMoney() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
    }

    private void fill() {
        System.out.println("Write how many ml of water you want to add:");
        this.state = States.FILLING_WATER;
    }

    private void fillWater(String input) {
        this.water += Integer.valueOf(input);
        System.out.println("Write how many ml of milk you want to add:");
        this.state = States.FILLING_MILK;
    }

    private void fillMilk(String input) {
        this.milk += Integer.valueOf(input);
        System.out.println("Write how many grams of beans you want to add:");
        this.state = States.ADDING_BEANS;
    }

    private void addBeans(String input) {
        this.beans += Integer.valueOf(input);
        System.out.println("Write how many disposable cups of coffee you want to add:");
        this.state = States.ADDING_CUPS;
    }

    private void addCups(String input) {
        this.cups += Integer.valueOf(input);
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        this.state = States.MAIN_MENU;
    }

    private void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        this.state = States.BUYING;
    }



    private void buyCoffee(String sortOfCoffee) {
        if (checkResources(sortOfCoffee)) {
            switch (sortOfCoffee) {
                case "1" :
                    this.water -= 250;
                    this.beans -= 16;
                    this.cups -=1;
                    this.money += 4;
                    break;
                case "2" :
                    this.water -= 350;
                    this.milk -= 75;
                    this.beans -= 20;
                    this.cups -=1;
                    this.money += 7;
                    break;
                case "3" :
                    this.water -= 200;
                    this.milk -= 100;
                    this.beans -= 12;
                    this.cups -=1;
                    this.money += 6;
                    break;
                default:
                    //                  System.out.println("Wrong input!");
            }
            System.out.println("I have enough resources, making you a coffee!");
        }
        this.state = States.MAIN_MENU;
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
    }

    private boolean checkResources(String sortOfCoffee) {
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

        if (waterNeeded > this.water) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milkNeeded > this.milk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (beansNeeded > this.beans) {
            System.out.println("Sorry, not enough beans!");
            return false;
        }
        if (cupsNeeded > this.cups) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        return true;
    }

    private void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " ml of water");
        System.out.println(this.milk + " ml of milk");
        System.out.println(this.beans + " of coffee beans");
        System.out.println(this.cups + " disposable cups");
        System.out.println("$" + this.money + " of money");
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
    }

}

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String input = scanner.next();
        CoffeeMachineDevice coffeeMachineDevice = new CoffeeMachineDevice(400, 540,120,9,550);
        while (!input.equals("exit")) {
            coffeeMachineDevice.processInput(input);
            input = scanner.next();
        }
    }
}
