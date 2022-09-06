package com.eprex.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginInterceptor
 * @Description TODO
 * @Author mi
 * @Date 31/8/2022 下午3:18
 * @Version 1.0
 **/
public class LoginInterceptor implements HandlerInterceptor {
    /*
    * @Author eprex
    * @Date 下午3:25 31/8/2022
    * @Description 检测全局session对象中是否有uid
    * @MethodName preHandle
    * @Param [request, response, handler]
    * @return boolean true就放行请求，false就拒绝请求 拦截掉
    **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object uid = request.getSession().getAttribute("uid");
        if(uid == null){
            //未登录过系统 重顶向到login
            response.sendRedirect("/web/login.html");
            return false;
        }
        //请求放行
        return true;
    }
}
