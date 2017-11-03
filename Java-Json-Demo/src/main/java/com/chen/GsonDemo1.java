package com.chen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author 陈梓平
 * @date 2017/11/2.
 */
public class GsonDemo1 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        gson.toJson("Hello", System.out);
        gson.toJson(123, System.out);
    }
}
