package com.chen.creationtype.factory;

import java.util.logging.Logger;

/**
 * @author 陈梓平
 * @date 2017/11/3.
 */
public class Benz extends Car {
    private static final Logger log =Logger.getLogger(Benz.class.getName());
    public Benz(){
        log.info("it is benz....");
    }
}
