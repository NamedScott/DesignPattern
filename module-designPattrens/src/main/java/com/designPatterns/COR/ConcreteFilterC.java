package com.designPatterns.COR;

/**
 * @author yanzhen
 * @date 2018/6/23
 * @project-name ModuleProject
 * @package-name com.designPatterns.COR
 */
public class ConcreteFilterC implements MyFilter {

    private final static String RESPONSIBILITY_TYPE = "C";
    @Override
    public void doChain(MyRequestParam requestParam,FilterChain chain) {
        if(RESPONSIBILITY_TYPE.equals(requestParam.getRequestStr())){
            System.out.println(String.format("[%s]责任链实现类执行完毕",this.getClass().getName()));
            chain.doChain(requestParam,chain);
        }else{
            System.out.println(String.format("未满足[%s]执行条件,进入下一个责任链实现类",this.getClass().getName()));
            chain.doChain(requestParam,chain);
        }
    }
}
