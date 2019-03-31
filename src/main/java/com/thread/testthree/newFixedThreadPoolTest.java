package com.thread.testthree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newFixedThreadPool
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 */
public class newFixedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService  fixedThreadPool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        /**
                         * 因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字。
                         * 定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
                         */
                        System.out.println(index+"--"+Thread.currentThread().getName());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        fixedThreadPool.shutdown();
    }
}
