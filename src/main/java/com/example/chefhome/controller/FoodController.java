package com.example.chefhome.controller;

import com.example.chefhome.main.Chef;
import com.example.chefhome.main.Food;
import com.example.chefhome.main.FoodType;
import com.example.chefhome.main.HttpResult;
import com.example.chefhome.repository.FoodRepository;
import com.example.chefhome.repository.FoodTypeRepository;
import com.example.chefhome.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜品接口
 * */
@RestController
public class FoodController {

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    FoodTypeRepository foodTypeRepository;

    private final static Logger logger = LoggerFactory.getLogger(FoodController.class);

    /**
     * 查询所有菜品接口
     */
    @GetMapping(value = "/food")
    public HttpResult<Food> foodList() {
        logger.info("获取菜品数据");
        return HttpResultUtil.success(foodRepository.findAll());
    }

    @GetMapping(value = "/food/{tid}")
    public HttpResult<Food> foodFromTypeList(@PathVariable("tid") Integer tid){
        return HttpResultUtil.success(foodRepository.findOne(tid));
    }


}