package com.chen.stack.test;

import com.chen.stack.CustomStack;
import org.junit.Test;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * 测试
 * @author 陈梓平
 * @date 2017/10/23.
 */
public class TestCustomStack {
    private static final Logger log = Logger.getLogger(TestCustomStack.class.getName());
    @Test
    public void test(){
        CustomStack<String> customStack = new CustomStack<>();
        String str = "A,B,C,D,E,F,G";
        Arrays.asList(str.split(",")).forEach(s ->{
            customStack.push(s);
        });
        log.info(customStack+"");
        Arrays.asList(customStack.getLinkedList().toArray()).forEach(obj -> {
            System.out.print(customStack.peek()+",");
            customStack.pop();
        });
    }
}
