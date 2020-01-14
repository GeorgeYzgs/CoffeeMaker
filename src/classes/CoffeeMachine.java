/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Scanner;

/**
 *
 * @author George.Giazitzis
 */
public class CoffeeMachine {

    private Scanner sc = new Scanner(System.in);
    private int waterStock;
    private int milkStock;
    private int coffeeStock;
    private int cupStock;
    private int money;

    public CoffeeMachine() {
        this.waterStock = 400;
        this.milkStock = 540;
        this.coffeeStock = 120;
        this.cupStock = 9;
        this.money = 550;
        option();
    }

    public int getWaterStock() {
        return waterStock;
    }

    public int getMilkStock() {
        return milkStock;
    }

    public int getCoffeeStock() {
        return coffeeStock;
    }

    public int getCupStock() {
        return cupStock;
    }

    public int getMoney() {
        return money;
    }

    private void option() {
        loop:
        do {
            System.out.println("What would you like to do? (buy, fill, take, remaining, exit):");
            switch (sc.nextLine()) {
                case "buy":
                    buy();
                    break loop;
                case "fill":
                    fill();
                    break;
                case "take":
                    System.out.printf("I gave you $%d from the cash register\n",money);
                    money = 0;
                    break;
                case "remaining":
                    stock();
                    break;
                case "exit":
                    break loop;
                default:
                    System.out.println("This is not a valid option!");
            }
        } while (true);
    }

    private void buy() {
        loop:
        do {
            System.out.println("What do you want to buy?  1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
            switch (sc.nextLine()) {
                case "1":
                    makeCoffee(TypeOfCoffee.ESPRESSO);
                    break loop;
                case "2":
                    makeCoffee(TypeOfCoffee.CAPPUCCINO);
                    break loop;
                case "3":
                    makeCoffee(TypeOfCoffee.LATTE);
                    break loop;
                case "back":
                    option();
                    break loop;
                default:
                    System.out.println("This is not a valid option!");
            }
        } while (true);
    }

    private void makeCoffee(TypeOfCoffee type) {
        if (cupStock < 1) {
            System.out.println("Sorry, not enough cups");
        } else if (waterStock < type.getWATER()) {
            System.out.println("Sorry, not enough water!");
        } else if (milkStock < type.getMILK()) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeStock < type.getCOFFEE()) {
            System.out.println("Sorry, not enough coffee beans!");
        } else {
            System.out.println("Making you a " + type.name() + "!");
            waterStock -= type.getWATER();
            milkStock -= type.getMILK();
            coffeeStock -= type.getCOFFEE();
            cupStock--;
            money += type.getPRICE();
        }
        option();
    }

    private void fill() {
        System.out.println("How many ml of water do you want to add?");
        waterStock += sc.nextInt();
        System.out.println("How many ml of milk do you want to add?");
        milkStock += sc.nextInt();
        System.out.println("How many grams of coffee beans do you want to add?");
        coffeeStock += sc.nextInt();
        System.out.println("How many disposable cups do you want to add?");
        cupStock += sc.nextInt();
        sc.nextLine();
    }

    private void stock() {
        System.out.println("The coffee machine has:\n"
                + String.format("%dml of water\n", waterStock)
                + String.format("%dml of milk\n", milkStock)
                + String.format("%dg of coffee beans\n", coffeeStock)
                + String.format("%d disposable cups\n", cupStock)
                + String.format("%d$", money));
    }
}
