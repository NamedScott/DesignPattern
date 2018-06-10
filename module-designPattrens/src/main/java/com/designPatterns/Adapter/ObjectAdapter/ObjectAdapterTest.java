package com.designPatterns.Adapter.ObjectAdapter;

/**
 * Created by scott on 2018/6/10.
 */
public class ObjectAdapterTest {

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);

        adapter.methodA();
        adapter.methodB();


    }

}
