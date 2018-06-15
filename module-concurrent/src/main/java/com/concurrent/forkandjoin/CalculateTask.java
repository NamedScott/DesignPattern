package com.concurrent.forkandjoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by scott on 2018/6/14.
 */
public class CalculateTask extends RecursiveTask<Long>{

    private final  static Integer  SPLIT_THRESHOLD = 5;

    private  long[] arr ;
    private  int  start ;
    private  int  end ;

    public CalculateTask(long[] arr ,int start ,int end){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        StringBuffer sb = new StringBuffer();
        if ( (end - start) <= SPLIT_THRESHOLD) {
            long totalValue = sumArray(arr,start,end,sb);
            /*System.out.println(String.format("Current Thread Name is %s , calculate result is [%s], start index is %s ,end index is %s ",
                    Thread.currentThread().getName(), totalValue,start ,end));*/
            SingleTonForkAndJoinPool.countThreadMapA.putIfAbsent(Thread.currentThread().getName(),"");
            return totalValue ;
        } else {
            int middle = ( start + end ) / 2;
            CalculateTask subTaskA = new CalculateTask(arr , start ,middle);
            CalculateTask subTaskB = new CalculateTask(arr , middle+1 ,end);
            subTaskA.fork();
            subTaskB.fork();
            return   subTaskA.join() + subTaskB.join();
        }


    }

    public static  long sumArray(long[] array,int start ,int end ,StringBuffer sb) {

        sb.append(start+"--"+end +">>>>");
        long returnValue = 0;
        for (int i = start; i <= end; i++) {
            sb.append(array[i]).append(",");
            returnValue += array[i];
        }
        return returnValue;
    }


}
