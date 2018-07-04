package com.designPatterns.Constructor;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author yanzhen
 * @date 2018/7/4
 * @project-name ModuleProject
 * @package-name com.designPatterns.Constructor
 */
public class ConstrutorTest {

    public static void main(String[] args) {

        ConcreteBuilder cb = new ConcreteBuilder();
        Director director = new Director(cb);
        director.construct("产品1","产品描述1");
        System.out.println(ToStringBuilder.reflectionToString(cb.getProduct()));
    }
}
