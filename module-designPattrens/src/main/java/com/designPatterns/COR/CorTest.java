package com.designPatterns.COR;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author yanzhen
 * @date 2018/6/23
 * @project-name ModuleProject
 * @package-name com.designPatterns.COR
 */
public class CorTest {

    private FilterChain chain = new FilterChain();

    @Before
    public void initFilterChainByEnum() {
        List<CorTypeEnum.CorType> classReferencesList = CorTypeEnum.getClassReferencesList();
        classReferencesList.forEach(CorType -> {
            try {
                Class<?> aClass = Class.forName(CorType.getClassReferences());
                chain.addChain((MyFilter) aClass.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void test() {
       /* MyRequestParam param = new MyRequestParam("A");
        chain.doChain(param, chain);
        System.out.println("-----------------------------------");
        chain.setCursor(0);
        param.setRequestStr("B");
        chain.doChain(param, chain);
        System.out.println("-----------------------------------");
        chain.setCursor(0);
        param.setRequestStr("C");
        chain.doChain(param, chain);*/
        String.format("ttt%s",123);
    }


}
