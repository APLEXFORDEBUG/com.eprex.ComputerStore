package com.eprex.store.controller;

import com.eprex.store.service.ex.*;
import com.eprex.store.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Author mi
 * @Date 29/8/2022 下午9:42
 * @Version 1.0
 **/
//表示控制层的基类
@Controller
public class BaseController {
    //操作成功的状态码
    public static final int OK =200;
    //public static final int FALSE =400;

    // 请求处理方法，这个方法的返回值就是需要传递给前端的数据
    //自动将异常的对象传递给方法的参数列表上
    //当项目中出现了异常 ，会被统一拦截到此方法中，这个方法此时就冲当是请求处理方法 ，方法的返回值直接给到前端 传到error xrh中
    //可以将异常放入参数列表上{ServiceException.class,FileUploadException.class} 作为数组形式
    @ExceptionHandler({ServiceException.class,FileUploadException.class})  //用于统一处理抛出的异常 传入异常实例的类型
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if(e instanceof UserNameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户已经被占用");
        }else if(e instanceof InsertException){
            result.setState(4001);
            result.setMessage("注册时插入数据产生未知的异常");
        }
        else if(e instanceof UserNameNotFoundException){
            result.setState(4002);
            result.setMessage("用户名不存在");
        }else if(e instanceof PasswordNotMatchException){
            result.setState(4003);
            result.setMessage("密码不匹配");
        }else if(e instanceof ServiceException){
            result.setState(4004);
            result.setMessage("用户名或者密码为空");
        }else if(e instanceof UpdateException){
            result.setState(4005);
            result.setMessage("更行异常");
        }else if(e instanceof FileStateException){
            result.setState(5000);
            result.setMessage("文件状态异常");
        }else if(e instanceof FileEmptyException){
            result.setState(5001);
            result.setMessage("文件为空");
        }else if(e instanceof FileSizeException){
            result.setState(5002);
            result.setMessage("文件大小超出限制");
        }else if(e instanceof FileUploadIOException){
            result.setState(5003);
            result.setMessage("上传IO异常");
        }else if(e instanceof AddressCountLimitException){
            result.setState(6000);
            result.setMessage("地址数目超出限制，无法添加");
        }

        return result;
    }

    //封装session获取session对象中的uid，，当前登录对象的uid值
    protected  final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    //封装session获取session对象中的username，，当前登录对象的username值
    protected  final String getUserNameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }

}
