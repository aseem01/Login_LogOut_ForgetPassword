/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service;

import com.bank.dao.AdminDao;
import com.bank.dao.OperatorDao;
import com.bank.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASHIM
 */
@Service
public class OperatorService implements InterfaceOperatorService {

    OperatorDao operatorDao;
    @Autowired
    public void setOperatorDao(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    } 

    @Override
    public List listAllUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getMaxUserId() {
       return operatorDao.getMaxUserId();
    }

    @Override
    public boolean updateMyprofile(User user) {
         return operatorDao.updateMyProfile(user);
    }

    @Override
    public String getMyPasw(Integer id) {
        return operatorDao.getUserPassword(id);
    }


}
