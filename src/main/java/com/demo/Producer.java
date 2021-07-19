package com.demo;

import java.util.concurrent.BlockingQueue;

/**
 * @author GXY
 * @Package com.demo
 * @date 2020/10/22 0:11
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class Producer implements Runnable{

    private BlockingQueue<Object> queue;

    Producer(java.util.concurrent.BlockingQueue<Object> theQueue) {
        this.queue = theQueue;
    }

    public void run() {
        try {
            while (true) {
                Object justProduced = getResource();
                queue.put(justProduced);
                System.out.println("生产者资源队列大小= " + queue.size());
            }
        } catch (InterruptedException ex) {
            System.out.println("生产者 中断");
        }
    }

    Object getResource() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println("生产者 读 中断");
        }
        return new Object();
    }
}
