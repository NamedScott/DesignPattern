package com.designPatterns.Constructor;

/**
 * @author yanzhen
 * @date 2018/7/4
 * @project-name ModuleProject
 * @package-name com.designPatterns.Constructor
 * 建造者接口,用来定义哪些属性必须被填充
 */
public interface Builder {

    void buildProName(String name);

    void buildProDescription(String description);

    Product getProduct();
}
