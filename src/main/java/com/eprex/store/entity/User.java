package com.eprex.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description 用户实体类 springboot 约定大于配置
 * @Author mi
 * @Date 29/8/2022 下午12:55
 * @Version 1.0
 **/
@Data()
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User extends BaseEntity implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String salt;//盐值
    private String phone;
    private String email;
    private Integer gender;
    private String avatar; //头像
    private Integer isDelete;// 是否被删除



}
