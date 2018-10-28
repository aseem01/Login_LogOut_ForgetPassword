/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;

import com.bank.model.User;
import com.bank.service.OperatorService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ASHIM
 */
@Controller
@RequestMapping("Admin/")
public class AdminController {

    //@Autowired
    OperatorService userservice=new OperatorService();
    private static HttpSession session;

    public static void craeteLoginSession(User user, HttpServletRequest req) {
        System.out.println("Session Created");
        user.setPassword("null");
        session = req.getSession();
        session.setAttribute("user", user);

    }

    public static boolean checkSession() {
        boolean login = false;
        User user;
        try {
            System.out.println("Checking session...");
            user = (User) session.getAttribute("user");
            if (user.getUsertype().equals("Admin") && user.getStatus().equals("Active")) {
                login = true;
            } else {
                login = false;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            login = false;
        }

        return login;
    }

    @RequestMapping(value = "/dashboard")
    public String viewDash() {
        return "Admin/dashboard";
    }

    @RequestMapping(value = "/addoperator")
    public String AddForm() {
        return "Admin/addoperator";
    }
    
     @RequestMapping(value = "/viewoperator")
    public String ViewOperator(Model m) {
        List<User>user=userservice.listAllUser();
         System.out.println("user size() : "+user.size());
        m.addAttribute("userlist",user);
        return "Admin/viewoperator";
    }
    
    
}
