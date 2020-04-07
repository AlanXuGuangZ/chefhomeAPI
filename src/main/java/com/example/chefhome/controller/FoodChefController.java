package com.example.chefhome.controller;

import com.example.chefhome.main.FoodChef;
import com.example.chefhome.main.HttpResult;
import com.example.chefhome.repository.FoodChefRepository;
import com.example.chefhome.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodChefController {

    @Autowired
    FoodChefRepository foodChefRepository;

    private final static Logger logger = LoggerFactory.getLogger(FoodChefController.class);

    // 查询
    @GetMapping(value = "/foodChef")
    public HttpResult<FoodChef> foodChefList() {
        logger.info("获取菜品厨师对应数据");
        try{
            return HttpResultUtil.success(foodChefRepository.findAll());
        }catch (Exception e){
            return HttpResultUtil.error(400,"获取菜品厨师对应数据失敗： " + e.toString());
        }
    }

    @GetMapping(value = "/foodChef/chef/{cid}")
    public HttpResult<FoodChef> cidFoodChefList(@PathVariable("cid") Integer cid) {
        logger.info("获取菜品厨师cid对应数据");
        try{
            return HttpResultUtil.success(foodChefRepository.findByCid(cid));
        }catch (Exception e){
            return HttpResultUtil.error(400,"获取菜品厨师cid对应数据： " + e.toString());
        }
    }

    @GetMapping(value = "/foodChef/food/{fid}")
    public HttpResult<FoodChef> fidFoodChefList(@PathVariable("fid") Integer fid) {
        logger.info("获取菜品厨师fid对应数据");
        try{
            return HttpResultUtil.success(foodChefRepository.findByFid(fid));
        }catch (Exception e){
            return HttpResultUtil.error(400,"获取菜品厨师fid对应数据： " + e.toString());
        }
    }

    @GetMapping(value = "/foodChef/{id}")
    public HttpResult<FoodChef> idFoodChefList(@PathVariable("id") Integer id) {
        logger.info("获取菜品厨师id对应数据");
        try{
            return HttpResultUtil.success(foodChefRepository.findOne(id));
        }catch (Exception e){
            return HttpResultUtil.error(400,"获取菜品厨师id对应数据： " + e.toString());
        }
    }
}
