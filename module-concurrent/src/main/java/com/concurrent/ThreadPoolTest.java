package com.concurrent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by scott on 2018/6/15.
 */
public class ThreadPoolTest {

    @Test
    public void ThreadPoolTest(){

        ExecutorService threadPoolA = ExecutorServiceInitPool();
        ThreadPoolExecutor threadPoolB = ThreadPoolExecutorInitPool();

        ExecuterTestTaskWithDiffPool(threadPoolA);
        System.out.println("--------------------------------------------------------");
        ExecuterTestTaskWithDiffPool(threadPoolB);
        threadPoolB.shutdown();
        threadPoolB.shutdownNow();
        try {
            boolean awaitTermination = threadPoolB.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void ExecuterTestTaskWithDiffPool(ExecutorService threadPool) {
        List<Future<Integer>> list = new ArrayList<>();
        for (int i = 0 ;i < 10 ; i ++){
            list.add(threadPool.submit(new TestTask(i)));
        }
        StringBuffer sb = new StringBuffer();
        list.forEach(future->{
            try {
                sb.append(future.get()).append(",");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        /*System.out.println(sb.toString());*/
        boolean shutdown = threadPool.isShutdown();
        System.out.println(String.format("threadPool  is shutdown :%s",shutdown));
    }

    private ExecutorService ExecutorServiceInitPool() {
       return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    private  ThreadPoolExecutor  ThreadPoolExecutorInitPool(){
        return new ThreadPoolExecutor(1,Runtime.getRuntime().availableProcessors(),
                2,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5),new ThreadPoolExecutor.CallerRunsPolicy());
    }


    private static class TestTask implements  Callable<Integer>{
        private Integer num ;

        public TestTask (Integer i ){
            this.num = i;
        }

        @Override
        public Integer call() throws Exception {

            return num;
        }
    }
}
