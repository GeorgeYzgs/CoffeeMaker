/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author George
 */
public enum TypeOfCoffee {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7), 
    CAPPUCCINO(200, 100, 12, 6);

    private final int WATER;
    private final int MILK;
    private final int COFFEE;
    private final int PRICE;

    TypeOfCoffee(int water, int milk, int coffee,int price) {
        this.WATER = water;
        this.MILK = milk;
        this.COFFEE = coffee;
        this.PRICE = price;
    }

    public int getWATER() {
        return WATER;
    }

    public int getMILK() {
        return MILK;
    }

    public int getCOFFEE() {
        return COFFEE;
    }

    public int getPRICE() {
        return PRICE;
    }
    
}
