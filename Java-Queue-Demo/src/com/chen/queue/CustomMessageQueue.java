package com.chen.queue;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 自定义消息队列缓冲定义
 * 直接使用LinkedBlockingQueue队列，自带队列阻塞功能，免去线程安全控制
 * @author 陈梓平
 * @date 2017/10/23.
 */
public class CustomMessageQueue extends LinkedBlockingQueue<Object>{
    private static final long serialVersionUID = -1L;
    /**
     * 线程工厂
     */
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();
    /**
     * 线程池
     */
    private static ExecutorService es = new ThreadPoolExecutor(5,200,0L,TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),namedThreadFactory,
            new ThreadPoolExecutor.AbortPolicy());
    /**
     * 单例
     */
    private static CustomMessageQueue cmq = new CustomMessageQueue();

    /**
     * 队列监听启动关闭状态
     */
    private boolean flag = false;
    private CustomMessageQueue(){
    }

    /**
     * 获取单例
     * @return
     */
    public static CustomMessageQueue getInstance(){
        return cmq;
    }

    /**
     * 启动队列监听
     */
    public void start(){
        if (!flag){
            this.flag = true;
        }else {
            throw new IllegalArgumentException("队列已经启动");
        }
        new Thread(() -> {
            while (flag){
                Object object = null;
                try {
                    //获取BlockingQueue里排在首位的对象
                    object = take();
                    es.execute(new CustomMessageQueueHander(object));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    /**
     * 停止队列监听
     */
    public void stop(){
        this.flag = false;
    }
}
