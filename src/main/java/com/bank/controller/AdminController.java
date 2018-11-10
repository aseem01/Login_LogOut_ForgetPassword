/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;

import com.bank.encryptor.Encryptor;
import com.bank.lib.SingletonPattern;
import com.bank.model.User;
import com.bank.service.AdminService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
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
        String encryptedPassword = Encryptor.Encrypt(user.getPassword());
        String imageName = "";
        String fileExte = FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase();
//        String imagename = file.getOriginalFilename();

        boolean test = false;
        if (file.isEmpty()) {
            imageName = "default_user_image.png";
            test = true;
        } else {
            System.out.println(" ID : " + adminservice.getMaxUserId() + 1);

            imageName = "user_" + (adminservice.getMaxUserId() + 1) + "." + fileExte;
            System.out.println("New name : " + imageName);
            //image upload code;
            String root = request.getRealPath("/");
            System.out.println("new name  " + file.getOriginalFilename());
            String rootPath = root.substring(0, root.indexOf("improvement_multipurpose"));
            rootPath = rootPath + "improvement_multipurpose\\src\\main\\webapp\\software\\user_image\\";
            System.out.println("rootpath : " + rootPath);
            test = SingletonPattern.getHelper().Imageupload(rootPath, file, imageName);
        }

        if (test) {
            System.out.println("file name : " + imageName);
            System.out.println("I'm running : " + sDate1);
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
            System.out.println("date : " + sDate1);
            imageName = "\\software\\user_image\\" + imageName;
            user.setJoiningDate(date);
            user.setImage(imageName);
            user.setVerificationCode("Null");
            user.setPassword(encryptedPassword);
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

    @RequestMapping(value = "updateoperator")
    public String updateOperator(Model m, @ModelAttribute("user") User user, @RequestParam("join") String join) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = sdf.parse(join);
            user.setJoiningDate(d);
            boolean isUpdated = adminservice.updateUser(user);
            if (isUpdated) {
                m.addAttribute("successMsg", "Updated Successfully");
            } else {
                m.addAttribute("successMsg", "Updated Failed !!");
            }
        } catch (ParseException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<User> userlist = adminservice.listAllUser();
        m.addAttribute("userlist", userlist);
        return "Admin/viewoperator";
    }

    //view profile Admin;
    @RequestMapping(value = "/profileview", method = RequestMethod.GET)
    public String ViewProfile(HttpServletRequest request, Model m) {
        User usersession = SingletonPattern.getHelper().GetSession(request);
        m.addAttribute("user", usersession);
        return "Admin/adminprofile";
    }

    @RequestMapping(value = "/updateAdminProfile", method = RequestMethod.POST)
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
            user.setPassword(adminservice.getMyPasw(user.getId()));
        }
        if (!user.getEmail().equals(updateUser.getEmail())) {
            user.setEmail(updateUser.getEmail());
        }
        try {
            if (!newImg.isEmpty()) {
                System.out.println(" ID : " + adminservice.getMaxUserId() + 1);
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
        boolean update = adminservice.updateMyprofile(user);
        if (update) {
            
            m.addAttribute("controllerMsg", "Profile Updated !");
        } else {
            m.addAttribute("controllerMsg", "Error Occured !");
        }
        m.addAttribute("user", user);
        return "redirect:/Admin/profileview";

    }
}
