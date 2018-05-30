package com.designPatterns.Decorator.javeBean;

import com.designPatterns.Decorator.inter.Component;

/**
 * Created by scott on 2018/5/13.
 */
public class ConcreteDecoratorA  extends Decorator{


    public ConcreteDecoratorA (Component con){
        super(con);

    }

    @Override
    public void operation() {
        System.out.println("ConcreteDecoratorA operation method has been done! the next is ConcreteComponent");
        super.operation();
    }
}
