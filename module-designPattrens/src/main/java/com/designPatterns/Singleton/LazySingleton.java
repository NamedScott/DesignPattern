package com.designPatterns.Singleton;

/**
 * @author yanzhen
 * @date 2018/7/6
 * @project-name module-root
 * @package-name com.designPatterns.Singleton
 * 单例双检索模式
 */
public class LazySingleton {

    private static volatile LazySingleton lazySingleton  ;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(null == lazySingleton){
            synchronized (lazySingleton.getClass()){
                if(null == lazySingleton){
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

}
