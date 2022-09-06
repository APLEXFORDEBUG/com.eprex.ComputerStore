package com.eprex.store.service;

import com.eprex.store.entity.User;
import com.eprex.store.mapper.UserMapper;
import com.eprex.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @ClassName UserServiceTest
 * @Description TODO
 * @Author mi
 * @Date 29/8/2022 下午3:19
 * @Version 1.0
 **/
@SpringBootTest
public class UserServiceTest {
    @Autowired
    IUserService userService;
    @Autowired
    UserMapper userMapper;


    @Test
    public void Reg(){
        try {
            User user = new User();
            user.setUsername("root2");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("--------successful-------");
        } catch (ServiceException e) {
            //获取类的对象 在获取类的名称
            System.out.println(e.getClass().getSimpleName());
            //获取异常信息
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void updatePasswordByUid(){
        //
        System.out.println(new Date());
        //userService.changePassword(9,"fuck","fuckfuck","fuck");
        Integer integer = userMapper.updatePasswordByUid(12,"eprex01","root",new Date("Sat Sep 03 10:38:13 CST 2022"));
        System.out.println(integer);
    }

    @Test
    public void findByUid(){
        User uid = userMapper.findByUid(2);
        System.out.println(uid);
    }

    @Test
    public void changeInfoByUid(){
        User result = new User();
        result.setPhone("772344237");
        result.setEmail("77777@qq.com");
        result.setGender(0);
        result.setUid(12);
        //Integer rows = userMapper.updateInfo(result);
        //Integer rows = userMapper.updateInfoByUid(result);
        userService.changeInfo(12, "root", result);
        System.out.println();
    }

    @Test
    public void updateAvatar(){

        //Integer integer = userMapper.updateAvatarByUid(11,"/abc/1.png","root",new Date());
        userService.changeAvatar(12,"/abv","root");
        System.out.println();
    }

    @Test
    public void testOne(){
        System.out.println("file:"+System.getProperty("user.dir")+"/src/main/resources/static/upload/");
    }
}
