package com.bank.dao;

import com.bank.model.EntityFactory;
import com.bank.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ashim
 */
@Component
@Repository
public class DaoDefault implements InterfaceDefault{

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    static void sessionClose(Session session) {
        try {
            if (session != null && session.isOpen()) {
                session.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
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
            System.out.println("size "+user.size());
           
            if (user.size() == 1) {
                login = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            login = false;
        } finally {
            sessionClose(session);
        }
        return login;
    }

    @Override
    public User loadUserInfo(String username,String password)
    {
        User user=(User) EntityFactory.getEntityObj("User");
        Session session=sessionFactory.openSession();
        
        try{
            session.beginTransaction();
            Criteria criteria=session.createCriteria(User.class);
            criteria.add(Restrictions.eq("username", username));
            criteria.add(Restrictions.eq("password", password));
            user=(User) criteria.uniqueResult();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            sessionClose(session);
        }
        return user;
    }
}
