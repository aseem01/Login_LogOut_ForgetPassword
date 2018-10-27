/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Monirul Islam
 */
@Controller
public class DefaultController {
     @RequestMapping(value = {"/", "index"})
    public String viewIndex() {
        
        System.out.println("I'm running man.");
        return "index";
    }
    
}
