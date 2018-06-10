package com.designPatterns.Adapter.ObjectAdapter;

/**
 * Created by scott on 2018/6/10.
 */
public class Adapter implements Target{

    private Adaptee adaptee;


    public Adapter(Adaptee adaptee){

        this.adaptee = adaptee;

    }


    @Override
    public void methodA() {
        this.adaptee.methodA();
    }

    @Override
    public void methodB() {
        System.out.println(String.format("this is %s methodB",this.getClass().getName()));
    }
}
