package com.hwadee.eldercare.config;

import com.fasterxml.jackson.core.filter.TokenFilter;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object object = request.getSession().getAttribute("user");
        if(object==null){
            System.out.println(request.getRequestURI());
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}
