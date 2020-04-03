package com.example.chefhome.handle;

import com.example.chefhome.exception.UserException;
import com.example.chefhome.main.HttpResult;
import com.example.chefhome.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HttpResult userHandle(Exception e) {

        if (e instanceof UserException) {
            UserException userException = (UserException)e;
            return HttpResultUtil.error(userException.getCod(),userException.getMessage());
        }else {
            return HttpResultUtil.error(-1,"未知异常");
        }
    }

}
