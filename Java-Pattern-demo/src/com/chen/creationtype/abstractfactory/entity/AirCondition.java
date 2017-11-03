package com.chen.creationtype.abstractfactory.entity;

import java.util.logging.Logger;

/**
 * @author 陈梓平
 * @date 2017/11/3.
 */
public interface AirCondition {

    Logger log =Logger.getLogger(AirCondition.class.getName());

    class AirConditionA implements AirCondition{
        public AirConditionA(){
            log.info("it is AirConditionA...");
        }
    }
    class AirConditionB implements AirCondition{
        public AirConditionB(){
            log.info("it is AirConditionB...");
        }
    }
}
