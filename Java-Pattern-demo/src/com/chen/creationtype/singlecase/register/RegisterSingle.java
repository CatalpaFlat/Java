package com.chen.creationtype.singlecase.register;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈梓平
 * @date 2017/11/3.
 */
public class RegisterSingle {
    private static Map<String,RegisterSingle> map = new HashMap<>();

    static{
        RegisterSingle registerSingle = new RegisterSingle();
        map.put(registerSingle.getClass().getName(),registerSingle);
    }

    private RegisterSingle(){}

    public static RegisterSingle getInstance(String name){
        if (name == null){
            name = RegisterSingle.class.getName();
        }
        if (map.get(name) == null){
            try {
                map.put(name,(RegisterSingle)Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return  map.get(name);
    }


}
