package com.designPatterns.COR;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanzhen
 * @date 2018/6/23
 * @project-name ModuleProject
 * @package-name com.designPatterns.COR
 * 责任链传递类
 */
public class FilterChain implements  MyFilter {

    private int cursor = 0;

    private List<MyFilter> chainList = new ArrayList<MyFilter>();

    public FilterChain (){};

    public FilterChain (MyFilter filter){
        this.chainList.add(filter);
    }

    public void addChain(MyFilter filter) {
        this.chainList.add(filter);
    }

    @Override
    public void doChain(MyRequestParam requestParam,FilterChain chain) {
        if(cursor < chainList.size()){
            MyFilter filter = chainList.get(cursor);
            cursor++;
            filter.doChain(requestParam,chain);
        }else {
            System.out.println("责任链执行完毕");
        }
    }


    public void setCursor(int cursor) {
        this.cursor = cursor;
    }
}
