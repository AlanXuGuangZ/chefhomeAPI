package com.example.chefhome.controller;

import com.example.chefhome.main.Food;
import com.example.chefhome.main.FoodType;
import com.example.chefhome.main.HttpResult;
import com.example.chefhome.main.Order;
import com.example.chefhome.repository.FoodRepository;
import com.example.chefhome.repository.FoodTypeRepository;
import com.example.chefhome.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodTypeController {

    @Autowired
    FoodTypeRepository foodTypeRepository;

    @Autowired
    FoodRepository foodRepository;

    private final static Logger logger = LoggerFactory.getLogger(FoodTypeController.class);

    // 查询
    @GetMapping(value = "/foodType")
    public HttpResult<FoodType> foodTypeList() {
        logger.info("获取菜品类型搜索菜品数据");
        try{
            return HttpResultUtil.success(foodTypeRepository.findAll());
        }catch (Exception e){
            return HttpResultUtil.error(400,"获取菜品类型搜索菜品数据失敗： " + e.toString());
        }
    }

    @GetMapping(value = "/foodType/{fid}")
    public HttpResult<FoodType> idFoodTypeList(@PathVariable("fid") Integer fid){
        logger.info("获取菜品类型id搜索菜品数据");
        try {
            return HttpResultUtil.success(foodTypeRepository.findOne(fid));
        } catch (Exception e){
            return HttpResultUtil.error(400,"获取菜品类型id搜索菜品数据失败: " + e.toString());
        }
    }

    //插入
    @PostMapping("/foodType/insert")
    public HttpResult<FoodType> insertFoodType(FoodType foodType){
        logger.info("插入菜品类型数据");
        try {
            FoodType save = foodRepository.save(foodType);
            return HttpResultUtil.success(save);
        } catch (Exception e){
            return HttpResultUtil.error(400,"插入菜品类型数据失败： " + e.toString());
        }
    }

    //更新
    @PostMapping("/foodType/update/{id}")
    public HttpResult<FoodType> updateOrder(@PathVariable("id") Integer id,FoodType foodTypeIn){
        logger.info("更新菜品类型数据");
        try {
            FoodType foodTypeOut = foodTypeRepository.getOne(id);
            BeanUtils.copyProperties(foodTypeIn, foodTypeOut, OrderController.getNullPropertyNames(foodTypeIn));
            return HttpResultUtil.success(foodTypeRepository.save(foodTypeOut));
        }catch (Exception e){
            return HttpResultUtil.error(400,"更新菜品类型数据失败: " + e.toString());
        }
    }

    //删除
    @PostMapping("/foodType/delete/{id}")
    public HttpResult<FoodType> deleteOrder(@PathVariable("id") Integer id){
        logger.info("删除菜品类型数据");
        try {
            foodTypeRepository.delete(id);
            return HttpResultUtil.success(200,"删除菜品类型数据成功");
        } catch (Exception e){
            return HttpResultUtil.error(400,"删除菜品类型数据失败 ：" + e.toString());
        }
    }

}
