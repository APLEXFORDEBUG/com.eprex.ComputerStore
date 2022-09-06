package com.eprex.store.service;

import com.eprex.store.entity.User;
import org.springframework.stereotype.Service;

/**
 * @ClassName IUserService
 * @Description TODO
 * @Author eprex
 * @Date 29/8/2022 下午3:03
 * @Version 1.0
 **/
//用户模块业务层接口
@Service
public interface IUserService {
    void reg(User user);  //注册

    //登录
    User login(String username,String password);//返回User对象  用于登录成功后 主页显示一些信息

    void changePassword(Integer uid,String username,String oldPassword,String newPassword);

    //Uid 获取User 对象
    User getByUid(Integer uid);

    //更新用户对象
    void changeInfo(Integer uid,String username,User user);

    /**
     * 修改用户的头像
     * @param uid uid
     * @param avatar 头像图片路径
     * @param username 用户名
     */
    //更新头像
    void changeAvatar(Integer uid,String avatar,String username);

}
