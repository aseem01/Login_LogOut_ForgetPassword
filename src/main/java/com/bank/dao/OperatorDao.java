/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.dao;

import com.bank.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASHIM
 */
@Repository
public class OperatorDao implements OperatorInterface {
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
    public List listAllUsers(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public Integer getMaxUserId() {
          Integer maxId=0;
        Session session=sessionFactory.openSession();
        try{
            session.beginTransaction();
            Criteria crt=session.createCriteria(User.class);
            crt.setProjection(Projections.max("id"));
            maxId=(Integer) crt.uniqueResult();
            System.out.println("Max ID : "+maxId);
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            maxId=0;
        } finally {
            sessionClose(session);
        }
        return maxId;
    }

    @Override
    public boolean updateMyProfile(User user) {
          boolean update=false;
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        try{
            
//            User usr = (User) session.get(User.class, user.getId());
//            session.clear();
//            System.out.println("User pasw "+usr.getPassword());
//            usr.setFullname(user.getFullname());
//            usr.setEmail(user.getEmail());
//            if(user.getPassword().length()>7)
//            {
//                usr.setPassword(user.getPassword());
//            }
//            usr.setImage(user.getImage());
            session.update(user);
            session.getTransaction().commit();
            update=true;
        }catch(Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
            update=false;
        }finally {
            sessionClose(session);
        }
        
        return update;
    }

    @Override
    public String getUserPassword(Integer id) {
         String pasw="";
        Session session=sessionFactory.openSession();
        try{
            User user=(User) session.get(User.class,id);
            pasw=user.getPassword();
        }catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            sessionClose(session);
        }
        return pasw;
    }
    
}
