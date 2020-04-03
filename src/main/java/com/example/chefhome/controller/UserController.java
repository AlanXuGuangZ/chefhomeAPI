package com.example.chefhome.controller;

import com.example.chefhome.main.HttpResult;
import com.example.chefhome.main.User;
import com.example.chefhome.repository.AddressRepository;
import com.example.chefhome.repository.UserRepository;
import com.example.chefhome.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    // 查询
    @GetMapping(value = "/user")
    public HttpResult<User> userList() {
        logger.info("获取用户搜索地址,订单数据");
        try{
            return HttpResultUtil.success(userRepository.findAll());
        }catch (Exception e){
            return HttpResultUtil.error(400,"获取用户搜索地址,订单数据失敗： " + e.toString());
        }
    }

    @GetMapping(value = "/user/{uid}")
    public HttpResult<User> idUserList(@PathVariable("uid") Integer uid){
        logger.info("获取用户id地址数据");
        try {
            return HttpResultUtil.success(userRepository.findOne(uid));
        } catch (Exception e){
            return HttpResultUtil.error(400,"获取用户id地址数据失败: " + e.toString());
        }
    }

    @GetMapping(value = "/user/phone/{phone}")
    public HttpResult userListByPhoneNum(@PathVariable("phone") String phoneNum) {
        if (phoneNum.equals(userRepository.findByphonenum(phoneNum).getPhonenum())) {
            return HttpResultUtil.error(1,"已注册",userRepository.findByphonenum(phoneNum).getUid());
        }else {
            return HttpResultUtil.success(2,"未注册");
        }
    }

    //插入
    @PostMapping("/user/insert")
    public HttpResult<User> insertUser(User user){
        logger.info("插入用户数据");
        try {
            User save = userRepository.save(user);
            return HttpResultUtil.success(save);
        } catch (Exception e){
            return HttpResultUtil.error(400,"插入用户数据失败： " + e.toString());

        }
    }

}
