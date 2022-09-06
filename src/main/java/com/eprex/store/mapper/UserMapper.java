package com.eprex.store.mapper;

import com.eprex.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @ClassName UserMapper
 * @Description 用户接口
 * @Author mi
 * @Date 29/8/2022 下午1:10
 * @Version 1.0
 **/
//@Mapper
public interface UserMapper {
    /*
    * @Author eprex
    * @Date 下午1:15 29/8/2022
    * @Description 插入用户的数据 返回受影响的行数
    * @MethodName insert
    * @Param [user]
    * @return 返回受影响的行数 增删改 根据返回值来判断是否执行成功
    **/
    Integer insert(User user);//插入用户

    User findByUserName(@Param("username") String username);//根据用户名称 查询用户

    //根据uid来更新密码  返回影响行数
    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);

    //根据用户的uid 查询 数据 返回对象 否则为null
    User findByUid(Integer uid);

    //更新用户信息  电话 邮件 性别
    Integer updateInfoByUid(User user);

    Integer updateInfo(User user);
    //@Param 提供占位符传值
    //更新用户头像
    Integer updateAvatarByUid(Integer uid,String avatar,String modifiedUser, Date modifiedTime);

}
