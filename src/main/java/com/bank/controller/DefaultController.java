/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;

import com.bank.dao.DaoDefault;
import com.bank.encryptor.Encryptor;
import com.bank.model.User;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Monirul Islam
 */
@Controller
public class DefaultController {
    
    DaoDefault defMod=new DaoDefault();
    
    @RequestMapping(value = {"/", "index"})
    public String viewIndex() {

        System.out.println("I'm running man.");
        return "index";
    }

    @RequestMapping(value = "UserLogin", method = RequestMethod.POST)
    public String userLogin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpServletRequest req, Model m) {
        String encryptedPassword = Encryptor.Encrypt(password);
        System.out.println("Email :" + username);
        System.out.println("Pass " + encryptedPassword);
        boolean login = defMod.checkLoginCredential(username, encryptedPassword);
        System.out.println("val " + login);

        if (login) {
            User user = defMod.loadUserInfo(username, encryptedPassword);
            if (user.getUsertype().equals("Admin") && user.getStatus().equals("Active")) {
                System.out.println("true man");
                AdminController.craeteLoginSession(user, req);
                return "Admin/redirectDash";
            } else if (user.getUsertype().equals("Operator") && user.getStatus().equals("Active")) {
                System.out.println("Def cont login ");
                OperatorController.craeteLoginSession(user, req);
                return "Operator/redirectDash";
            } else if (user.getUsertype().equals("Operator") && user.getStatus().equals("Inactive")) {
                m.addAttribute("controllerReply", "You are not active.Access denied");
                return "index";
            } else if (user.getUsertype().equals("Admin") && user.getStatus().equals("Inactive")) {
                m.addAttribute("controllerReply", "Access denied ! You are not active.");
                return "index";
            } else {
                m.addAttribute("controllerReply", "Wrong email or password");
            }
            return "index";
        } else {
            
            m.addAttribute("controllerReply", "Wrong email or password");
            return "index";
        }

    }

}
