package com.eprex.store.controller;

import com.eprex.store.entity.Address;
import com.eprex.store.service.IAddressService;
import com.eprex.store.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @ClassName AddressController
 * @Description TODO
 * @Author mi
 * @Date 2/9/2022 下午5:32
 * @Version 1.0
 **/
@RequestMapping("addresses")
@RestController
public class AddressController extends BaseController{
    @Resource
    private IAddressService addressService;

    @RequestMapping("add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUserNameFromSession(session);
        addressService.addNewAddress(uid,username,address);
        return new JsonResult<>(OK,"添加新地址成功");
    }

}
