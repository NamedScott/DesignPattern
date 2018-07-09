package com.designPatterns.Composite;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yanzhen
 * @date 2018/7/6
 * @project-name module-root
 * @package-name com.designPatterns.Composite
 * 这个例子网上抄的 简直垃圾
 */
public class PayDemo {

    public static Map<String,Integer> CREDIT_MAP = new HashMap<>();

    public abstract class Market{
        protected String marketName;

        protected abstract void addMarket(Market market);

        protected abstract void removeMarket(Market market);

        protected abstract void payAndAddCredit(String userName,Integer credit);
    }

    /**
     * 加盟店
     */
    public class MarketBranch extends  Market {

        private List<Market> list = new ArrayList<>();

        public MarketBranch (String name){
            this.marketName = name;
        }

        @Override
        public void addMarket(Market market) {
            list.add(market);
        }

        @Override
        public void removeMarket(Market market) {
            list.remove(market);
        }

        @Override
        public void payAndAddCredit(String userName,Integer credit) {
            CREDIT_MAP.put(userName,CREDIT_MAP.get(userName) == null ? credit : credit+CREDIT_MAP.get(userName));
            System.out.println(String.format("[%s]顾客在[%s]消费产生[%s],累计积分[%s]...",
                    userName,marketName,credit,CREDIT_MAP.get(userName)));
        }
    }


    /**
     * 分店
     */
    public class MarketLeaf extends Market{

        public MarketLeaf (String name){
            this.marketName = name;
        }

        @Override
        protected void addMarket(Market market) {

        }

        @Override
        protected void removeMarket(Market market) {

        }

        @Override
        protected void payAndAddCredit(String userName, Integer credit) {
            CREDIT_MAP.put(userName,CREDIT_MAP.get(userName) == null ? credit : credit+CREDIT_MAP.get(userName));
            System.out.println(String.format("[%s]顾客在[%s]消费产生[%s],累计积分[%s]...",
                    userName,marketName,credit,CREDIT_MAP.get(userName)));
        }
    }
}
