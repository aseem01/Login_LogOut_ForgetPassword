/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.lib;

/**
 *
 * @author ASHIM
 */
public class SingletonPattern {
     public static Helper helper;
    private SingletonPattern(){
        
    }
    public static Helper getHelper()
    {
        if(helper==null)
        {
            helper=new Helper();
        }
        return helper;
    }
    
}
