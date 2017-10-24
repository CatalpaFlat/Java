package com.chen.queue;

/**
 * 队列消息处理实现
 * @author 陈梓平
 * @date 2017/10/23.
 */
public class CustomMessageQueueHander implements Runnable {

    private Object object;

    public CustomMessageQueueHander(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        doBusiness();
    }
    /**
     * 业务处理时限
     */
    private void doBusiness() {
        System.out.println(" 处理请求 "+object );
    }
}
