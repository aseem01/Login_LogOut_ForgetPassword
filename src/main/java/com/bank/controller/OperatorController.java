/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;

import com.bank.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASHIM
 */
public class OperatorController {
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
