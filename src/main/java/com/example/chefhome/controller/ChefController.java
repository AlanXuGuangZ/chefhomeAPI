package com.example.chefhome.controller;


import com.example.chefhome.main.Chef;
import com.example.chefhome.main.HttpResult;
import com.example.chefhome.repository.ChefRepository;
import com.example.chefhome.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 厨师接口
 */
@RestController
public class ChefController {
    @Autowired
    ChefRepository chefRepository;

    private final static Logger logger = LoggerFactory.getLogger(ChefController.class);

    // 查询
    @GetMapping(value = "/chef")
    public HttpResult<Chef> chefList() {
        logger.info("根据厨师数据");
        try {
            return HttpResultUtil.success(chefRepository.findAll());
        } catch (Exception e){
            return HttpResultUtil.error(400,"搜索厨师数据失败： " + e.toString());
        }
    }

    @GetMapping(value = "/chef/{cid}")
    public HttpResult<Chef> idChefList(@PathVariable("cid") Integer cid) {
        logger.info("获取厨师id数据");
        try {
            return HttpResultUtil.success(chefRepository.findOne(cid));
        } catch (Exception e){
            return HttpResultUtil.error(400,"获取厨师id数据失败： " + e.toString());
        }
    }

    //更新
    @PostMapping("/chef/update/{id}")
    public HttpResult<Chef> updateChef(@PathVariable("id") Integer id, Chef chefIn){
        logger.info("更新厨师数据");
        try {
            Chef chefOut = chefRepository.getOne(id);
            BeanUtils.copyProperties(chefIn, chefOut, OrderController.getNullPropertyNames(chefIn));
            return HttpResultUtil.success(chefRepository.save(chefOut));
        } catch (Exception e){
            return HttpResultUtil.error(400,"更新厨师数据失败: " + e.toString());
        }
    }
}
