/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.lib;

import com.bank.model.User;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASHIM
 */
public class Helper {
     public boolean Imageupload(String UploadPath,MultipartFile file,String fileName) throws FileNotFoundException, IOException
    {
        if (!file.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(
                    new File(UploadPath,fileName)));
            
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
        }else return false;
        return true;
    }
    
    public User GetSession(HttpServletRequest request)
    {
        
        HttpSession session = request.getSession();
        return (User) session.getAttribute("user");
    }
    
}
