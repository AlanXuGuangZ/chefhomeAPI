package com.example.chefhome.service;

import com.example.chefhome.main.HttpResult;
import com.example.chefhome.repository.UserRepository;
import com.example.chefhome.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by tony on 2020/4/2 23:46
 */
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);
    public HttpResult UserOnlyOnePhone(String phone) {

        logger.info("phone is :" + phone);
        if (phone.equals(userRepository.findByPhoneNum(phone).getPhonenum())) {
            return HttpResultUtil.error(1,"已经注册");
        }else {
           return HttpResultUtil.success(userRepository.findByPhoneNum(phone));
        }
    }


}
