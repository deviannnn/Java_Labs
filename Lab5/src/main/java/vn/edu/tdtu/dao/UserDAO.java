package vn.edu.tdtu.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.edu.tdtu.model.User;
import vn.edu.tdtu.repository.UserRepository;
import vn.edu.tdtu.utils.HibernateUtils;

import java.util.List;

public class UserDAO implements UserRepository {
    @Override
    public void add(User item) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public User validate(String email, String password) {
        Transaction transaction = null;
        List<User> userList = null;
        try (Session session = HibernateUtils.getFactory().openSession()) {
            transaction = session.beginTransaction();
            userList = session.createQuery("from User where email = '" + email + "' and password = '" + password + "'").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        if (userList != null && !userList.isEmpty()) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public User existed(String email) {
        Transaction transaction = null;
        List<User> userList = null;
        try (Session session = HibernateUtils.getFactory().openSession()) {
            transaction = session.beginTransaction();
            userList = session.createQuery("from User where email = '" + email + "'").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        if (userList != null && !userList.isEmpty()) {
            return userList.get(0);
        } else {
            return null;
        }
    }


}
