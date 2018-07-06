package com.designPatterns.Singleton;

/**
 * @author yanzhen
 * @date 2018/7/6
 * @project-name module-root
 * @package-name com.designPatterns.Singleton
 * 利用内部类加载机制实现线程安全的单例模式
 */
public class LazySingletonV2 {

    private LazySingletonV2(){}

    /**
     * 由于对象实例化是在内部类加载的时候构建的，
     * 因此该版是线程安全的(因为在方法中创建对象，才存在并发问题，静态内部类随着方法调用而被加载，
     * 只加载一次，不存在并发问题，所以是线程安全的)。
     */
    static class SingletonHolder{
        private static final LazySingletonV2 instance = new LazySingletonV2();
    }

    public LazySingletonV2 getInstance(){
        return SingletonHolder.instance;
    }

}
