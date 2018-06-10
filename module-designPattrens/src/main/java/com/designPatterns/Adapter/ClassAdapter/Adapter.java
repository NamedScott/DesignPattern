package com.designPatterns.Adapter.ClassAdapter;

/**
 * Created by scott on 2018/6/10.
 */
public class Adapter extends Adaptee implements Target{

    @Override
    public void methodB() {

        System.out.println(" this is methodB!");

    }
}
