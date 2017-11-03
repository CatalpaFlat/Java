package com.chen.creationtype.abstractfactory;

import com.chen.creationtype.abstractfactory.entity.AirCondition;
import com.chen.creationtype.abstractfactory.entity.Engine;

/**
 * @author 陈梓平
 * @date 2017/11/3.
 */
public interface AbstractFactorys {
    Engine createEngine();
    AirCondition createAirCondition();
}
