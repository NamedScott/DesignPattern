package com.designPatterns.Constructor;

/**
 * @author yanzhen
 * @date 2018/7/4
 * @project-name ModuleProject
 * @package-name com.designPatterns.Constructor
 * 具体建造者构造产品,填充产品属性
 */
public class ConcreteBuilder  implements Builder{

    private Product pro ;

    public ConcreteBuilder(){
        this.pro = new Product() ;
    }

    @Override
    public void buildProName(String name) {
        pro.setProNanme(name);
    }

    @Override
    public void buildProDescription(String description) {
        pro.setProDescription(description);
    }

    @Override
    public Product getProduct() {
        return pro;
    }
}
