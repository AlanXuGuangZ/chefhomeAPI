package com.example.chefhome.main;


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
