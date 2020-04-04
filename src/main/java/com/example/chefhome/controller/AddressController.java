package com.example.chefhome.controller;

import com.example.chefhome.main.Address;
import com.example.chefhome.main.HttpResult;
import com.example.chefhome.repository.AddressRepository;
import com.example.chefhome.units.HttpResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.chefhome.controller.OrderController.getNullPropertyNames;

@RestController
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    private final static Logger logger = LoggerFactory.getLogger(AddressController.class);

    // 查询
    @GetMapping(value = "/address")
    public HttpResult<Address> addressList() {
        logger.info("获取地址数据");
        try{
            return HttpResultUtil.success(addressRepository.findAll());
        }catch (Exception e){
            return HttpResultUtil.error(400,"获取地址数据失敗： " + e.toString());
        }
    }
    //通过uid查询
    @GetMapping(value = "/address/uid/{uid}")
    public HttpResult<Address> uidAddressList(@PathVariable("uid") String uid) {
        logger.info("通过uid查询地址列表");
        try {
            return HttpResultUtil.success(addressRepository.findByuid(uid));
        }catch (Exception e) {
            return HttpResultUtil.error(400,"查询失败：" + e.toString());
        }
    }

    @GetMapping(value = "/address/{aid}")
    public HttpResult<Address> idAddressList(@PathVariable("aid") Integer aid){
        logger.info("获取地址id数据");
        try {
            return HttpResultUtil.success(addressRepository.findOne(aid));
        } catch (Exception e){
            return HttpResultUtil.error(400,"获取地址id数据失败: " + e.toString());
        }
    }

    //插入
    @PostMapping("/address/insert")
    public HttpResult<Address> insertAddress(Address address){
        logger.info("插入地址数据");
        try {
            Address save = addressRepository.save(address);
            return HttpResultUtil.success(save);
        } catch (Exception e){
            return HttpResultUtil.error(400,"插入地址数据失败： " + e.toString());

        }
    }

    //更新
    @PostMapping("/address/update/{id}")
    public HttpResult<Address> updateAddress(@PathVariable("id") Integer id, Address addressIn){
        logger.info("更新地址数据");
        try {
            Address addressOut = addressRepository.getOne(id);
            BeanUtils.copyProperties(addressIn, addressOut, getNullPropertyNames(addressIn));
            return HttpResultUtil.success(addressRepository.save(addressOut));
        } catch (Exception e){
            return HttpResultUtil.error(400,"更新地址数据失败: " + e.toString());
        }
    }

    //删除
    @PostMapping("/address/delete/{id}")
    public HttpResult<Address> deleteAddress(@PathVariable("id") Integer id){
        logger.info("删除地址数据");
        try {
            addressRepository.delete(id);
            return HttpResultUtil.success(200,"删除地址数据成功");
        } catch (Exception e){
            return HttpResultUtil.error(400,"删除地址数据失败 ：" + e.toString());
        }
    }
}
