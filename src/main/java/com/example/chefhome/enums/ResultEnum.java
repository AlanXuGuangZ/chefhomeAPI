package com.example.chefhome.enums;

import com.sun.net.httpserver.Authenticator;

/**
 * created by tony on 2020/4/4 00:45
 */
public enum  ResultEnum {
    UNKOWN_EERO(-2,"未知错误");
    private Integer code;
    private String msg;
    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {return code;}
    public String getMsg() {return msg;}
}
