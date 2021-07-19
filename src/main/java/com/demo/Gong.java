package com.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author GXY
 * @Package com.demo
 * @date 2020/10/21 23:29
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class Gong {
    private int ataskNum;
    private AtomicInteger atomicInteger;
    private BlockingQueue<Object> queue;

    public Gong(int taskNum,AtomicInteger a,BlockingQueue<Object> queue) {
        System.out.println(a.get());
        System.out.println("二:"+queue.size());
        this.ataskNum = taskNum;
        this.atomicInteger = a;
        ataskNum = 100;
        this.queue = queue;
        try {
                this.queue.put(1);
                this.queue.put(2);
                this.queue.put(3);
            atomicInteger.getAndIncrement();
            System.out.println(a.get());
            System.out.println("三:"+queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
