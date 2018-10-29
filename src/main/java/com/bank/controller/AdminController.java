/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;

import com.bank.lib.SingletonPattern;
import com.bank.model.User;
import com.bank.service.AdminService;
import com.bank.service.OperatorService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASHIM
 */
@Controller
@RequestMapping("Admin/")
public class AdminController {

    @Autowired
    AdminService adminservice;
    //OperatorService userservice = new OperatorService();
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

    @RequestMapping(value = "/AddOperator", method = RequestMethod.POST)
    public String add(@ModelAttribute(value = "User") User user, @RequestParam(value = "join") String sDate1, Model m,
            @RequestParam(value = "upload") MultipartFile file, HttpServletRequest request) throws ParseException, FileNotFoundException, IOException {
        System.out.println("hi : ");
        String imagename = file.getOriginalFilename();

        //image upload code;
        String root = request.getRealPath("/");

        System.out.println("root : " + root);
        String rootPath = root.substring(0, root.indexOf("improvement_multipurpose"));
        rootPath = rootPath + "improvement_multipurpose\\src\\main\\webapp\\software\\user_image\\";
        System.out.println("rootpath : " + rootPath);
        boolean test = SingletonPattern.getHelper().Imageupload(rootPath, file);

        if (test) {
            System.out.println("file name : " + imagename);
            System.out.println("I'm running : " + sDate1);
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
            System.out.println("date : " + sDate1);
            imagename = "\\software\\user_image\\" + imagename;
            user.setJoiningDate(date);
            user.setImage(imagename);
            user.setVerificationCode("Null");
            User UserSession = SingletonPattern.getHelper().GetSession(request);
            user.setBankInfo(UserSession.getBankInfo());
            boolean check = adminservice.addUser(user);
            System.out.println("check : " + check);
            if (check) {
                m.addAttribute("success", "You Successfully added");
                return "Admin/dashboard";
            } else {
                m.addAttribute("error", "Error Occur");
                return "Admin/dashboard";
            }
        } else {
            m.addAttribute("error", "Error Occur");
            return "Admin/dashboard";
        }

    }

    @RequestMapping(value = "/viewoperator")
    public String ViewOperator(Model m) {
        List<User> user = adminservice.listAllUser();
        System.out.println("user size() : " + user.size());
        m.addAttribute("userlist", user);
        return "Admin/viewoperator";
    }

    @RequestMapping(value = "/Logout")
    public String Logout(Model map, HttpServletRequest request) {
        System.out.println("I'm logout");
        session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        map.addAttribute("You Successfully Logout");
        return "Admin/redirRoot";
    }

}
