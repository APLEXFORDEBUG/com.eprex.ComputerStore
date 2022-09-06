package com.eprex.store.service;

import com.eprex.store.entity.Address;
import org.springframework.stereotype.Service;

/**
 * @ClassName IAddressService
 * @Description TODO
 * @Author mi
 * @Date 2/9/2022 下午4:58
 * @Version 1.0
 **/
@Service
public interface IAddressService {

    //添加地址
    void addNewAddress(Integer uid,String username,Address address);
}
