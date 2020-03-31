package com.example.chefhome.controller;

import com.example.chefhome.main.HttpResult;
import com.example.chefhome.main.UserAddress;
import com.example.chefhome.repository.AddressRepository;
import com.example.chefhome.repository.UserAddressRepository;
import com.example.chefhome.repository.UserRepository;
import com.example.chefhome.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAddressController {

    @Autowired
    UserAddressRepository userAddressRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    private final static Logger logger = LoggerFactory.getLogger(UserAddressController.class);

//    // 查询
//    @GetMapping(value = "/userAddress")
//    public HttpResult<UserAddress> userAddressList() {
//        logger.info("获取用户地址数据");
//        try{
//            return HttpResultUtil.success(userAddressRepository.findAll());
//        }catch (Exception e){
//            return HttpResultUtil.error(400,"获取用户地址数据失敗： " + e.toString());
//        }
//    }

}
