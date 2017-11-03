package com.chen.creationtype.singlecase;

import com.chen.creationtype.singlecase.lazy.LazySingle;

/**
 * @author 陈梓平
 * @date 2017/11/3.
 */
public class Test {

    public static void main(String[] args){
        LazySingle instance = LazySingle.getInstance();
        LazySingle instanceStaticInside = LazySingle.getInstanceStaticInside();
    }
}
