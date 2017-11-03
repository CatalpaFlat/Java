package com.chen.creationtype.abstractfactory.entity;

import com.chen.creationtype.factory.Benz;

import java.util.logging.Logger;

/**
 * @author 陈梓平
 * @date 2017/11/3.
 */
public interface Engine {
      Logger log =Logger.getLogger(Engine.class.getName());

    class EngineA implements  Engine{
        public EngineA(){
            log.info("it is EngineA...");
        }
    }
     class EngineB implements  Engine{
        public EngineB(){
            log.info("it is EngineB...");
        }
    }
}
