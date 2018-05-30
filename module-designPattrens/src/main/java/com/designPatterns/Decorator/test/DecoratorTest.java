package com.designPatterns.Decorator.test;

import com.designPatterns.Decorator.inter.Component;
import com.designPatterns.Decorator.javeBean.ConcreteComponent;
import com.designPatterns.Decorator.javeBean.ConcreteDecoratorA;
import com.designPatterns.Decorator.javeBean.Decorator;

/**
 * Created by scott on 2018/5/13.
 */
public class DecoratorTest {


    public static void main(String[] args) {

        Component con = new ConcreteDecoratorA(new ConcreteComponent());
        con.operation();


    }



}
