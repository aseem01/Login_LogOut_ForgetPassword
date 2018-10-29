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
       Session session = sessionFactory.openSession();
        try {
            System.out.println("fullname : "+user.getFullname());
            System.out.println("password : "+user.getPassword());
            System.out.println("email : "+user.getEmail());
            System.out.println("joining date : "+user.getJoiningDate());
            System.out.println("user type: "+user.getUsertype());
            System.out.println("status : "+user.getStatus());
            System.out.println("username : "+user.getUsername());
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("eerror : "+e.toString());
            session.getTransaction().rollback();
            return false;
        }
        return true;
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
