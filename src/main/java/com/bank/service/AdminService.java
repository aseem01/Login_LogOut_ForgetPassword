/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service;

import com.bank.dao.AdminDao;
import com.bank.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ASHIM
 */
public class AdminService  implements InterfaceAdminService{
    AdminDao admindao;
    @Autowired
    public void setadmindao(AdminDao admindao){
        this.admindao=admindao;
    } 

    @Override
    public List listAllUser() {
        return admindao.listAllUsers();
    }

    @Override
    public boolean addUser(User user) {
         System.out.println("name : "+user.getFullname());
        System.out.println("email : "+user.getEmail());
        System.out.println("password : "+user.getPassword());
        System.out.println("status : "+user.getStatus());
        System.out.println("image : "+user.getImage());
        System.out.println("joining date : "+user.getJoiningDate());
        return admindao.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
