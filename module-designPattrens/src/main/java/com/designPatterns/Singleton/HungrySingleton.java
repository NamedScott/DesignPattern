package com.designPatterns.Singleton;

/**
 * @author yanzhen
 * @date 2018/7/6
 * @project-name module-root
 * @package-name com.designPatterns.Singleton
 * 饿汉式单例模式
 */
public class HungrySingleton {

    private static HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return singleton;
    }
}
