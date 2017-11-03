package com.chen.creationtype.factorymethod;

import com.chen.creationtype.factory.Car;

/**
 * @author 陈梓平
 * @date 2017/11/3.
 */
public class Test {
    public static void main(String[] args){
        FactoryMethod factoryMethod1 = new BenzFactory();
        factoryMethod1.create();
        FactoryMethod factoryMethod2 = new BMWFactory();
        factoryMethod1.create();
    }
}
