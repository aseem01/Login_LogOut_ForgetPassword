/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.dao;

import com.bank.model.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ASHIM
 */
public class AdminDao implements AdminInterface{

     SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public List listAllUsers() {
        Session session=sessionFactory.openSession();
        List list=new ArrayList();
        try{
           session.beginTransaction();
           Criteria c=session.createCriteria(User.class);
           session.getTransaction();
           list=c.list();
            System.out.println("list size() : "+list.size());
        }catch(Exception e){
            session.getTransaction();
            System.out.println("error int view");
        }
        return list;
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
    
}
