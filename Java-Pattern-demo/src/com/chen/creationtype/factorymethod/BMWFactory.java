package com.chen.creationtype.factorymethod;

import com.chen.creationtype.factory.BMW;

/**
 * @author 陈梓平
 * @date 2017/11/3.
 */
public class BMWFactory implements FactoryMethod {
    @Override
    public BMW create() {
        return new BMW();
    }
}
