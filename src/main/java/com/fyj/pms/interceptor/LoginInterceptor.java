package com.fyj.pms.interceptor;

import com.mysql.cj.Session;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author FYJ
 * @version V1.0.0
 * @email tang.wangwang@qq.com
 * @date 2019-09-03 20:56
 * @name com.fyj.pms.interceptor.LoginInterceptor.java
 * @see 拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器");
        HttpSession session = request.getSession();
        // int count = (int) session.getAttribute("activeUser");
        // if(count>0){
        //     return true;
        // }
        // request.getRequestDispatcher("WEB-INF/login.jsp");
        // return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
