package com.chen.creationtype.singlecase.Hungry;

/**
 * @author 陈梓平
 * @date 2017/11/3.
 */
public class HungrySingle {
    private HungrySingle(){}
    /**线程安全*/
    private static final HungrySingle HungrySingle = new HungrySingle();

    public static HungrySingle getInstaance(){
        return HungrySingle;
    }

}
