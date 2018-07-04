package com.designPatterns.Constructor;

/**
 * @author yanzhen
 * @date 2018/7/4
 * @project-name ModuleProject
 * @package-name com.designPatterns.Constructor
 * 执行者,实际构造者,construct方法具体确定产品哪些属性需要定义
 */
public class Director {

    private Builder builder;

    public Director(Builder b){
        this.builder = b ;
    }

    public void construct(String name , String descrip){
        builder.buildProName(name);
        builder.buildProDescription(descrip);
    }

}
