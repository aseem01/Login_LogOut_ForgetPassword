/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;

import com.bank.model.User;
import com.bank.service.OperatorService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ASHIM
 */
@Controller
@RequestMapping("Operator/")
public class OperatorController {
    
    @Autowired
    OperatorService operatorServ;
    
    private static HttpSession session;
    
    public static void craeteLoginSession(User user, HttpServletRequest req) {
        System.out.println("Session Created");
        user.setPassword("null");
        session = req.getSession(true);
        session.setAttribute("user", user);

    }
    
    public static boolean checkSession() {
        boolean login = false;
        User user;
        try {
            user = (User) session.getAttribute("user");
            if(user.getUsertype().equals("Operator") && user.getStatus().equals("Active")){
                login = true;
            } else {
                login = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            login = false;
        }
        System.out.println("Cehck session "+login);
        return login;
    }
    
    
}
