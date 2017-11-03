package com.chen.creationtype.abstractfactory;

import com.chen.creationtype.abstractfactory.factorys.BensFactory;

/**
 * @author 陈梓平
 * @date 2017/11/3.
 */
public class Test {
    public static void main(String[] args){
        AbstractFactorys bensFactory = new BensFactory();
        bensFactory.createEngine();
        bensFactory.createAirCondition();
    }
}
