package com.designPatterns.Decorator.example;

/**
 * Created by scott on 2018/5/13.
 */
public class DrinkDecoratorTest {


    public static void main(String[] args) {

        DrinkInterface coffe = new Coffe();
        System.out.println(String.format("%s : %s",coffe.getDescription(),String.valueOf(coffe.cost())));

        coffe = new AddMilk(new DrinkDecorator(coffe));
        System.out.println(String.format("%s : %s",coffe.getDescription(),String.valueOf(coffe.cost())));


        coffe = new AddSuger(new DrinkDecorator(coffe));
        System.out.println(String.format("%s : %s",coffe.getDescription(),String.valueOf(coffe.cost())));

    }
}
