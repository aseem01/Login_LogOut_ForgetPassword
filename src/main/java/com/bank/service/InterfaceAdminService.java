/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service;

import com.bank.model.User;
import java.util.List;

/**
 *
 * @author ASHIM
 */
public interface InterfaceAdminService {

    public List listAllUser();

    public boolean addUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(int id);
    
    public Integer getMaxUserId() ;
    
    public boolean updateMyprofile(User user);
    
    public String getMyPasw(Integer id);

}
