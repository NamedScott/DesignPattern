package com.designPatterns.Decorator.example;

/**
 * Created by scott on 2018/5/13.
 */
public class AddSuger extends DrinkDecorator {


    private static final float ADD_PRICE = (float) 0.5;

    private static final String DESCRIPTION = "   add suger  ";


    public AddSuger(DrinkInterface drink) {
        super(drink);
    }

    @Override
    public Float cost() {
        return super.cost()+ADD_PRICE;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+DESCRIPTION;
    }
}
