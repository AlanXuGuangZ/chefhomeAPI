package com.example.chefhome.controller;

import com.example.chefhome.main.HttpResult;
import com.example.chefhome.main.UserAddress;
import com.example.chefhome.main.UserOrder;
import com.example.chefhome.repository.OrderRepository;
import com.example.chefhome.repository.UserOrderRepository;
import com.example.chefhome.repository.UserRepository;
import com.example.chefhome.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserOrderController {

    @Autowired
    UserOrderRepository userOrderRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    private final static Logger logger = LoggerFactory.getLogger(UserOrderController.class);

//    // 查询
//    @GetMapping(value = "/userOrder")
//    public HttpResult<UserOrder> userOrderList() {
//        logger.info("获取用户订单数据");
//        try{
//            return HttpResultUtil.success(userOrderRepository.findAll());
//        }catch (Exception e){
//            return HttpResultUtil.error(400,"获取用户订单数据失敗： " + e.toString());
//        }
//    }

}
