package com.eprex.store.service.impl;

import com.eprex.store.entity.Address;
import com.eprex.store.mapper.AddressMapper;
import com.eprex.store.service.IAddressService;
import com.eprex.store.service.ex.AddressCountLimitException;
import com.eprex.store.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassName AddressServiceImpl
 * @Description TODO
 * @Author mi
 * @Date 2/9/2022 下午5:02
 * @Version 1.0
 **/

@Service
public class AddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;

    @Value("${user.address.max-count}")
    private Integer maxCount;
    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        Integer count = addressMapper.countByUid(uid);
        if (count>maxCount){
            throw new AddressCountLimitException("地址数目超出20限制，请删除无用的地址");
        }
            address.setUid(uid);
            Integer isDefault = count==0?1:0;
            address.setIsDefault(isDefault);//0条时 插入第一条数据为 设置默认地址
            address.setCreatedUser(username);
            address.setCreatedTime(new Date());
            address.setModifiedUser(username);
            address.setModifiedTime(new Date());
        Integer rows = addressMapper.insertAddress(address);
        if(rows!=1){
            throw new InsertException("插入地址异常");
        }


    }
}
