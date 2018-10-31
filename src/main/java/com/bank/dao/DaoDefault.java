package com.bank.dao;

import com.bank.encryptor.Encryptor;
import com.bank.model.EntityFactory;
import com.bank.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ashim
 */
@Repository
public class DaoDefault implements InterfaceDefault {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    static void sessionClose(Session session) {
        try {
            if (session != null && session.isOpen()) {
                session.close();
            }

        } catch (HibernateException e) {
            System.out.println("session close : " + e.toString());
        }
    }

    @Override
    public boolean checkLoginCredential(String username, String password) {
        Session session = sessionFactory.openSession();
        boolean login = false;
        try {
            session.beginTransaction();
            Criteria loginCrit = session.createCriteria(User.class);
            loginCrit.add(Restrictions.eq("username", username));
            loginCrit.add(Restrictions.eq("password", password));
            session.getTransaction();

            List<User> user = loginCrit.list();
            System.out.println("size " + user.size());

            if (user.size() == 1) {
                login = true;
            }
        } catch (HibernateException e) {
            login = false;
        } finally {
            sessionClose(session);
        }
        return login;
    }

    @Override
    public User loadUserInfo(String username, String password) {
        User user = (User) EntityFactory.getEntityObj("User");
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("username", username));
            criteria.add(Restrictions.eq("password", password));
            user = (User) criteria.uniqueResult();
        } catch (HibernateException e) {
        } finally {
            sessionClose(session);
        }
        return user;
    }

    @Override
    public boolean checkUsername(String uname) {
        boolean isFound = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Criteria c = session.createCriteria(User.class);
            c.add(Restrictions.eq("username", uname));
            List<User> uList = c.list();
            if (uList.size() > 0) {
                isFound = true;
            } else {
                isFound = false;
            }
//            session.getTransaction().commit();

        } catch (HibernateException e) {
            session.beginTransaction().rollback();
            e.printStackTrace();
        }
        return isFound;
    }

    @Override
    public User generateRandomNumInsert(String uname, int randomnumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Criteria c = session.createCriteria(User.class);
            c.add(Restrictions.eq("username", uname));
            User user = (User) c.uniqueResult();

            User updatUser = (User) session.get(User.class, user.getId());
            updatUser.setVerificationCode(String.valueOf(randomnumber));
            session.update(updatUser);
            session.getTransaction().commit();
            return updatUser;
        } catch (HibernateException e) {
            session.beginTransaction().rollback();
            return null;
        }
    }

    @Override
    public boolean verifyCode(String vcode) {

        boolean isFound = false;
        Session session = sessionFactory.openSession();
        try {
            Criteria c = session.createCriteria(User.class);
            c.add(Restrictions.eq("verificationCode", vcode));
            List<User> ul = c.list();
            if (ul.size() > 0) {
                isFound = true;
            } else {
                isFound = false;
            }
        } catch (HibernateException e) {
            System.out.println("verify code : " + e.toString());
        }
        return isFound;
    }

    @Override
    public boolean updatePassword(String pass, String id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        System.out.println("update userid is : " + id);
        try {
            User user = (User) session.get(User.class, Integer.parseInt(id));
            System.out.println("password is : " + pass);
            user.setPassword(Encryptor.Encrypt(pass));
            System.out.println("enc password : " + Encryptor.Encrypt(pass));
            session.update(user);
            session.getTransaction().commit();
        } catch (NumberFormatException e) {
            System.out.println("update password : " + e.toString());
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }

}
