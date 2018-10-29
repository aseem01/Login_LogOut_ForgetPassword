/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service;

import com.bank.dao.AdminDao;
import com.bank.model.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASHIM
 */
@Service
public class AdminService implements InterfaceAdminService {

    AdminDao admindao;

    @Autowired
    public void setadmindao(AdminDao admindao) {
        this.admindao = admindao;
    }

    @Override
    public List listAllUser() {
        return admindao.listAllUsers();
    }

    @Override
    public boolean addUser(User user) {
        return admindao.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return admindao.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
