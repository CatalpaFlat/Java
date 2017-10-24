package com.chen.queue;

import org.junit.Test;

import java.util.Random;

/**
 * @author 陈梓平
 * @date 2017/10/23.
 */
public class TestCustomMessageQueue {
    @Test
    public void test() throws InterruptedException {
        CustomMessageQueue.getInstance().start();
        int max=200;
        int min=0;
        Random random = new Random();
        int i = random.nextInt(max) % (max - min + 1) + min;
        System.out.println(i);
//        for (;;){
//            //在队列的尾部插入指定的元素
//            CustomMessageQueue.getInstance().put("8888888");
//            Thread.sleep(1000);
//        }
    }

}
