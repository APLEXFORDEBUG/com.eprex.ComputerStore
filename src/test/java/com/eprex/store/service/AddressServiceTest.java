package com.eprex.store.service;

import com.eprex.store.entity.Address;
import com.eprex.store.entity.District;
import com.eprex.store.mapper.AddressMapper;
import com.eprex.store.mapper.DistrictMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AddressServiceTest
 * @Description 地址业务测试
 * @Author eprex
 * @Date 29/8/2022 下午3:19
 * @Version 1.0
 **/
@SpringBootTest
public class AddressServiceTest {
    @Resource
    AddressMapper addressMapper;
    @Resource
    IAddressService addressService;

    @Resource
    DistrictMapper districtMapper;

    @Test
    public void insertAddress(){

        /*Address address =new Address();
        address.setUid(12);
        address.setPhone("1896662werew7");
        address.setName("epdfdsex");
        Integer integer = addressMapper.insertAddress(address);
        System.out.println(integer);*/
        Integer integer1 = addressMapper.countByUid(12);
        System.out.println(integer1);
    }

    @Test
    public void insertAddressService(){

        Address address =new Address();
        address.setUid(12);
        address.setPhone("66666666");
        address.setName("root");
        addressService.addNewAddress(12,"root",address);

    }

    @Test
    public void findByParent(){

        List<District> districts = districtMapper.findByParent("110100");
        districts.forEach(System.out::println);
        /*District code = districtMapper.findByCode("110101");
        System.out.println(code);*/
    }


}
