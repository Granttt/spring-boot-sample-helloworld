package com.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author GXY
 * @Package com.demo
 * @date 2020/10/21 23:31
 * @Copyright © 2020-2021 新流通
 * @Description:通过实验可知BlockingQueues与AtomicInteger是共享的；int不共享
 */
public class GongTest {
    public static void main(String[] args) {
        int taskNum = 2;
        AtomicInteger atomicInteger = new AtomicInteger(1);
        BlockingQueue<Object> myQueue = new LinkedBlockingQueue<Object>(5);

        System.out.println("一:"+myQueue.size());
        Gong gong = new Gong(taskNum,atomicInteger,myQueue);
        System.out.println(atomicInteger.get());

        System.out.println("四："+myQueue.size());
    }
}
