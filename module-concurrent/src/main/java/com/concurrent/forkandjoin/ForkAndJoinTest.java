package com.concurrent.forkandjoin;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * Created by scott on 2018/6/14.
 */
public class ForkAndJoinTest  {




    public static void main(String[] args) {
        long[] arrays = LongStream.rangeClosed(1, 10000000).toArray();
        long startTime = 0;
        long endTime = 0 ;
        System.out.println("--------------------------forkAndJoin-------------------------------");
        startTime = System.currentTimeMillis();
        ForkJoinPool pool = SingleTonForkAndJoinPool.getInstance();
        Long result = pool.invoke(new CalculateTask(arrays, 0, arrays.length-1  ));
        System.out.println(String.format("forkAndJoin use thread count is %s",SingleTonForkAndJoinPool.countThreadMapA.size()));
        System.out.println(String.format("final result is %s",result));
        endTime = System.currentTimeMillis();
        System.out.println(String.format("the forkAndJoin mission cost time :%s",endTime-startTime));


        System.out.println("------------------------ExecutorServiceTask---------------------------");
        startTime = System.currentTimeMillis();
        ExecutorServiceCalculator  ex = new ExecutorServiceCalculator();
        long sum = ex.sum(arrays);
        System.out.println(String.format("ExecutorServiceTask use thread count is %s",SingleTonForkAndJoinPool.countThreadMapB.size()));
        System.out.println(String.format("final result is %s",sum));
        endTime = System.currentTimeMillis();
        System.out.println(String.format("the ExecutorService mission cost time :%s",endTime-startTime));
    }




}
