package com.thread.testone;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author GXY
 * @Package com.thread.testone
 * @date 2020/7/18 14:55
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class ThreadPoolTestFour {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i <=10; i++) {
            final int j=i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);
                }
            });
        }
        executor.shutdown();
    }
}
