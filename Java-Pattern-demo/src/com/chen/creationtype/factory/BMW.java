package com.chen.creationtype.factory;

import java.util.logging.Logger;

/**
 * @author 陈梓平
 * @date 2017/11/3.
 */
public class BMW extends Car {
    private static final Logger log =Logger.getLogger(BMW.class.getName());
    public BMW(){
        log.info("it is BMW....");
    }
}
