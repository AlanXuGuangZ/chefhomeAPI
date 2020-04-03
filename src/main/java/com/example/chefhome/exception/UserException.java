package com.example.chefhome.exception;

import com.example.chefhome.enums.ResultEnum;


public class UserException extends RuntimeException{

    private Integer cod;
    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.cod = resultEnum.getCode();
    }
    public Integer getCod() {return cod;}
    public void setCod(Integer cod) {this.cod = cod;}
}
