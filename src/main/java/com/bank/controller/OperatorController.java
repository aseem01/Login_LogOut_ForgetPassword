/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;

import com.bank.encryptor.Encryptor;
import com.bank.lib.SingletonPattern;
import com.bank.model.User;
import com.bank.service.OperatorService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
    
     @RequestMapping(value = "/Logout")
    public String Logout(Model map, HttpServletRequest request) {
        System.out.println("I'm logout");
        session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        map.addAttribute("You Successfully Logout");
        return "Operator/redirRoot";
    }
    
    
    //view profile Admin;
    @RequestMapping(value = "/profileview", method = RequestMethod.GET)
    public String ViewProfile(HttpServletRequest request, Model m) {
        User usersession = SingletonPattern.getHelper().GetSession(request);
        m.addAttribute("user", usersession);
        return "Operator/operatorprofile";
    }
    
    
     @RequestMapping(value = "/updateOperatorProfile", method = RequestMethod.POST)
    public String updateProfile(@ModelAttribute("User") User updateUser, MultipartFile newImg, HttpServletRequest request, Model m) {
        User user = SingletonPattern.getHelper().GetSession(request);

        System.out.println("Update pas " + updateUser.getPassword());
        //System.out.println("Update pas "+updateUser.getEmail());
        //System.out.println("Image :" +newImg.getOriginalFilename());

        if (!user.getFullname().equals(updateUser.getFullname())) {
            user.setFullname(updateUser.getFullname());
        }
        if (updateUser.getPassword().length() > 7) {
            user.setPassword(Encryptor.Encrypt(updateUser.getPassword()));
            System.out.println("New Passw " + updateUser.getPassword());
        } else {
            user.setPassword(operatorServ.getMyPasw(user.getId()));
        }
        if (!user.getEmail().equals(updateUser.getEmail())) {
            user.setEmail(updateUser.getEmail());
        }
        try {
            if (!newImg.isEmpty()) {
                System.out.println(" ID : " + operatorServ.getMaxUserId() + 1);
                String fileExte = FilenameUtils.getExtension(newImg.getOriginalFilename()).toLowerCase();
                String imageName = "user_" + user.getId() + "." + fileExte;

                System.out.println("New name : " + imageName);
                String root = request.getRealPath("/");
                System.out.println("root " + root);
                String rootPath = root.substring(0, root.indexOf("improvement_multipurpose"));
                rootPath = rootPath + "improvement_multipurpose\\src\\main\\webapp\\software\\user_image\\";
                System.out.println("rootpath : " + rootPath);

                if (SingletonPattern.getHelper().deleteOldFile(rootPath, imageName)) {
                    Thread.currentThread().sleep(500);
                    SingletonPattern.getHelper().Imageupload(rootPath, newImg, imageName);
                    Thread.currentThread().sleep(1200);
                    imageName = "\\software\\user_image\\" + imageName;
                    
                    user.setImage(imageName);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        
        session.setAttribute("user", user);
        boolean update = operatorServ.updateMyprofile(user);
        if (update) {
            
            m.addAttribute("controllerMsg", "Profile Updated !");
        } else {
            m.addAttribute("controllerMsg", "Error Occured !");
        }
        m.addAttribute("user", user);
        return "Operator/profileview";

    }
}
