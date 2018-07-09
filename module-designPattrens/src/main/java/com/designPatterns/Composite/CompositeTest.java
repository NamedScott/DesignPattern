package com.designPatterns.Composite;

import org.junit.Test;

/**
 * @author yanzhen
 * @date 2018/7/6
 * @project-name module-root
 * @package-name com.designPatterns.Composite
 */
public class CompositeTest {

    private String name = "二狗哥";

    @Test
    public void test(){
        PayDemo pd = new PayDemo();
        Integer credit = PayDemo.CREDIT_MAP.get(name) == null ? 0 :PayDemo.CREDIT_MAP.get(name);
        System.out.println(String.format("%s当前积分为:%s",name,credit));

        PayDemo.MarketBranch firstJoin = pd.new MarketBranch("第一加盟店");
        firstJoin.payAndAddCredit(name,10);
        credit = PayDemo.CREDIT_MAP.get(name) == null ? 0 :PayDemo.CREDIT_MAP.get(name);
        System.out.println(String.format("%s当前积分为:%s",name,credit));


        PayDemo.MarketLeaf firstLeaf = pd.new MarketLeaf("第一加盟店第一分店");
        firstLeaf.payAndAddCredit(name,60);
        credit = PayDemo.CREDIT_MAP.get(name) == null ? 0 :PayDemo.CREDIT_MAP.get(name);
        System.out.println(String.format("%s当前积分为:%s",name,credit));

    }
}
