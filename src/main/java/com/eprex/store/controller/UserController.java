package com.eprex.store.controller;

import com.eprex.store.entity.User;
import com.eprex.store.service.IUserService;
import com.eprex.store.service.ex.*;
import com.eprex.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName UserController
 * @Description User控制层
 * @Author mi
 * @Date 29/8/2022 下午9:19
 * @Version 1.0
 **/
@RestController //RestController = @Controller + ResponseBody
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    /*  @RequestMapping("reg")
      //@ResponseBody  //表示此方法的响应结果以json的格式给到前端
      public JsonResult<Void> reg(User user){
          JsonResult<Void> result = new JsonResult<>();
          try {
              userService.reg(user);
              result.setState(200);
              result.setMessage("注册成功");
          } catch (UserNameDuplicatedException e) {
              result.setState(4000);
              result.setMessage("用户名被占用");
          }catch (InsertException e){
              result.setState(4000);
              result.setMessage("注册时产生未知的异常");
          }

          return result;
      }*/

     /*
     因为约定大于配置，所以省掉了mvc中的注解编写 一般要使用RequestBody 和RequestParam
     @ResponseBody  //表示此方法的响应结果以json的格式给到前端
     1.接收数据的方式：请求处理数据的参数列表设置为pojo类型来接收前端的数据
       springboot 会将前端的url地址中参数名和pojo的属性名进行比较，如果匹配就会注入到属性中
     */
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return new JsonResult<>(OK);
    }
/*2.接收数据方式：请求处理方法的参数列表设置为非自己封装的pojo类型，
  springboot直接将请求的参数名直接进行比较，如果名称相同则自动完成值的依赖注入
*
* */
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        //User result = userService.login(user.getUsername(),user.getPassword());
        User result = userService.login(username,password);

        //向全局session中设置对象
        session.setAttribute("uid",result.getUid());
        session.setAttribute("username",result.getUsername());

        return new JsonResult<User>(OK,result);
    }

    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword,String newPassword,HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUserNameFromSession(session);
        userService.changePassword(uid,username,oldPassword,newPassword);

        return new JsonResult<>(OK,username+": 更新成功");
    }
    //页面启动 加载信息到文本框
    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session){
        User result = userService.getByUid(getUidFromSession(session));

        return new JsonResult<User>(OK,"加载信息成功",result);
    }
    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user,HttpSession session){
        //user对象中有四部分的数据
        userService.changeInfo(getUidFromSession(session),getUserNameFromSession(session),user);

        return new JsonResult<>(OK,"修改个人信息成功");
    }



    //设置文件上传的最大值  默认单位是字节  10MB *1024= 1024kb *1024=1048576byte
    public static final int AVATAR_MAX_SIZE=10*1024*1024;
    //限制文件类型 可以放在数组中
    public static final List<String> AVATAR_TYPE=new ArrayList<>();
    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
        AVATAR_TYPE.add("image/jpg");
    }

    //public JsonResult<String> changeAvatar(HttpSession session, @RequestParam("file") MultipartFile file)
    @RequestMapping("change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session, MultipartFile file) throws IOException {
        //判断文件为null
        if (file.isEmpty()){
            throw new FileEmptyException("文件为空");
        }
        if (file.getSize()>AVATAR_MAX_SIZE){
            throw new FileSizeException("文件超出限制");
        }
        //判断文件类型  使用集合的方法
        String type = file.getContentType();
        if (!AVATAR_TYPE.contains(type)) {
            throw new FileTypeException("文件类型不支持");
        }
        //上传的文件 .../upload/文件.png getServletContext()是项目在容器中的实际发布运行的根路径
        //String parent = session.getServletContext().getRealPath("upload"); tomcat每次启动会创建新的路径 所以可以自己建立一个路径专门用来存放上传的文件
        String parent = "D:\\JAVAProgramm\\com.eprex\\src\\main\\resources\\static\\upload";

        File dir=new File(parent);
        if(!dir.exists()){//文件不存在
            dir.mkdir();//创建目录
        }
        //为了避免名称重复 获取到文件名称 用uuid 生成随机的串作文件名
        //avatar.png
        String originalFilename = file.getOriginalFilename();
        System.out.println("originalFilename: "+originalFilename);

        String suffix = originalFilename.split("\\.")[1];
        String filename = UUID.randomUUID().toString().toUpperCase()+"."+suffix;

        //创建新的文件中在项目本地
        File dest = new File(dir,filename); //空文件 指定文件名
        //将file中的数据写入到空文件中
        try {
            file.transferTo(dest);//将数据写入到目标文件中  使用multipart 提供的方法，后缀要一致
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }catch (FileStateException e){
            throw new FileStateException("文件状态异常");
        }catch (FileUploadIOException e){
            throw new FileUploadIOException("文件读写异常");
        }

        Integer uid = getUidFromSession(session);
        String username = getUserNameFromSession(session);
        //返回头像的路径到json中 给前端
        String avatar = "/upload/"+filename;
        //返回头像的路径给前端页面  将来用于头像的展示
        userService.changeAvatar(uid,avatar,username);

        return new JsonResult<String>(OK,"上传用户头像成功",avatar);//头像传给前端
    }



}
