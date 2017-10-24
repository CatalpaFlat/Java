package com.chen.stack;

import java.util.LinkedList;

/**
 * 自定义堆
 * 使用链式列表实现队列的功能
 * 先进后出(LIFO)
 * @author 陈梓平
 * @date 2017/10/23.
 */
public class CustomStack<T> {
    private LinkedList<T> linkedList = new LinkedList<T>();

    /**
     * 线程安全
     * 压入堆中
     * @param t
     */
    public synchronized void push(T t){
        linkedList.addFirst(t);
    }

    /**
     * 取出
     * @return
     */
    public T peek(){
        return linkedList.getFirst();
    }

    /**
     * 移除
     */
    public void pop(){
        linkedList.removeFirst();
    }

    /**
     * 获取stack
     * @return
     */
    public LinkedList<T> getLinkedList(){
        return this.linkedList;
    }

    @Override
    public String toString() {
        return "CustomStack{" +
                "linkedList=" + linkedList +
                '}';
    }
}
