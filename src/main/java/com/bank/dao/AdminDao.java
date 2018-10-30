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
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASHIM
 */
@Repository
public class AdminDao implements AdminInterface {

    void sessionClose(Session session) {
        try {
            if (session != null && session.isOpen()) {
                session.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List listAllUsers() {
        Session session = sessionFactory.openSession();
        List list = new ArrayList();
        try {
            session.beginTransaction();
            Criteria c = session.createCriteria(User.class);
            session.getTransaction();
            list = c.list();
            System.out.println("list size() : " + list.size());
        } catch (HibernateException e) {
            session.getTransaction();
            System.out.println("error int view : " + e.toString());
        } finally {
            sessionClose(session);
        }
        return list;
    }

    @Override
    public boolean addUser(User user) {
        Session session = sessionFactory.openSession();
        try {
            System.out.println("fullname : " + user.getFullname());
            System.out.println("password : " + user.getPassword());
            System.out.println("email : " + user.getEmail());
            System.out.println("joining date : " + user.getJoiningDate());
            System.out.println("user type: " + user.getUsertype());
            System.out.println("status : " + user.getStatus());
            System.out.println("username : " + user.getUsername());
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("eerror : " + e.toString());
            session.getTransaction().rollback();
            return false;
        } finally {
            sessionClose(session);
        }
        return true;
    }

    @Override
    public boolean updateUser(User user) {

        boolean done = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            User usr = (User) session.get(User.class, user.getId());
            usr.setFullname(user.getFullname());
            usr.setJoiningDate(user.getJoiningDate());
            usr.setStatus(user.getStatus());
            usr.setUsertype(user.getUsertype());
            session.update(usr);
            session.getTransaction().commit();
            done = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            done = false;
        } finally {
            sessionClose(session);
        }
        return done;
    }

    @Override
    public boolean deleteUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
