package com.example.chefhome.exception;

import com.example.chefhome.enums.ResultEnum;

/**
 * created by tony on 2020/4/4 00:42
 */
public class UserException extends RuntimeException{

    private Integer cod;
    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.cod = resultEnum.getCode();
    }
    public Integer getCod() {return cod;}
    public void setCod(Integer cod) {this.cod = cod;}
}
