package com.example.chefhome.main;

/**
 * created by tony on 2020/3/26 00:05
 */
public class HttpResult<T> {
    //错误码
    private Integer cod;
    //提示信息
    private String msg;
    //返回的内容
    private T data;

    public HttpResult() {

    }

    public Integer getCod() {
        return cod;
    }
    public void setCod(Integer cod) {
        this.cod = cod;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
