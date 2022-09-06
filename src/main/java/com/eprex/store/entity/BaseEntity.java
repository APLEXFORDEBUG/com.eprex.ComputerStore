package com.eprex.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName BaseEntity
 * @Description 基类表
 * @Author mi
 * @Date 29/8/2022 下午12:50
 * @Version 1.0
 **/
//作为实体类的基类
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
public class BaseEntity {

    private String createdUser;//创建用户
    private Date createdTime;//创建时间
    private String modifiedUser;//修改者
    private Date modifiedTime;//修改时间



}
