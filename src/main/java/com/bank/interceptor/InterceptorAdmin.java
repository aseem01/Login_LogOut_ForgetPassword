/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.interceptor;

import com.bank.controller.AdminController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author ASHIM
 */
public class InterceptorAdmin extends HandlerInterceptorAdapter{
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean login = AdminController.checkSession();

        System.out.println("Admin interceptor...");
        System.out.println("url : " + request.getContextPath());
        if (login) {
            return login;
        } else {
            response.sendRedirect(request.getContextPath() + "/index");
            return login;
        }

    }
    
}
