package com.eprex.store.mapper;

import com.eprex.store.entity.Address;

/**
 * @ClassName AddressMapper
 * @Description 地址操作
 * @Author mi
 * @Date 2/9/2022 下午4:20
 * @Version 1.0
 **/
public interface AddressMapper {

    //插入收获地址数据
    Integer insertAddress(Address address);

    //统计行数和总记录
    Integer countByUid(Integer uid);

}
