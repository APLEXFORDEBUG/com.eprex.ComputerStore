package com.eprex.store;

import com.eprex.store.entity.User;
import com.eprex.store.mapper.UserMapper;
import com.eprex.store.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @ClassName UserTest
 * @Description TODO
 * @Author mi
 * @Date 29/8/2022 下午2:33
 * @Version 1.0
 **/
@SpringBootTest
public class UserTest {
    @Resource
    private UserMapper userMapper;  //底层使用动态代理 实现 接口注入
    @Autowired
    private IUserService userService;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("eprex01");
        user.setPassword("eprex01");
        Integer row = userMapper.insert(user);
        System.out.println(row);
    }

    @Test
    public void findUserById(){
        User user = userMapper.findByUserName("eprex");
        System.out.println(user);
    }
    @Test
    public void loginTest(){
        User user = userService.login("eprex", "eprex");
        System.out.println(user);
    }
}
