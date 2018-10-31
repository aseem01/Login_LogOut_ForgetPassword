/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.dao;

import com.bank.model.User;

/**
 *
 * @author Monirul Islam
 */
public interface InterfaceDefault {

    public boolean checkLoginCredential(String email, String password);

    public User loadUserInfo(String email, String password);

    public boolean checkUsername(String uname);

    public User generateRandomNumInsert(String uname, int randomnumber);

    public boolean verifyCode(String vcode);

    public boolean updatePassword(String pass,String id);
}
