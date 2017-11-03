package com.chen.creationtype.factorymethod;

import com.chen.creationtype.factory.Benz;

/**
 * @author 陈梓平
 * @date 2017/11/3.
 */
public class BenzFactory implements  FactoryMethod {
    @Override
    public Benz create() {
        return new Benz();
    }
}
