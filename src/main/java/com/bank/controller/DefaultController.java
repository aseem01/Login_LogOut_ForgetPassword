/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;

import com.bank.dao.DaoDefault;
import com.bank.encryptor.Encryptor;
import com.bank.model.User;
import java.util.Random;
import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
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

    HttpSession ss;

    @Autowired
    private JavaMailSender mailSenderObj;

    static String emailToRecipient, emailSubject, emailMessage;
    static final String emailFromRecipient = "satubiswas2020@gmail.com";

    DaoDefault defMod = new DaoDefault();

    @RequestMapping(value = {"/", "index"})
    public String viewIndex(Model m) {
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

    @RequestMapping(value = "checkuser", method = RequestMethod.POST)
    public String generateCode(Model m, @RequestParam("uname") String uname, HttpServletRequest req) {
        if (defMod.checkUsername(uname)) {
            Random rd = new Random();
            final int randomnumber = rd.nextInt(999999);
            ss = req.getSession();
            final User u = defMod.generateRandomNumInsert(uname, randomnumber);
            ss.setAttribute("userid", u.getId());
            ss.setAttribute("useremail", u.getEmail());
            mailSenderObj.send(new MimeMessagePreparator() {
                @Override
                public void prepare(javax.mail.internet.MimeMessage mm) throws Exception {
                    MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mm, true, "UTF-8");
                    mimeMsgHelperObj.setTo(u.getEmail());
                    mimeMsgHelperObj.setFrom(emailFromRecipient);
                    mimeMsgHelperObj.setText("Your verification code is : " + randomnumber);
                    mimeMsgHelperObj.setSubject("Verification code");
                }
            });
            m.addAttribute("newpass", "yes");
            m.addAttribute("codetoemail", u.getEmail());
            return "index";
        } else {
            m.addAttribute("newpass", "no");
            return "index";
        }
    }

    @RequestMapping(value = "checkuser", method = RequestMethod.GET)
    public String checkuser() {
        return "index";
    }

    @RequestMapping(value = "verifycode", method = RequestMethod.POST)
    public String verifyCode(Model m, @RequestParam("vcode") String code) {
        
        if (defMod.verifyCode(code)) {
            m.addAttribute("isCodeMatched", "yes");
            return "index";
        } else {
            m.addAttribute("codetoemail", ss.getAttribute("useremail"));
            m.addAttribute("isCodeMatched", "no");
            return "index";
        }
    }

    @RequestMapping(value = "recoverypassword", method = RequestMethod.POST)
    public String recoverypassword(@RequestParam("secondPass") String secondPass,Model m) {
        if (ss != null) {
            if (defMod.updatePassword(secondPass, ss.getAttribute("userid") + "")) {
                m.addAttribute("controllerReply", "Password changed successfully");
                return "index";
            }else{
                m.addAttribute("controllerReply", "Error in changing password");
                return "index";
            }
        }
        return "index";
    }

}
