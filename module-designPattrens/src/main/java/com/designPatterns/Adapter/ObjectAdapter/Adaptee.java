package com.designPatterns.Adapter.ObjectAdapter;

/**
 * Created by scott on 2018/6/10.
 */
public class Adaptee {

    public void methodA(){

        System.out.println(String.format("this is %s  methodA",this.getClass().getName().toString()));
    }

}
