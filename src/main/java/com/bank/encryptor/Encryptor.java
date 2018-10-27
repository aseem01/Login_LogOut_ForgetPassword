/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.encryptor;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author ASHIM
 */
public class Encryptor {
     public static String Encrypt(String code)
    {
        String encryptedCode="";
        try {
        MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
        msdDigest.update(code.getBytes("UTF-8"), 0, code.length());
        encryptedCode = DatatypeConverter.printHexBinary(msdDigest.digest());
    } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
       
    }
        return encryptedCode;
    }
    
}
