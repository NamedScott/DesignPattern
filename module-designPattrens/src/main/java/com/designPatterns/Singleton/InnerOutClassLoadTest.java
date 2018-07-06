package com.designPatterns.Singleton;

/**
 * @author yanzhen
 * @date 2018/7/6
 * @project-name module-root
 * @package-name com.designPatterns.Singleton
 * 加载一个类时，其内部类不会被加载
 * 静态方法或者成员被调用时就会加载该类
 */
public class InnerOutClassLoadTest {

    static {
        System.out.println("load out class...");
    }

    public static class InnerClass{
        static {
            System.out.println("load Inner static class ...");
        }
        static void method(){
            System.out.println("load Inner static method...");
        }
    }

    public static void main(String[] args) {
        /*InnerOutClassLoadTest iocl = new InnerOutClassLoadTest();*/
        System.out.println("==============================");
        InnerOutClassLoadTest.InnerClass.method();
    }
}
