package com.designPatterns.COR;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.*;

/**
 * @author yanzhen
 * @date 2018/6/23
 * @project-name ModuleProject
 * @package-name com.designPatterns.COR
 * 责任链配置枚举类
 * index 责任链执行顺序
 * classReferences 责任链具体实现类全路径
 */
public enum CorTypeEnum {

    CONCRETE_FILTERA(3,"com.designPatterns.COR.ConcreteFilterA"),

    CONCRETE_FILTERB(2,"com.designPatterns.COR.ConcreteFilterB"),

    CONCRETE_FILTERC(1,"com.designPatterns.COR.ConcreteFilterC")
    ;

    private int index ;

    private String classReferences ;

    private static List<CorType> classReferenceList = new ArrayList<>();

    CorTypeEnum (int index ,String classReferences){
        this.classReferences = classReferences;
        this.index = index;
    }

    public static List<CorType> getClassReferencesList (){
        for(CorTypeEnum type : CorTypeEnum.values()){
            CorType ct = new CorType();
            ct.setIndex(type.index);
            ct.setClassReferences(type.classReferences);
            classReferenceList.add(ct);
        }
        Collections.sort(classReferenceList, new Comparator<CorType>() {
            @Override
            public int compare(CorType ct1, CorType ct2) {
                return String.valueOf(ct1.getIndex()).compareTo(String.valueOf(ct2.getIndex()));
            }
        });
        StringBuffer sb  = new StringBuffer();
        classReferenceList.forEach(corType -> {
           sb.append(ToStringBuilder.reflectionToString(corType));
        });
        System.out.println(String.format("责任链实现类执行顺序--->[%s]      ;",sb.toString()));
        return classReferenceList ;
    }

    public static class CorType{
        private int index ;

        private String classReferences ;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getClassReferences() {
            return classReferences;
        }

        public void setClassReferences(String classReferences) {
            this.classReferences = classReferences;
        }
    }

}
