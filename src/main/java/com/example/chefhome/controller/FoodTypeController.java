package com.example.chefhome.controller;

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

@RestController
public class FoodTypeController {

    @Autowired
    FoodTypeRepository foodTypeRepository;

    @Autowired
    FoodRepository foodRepository;

    private final static Logger logger = LoggerFactory.getLogger(FoodTypeRepository.class);

    /**
     * 查询所有菜品类型接口
     */
    @GetMapping(value = "/foodType")
    public HttpResult<FoodTypeController> foodTypeList() {

        logger.info("获取菜品类型数据");

        return HttpResultUtil.success(foodTypeRepository.findAll());
    }

    @GetMapping(value = "/foodType/{fid}")
    public HttpResult<Food> foodFromTypeList(@PathVariable("fid") Integer fid){
        return HttpResultUtil.success(foodTypeRepository.findOne(fid));
    }


}
