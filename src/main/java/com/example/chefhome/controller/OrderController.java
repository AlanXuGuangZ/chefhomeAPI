package com.example.chefhome.controller;

import com.example.chefhome.main.HttpResult;
import com.example.chefhome.main.Order;
import com.example.chefhome.repository.OrderRepository;
import com.example.chefhome.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    private final static Logger logger = LoggerFactory.getLogger(OrderController.class);

    // 查询
    @GetMapping("/order")
    public HttpResult<Order> getOrder(){
        logger.info("搜索订单数据");
        try {
            return HttpResultUtil.success(orderRepository.findAll());
        } catch (Exception e){
            return HttpResultUtil.error(400,"搜索订单数据失败");
        }
    }

    // 查询
    @GetMapping("/order/{id}")
    public HttpResult<Order> getOrder(@PathVariable("id") Integer id){
        logger.info("根据id搜索订单数据");
        try {
            return HttpResultUtil.success(orderRepository.findOne(id));
        } catch (Exception e){
            return HttpResultUtil.error(400,"根据id搜索订单数据失败： " + e.toString());
        }
    }
    @GetMapping("/order/uid/{uid}")
    public HttpResult<Order> getUidOrder(@PathVariable("uid") String uid) {
        logger.info("根据uid搜索订单数据");
        try {
            return HttpResultUtil.success(orderRepository.findByuid(uid));
        } catch (Exception e){
            return HttpResultUtil.error(400,"根据uid搜索订单数据失败： " + e.toString());
        }
    }

    //插入
    @PostMapping("/order/insert")
    public HttpResult<Order> insertOrder(Order order){
        logger.info("插入订单数据");
        try {
            Order save = orderRepository.save(order);
            return HttpResultUtil.success(save);
        } catch (Exception e){
            return HttpResultUtil.error(400,"插入订单数据失败： " + e.toString());

        }
    }

    //更新
    @PostMapping("/order/update/{id}")
    public HttpResult<Order> updateOrder(@PathVariable("id") Integer id, Order orderIn){
        logger.info("更新订单数据");
        try {
            Order orderOut = orderRepository.getOne(id);
            BeanUtils.copyProperties(orderIn, orderOut, getNullPropertyNames(orderIn));
            return HttpResultUtil.success(orderRepository.save(orderOut));
        } catch (Exception e){
            return HttpResultUtil.error(400,"更新订单数据失败: " + e.toString());
        }
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    //删除
    @PostMapping("/order/delete/{id}")
    public HttpResult<Order> deleteOrder(@PathVariable("id") Integer id){
        logger.info("删除订单数据");
        try {
            orderRepository.delete(id);
            return HttpResultUtil.success(200,"删除订单数据成功");
        } catch (Exception e){
            return HttpResultUtil.error(400,"删除订单数据失败 ：" + e.toString());
        }
    }
}
