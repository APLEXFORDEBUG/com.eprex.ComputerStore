package com.eprex.store.service.impl;

import com.eprex.store.entity.User;
import com.eprex.store.mapper.UserMapper;
import com.eprex.store.service.IUserService;
import com.eprex.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author mi
 * @Date 29/8/2022 下午3:05
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {

        //先检测用户名是否被注册
        User result = userMapper.findByUserName(user.getUsername());
        if(result != null){
            throw new UserNameDuplicatedException("用户名已经存在");
        }
        //md5 密码加密
        String oldPassword = user.getPassword();
        //获取 盐值 （随机生成一个盐值）
        String salt = UUID.randomUUID().toString().toUpperCase();
        //将盐值和密码进行加密处理
        String md5Password = getMD5Password(oldPassword, salt);
        //将加密之后的密码补全到User中
        user.setPassword(md5Password);
        user.setSalt(salt);
        user.setIsDelete(0);  //设置0 是指的是未被删除  1表示已经注销 删除
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        user.setCreatedTime(new Date());
        user.setModifiedTime(new Date());


            Integer row = userMapper.insert(user);
            if(row != 1){
                throw new InsertException("插入过程中产生未知异常");
            }


    }

    @Override
    public User login(String username, String password) {
        if(username == null||username == ""||password == null||password == ""){
            throw new ServiceException("用户名或者密码为空");
        }
        User result = userMapper.findByUserName(username);
        if(result == null){
            throw new UserNameNotFoundException("用户不存在");
        }
        String oldPassword = password;
        String salt = result.getSalt();
        //将盐值和密码进行加密处理
        String md5Password = getMD5Password(oldPassword, salt);
        if(!md5Password.equals(result.getPassword())){
            throw new PasswordNotMatchException("密码不对");
        }
        if(result.getIsDelete() == 1){
            throw new UserNameNotFoundException("用户数据不存在");
        }

        // 以下代码为了提升性能，减少数据的传输，提高响应
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setPassword(result.getPassword());
        user.setAvatar(result.getAvatar());

        return user;
    }
    //修改密码


    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if(result == null && result.getIsDelete()==1){
            throw new UserNameNotFoundException("用户数据不存在");
        }
        //原始密码和数据库中密码比较
        String md5Password = getMD5Password(oldPassword, result.getSalt());
        if(!md5Password.equals(result.getPassword())){
            throw new PasswordNotMatchException("密码错误");
        }
        String newMd5Password = getMD5Password(newPassword, result.getSalt());
        Integer row = userMapper.updatePasswordByUid(uid, newMd5Password, result.getModifiedUser(), new Date());
        if(row!=1){
            throw new UpdateException("更新异常");
        }
    }

    //定义一个md5算法加密方法
    private String getMD5Password(String password,String salt){

        //md5加密算法
        for (int i = 0; i < 3; i++) {
            //三次加密
           password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }

        return password;
    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if(result==null||result.getIsDelete()==1){
            throw new UserNameNotFoundException("用户不存在");
        }

        //设置一个中间过渡，减少数据的传输
        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    //phone email gender 会被自动封装在user中
    @Override
    public void changeInfo(Integer uid,String username,User user) {
        User result = userMapper.findByUid(uid);
        if(result==null||result.getIsDelete()==1){
            throw new UserNameNotFoundException("用户不存在");
        }
        user.setUsername(username);
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());

        Integer row = userMapper.updateInfoByUid(user);
        /*if(row!=1){
            throw new UpdateException("更新信息时异常");
        }*/

    }

    @Override
    public void changeAvatar(Integer uid, String avatar, String username) {
        User result = userMapper.findByUid(uid);
        if(result==null||result.getIsDelete()==1){
            throw new UserNameNotFoundException("用户不存在");
        }
        Integer row = userMapper.updateAvatarByUid(uid,  avatar,username,new Date());
        /*if(row != 1){
            throw new UpdateException("更新头像异常");
        }*/

    }


}
