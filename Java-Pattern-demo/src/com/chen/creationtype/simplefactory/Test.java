package com.chen.creationtype.simplefactory;

/**
 * @author 陈梓平
 * @date 2017/11/3.
 */
public class Test {

    public static void main(String[] args){
        SimpleFactorys.createCar(SimpleFactorys.CAR_TYPE.Benz);
        SimpleFactorys.createCar(SimpleFactorys.CAR_TYPE.BMW);
    }

}
