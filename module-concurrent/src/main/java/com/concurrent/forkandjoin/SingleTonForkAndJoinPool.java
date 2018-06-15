package com.concurrent.forkandjoin;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by scott on 2018/6/14.
 * ForkAndJoinPool singleton parterrn
 */
public class SingleTonForkAndJoinPool {

    public   static  volatile ConcurrentHashMap<String, String> countThreadMapA = new ConcurrentHashMap<>();

    public   static  volatile ConcurrentHashMap<String, String> countThreadMapB = new ConcurrentHashMap<>();

    private SingleTonForkAndJoinPool(){}

    static class  SingleTonHolder{
        private static final ForkJoinPool instance = new ForkJoinPool();
    }

    public static  ForkJoinPool getInstance () {
        return SingleTonHolder.instance;
    }

}
