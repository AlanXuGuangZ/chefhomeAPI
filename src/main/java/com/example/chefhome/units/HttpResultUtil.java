package com.example.chefhome.units;

import com.example.chefhome.main.HttpResult;


/**
 * created by tony on 2020/3/25 23:59
 */
public class HttpResultUtil {

    public static HttpResult success(Object object) {

        HttpResult httpResult = new HttpResult();
        httpResult.setCod(200);
        httpResult.setMsg("成功");
        httpResult.setData(object);
        return httpResult;
    }
    public static HttpResult success() {
        return success();
    }
    public static HttpResult error(Integer cod,String msg) {
        HttpResult httpResult = new HttpResult();
        httpResult.setCod(cod);
        httpResult.setMsg(msg);
        httpResult.setMsg(null);
        return httpResult;
    }

}
