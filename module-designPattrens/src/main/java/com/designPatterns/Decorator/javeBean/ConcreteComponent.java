package com.designPatterns.Decorator.javeBean;

import com.designPatterns.Decorator.inter.Component;

/**
 * Created by scott on 2018/5/13.
 * 具体构件角色
 */
public class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("ConcreteComponent operation method has been done!");
    }
}
