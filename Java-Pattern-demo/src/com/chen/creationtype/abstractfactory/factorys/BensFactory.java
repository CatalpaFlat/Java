package com.chen.creationtype.abstractfactory.factorys;

import com.chen.creationtype.abstractfactory.AbstractFactorys;
import com.chen.creationtype.abstractfactory.entity.AirCondition;
import com.chen.creationtype.abstractfactory.entity.Engine;

/**
 * @author 陈梓平
 * @date 2017/11/3.
 */
public class BensFactory implements AbstractFactorys {
    @Override
    public Engine createEngine() {
        return new Engine.EngineA();
    }

    @Override
    public AirCondition createAirCondition() {
        return new AirCondition.AirConditionA();
    }
}
