package com.designPatterns.Decorator.example;

/**
 * Created by scott on 2018/5/13.
 */
public class Coffe implements DrinkInterface {


    /**
     * 基础价格
     */
    private static float BASIC_COST = 10;

    private static final  String DESCRIPTION = "coffe";


    @Override
    public Float cost() {
        return BASIC_COST;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
