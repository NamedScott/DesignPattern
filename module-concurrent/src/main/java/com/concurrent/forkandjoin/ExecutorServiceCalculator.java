package com.concurrent.forkandjoin;

import com.sun.tools.javadoc.Start;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by scott on 2018/6/14.
 */
public class ExecutorServiceCalculator implements  Calculator {

    private  ExecutorService pool ;

    private final static Integer SPLIT_THRESHOLD = 5;

    public ExecutorServiceCalculator () {
        pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    private static class SumTask implements Callable<Long>{
        private long[] arr ;
        private int start ;
        private int end;

        public SumTask(long[] arr ,int start ,int end){
            this.arr = arr ;
            this.start = start ;
            this.end = end;
        }

        @Override
        public Long call() throws Exception {
            SingleTonForkAndJoinPool.countThreadMapB.putIfAbsent(Thread.currentThread().getName(),"");
            StringBuffer sb = new StringBuffer();
            long returnValue = 0;
            for (int i = start; i < end; i++) {
                sb.append(arr[i]).append(",");
                returnValue += arr[i];
            }
            /*System.out.println(String.format("Current Thread Name is %s , calculate result is [%s], start index is %s ,end index is %s, the arr is [%s] ",
                    Thread.currentThread().getName(), returnValue,start ,end,sb.toString()));*/
            return returnValue;
        }
    }

    @Override
    public long sum(long[] arr) {
        int length = arr.length  ;
        if(length < SPLIT_THRESHOLD){
            long value = 0;
            try {
                value = pool.submit(new SumTask(arr,0,length)).get();
            }catch (Exception e){
                e.printStackTrace();
            }
            return value;
        }
        List<Future<Long>> futureList = new ArrayList<>();
        int num = length / SPLIT_THRESHOLD;
        num = length % SPLIT_THRESHOLD > 0 ? num + 1 : num ;
        int lastIndex = 0;
        for (int i = 0 ; i < SPLIT_THRESHOLD ; i ++ ){
            int endIndex = i == (SPLIT_THRESHOLD - 1) ?  arr.length  :lastIndex + num ;
            /*System.out.println(String.format("start index is %s, end index is %s",lastIndex,endIndex));*/
            futureList.add(pool.submit(new SumTask(arr,lastIndex,endIndex)));
            lastIndex += num;
        }
        long totalValue = 0;
        for (int j = 0 ; j < futureList.size() ; j++){
            Future<Long> future = futureList.get(j);
            try {
                totalValue += future.get();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        pool.shutdown();
        pool.shutdownNow();
        return totalValue;
    }

}
