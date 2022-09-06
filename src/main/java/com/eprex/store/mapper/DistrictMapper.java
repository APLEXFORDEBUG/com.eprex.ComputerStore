package com.eprex.store.mapper;

import com.eprex.store.entity.District;

import java.util.List;

/**
 * @ClassName DistrictMapper
 * @Description 区域操作
 * @Author mi
 * @Date 29/8/2022 下午1:10
 * @Version 1.0
 **/
//@Mapper
public interface DistrictMapper {

    //查询父代号下的所有区域
    List<District> findByParent(String parent);

    District findByCode(String code);

}
