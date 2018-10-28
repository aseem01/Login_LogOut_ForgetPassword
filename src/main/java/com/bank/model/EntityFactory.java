/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

/**
 *
 * @author Monirul Islam
 */
public class EntityFactory {

    public static java.io.Serializable getEntityObj(String entityName)
    {
        switch (entityName) {
            case "User":
                return new User();
            case "ShopInfo":
                return new BankInfo();
            default:
                return null;
        }
    }
}
