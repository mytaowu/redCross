package com.red.config.interceptor;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author: TMingYi
 * @date: 2020/4/23 17:55
 */
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    //handler请求的mapper地址；
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Object userInfo1 = session.getAttribute("userInfo");
        Object teacherInfo = session.getAttribute("teacherInfo");
        Object adminInfo = session.getAttribute("adminInfo");
        if (userInfo1 == null && teacherInfo == null && adminInfo == null){
            response.sendRedirect("http://localhost:8081/index");
            return false;
        }
        return true;
    }

}
