package com.designPatterns.Decorator.javeBean;

import com.designPatterns.Decorator.inter.Component;

/**
 * Created by scott on 2018/5/13.
 */
public class Decorator implements Component {

    private Component component;


    public Decorator(Component compo){
        this.component = compo;
    }


    @Override
    public void operation() {
        component.operation();
    }

}
