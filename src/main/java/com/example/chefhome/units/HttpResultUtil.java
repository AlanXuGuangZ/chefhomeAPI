package com.example.chefhome.units;

import com.example.chefhome.main.HttpResult;


public class HttpResultUtil {

    public static HttpResult success(Object object) {

        HttpResult httpResult = new HttpResult();
        httpResult.setCod(200);
        httpResult.setMsg("成功");
        httpResult.setData(object);
        return httpResult;
    }
    public static HttpResult success(Integer cod,String msg) {
        HttpResult httpResult = new HttpResult();
        httpResult.setCod(cod);
        httpResult.setMsg(msg);
        return httpResult;
    }
    public static HttpResult error(Integer cod,String msg) {
        HttpResult httpResult = new HttpResult();
        httpResult.setCod(cod);
        httpResult.setMsg(msg);
        return httpResult;
    }

    public static HttpResult error(Integer cod,String msg,Object object) {
        HttpResult httpResult = new HttpResult();
        httpResult.setCod(cod);
        httpResult.setMsg(msg);
        httpResult.setData(object);
        return httpResult;
    }

}
