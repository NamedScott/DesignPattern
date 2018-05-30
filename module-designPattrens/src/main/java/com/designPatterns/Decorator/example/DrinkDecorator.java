package com.designPatterns.Decorator.example;

/**
 * Created by scott on 2018/5/13.
 */
public class DrinkDecorator implements  DrinkInterface {

    protected DrinkInterface drink ;

    public DrinkDecorator (DrinkInterface drink){
        this.drink  = drink;
    }


    @Override
    public Float cost() {
        return drink.cost();
    }

    @Override
    public String getDescription() {
        return drink.getDescription();
    }
}
