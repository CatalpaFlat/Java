package com.chen.creationtype.simplefactory;

import com.chen.creationtype.factory.BMW;
import com.chen.creationtype.factory.Benz;
import com.chen.creationtype.factory.Car;

/**
 * @author 陈梓平
 * @date 2017/11/3.
 */
public class SimpleFactorys {

    enum CAR_TYPE{
        Benz,BMW
    }

    public static Car createCar(CAR_TYPE type){
        switch (type){
            case Benz:
                return new Benz();
            case BMW:
                return new BMW();
            default:
                break;
        }
        return null;
    }

}
